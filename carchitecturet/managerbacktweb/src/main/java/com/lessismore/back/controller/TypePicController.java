package com.lessismore.back.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Comactivity;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.TypePicCriteria;
import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Entity.ComactivityCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.TypePic;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.service.TypePicService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

/**
 * 分类图片管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/typePic")
public class TypePicController {
	@Autowired
	private TypePicService typePicService;
	@Autowired
	private PictureService pictureService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getAll(HttpServletRequest request,Integer foid){
		TypePicCriteria criteria=new TypePicCriteria();
		//查询所属的技术外派的图片信息
		criteria.setForId(Entity.Value.eq(foid));
		criteria.setImgType(Entity.Value.eq(2));
		List<TypePic> typePics=typePicService.selectList(criteria);		
		List urlsList=new ArrayList();				
		for(int i=0;i<typePics.size();i++){						
				String[] urls=FileUploadUtil.getFileUrls(typePics.get(i).getImgKey());		
				urlsList.add(urls);									
		}			
		request.setAttribute("urls", urlsList);	
		request.setAttribute("list", typePics);	
		request.setAttribute("foid", foid);	
		return "tecoope/picList";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request,Integer id){	
		request.setAttribute("foid", id);
		return "tecoope/picView";
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id,Integer foid){
		TypePic typePic=typePicService.selectOne(id);
		String[] urls=FileUploadUtil.getFileUrls(typePic.getImgKey());
		request.setAttribute("urls", urls);
		request.setAttribute("bean", typePic);		
		request.setAttribute("foid", foid);
		return "tecoope/picView";
	}
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id,Integer foid){		
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
			typePic.setImgType(2);
			Integer addRum=typePicService.save(typePic);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}		
		if(file!=null){
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
		}		
		return result;
	}
}
