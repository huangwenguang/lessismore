package com.lessismore.back.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.By;
import com.lessismore.commont.model.Entity.ShareCriteria;
import com.lessismore.commont.model.Admin;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Share;
import com.lessismore.commont.model.TecCoope;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.TecCoopeCriteria;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.service.ShareService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

/**
 * 页面分享
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/share")
public class ShareController {
	@Autowired
	private ShareService shareService;
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Share share,Pagination pagination){
		//获取信息
		ShareCriteria criteria=new ShareCriteria();	
		/*if(tecCoope!=null&&tecCoope.getCompanyName()!=null&&!"".equals(tecCoope.getCompanyName())){
			criteria.setCompanyName(Entity.Value.like(tecCoope.getCompanyName()+"%"));
		}*/
		//按创建时间倒序
		criteria.setCreateDate(Entity.Value.orderBy(By.DESC));
		Pagination list=shareService.selectPage(criteria, pagination);	
		List<Share> indexpro2=(List<Share>)list.getRows();
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
		return "share/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		return "share/view";
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		Share share=shareService.selectOne(id);
		//图片
		if(share!=null&&share.getPid()!=null){
			Picture picture=pictureService.selectOne(share.getPid());
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
			request.setAttribute("urls", urls);	
		}		
		request.setAttribute("bean", share);			
		return "share/view";
	}
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		Share share=shareService.selectOne(id);		
		//删除七牛的文件
		Picture picture=pictureService.selectOne(share.getPid());
		if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
			FileUploadUtil.deleteFile(picture.getPicurl());
		}
		//删除图片表
		pictureService.delete(share.getPid());
		Integer num=shareService.delete(id);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Share share,MultipartFile file){	
		JsonResult result=new JsonResult();
		//添加
		if(share!=null&&share.getId()==null){
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
			share.setPid(pcNum);
			//设置创建时间
			share.setCreateDate(new Date());
			//设置状态，默认是开启
			share.setState(1);
			Integer addRum=shareService.save(share);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);				
			}
			return result;		
		}
		//修改
		Share share2=shareService.selectOne(share.getId());
		Picture picture=pictureService.selectOne(share2.getPid());		
		if(file!=null){
			//删除七牛和图片表数据			
			if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
				FileUploadUtil.deleteFile(picture.getPicurl());
			}
			pictureService.delete(share2.getPid());	
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
			//share2.setPid(pcNum);
			share.setPid(pcNum);
		}										
		share.setUpdateDate(new Date());
		Integer upNum=shareService.update(share);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);			
		}
		return result;
	}
	@RequestMapping(value="/lock",method=RequestMethod.POST)
	public @ResponseBody JsonResult lock(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();	
		Share share=shareService.selectOne(id);
		//冻结
		if(share.getState()==1){
			share.setState(0);
		}else{
		//解锁
			share.setState(1);
		}
		//更改
		Integer num=shareService.update(share);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}				
		return result;
	}
}
