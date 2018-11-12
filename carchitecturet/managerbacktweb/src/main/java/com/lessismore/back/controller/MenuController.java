package com.lessismore.back.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Admin;
import com.lessismore.commont.model.AdminRefRole;
import com.lessismore.commont.model.Cover;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.model.Entity.AdminRefRoleCriteria;
import com.lessismore.commont.model.Entity.MenuCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.RoleRefMenuCriteria;
import com.lessismore.commont.model.Interface;
import com.lessismore.commont.model.Menu;
import com.lessismore.commont.model.RoleRefMenu;
import com.lessismore.commont.service.AdminRefRoleService;
import com.lessismore.commont.service.GwUserService;
import com.lessismore.commont.service.InterfaceService;
import com.lessismore.commont.service.MenuService;
import com.lessismore.commont.service.RoleRefMenuService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private AdminRefRoleService adminRefRoleService;
	@Autowired
	private RoleRefMenuService roleRefMenuService;
	@Autowired
	private InterfaceService interfaceService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Menu bean, Pagination pagination){
		MenuCriteria criteria=new MenuCriteria();
		//模糊查询，根据名称查询
		/*if(bean!=null&&bean.getName()!=null&&!"".equals(bean.getName())){
			criteria.setName(Entity.Value.like(bean.getName()+"%"));
		}*/
		//分页查询
		Pagination list=menuService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		return "menu/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		//显示父节点
		MenuCriteria criteria=new MenuCriteria();
		//criteria.setParentId(Entity.Value.eq(0));
		List<Menu> menus=menuService.selectList(criteria);
		//获取接口管理数据的最大ID
		List<Interface> interfaces=interfaceService.selectAll();
		List<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<interfaces.size();i++){
			ids.add(interfaces.get(i).getId());
		}
		Integer maxId=Collections.max(ids);
		System.out.println("id:"+maxId);
		request.setAttribute("maxId", maxId+1);
		request.setAttribute("list", menus);
		return "menu/view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		//显示父节点
		MenuCriteria criteria=new MenuCriteria();
		//criteria.setParentId(Entity.Value.eq(0));
		List<Menu> menus=menuService.selectList(criteria);
		request.setAttribute("list", menus);
		Menu menu=menuService.selectOne(id);
		request.setAttribute("bean", menu);
		return "menu/view";
	}
	/**
	 * 保存或者修改
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(HttpServletRequest request,Menu menu){		
		JsonResult result=new JsonResult();
		//设置创建时间
		menu.setCreationTime(new Date());
		//设置isleaf
		menu.setIsleaf(1);
		//设置父级菜单
		Menu menu2=menuService.selectOne(menu.getParentId());		
		if(menu2!=null){
			menu.setParentName(menu2.getName());
		}
		//添加
		if(menu!=null&&menu.getId()==null){			
			Integer addNum=menuService.save(menu);
			if(addNum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			//判断是否接口文档
			if(menu!=null&&menu.getParentId()!=null&&!"".equals(menu.getParentId())){
				//父级是否是接口管理的子节点
				Menu menu3=menuService.selectOne(menu.getParentId());
				if(menu3!=null&&menu3.getParentName().trim().equals("接口管理")){
					
				}
			}
			//添加到角色权限
			Admin admin=(Admin) request.getSession().getAttribute("USER");
			AdminRefRoleCriteria adminRefRoleCriteria=new AdminRefRoleCriteria();
			adminRefRoleCriteria.setAdminid(Entity.Value.eq(admin.getId()));
			AdminRefRole adminRefRole=adminRefRoleService.selectOne(adminRefRoleCriteria);
			RoleRefMenu roleRefMenu=new RoleRefMenu();
			roleRefMenu.setId(null);
			roleRefMenu.setRoleId(adminRefRole.getRoleid());
			roleRefMenu.setMenuId(addNum);
			roleRefMenuService.save(roleRefMenu);
			return result;
		}
		//修改
		Integer upNum=menuService.update(menu);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}		
		return result;
	}
	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){	
		JsonResult result=new JsonResult();
		
		Admin admin=(Admin) request.getSession().getAttribute("USER");
		AdminRefRoleCriteria adminRefRoleCriteria=new AdminRefRoleCriteria();
		adminRefRoleCriteria.setAdminid(Entity.Value.eq(admin.getId()));
		AdminRefRole adminRefRole=adminRefRoleService.selectOne(adminRefRoleCriteria);
		/*RoleRefMenuCriteria roleRefMenuCriteria=new RoleRefMenuCriteria();
		roleRefMenuCriteria.setMenuId(Entity.Value.eq(id));
		roleRefMenuCriteria.setRoleId(Entity.Value.eq(adminRefRole.getRoleid()));		
		Integer delNumber=roleRefMenuService.delete(roleRefMenuCriteria);*/
		
		//删除子菜单和子子菜单
		MenuCriteria criteria=new MenuCriteria();
		criteria.setParentId(Entity.Value.eq(id));
		List<Menu> list=menuService.selectList(criteria);		
		//遍历子菜单
		for(int i=0;i<list.size();i++){					
			MenuCriteria criteria2=new MenuCriteria();
			criteria2.setParentId(Entity.Value.eq(list.get(i).getId()));
			List<Menu> list2=menuService.selectList(criteria2);
			for(int j=0;j<list2.size();j++){
				//删除角色对应的菜单	信息	
				RoleRefMenuCriteria roleRefMenuCriteria=new RoleRefMenuCriteria();
				roleRefMenuCriteria.setMenuId(Entity.Value.eq(list2.get(j).getId()));
				roleRefMenuCriteria.setRoleId(Entity.Value.eq(adminRefRole.getRoleid()));		
				Integer delNumber=roleRefMenuService.delete(roleRefMenuCriteria);
				menuService.delete(list2.get(j).getId());
			}
			//删除角色对应的菜单	信息	
			RoleRefMenuCriteria roleRefMenuCriteria=new RoleRefMenuCriteria();
			roleRefMenuCriteria.setMenuId(Entity.Value.eq(list.get(i).getId()));
			roleRefMenuCriteria.setRoleId(Entity.Value.eq(adminRefRole.getRoleid()));		
			Integer delNumber=roleRefMenuService.delete(roleRefMenuCriteria);
			menuService.delete(list.get(i).getId());
		}
		Integer delNum=menuService.delete(id);
		if(delNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		//删除对应的角色关联信息
		RoleRefMenuCriteria roleRefMenuCriteria=new RoleRefMenuCriteria();
		roleRefMenuCriteria.setMenuId(Entity.Value.eq(id));
		roleRefMenuCriteria.setRoleId(Entity.Value.eq(adminRefRole.getRoleid()));		
		Integer delNumber=roleRefMenuService.delete(roleRefMenuCriteria);
		if(delNumber==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 获取所有父节点
	 * @return
	 */
	@RequestMapping(value="/getPars",method=RequestMethod.GET)
	public @ResponseBody JsonResult getParents(){
		JsonResult result=new JsonResult();
		//获取全部父节点
		MenuCriteria criteria=new MenuCriteria();
		criteria.setParentId(Entity.Value.eq(0));
		List<Menu> menus=menuService.selectList(criteria);
		result.setData(menus);
		return result;
	}
	/**
	 * 获取父节点下的子节点
	 * @return
	 */
	@RequestMapping(value="/getNodes",method=RequestMethod.GET)
	public @ResponseBody JsonResult getNodeById(Integer id){
		JsonResult result=new JsonResult();
		//获取子节点
		MenuCriteria criteria=new MenuCriteria();
		criteria.setParentId(Entity.Value.eq(id));
		List<Menu> menus=menuService.selectList(criteria);
		result.setData(menus);
		return result;
	}
}
