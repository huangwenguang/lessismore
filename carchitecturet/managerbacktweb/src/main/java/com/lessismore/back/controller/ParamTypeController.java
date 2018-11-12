package com.lessismore.back.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.ParamType;
import com.lessismore.commont.model.Entity.By;
import com.lessismore.commont.model.Entity.GwUserCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.ParamTypeCriteria;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.service.ParamTypeService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;

/**
 * 字段类型管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/paramType")
public class ParamTypeController {
	@Autowired
	private ParamTypeService paramTypeService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, ParamType bean, Pagination pagination){
		ParamTypeCriteria criteria = new ParamTypeCriteria();
		//按照创建时间倒序			
		criteria.setCreateDate(Value.orderBy(By.DESC));
		Pagination list = paramTypeService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);		
		return "paramType/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		return "paramType/view";
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		ParamType paramType=paramTypeService.selectOne(id);
		request.setAttribute("bean", paramType);			
		return "paramType/view";
	}
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();		
		Integer num=paramTypeService.delete(id);
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
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(ParamType paramType){	
		JsonResult result=new JsonResult();
		if(paramType!=null&&paramType.getId()==null){
			paramType.setCreateDate(new Date());
			Integer addRum=paramTypeService.save(paramType);
			if(addRum<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		paramType.setUpdateDate(new Date());
		Integer upNum=paramTypeService.update(paramType);
		if(upNum<1){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * ajax获取全部数据
	 * @return
	 */
	@RequestMapping(value="/ajaxGet",method=RequestMethod.GET)
	public @ResponseBody JsonResult ajaxGet(){
		JsonResult jsonResult=new JsonResult();
		List<ParamType> types=paramTypeService.selectAll();
		jsonResult.setData(types);
		return jsonResult;
	}
}
