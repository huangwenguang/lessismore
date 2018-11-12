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
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.RoleRefMenuCriteria;
import com.lessismore.commont.model.Entity.UserCriteria;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.Menu;
import com.lessismore.commont.model.Role;
import com.lessismore.commont.model.RoleRefMenu;
import com.lessismore.commont.service.MenuService;
import com.lessismore.commont.service.RoleRefMenuService;
import com.lessismore.commont.service.RoleService;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.util.StringUtil;



@Controller
@RequestMapping("roleMgt")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleRefMenuService roleRefMenuService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, UserCriteria criteria, Pagination pagination){
		Pagination list = roleService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		return "role/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		return "role/view";
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, Integer id) {	
		
		// 所有菜单
		List<Menu> menus = menuService.getMenus();
		
		// 已对该角色分配了的菜单列表
		RoleRefMenuCriteria menuCriteria = new RoleRefMenuCriteria();
		menuCriteria.setRoleId(Value.eq(id));
		List<RoleRefMenu> rms =  roleRefMenuService.selectList(menuCriteria);				
		request.setAttribute("menuids", StringUtil.toMenuIdsString(rms));
		request.setAttribute("menus", menus);
		request.setAttribute("roleId", id);
		return "role/edit_menu";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JsonResult save(Role role) {
		return roleService.saveOrUpdate(role);
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public @ResponseBody JsonResult del(HttpServletRequest request, Integer id) {
		int d = roleService.delete(id);
		if (d > 0) {
			RoleRefMenuCriteria criteria = new RoleRefMenuCriteria();
			criteria.setRoleId(Value.eq(id));
			List<RoleRefMenu> list = roleRefMenuService.selectList(criteria);
			for (RoleRefMenu menu : list) {
				roleRefMenuService.delete(menu.getId());
			}
		}
		return new JsonResult();
	}
	
	
	@RequestMapping(value = "/save_menu", method = RequestMethod.POST)
	public @ResponseBody JsonResult saveMenu(HttpServletRequest request, Integer[] menuIds, Integer roleId) {
		return roleRefMenuService.saveRoleMenuByMgt(menuIds, roleId);
	}
}
