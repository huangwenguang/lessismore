package com.lessismore.interfaces.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.lessismore.commont.model.Company;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Info;
import com.lessismore.commont.model.TypePic;
import com.lessismore.commont.model.WeTeams;
import com.lessismore.commont.model.Entity.CompanyCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.TypePicCriteria;
import com.lessismore.commont.service.CompanyService;
import com.lessismore.commont.service.TypePicService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

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
	@Autowired
	private TypePicService typePicService;
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
		Company company=companyService.selectOne(id);		
		company.setPicture(str);
		companyService.update(company);
		request.setAttribute("bean", company);
		return "company/edit_company"; 
	}
	/**
	 * 专用接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/infoApi",method=RequestMethod.GET)
	public @ResponseBody JsonResult getAllInfo(HttpServletRequest request){
		JsonResult result=new JsonResult();	
		//company信息
		Company company=companyService.selectAll().get(0);
		String[] urls=company.getPicture().split(";");
		List list=new ArrayList();
		for(int i=0;i<urls.length;i++){
			String[] us=FileUploadUtil.getFileUrls(urls[i]);
			Map mapUrl=new HashMap();
			mapUrl.put("sm",us[0]);
			mapUrl.put("md",us[1]);
			mapUrl.put("lg",us[2]);
			Map map=new HashMap();			
			map.put("img", mapUrl);
			map.put("content", company.getContent());
			list.add(i, map);
		}
		result.setData(list);
		return result;
	}
	//获取图片
	@RequestMapping(value="/comPic",method=RequestMethod.GET)
	public @ResponseBody JsonResult getAllPic(HttpServletRequest request){
		/*JsonResult result=new JsonResult();			
		//company信息
		String pics="";
		Company company=companyService.selectAll().get(0);
		if(company!=null&&company.getPicture()!=null&&!"".equals(company.getPicture())){
			pics=company.getPicture();
		}		
		String[] pictures=pics.split(";");
		Map map=new HashMap();
		//0
		String[] firImg=FileUploadUtil.getFileUrls(pictures[0]);
		map.put("firImg", firImg);
		//1,2,3,4
		List imgs=new ArrayList();
		for(int i=1;i<pictures.length;i++){
			String[] urls=FileUploadUtil.getFileUrls(pictures[i]);
			Map mapUrls=new HashMap();
			mapUrls.put("urls", urls);
			imgs.add(mapUrls);
		}		
		map.put("tfImgs", imgs);
		result.setData(map);*/
		JsonResult jsonResult=new JsonResult();
		//接收数据的集合
		Map map=new HashMap();
		//获取我的团队信息
		List<Company> teams=companyService.selectAll();		
		//遍历我的团队，获取对应的图片
		for(int i=0;i<teams.size();i++){
			//获取对应的图片,type=1,for_id=我的团队的主键
			TypePicCriteria criteria=new TypePicCriteria();
			criteria.setImgType(Entity.Value.eq(3));
			criteria.setForId(Entity.Value.eq(teams.get(i).getId()));
			List<TypePic> list=typePicService.selectList(criteria);	
			List picList=new ArrayList();
			String[] firImg=FileUploadUtil.getFileUrls(list.get(0).getImgKey());
			map.put("firImg", firImg);
			for(int j=0;j<list.size();j++){
				if(j>0){
					String[] typics=FileUploadUtil.getFileUrls(list.get(j).getImgKey());
					Map mappic=new HashMap();
					/*mappic.put("sm",typics[0]);
					mappic.put("md",typics[1]);
					mappic.put("lg",typics[2]);*/
					mappic.put("urls", typics);
					picList.add(mappic);
				}				
			}		
			map.put("content", teams.get(i).getContent());
			map.put("tfImgs", picList);
		}
		jsonResult.setData(map);
		return jsonResult;
	}
}	
