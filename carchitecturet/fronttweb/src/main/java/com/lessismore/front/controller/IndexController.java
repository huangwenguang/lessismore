package com.lessismore.front.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Company;
import com.lessismore.commont.model.Info;
import com.lessismore.commont.service.CompanyService;
import com.lessismore.commont.service.InfoService;
import com.lessismore.commont.util.JsonResult;
@Controller
public class IndexController {
	@Autowired
	private InfoService infoService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String indexPage(HttpServletRequest request){
		//info信息
		Info info=infoService.selectAll().get(0);
		//company信息
		Company company=companyService.selectAll().get(0);
		request.getSession().setAttribute("info", info);
		request.getSession().setAttribute("company", company);
		return "index";
	}
	
}
