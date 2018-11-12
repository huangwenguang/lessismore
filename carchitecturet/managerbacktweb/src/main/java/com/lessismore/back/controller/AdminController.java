package com.lessismore.back.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Admin;
import com.lessismore.commont.model.AdminRefRole;
import com.lessismore.commont.model.Comactivity;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Entity.AdminCriteria;
import com.lessismore.commont.model.Entity.AdminRefRoleCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.Role;
import com.lessismore.commont.service.AdminRefRoleService;
import com.lessismore.commont.service.AdminService;
import com.lessismore.commont.service.RoleService;
import com.lessismore.commont.service.UserService;
import com.lessismore.commont.util.CryptUtil;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;



@Controller
@RequestMapping("adminMgt")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AdminRefRoleService adminRefRoleService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Admin bean, Pagination pagination) {
		AdminCriteria criteria = new AdminCriteria();
		if (bean.getUserName() != null && !bean.getUserName().equals("")) {
			criteria.setUserName(Value.eq(bean.getUserName()));
		}
		Pagination list = adminService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		request.setAttribute("bean", bean);
		return "admin/list";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		List<Role> roles = roleService.selectAll();
		request.setAttribute("roles", roles);
		return "admin/view";
	}
	//进入修改页面
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id) {
		Admin admin=adminService.selectOne(id);
		request.setAttribute("bean", admin);		
		//获取用户对应的角色
		AdminRefRoleCriteria criteria=new AdminRefRoleCriteria();
		criteria.setAdminid(Entity.Value.eq(id));
		List<AdminRefRole> adminRefRoles=adminRefRoleService.selectList(criteria);
		request.setAttribute("list", adminRefRoles);
		List<Role> roles = roleService.selectAll();
		request.setAttribute("roles", roles);
		return "admin/editView";
	}
	//进入修改密码页面
	@RequestMapping(value = "/passEdit", method = RequestMethod.GET)
	public String passEdit(HttpServletRequest request) {
		Admin admin=(Admin) request.getSession().getAttribute("USER");
		request.setAttribute("bean", admin);
		return "admin/passView";
	}
	//修改密码功能
	@RequestMapping(value = "/replace", method = RequestMethod.POST)
	public @ResponseBody JsonResult save(Admin admin,String newUserPwd) {
		JsonResult result=new JsonResult();
		if(admin!=null&&admin.getUserPwd()==null||"".equals(admin.getUserPwd())){
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;			
		}
		if(newUserPwd==null||"".equals(newUserPwd)){
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		//判断确认密码			
		if(!admin.getUserPwd().equals(newUserPwd)){
			result.addErrorCode(ErrorCode.CUSTOM_PHONE_NOT_DIFFERENT);
			return result;
		}
		admin.setUserPwd(CryptUtil.md5(admin.getUserPwd()));//加密
		Integer num=adminService.update(admin);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();		
		Integer num=adminService.delete(id);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	
	/**
	 * 解冻账户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/lock",method=RequestMethod.POST)
	public @ResponseBody JsonResult lock(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();	
		Admin admin=adminService.selectOne(id);
		//冻结
		if(admin.getState()==1){
			admin.setState(-1);
		}else{
		//解锁
			admin.setState(1);
		}
		Integer num=adminService.update(admin);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JsonResult save(Admin admin, Integer[] roleids,String newUserPwd) {
		return adminService.saveOrUpdate(admin, roleids,newUserPwd);
	}
	/**
	 * 获取当前登录用户外的其他所有用户
	 * @return
	 */
	@RequestMapping(value = "/getOther", method = RequestMethod.GET)
	public @ResponseBody JsonResult getOther(HttpServletRequest request) {
		Admin u = (Admin) request.getSession().getAttribute("USER");
		List<Integer> ids=new ArrayList<Integer>();
		//不满足的参数ID,如果当前用户不是超级管理员
		if(u!=null&&u.getId()!=1){
			ids.add(1);
			ids.add(u.getId());
		}else{
			ids.add(u.getId());
		}
		AdminCriteria adminCriteria=new AdminCriteria();
		adminCriteria.setId(Value.ne(u.getId()));
		List<Admin> list=adminService.selectList(adminCriteria);
		JsonResult result=new JsonResult();
		result.setData(list);
		return result;
	}
	/**
	 * 根据ID获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public @ResponseBody JsonResult getById(Integer id) {
		JsonResult result=new JsonResult();
		Admin admin=adminService.selectOne(id);
		result.setData(admin);
		return result;
	}
}
