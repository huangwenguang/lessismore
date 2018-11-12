package com.lessismore.interfaces.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.commont.model.Company;
import com.commont.model.Entity.CompanyCriteria;
import com.commont.model.Entity.Pagination;
import com.commont.service.CompanyService;
import com.commont.util.ErrorCode;
import com.commont.util.FileUploadUtil;
import com.commont.util.JsonResult;

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
	/**
	 * 信息显示页面
	 * @param request
	 * @param pagination
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getAll(HttpServletRequest request,Pagination pagination,Company company){
		CompanyCriteria criteria=new CompanyCriteria();
		Pagination list=companyService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		List<Company> companies=companyService.selectAll();
		String[] pic=companies.get(0).getPicture().split(";");
		List<String> picList=new ArrayList<String>();
		for(int i=0;i<pic.length;i++){
			picList.add(pic[i]);
			System.out.println("url:"+pic[i]);
		}		
		request.setAttribute("picList", picList);
		return "company/list";
	}
	/**
	 * 修改功能
	 * @param company
	 * @return
	 */
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
	/**
	 * 跳转到编辑页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		Company company=companyService.selectOne(id);
		request.setAttribute("bean", company);
		return "company/edit_company";
	}
	/**
	 * 上传照片
	 * @param files
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/uploadPic")  
	public String threeFileUpload(  
       @RequestParam("file") CommonsMultipartFile files[],  
       HttpServletRequest request, ModelMap model,Integer id) {  		
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
		/*List<String> list = new ArrayList<String>();  
		// 获得项目的路径  
		ServletContext sc = request.getSession().getServletContext();  
		// 上传位置  
		String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  
		File f = new File(path);  
		String str="";
		if (!f.exists())  
			f.mkdirs();  
  
		for (int i = 0; i < files.length; i++) {  
			// 获得原始文件名  
			String fileName = files[i].getOriginalFilename();  
			System.out.println("原始文件名:" + fileName);  
			// 新文件名  
			String newFileName = UUID.randomUUID() + fileName;  
			str+=newFileName+";";
			if (!files[i].isEmpty()) {  
				try {  
					FileOutputStream fos = new FileOutputStream(path  
                       + newFileName);  
					InputStream in = files[i].getInputStream();  
					int b = 0;  
					while ((b = in.read()) != -1) {  
                    fos.write(b);  
					}  
					fos.close();  
					in.close();  
				} catch (Exception e) {  
					e.printStackTrace();  
				}  
			}  
			System.out.println("上传图片到:" + path + newFileName); 
			System.out.println("新文件名:"+newFileName);
			//list.add(path + newFileName);
			list.add(newFileName);
		}  		*/
		// 保存文件地址，用于JSP页面回显  
		//model.addAttribute("fileList", list);  
		Company company=companyService.selectOne(id);		
		company.setPicture(str);
		companyService.update(company);
		request.setAttribute("bean", company);
		return "company/edit_company"; 
	}
}	
