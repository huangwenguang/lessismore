package com.lessismore.front.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commont.model.Company;
import com.commont.model.Entity.CompanyCriteria;
import com.commont.model.Entity.Pagination;
import com.commont.service.CompanyService;
import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;

/**
 * 关于我们
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/company")
public class compController {
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getAll(HttpServletRequest request,Pagination pagination,Company company){
		CompanyCriteria criteria=new CompanyCriteria();
		Pagination list=companyService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		return "index";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public @ResponseBody JsonResult update(Company company){
		JsonResult result=new JsonResult();
		Integer upRow=companyService.update(company);
		if(upRow==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
