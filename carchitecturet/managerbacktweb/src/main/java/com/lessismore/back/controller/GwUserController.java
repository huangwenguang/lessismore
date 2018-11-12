package com.lessismore.back.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Entity.By;
import com.lessismore.commont.model.Entity.GwUserCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.RoleRefMenuCriteria;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.Admin;
import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.model.Menu;
import com.lessismore.commont.model.RoleRefMenu;
import com.lessismore.commont.service.GwUserService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.util.StringUtil;



@Controller
@RequestMapping("/gwUserMgt")
public class GwUserController {

	@Autowired
	private GwUserService gwUserService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, GwUser bean, Pagination pagination){
		GwUserCriteria criteria = new GwUserCriteria();
		//按照创建时间倒序	
		criteria.setCreateTime(Value.orderBy(By.DESC));		
		if (bean.getPhone() != null && !bean.getPhone().equals("")) {
			criteria.setPhone(Value.eq(bean.getPhone()));
		}
		Pagination list = gwUserService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		request.setAttribute("bean", bean);
		return "gwuser/list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, Integer id) {
		GwUserCriteria criteria = new GwUserCriteria();
		criteria.setId(Value.eq(id));
		GwUser gwuser =  gwUserService.selectOne(criteria);
		String visitTimee="";
		if(gwuser.getVisitTime()!=null){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			visitTimee=format.format(gwuser.getVisitTime()); 
		}		
		request.setAttribute("visitTimee", visitTimee);
		request.setAttribute("gwuser", gwuser);
	
		return "gwuser/edit_gwuser";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody JsonResult save(GwUser gwUser,String visitTimee) {		
		//return gwUserService.saveOrUpdate(gwUser);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=simpleDateFormat.parse(visitTimee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResult result=new JsonResult();
		gwUser.setVisitTime(date);
		Integer upRow=gwUserService.update(gwUser);
		if(upRow==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult del(Integer id){
		JsonResult result=new JsonResult();
		Integer upRow=gwUserService.delete(id);
		if(upRow==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
