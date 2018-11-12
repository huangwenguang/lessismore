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
import com.lessismore.commont.model.Entity.IndexproCriteria;
import com.lessismore.commont.model.Indexpro;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.service.IndexproService;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

@Controller
@RequestMapping(value="/indexpro")
public class IndexproController {
	@Autowired
	private IndexproService indexproService;
	@Autowired
	private PictureService pictureService;
	/**
	 * 获取合作企业信息
	 * @param request
	 * @param indexpro
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Indexpro indexpro,Pagination pagination){
		//获取所有合作伙伴信息
		IndexproCriteria criteria=new IndexproCriteria();	
		if(indexpro!=null&&indexpro.getProname()!=null&&!"".equals(indexpro.getProname())){
			criteria.setProname(Entity.Value.like(indexpro.getProname()));
		}
		Pagination list=indexproService.selectPage(criteria, pagination);
		//获取合作伙伴集合
		List<Indexpro> indexpro2=(List<Indexpro>)list.getRows();
		List urlsList=new ArrayList();				
		for(int i=0;i<indexpro2.size();i++){
			Picture picture=pictureService.selectOne(indexpro2.get(i).getPid());
			if(picture!=null){
				String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());		
				urlsList.add(urls);
			}								
		}					
		request.setAttribute("urls", urlsList);		
		request.setAttribute("pagination", list);		
		return "indexpro/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request){			
		return "indexpro/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Indexpro indexpro){	
		JsonResult result=new JsonResult();
		if(indexpro!=null&&indexpro.getId()==null){
			Integer addRum=indexproService.save(indexpro);
			if(addRum<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		Integer upNum=indexproService.update(indexpro);
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
		Indexpro indexpro=indexproService.selectOne(id);
		request.setAttribute("bean", indexpro);			
		return "indexpro/view";
	}
	/**
	 * 删除封面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		Indexpro indexpro=indexproService.selectOne(id);
		pictureService.delete(indexpro.getPid()); 			
		//删除七牛的文件
		Picture picture=pictureService.selectOne(indexpro.getPid());
		if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
			FileUploadUtil.deleteFile(picture.getPicurl());
		}
		if(indexproService.delete(id)<1){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 上传信息
	 * @param file
	 * @param indexpro
	 * @return
	 */
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult saveDo(@RequestParam(value="file",required=false) MultipartFile file,Indexpro indexpro){
		return indexproService.saveDo(indexpro, file);
	}
		
}
