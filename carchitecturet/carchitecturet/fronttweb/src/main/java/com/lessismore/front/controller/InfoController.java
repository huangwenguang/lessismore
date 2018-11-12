package com.lessismore.front.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commont.model.Entity.InfoCriteria;
import com.commont.model.Entity.Pagination;
import com.commont.model.Company;
import com.commont.model.Info;
import com.commont.service.CompanyService;
import com.commont.service.InfoService;
import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;

/**
 * 详细信息修改处理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/info")
public class InfoController {
	@Autowired
	private InfoService infoService;
	/**
	 * 显示列表信息
	 * @param request
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getInfo(HttpServletRequest request,Pagination pagination){		
		InfoCriteria criteria=new InfoCriteria();
		Pagination list=infoService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		return "info/list";
	}
	/**
	 * 跳转页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		Info info=infoService.selectOne(id);
		request.setAttribute("bean", info);
		return "info/edit_info";
	}
	/**
	 * 修改信息
	 * @param info
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public @ResponseBody JsonResult update(Info info){
		JsonResult result=new JsonResult();
		Integer upRow=infoService.update(info);
		if(upRow==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
