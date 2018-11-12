package com.lessismore.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lessismore.commont.model.Entity.LogrecordCriteria;
import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.model.Entity.By;
import com.lessismore.commont.model.Entity.GwUserCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.Logrecord;
import com.lessismore.commont.service.LogrecordService;
/**
 * 日志记录列表
 * @author Administrator
 *
 */
@Controller
@RequestMapping("Logrecord")
public class LogrecordController {
	@Autowired
	private LogrecordService logrecordService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Logrecord bean, Pagination pagination){
		LogrecordCriteria criteria = new LogrecordCriteria();
		//按照操作时间倒序	
		criteria.setMakeTime(Value.orderBy(By.DESC));
		
		Pagination list = logrecordService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);		
		return "logrecord/list";
	}
}
