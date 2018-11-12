package com.lessismore.interfaces.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lessismore.commont.model.Company;
import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.service.CompanyService;
import com.lessismore.commont.service.GwUserService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;


@Controller
@RequestMapping("/gwUser")
public class GwUserController {
	
	@Autowired
	private GwUserService gwUserService;
	@Autowired
	private CompanyService companyService;
	/**
	 * 留言系统
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
	/*@RequestMapping(value = "/save", method = RequestMethod.GET)
	public @ResponseBody JsonResult save(HttpServletRequest request, GwUser gwUser) {
		JsonResult result = new JsonResult();
		gwUser.setCreateTime(new Date());
		result.setData(gwUserService.save(gwUser));
		System.out.print(result);
		return result;
	}*/
	/**
	 *上产图片
	 * @param files
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/uploadPic")  
	public @ResponseBody JsonResult threeFileUpload(  
       @RequestParam("file") CommonsMultipartFile files[],  
       HttpServletRequest request, ModelMap model,Integer id) {  
		JsonResult result=new JsonResult();
		String str="";
		//for (CommonsMultipartFile commonsMultipartFile : files) {
		for(int i=0;i<files.length;i++){
			if(!files[i].isEmpty()){
			//上传图片，拿到图片Key
			//String key = FileUploadUtil.uploadFile(commonsMultipartFile.getBytes());
			String key = FileUploadUtil.uploadFile(files[i].getBytes());
			System.out.println("key:"+key);
			//把key保存到数据库
			str+=key+";";			
			//获取图片路径的时候调用工具类传入key获取url数组，页面用img标签的src属性读取
			String[] urls = FileUploadUtil.getFileUrls(key);
				for(int j=0;j<urls.length;j++){
					System.out.println("urls:"+urls[j]);
				}
		
			}
		}		
		Company company=companyService.selectOne(id);
		company.setPicture(str);
		companyService.update(company);
		//request.setAttribute("bean", company);		
		return result; 
	}
}
