package com.lessismore.commont.service;

import java.util.List;


import com.lessismore.commont.model.Menu;
import com.lessismore.commont.model.RoleRefMenu;

public interface MenuService extends BaseService<Integer, Menu> {

	/**
	 * 根据adminid获取菜单列表
	 */
	
	List<Menu> getMenuListByAdmin(int adminid,String name);
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	List<Menu> getMenus();
	
	/**
	 * 根据角色Id获取其所绑定的菜单
	 * @return
	 */
	List<RoleRefMenu> getMenuListByRoleId(int roleId);
	
	
	List<Menu> getMenuListByUser(String userId);
}