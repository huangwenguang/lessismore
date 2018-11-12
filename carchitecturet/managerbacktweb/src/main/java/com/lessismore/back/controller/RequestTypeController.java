package com.lessismore.back.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.lessismore.commont.model.Entity.By;
import com.lessismore.commont.model.Entity.GwUserCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.RequestTypeCriteria;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.RequestType;
import com.lessismore.commont.service.RequestTypeService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;
/**
 * 请求类型管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/requestType")
public class RequestTypeController {
	@Autowired
	private RequestTypeService requestTypeService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, RequestType bean, Pagination pagination){
		RequestTypeCriteria criteria = new RequestTypeCriteria();
		//按照创建时间倒序	
		criteria.setCreateDate(Value.orderBy(By.DESC));			
		Pagination list = requestTypeService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);		
		return "requestType/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		return "requestType/view";
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		RequestType requestType=requestTypeService.selectOne(id);
		request.setAttribute("bean", requestType);			
		return "requestType/view";
	}
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();		
		Integer num=requestTypeService.delete(id);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(RequestType requestType){	
		JsonResult result=new JsonResult();
		if(requestType!=null&&requestType.getId()==null){
			requestType.setCreateDate(new Date());
			Integer addRum=requestTypeService.save(requestType);
			if(addRum<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		requestType.setUpdateDate(new Date());
		Integer upNum=requestTypeService.update(requestType);
		if(upNum<1){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
