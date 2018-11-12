package com.wheat.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commont.model.Entity.Pagination;
import com.commont.model.Entity.UserCriteria;
import com.commont.model.Entity.Value;
import com.commont.model.User;
import com.commont.service.UserService;



@Controller
@RequestMapping("/userMgt")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, User bean, Pagination pagination){
		UserCriteria criteria = new UserCriteria();
		if (bean.getPhone() != null && !bean.getPhone().equals("")) {
			criteria.setPhone(Value.eq(bean.getPhone()));
		}
		Pagination list = userService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		request.setAttribute("bean", bean);
		return "user/list";
	}
	
}
