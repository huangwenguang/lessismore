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
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.PartnersCriteria;
import com.lessismore.commont.model.Partners;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.service.PartnersService;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

@Controller
@RequestMapping(value="/partners")
public class PartnersController {
	@Autowired
	private PartnersService partnersService;
	@Autowired
	private PictureService pictureService;
	/**
	 * 获取合作企业信息
	 * @param request
	 * @param partners
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Partners partners,Pagination pagination){
		//获取所有合作伙伴信息
		PartnersCriteria criteria=new PartnersCriteria();	
		if(partners!=null&&partners.getName()!=null&&!"".equals(partners.getName())){
			criteria.setName(Entity.Value.like(partners.getName()));
		}
		Pagination list=partnersService.selectPage(criteria, pagination);
		//获取合作伙伴集合
		List<Partners> partners2=(List<Partners>)list.getRows();
		List urlsList=new ArrayList();				
		for(int i=0;i<partners2.size();i++){
			Picture picture=pictureService.selectOne(partners2.get(i).getPid());
			if(picture!=null){
				String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());		
				urlsList.add(urls);
			}								
		}					
		request.setAttribute("urls", urlsList);		
		request.setAttribute("pagination", list);		
		return "partners/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		return "partners/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Partners partners){	
		JsonResult result=new JsonResult();
		if(partners!=null&&partners.getId()==null){
			Integer addRum=partnersService.save(partners);
			if(addRum<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		Integer upNum=partnersService.update(partners);
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
		Partners partners=partnersService.selectOne(id);
		request.setAttribute("bean", partners);			
		return "partners/view";
	}
	/**
	 * 删除封面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		Partners partners=partnersService.selectOne(id);
		pictureService.delete(partners.getPid());
		//删除七牛的文件
		Picture picture=pictureService.selectOne(partners.getPid());
		if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
			FileUploadUtil.deleteFile(picture.getPicurl());
		}
		if(partnersService.delete(id)!=1){
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
	public @ResponseBody JsonResult saveDo(@RequestParam(value="file",required=false) MultipartFile file,Partners partners){
		return partnersService.saveDo(partners, file);
	}
		
}
