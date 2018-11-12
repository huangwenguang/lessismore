package com.lessismore.back.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lessismore.commont.model.Company;
import com.lessismore.commont.model.Cover;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.CoverCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Protype;
import com.lessismore.commont.service.CoverService;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.service.ProtypeService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

/**
 * 项目封面处理类
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/cover")
public class CoverController {
	@Autowired
	private CoverService coverService;	
	@Autowired
	private ProtypeService protypeService;
	@Autowired
	private PictureService pictureService;
	/**
	 * 根据类型id获取封面信息
	 * @param request
	 * @param id
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Integer typeId,Pagination pagination){
		//根据类型获取封面信息,分页
		CoverCriteria criteria=new CoverCriteria();
		criteria.setType(Entity.Value.eq(typeId));
		Pagination list=coverService.selectPage(criteria, pagination);			
		//获取封面信息集合
		List<Cover> covers=(List<Cover>)list.getRows();		
		List urlsList=new ArrayList();						
		for(int i=0;i<covers.size();i++){
			Picture picture=pictureService.selectOne(covers.get(i).getPid());
			if(picture!=null){
				String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
				urlsList.add(urls);			
			}			
		}
		for(int k=0;k<urlsList.size();k++){
			System.out.println("ueljihe:"+urlsList.get(k));
		}
		Protype protype=protypeService.selectOne(typeId);
		request.setAttribute("urls", urlsList);
		request.setAttribute("protype", protype);
		request.setAttribute("pagination", list);
		request.setAttribute("typeId", typeId);
		return "cover/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request,Integer typeId){
		System.out.println("type:"+typeId);
		request.setAttribute("typeId", typeId);		
		return "cover/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Cover cover){	
		JsonResult result=new JsonResult();
		if(cover!=null&&cover.getId()==null){
			Integer addRum=coverService.save(cover);
			if(addRum<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		Integer upNum=coverService.update(cover);
		if(upNum<1){
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
		Cover cover=coverService.selectOne(id);
		request.setAttribute("bean", cover);	
		request.setAttribute("typeId", cover.getType());
		return "cover/view";
	}
	/**
	 * 删除封面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		Cover cover=coverService.selectOne(id);
		pictureService.delete(cover.getPid());
		//删除七牛的文件
		Picture picture=pictureService.selectOne(cover.getPid());
		if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
			FileUploadUtil.deleteFile(picture.getPicurl());
		}
		result.setData(cover.getType());
		if(coverService.delete(id)<1){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 上传图片和信息
	 * @param file
	 * @param cover
	 * @return
	 */
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult saveDo(@RequestParam(value="file",required=false) MultipartFile file,Cover cover){
		return coverService.saveDo(cover, file);
	}
		
		
}
