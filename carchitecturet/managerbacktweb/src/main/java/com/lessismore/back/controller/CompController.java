package com.lessismore.back.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lessismore.commont.model.Company;
import com.lessismore.commont.model.Entity;
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
public class CompController {
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
		/*CompanyCriteria criteria=new CompanyCriteria();
		Pagination list=companyService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		List<Company> companies=companyService.selectAll();
		List picList=new ArrayList();
		for(int i=0;i<companies.size();i++){
			String[] keys=companies.get(i).getPicture().split(";");
			for(int j=0;j<keys.length;j++){
				String[] urls=FileUploadUtil.getFileUrls(keys[j]);				
				picList.add(j, urls);
			}
		}
		String[] pic=companies.get(0).getPicture().split(";");
		List<String> picList=new ArrayList<String>();
		for(int i=0;i<pic.length;i++){
			picList.add(pic[i]);
			System.out.println("url:"+pic[i]);
		}		
		request.setAttribute("picList", picList);*/
		List<Company> companies=companyService.selectAll();
		if(companies.size()>0){
			//获取图片
			TypePicCriteria criteria=new TypePicCriteria();
			criteria.setImgType(Entity.Value.eq(3));		
			//我的团队里的照片列表
			//List<TypePic> list=typePicService.selectList(criteria);
			Pagination listPa=typePicService.selectPage(criteria, pagination);
			List<TypePic> list=(List<TypePic>)listPa.getRows();
			List urlsList=new ArrayList();				
			for(int i=0;i<list.size();i++){								
					String[] urls=FileUploadUtil.getFileUrls(list.get(i).getImgKey());		
					urlsList.add(urls);										
			}	
			request.setAttribute("urls", urlsList);
			request.setAttribute("list", listPa);
			request.setAttribute("bean", companies.get(0));
		}		
		return "company/list";
	}
	/**
	 * 调到添加图片页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request,Integer id){	
		request.setAttribute("foid", id);
		return "company/view";
	}
	/**
	 * 修改或者添加图片
	 * @param indexpro
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(TypePic typePic,Integer foid,MultipartFile file){	
		JsonResult result=new JsonResult();
		if(typePic!=null&&typePic.getId()==null){
			//上传图片
			String key="";			
			try {
				key = FileUploadUtil.uploadFile(file.getBytes());			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				result.addErrorCode(ErrorCode.RUNTIME_EXCEPTION_HANDLER);
				return result;
			}					
			typePic.setForId(foid);
			typePic.setImgKey(key);
			typePic.setImgType(3);
			Integer addRum=typePicService.save(typePic);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}		
		TypePic pic=typePicService.selectOne(typePic.getId());
		//删除7牛的图片
		FileUploadUtil.deleteFile(pic.getImgKey());
		//上传图片		
		String key="";
		try {
			key = FileUploadUtil.uploadFile(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result.addErrorCode(ErrorCode.RUNTIME_EXCEPTION_HANDLER);
			return result;
		}	
		pic.setImgKey(key);
		Integer upNum=typePicService.update(pic);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		TypePic typePic=typePicService.selectOne(id);
		String[] urls=FileUploadUtil.getFileUrls(typePic.getImgKey());
		request.setAttribute("urls", urls);
		request.setAttribute("bean", typePic);			
		return "company/view";
	}
	/**
	 * 删除图片
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		TypePic typePic=typePicService.selectOne(id);
		Integer num=typePicService.delete(id);	
		//删除七牛的文件
		FileUploadUtil.deleteFile(typePic.getImgKey());		
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/editWe",method=RequestMethod.GET)
	public String editWe(HttpServletRequest request,Integer id){
		Company teams=companyService.selectOne(id);
		request.setAttribute("bean", teams);			
		return "company/viewWe";
	}
	@RequestMapping(value="/editWeDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult editWeDo(Company teams){
		JsonResult result=new JsonResult();
		Integer num=companyService.update(teams);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);			
		}
		return result;
	}
	/**
	 * 修改功能
	 * @param company
	 * @return
	 *//*
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
	*//**
	 * 跳转到编辑页面
	 * @param request
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		Company company=companyService.selectOne(id);
		request.setAttribute("bean", company);
		return "company/edit_company";
	}

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
		List<String> list = new ArrayList<String>();  
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
		}  		
		// 保存文件地址，用于JSP页面回显  
		//model.addAttribute("fileList", list);  
		Company company=companyService.selectOne(id);
		
		company.setPicture(str);
		companyService.update(company);
		request.setAttribute("bean", company);
		return "company/edit_company"; 
	}*/
}	
