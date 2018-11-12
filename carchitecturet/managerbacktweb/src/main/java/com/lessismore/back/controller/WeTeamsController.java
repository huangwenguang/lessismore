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
import com.lessismore.commont.model.Indexpro;


import com.lessismore.commont.model.TypePic;


import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.TypePicCriteria;

import com.lessismore.commont.model.WeTeams;

import com.lessismore.commont.service.TypePicService;
import com.lessismore.commont.service.WeTeamsService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

@Controller
@RequestMapping("/weTeams")
public class WeTeamsController {
	@Autowired
	private WeTeamsService weTeamsService;
	@Autowired
	private TypePicService typePicService;
	/**
	 * 我的团队信息列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Pagination pagination){
		List<WeTeams> teams=weTeamsService.selectAll();
		if(teams.size()>0){
			//获取图片
			TypePicCriteria criteria=new TypePicCriteria();
			criteria.setImgType(Entity.Value.eq(1));
			criteria.setForId(Entity.Value.eq(teams.get(0).getId()));
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
			request.setAttribute("bean", teams.get(0));
		}		
		return "weteam/list";
	}
	/**
	 * 调到添加图片页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request,Integer id){	
		request.setAttribute("foid", id);
		return "weteam/view";
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
			typePic.setImgType(1);
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
		return "weteam/view";
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
		WeTeams teams=weTeamsService.selectOne(id);
		request.setAttribute("bean", teams);			
		return "weteam/viewWe";
	}
	@RequestMapping(value="/editWeDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult editWeDo(WeTeams teams){
		JsonResult result=new JsonResult();
		Integer num=weTeamsService.update(teams);
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);			
		}
		return result;
	}
}
