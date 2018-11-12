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
import com.lessismore.commont.model.Detail;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.CoverCriteria;
import com.lessismore.commont.model.Entity.DetailCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Protype;
import com.lessismore.commont.service.CoverService;
import com.lessismore.commont.service.DetailService;
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
@RequestMapping(value="/detail")
public class DetailController {
	@Autowired
	private CoverService coverService;	
	@Autowired
	private DetailService detailService;
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
	public String list(HttpServletRequest request,Integer cid,Pagination pagination){
		//根据类型获取案例信息,分页
		DetailCriteria criteria=new DetailCriteria();
		criteria.setCid(Entity.Value.eq(cid));
		Pagination list=detailService.selectPage(criteria, pagination);			
		//获取封面信息集合
		List<Detail> details=(List<Detail>)list.getRows();
		List urlsList=new ArrayList();				
		for(int i=0;i<details.size();i++){
			Picture picture=pictureService.selectOne(details.get(i).getPid());
			if(picture!=null){
				String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());		
				urlsList.add(urls);
			}								
		}					
		request.setAttribute("urls", urlsList);		
		request.setAttribute("pagination", list);
		request.setAttribute("typeId", cid);		
		return "detail/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request,Integer cid){
		System.out.println("type:"+cid);
		request.setAttribute("typeId", cid);		
		return "detail/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Detail detail){	
		JsonResult result=new JsonResult();
		if(detail!=null&&detail.getId()==null){
			Integer addRum=detailService.save(detail);
			if(addRum<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		Integer upNum=detailService.update(detail);
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
		Detail detail=detailService.selectOne(id);
		request.setAttribute("bean", detail);	
		request.setAttribute("typeId", detail.getCid());
		return "detail/view";
	}
	/**
	 * 删除封面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		Detail detail=detailService.selectOne(id);
		pictureService.delete(detail.getPid()); 	
		//删除七牛的文件
		Picture picture=pictureService.selectOne(detail.getPid());
		if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
			FileUploadUtil.deleteFile(picture.getPicurl());
		}
		result.setData(detail.getCid());
		if(detailService.delete(id)<1){
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
	public @ResponseBody JsonResult saveDo(@RequestParam(value="file",required=false) MultipartFile file,Detail detail){
		return detailService.saveDo(detail, file);
	}
		
		
}
