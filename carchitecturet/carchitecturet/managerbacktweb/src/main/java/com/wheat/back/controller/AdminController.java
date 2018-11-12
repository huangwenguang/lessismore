package com.wheat.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commont.model.Admin;
import com.commont.model.Entity.AdminCriteria;
import com.commont.model.Entity.Pagination;
import com.commont.model.Entity.Value;
import com.commont.model.Role;
import com.commont.service.AdminService;
import com.commont.service.RoleService;
import com.commont.service.UserService;
import com.commont.util.JsonResult;



@Controller
@RequestMapping("adminMgt")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;

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
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) {
		List<Role> roles = roleService.selectAll();
		request.setAttribute("roles", roles);
		return "admin/view";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JsonResult save(Admin admin, Integer[] roleids) {
		return adminService.saveOrUpdate(admin, roleids);
	}
}
