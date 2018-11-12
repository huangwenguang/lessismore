package com.commont.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.commont.dao.MenuDao;
import com.commont.model.AdminRefRole;
import com.commont.model.Entity.AdminRefRoleCriteria;
import com.commont.model.Entity.Value;
import com.commont.model.Menu;
import com.commont.model.RoleRefMenu;
import com.commont.service.AdminRefRoleService;
import com.commont.service.MenuService;
import com.commont.service.RoleRefMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Integer, Menu> implements MenuService {
	
	@Autowired
	private MenuDao dao;
	
	@Autowired
	private AdminRefRoleService adminRefRoleService;
	
	@Autowired
	private RoleRefMenuService roleRefMenuService;
	

	public List<Menu> getMenuListByAdmin(int adminId) {
		System.out.println("adminId:"+adminId);
		// 1.根据adminid获取该用户的角色列表
		// admin ---> role
		AdminRefRoleCriteria adminRefRoleCriteria =  new AdminRefRoleCriteria();
		adminRefRoleCriteria.setAdminid(Value.eq(adminId));
		List<AdminRefRole> list = adminRefRoleService.selectList(adminRefRoleCriteria);
		// 组装成一个Integer数组，用于查询
		if (list.size() == 0) {
			return new ArrayList<Menu>();
		}
		List<Integer> roleIds = new ArrayList<Integer>();
		for (AdminRefRole ar : list) {
			roleIds.add(ar.getRoleid());
		}
		
		// 2.根据该用户的角色列表来获取每个角色所拥有的菜单权限
		// role ---> menu
		List<Menu> menus = dao.getMenusByRoleIds(roleIds);
		System.out.println("menus size" + menus.size());
		// 4.遍历菜单做成树形格式
		// 0是最高级节点		
		List<Menu> roots = getChilds(menus, 0);//报错
		dg(menus,roots);
		return roots;
	}

	// 递归所有菜单
		public void dg(List<Menu> allMenus,List<Menu> list){
			for(Menu menu : list){
				int id = menu.getId();
				List<Menu> childs = getChilds(allMenus, id);
				if(!childs.isEmpty()){
					menu.setList(childs);
					dg(allMenus,childs);
				}
			}
		}
		
		// 根据parentId 获取所有子节点
		public List<Menu> getChilds(List<Menu> list , int parentId){
			List<Menu> childs = new ArrayList<Menu>();
			for(Menu menu : list){				
				int _parentId = menu.getParentId();//报错
				if(parentId ==_parentId){
					childs.add(menu);
				}
			}
			return childs;
		}
		

	public List<Menu> getMenus() {
		List<Menu> menus = selectAll();
		List<Menu> roots = getChilds(menus, 0);
		dg(menus,roots);
		return roots;
	}

	
	public List<RoleRefMenu> getMenuListByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Menu> getMenuListByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}