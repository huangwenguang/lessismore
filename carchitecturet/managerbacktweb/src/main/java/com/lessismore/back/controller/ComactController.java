package com.lessismore.back.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Comactivity;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Entity.ComactivityCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.service.ComactivityService;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

/**
 * 公司活动处理类
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/comact")
public class ComactController {
	@Autowired
	private ComactivityService service;
	@Autowired
	private PictureService pictureService;
	
	/**
	 * 展示信息列表
	 * @param request
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getAll(HttpServletRequest request,Pagination pagination){
		ComactivityCriteria criteria=new ComactivityCriteria();
		Pagination list=service.selectPage(criteria, pagination);
		List<Comactivity> comactivities=(List<Comactivity>)list.getRows();
		List urlsList=new ArrayList();				
		for(int i=0;i<comactivities.size();i++){
			Picture picture=pictureService.selectOne(comactivities.get(i).getPid());
			if(picture!=null){
				String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());		
				urlsList.add(urls);
			}								
		}	
		request.setAttribute("pagination", list);
		request.setAttribute("urls", urlsList);
		return "comactiv/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		return "comactiv/view";
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		Comactivity comactivity=service.selectOne(id);
		request.setAttribute("bean", comactivity);			
		return "comactiv/view";
	}
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		Comactivity comactivity=service.selectOne(id);
		pictureService.delete(comactivity.getPid());
		//删除七牛的文件
		Picture picture=pictureService.selectOne(comactivity.getPid());
		if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
			FileUploadUtil.deleteFile(picture.getPicurl());
		}
		if(service.delete(id)<1){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 上传信息
	 * @param file
	 * @param partners
	 * @return
	 */
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult saveDo(@RequestParam(value="file",required=false) MultipartFile file,Comactivity comactivity){
		return service.saveDo(comactivity, file);
	}
}
