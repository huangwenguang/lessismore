package com.lessismore.back.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Admin;
import com.lessismore.commont.model.Logrecord;
import com.lessismore.commont.model.Menu;
import com.lessismore.commont.service.AdminService;
import com.lessismore.commont.service.LogrecordService;
import com.lessismore.commont.service.MenuService;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;



@Controller
public class CenterController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private LogrecordService logrecordService;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main(HttpServletRequest request,String name) {
		Admin u = (Admin) request.getSession().getAttribute("USER");
		if (u == null) {
			return "login/login";
		}
		request.setAttribute("USER", u);
		System.out.println("id:"+u.getId());
		List<Menu> list = menuService.getMenuListByAdmin(u.getId(),name);
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
		Admin admin=(Admin) request.getSession().getAttribute("USER");
		if(admin!=null){
			//添加操作日志记录
			Logrecord logrecord=new Logrecord();
			logrecord.setId(null);
			logrecord.setType(2);
			logrecord.setContent("成功退出系统");
			logrecord.setMakeClass("com.wheat.back.controller.CenterController#logout");
			
			logrecord.setMakePeople(admin.getUserName());
			logrecord.setMakeTime(new Date());
			String ip=(String) request.getSession().getAttribute("ip");
			logrecord.setIp(ip);
			logrecordService.save(logrecord);
		}		
		request.getSession().invalidate();		
		return "login/login";
	}
}
