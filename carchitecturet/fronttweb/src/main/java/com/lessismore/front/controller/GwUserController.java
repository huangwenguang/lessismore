package com.lessismore.front.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.service.GwUserService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;


/**
 * 官网处理类
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/gwUser")
public class GwUserController {
	@Autowired
	private GwUserService gwUserService;
	/**
	 * 用户留言提交
	 * @param request
	 * @param gwUser
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(GwUser gwUser){
		System.out.println("enter save");
		JsonResult result=new JsonResult();
		//gwUser.setIp(request.getRemoteAddr());//ip
		//gwUser.setPlatform(request.getHeader("user-agent"));//浏览器信息			
		gwUser.setCreateTime(new Date());//提交时间
		Integer num=gwUserService.save(gwUser);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	
}
