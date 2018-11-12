package com.lessismore.front.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Company;
import com.lessismore.commont.model.Info;
import com.lessismore.commont.model.Entity.CompanyCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.service.CompanyService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

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
	@RequestMapping(value="/comApi",method=RequestMethod.GET)
	public @ResponseBody JsonResult getAllInfo(HttpServletRequest request){
		JsonResult result=new JsonResult();			
		//company信息
		Company company=companyService.selectAll().get(0);			
		result.setData(company);
		return result;
	}
	@RequestMapping(value="/comPic",method=RequestMethod.GET)
	public @ResponseBody JsonResult getAllPic(HttpServletRequest request){
		JsonResult result=new JsonResult();			
		//company信息
		String pics="";
		Company company=companyService.selectAll().get(0);
		if(company!=null&&company.getPicture()!=null&&!"".equals(company.getPicture())){
			pics=company.getPicture();
		}		
		String[] pictures=pics.split(";");
		Map map=new HashMap();
		//0
		String[] firImg=FileUploadUtil.getFileUrls(pictures[0]);
		map.put("firImg", firImg);
		//1,2,3,4
		List imgs=new ArrayList();
		for(int i=1;i<pictures.length;i++){
			String[] urls=FileUploadUtil.getFileUrls(pictures[i]);
			Map mapUrls=new HashMap();
			mapUrls.put("urls", urls);
			imgs.add(mapUrls);
		}		
		map.put("tfImgs", imgs);
		result.setData(map);
		return result;
	}
}
