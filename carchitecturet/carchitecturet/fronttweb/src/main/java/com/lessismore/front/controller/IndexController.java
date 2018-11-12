package com.lessismore.front.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commont.model.Company;
import com.commont.model.Info;
import com.commont.service.CompanyService;
import com.commont.service.InfoService;
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
