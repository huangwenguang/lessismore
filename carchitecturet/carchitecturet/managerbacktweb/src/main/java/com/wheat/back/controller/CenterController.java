package com.wheat.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commont.model.Admin;
import com.commont.model.Menu;
import com.commont.service.AdminService;
import com.commont.service.MenuService;
import com.commont.util.FileUploadUtil;
import com.commont.util.JsonResult;



@Controller
public class CenterController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main(HttpServletRequest request) {
		Admin u = (Admin) request.getSession().getAttribute("USER");
		if (u == null) {
			return "login/login";
		}
		request.setAttribute("USER", u);
		System.out.println("id:"+u.getId());
		List<Menu> list = menuService.getMenuListByAdmin(u.getId());
		System.out.println("id 执行后");
		request.setAttribute("menus", list);
		System.out.println(list);
		return "login/home";
	}

	@RequestMapping(value = "/getLogin", method = RequestMethod.POST)
	public @ResponseBody JsonResult getLogin(String passport, String passwd, HttpServletRequest request)  throws Exception {
		JsonResult result = adminService.Login(passport, passwd);
		if (result.getStatus() == 1) {
			request.getSession().setAttribute("USER", result.getData());
		}
		return result;
	}

	@RequestMapping(value="/welcome",method= RequestMethod.GET)
    public String welcome() {
    	return "login/login";
    }
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		return "login/login";
	}
}
