package com.wheat.back.controller;

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

import com.commont.model.Entity.GwUserCriteria;
import com.commont.model.Entity.Pagination;
import com.commont.model.Entity.RoleRefMenuCriteria;
import com.commont.model.Entity.Value;
import com.commont.model.Admin;
import com.commont.model.GwUser;
import com.commont.model.Menu;
import com.commont.model.RoleRefMenu;
import com.commont.service.GwUserService;
import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;
import com.commont.util.StringUtil;



@Controller
@RequestMapping("/gwUserMgt")
public class GwUserController {

	@Autowired
	private GwUserService gwUserService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, GwUser bean, Pagination pagination){
		GwUserCriteria criteria = new GwUserCriteria();
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
	
}
