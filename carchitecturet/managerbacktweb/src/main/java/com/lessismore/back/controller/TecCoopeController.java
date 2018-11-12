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

import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.TecCoopeCriteria;
import com.lessismore.commont.model.Comactivity;
import com.lessismore.commont.model.Indexpro;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Entity.IndexproCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.TecCoope;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.service.TecCoopeService;
import com.lessismore.commont.service.TypePicService;
import com.lessismore.commont.service.WeTeamsService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

/**
 * 技术外派管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/tecCoope")
public class TecCoopeController {
	@Autowired
	private TecCoopeService coopeService;
	@Autowired
	private TypePicService typePicService;
	@Autowired
	private PictureService pictureService;
	/**
	 * 分页显示
	 * @param request
	 * @param indexpro
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,TecCoope tecCoope,Pagination pagination){
		//获取信息
		TecCoopeCriteria criteria=new TecCoopeCriteria();	
		if(tecCoope!=null&&tecCoope.getCompanyName()!=null&&!"".equals(tecCoope.getCompanyName())){
			criteria.setCompanyName(Entity.Value.like(tecCoope.getCompanyName()+"%"));
		}
		Pagination list=coopeService.selectPage(criteria, pagination);	
		List<TecCoope> indexpro2=(List<TecCoope>)list.getRows();
		List urlsList=new ArrayList();		
		//获取LOGO		
		for(int i=0;i<indexpro2.size();i++){
			Picture picture=pictureService.selectOne(indexpro2.get(i).getPid());
			if(picture!=null){
				String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());		
				urlsList.add(urls);
			}								
		}	
		request.setAttribute("urls", urlsList);		
		request.setAttribute("pagination", list);		
		return "tecoope/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		return "tecoope/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(TecCoope tecCoope,MultipartFile file){	
		JsonResult result=new JsonResult();
		if(tecCoope!=null&&tecCoope.getId()==null){
			//上传图片
			Picture picture=new Picture();
			String key="";
			try {
				key=FileUploadUtil.uploadFile(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;		
			}
			picture.setPicurl(key);
			Integer pcNum=pictureService.save(picture);
			tecCoope.setPid(pcNum);
			Integer addRum=coopeService.save(tecCoope);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);				
			}
			return result;		
		}		
		TecCoope tecCoope2=coopeService.selectOne(tecCoope.getId());
		Picture picture=pictureService.selectOne(tecCoope2.getPid());
		if(file!=null){
			//删除七牛和图片表数据			
			if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
				FileUploadUtil.deleteFile(picture.getPicurl());
			}
			pictureService.delete(tecCoope2.getPid());	
			//上传图片
			Picture picture2=new Picture();
			String key="";
			try {
				key=FileUploadUtil.uploadFile(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;		
			}
			picture2.setPicurl(key);
			Integer pcNum=pictureService.save(picture2);
			tecCoope.setPid(pcNum);
		}								
		Integer upNum=coopeService.update(tecCoope);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);			
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
		TecCoope tecCoope=coopeService.selectOne(id);
		//图片
		if(tecCoope!=null&&tecCoope.getPid()!=null){
			Picture picture=pictureService.selectOne(tecCoope.getPid());
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
			request.setAttribute("urls", urls);	
		}		
		request.setAttribute("bean", tecCoope);			
		return "tecoope/view";
	}
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		TecCoope tecCoope=coopeService.selectOne(id);		
		//删除七牛的文件
		Picture picture=pictureService.selectOne(tecCoope.getPid());
		if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
			FileUploadUtil.deleteFile(picture.getPicurl());
		}
		//删除图片表
		pictureService.delete(tecCoope.getPid());
		Integer num=coopeService.delete(id);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
