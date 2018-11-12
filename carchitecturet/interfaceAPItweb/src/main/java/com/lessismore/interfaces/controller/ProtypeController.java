package com.lessismore.interfaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Protype;
import com.lessismore.commont.service.IndexproService;
import com.lessismore.commont.service.ProtypeService;
import com.lessismore.commont.util.JsonResult;

/**
 * 开发类型获取
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/Protype")
public class ProtypeController {
	@Autowired
	private ProtypeService protypeService;
	/**
	 * 获取protype的所有数据
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody JsonResult list(){
		JsonResult result=new JsonResult();
		List<Protype> protypes=protypeService.selectAll();
		result.setData(protypes);
		return result;
	}
}
