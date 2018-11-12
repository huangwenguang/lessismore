package com.lessismore.interfaces.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commont.model.Cover;
import com.commont.model.Detail;
import com.commont.model.Entity;
import com.commont.model.Entity.DetailCriteria;
import com.commont.model.Picture;
import com.commont.model.Protype;
import com.commont.model.Entity.CoverCriteria;
import com.commont.model.Entity.Pagination;
import com.commont.service.CoverService;
import com.commont.service.DetailService;
import com.commont.service.PictureService;
import com.commont.service.ProtypeService;
import com.commont.util.FileUploadUtil;
import com.commont.util.JsonResult;
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
	 * 根据封面id获取案例信息
	 * @param request
	 * @param id
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/detailList",method=RequestMethod.GET)
	public @ResponseBody JsonResult list(Integer cId){
		JsonResult result=new JsonResult();
		//根据类型获取封面信息,分页
		DetailCriteria criteria=new DetailCriteria();
		criteria.setCid(Entity.Value.eq(cId));	
		List<Detail> details=detailService.selectList(criteria);	
		//接收图片路径
		//List urlsList=new ArrayList();		
		//接受内容集合
		//List<String> contents=new ArrayList<String>();
		List mapList=new ArrayList();
		for(int i=0;i<details.size();i++){			
			String content1=details.get(i).getContdet();			
			Picture picture=pictureService.selectOne(details.get(i).getPid());
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());	
			Map urlMap=new HashMap();
			urlMap.put("sm", urls[0]);
			urlMap.put("md", urls[1]);
			urlMap.put("lg", urls[2]);
			Map map=new HashMap();		
			map.put("contents", content1);
			map.put("urls", urlMap);			
			mapList.add(i, map);
		}							
		result.setData(mapList);
		return result;
	}
}
