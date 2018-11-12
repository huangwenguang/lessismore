package com.lessismore.front.controller;

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

import com.lessismore.commont.model.Cover;
import com.lessismore.commont.model.Detail;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.DetailCriteria;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Protype;
import com.lessismore.commont.model.Entity.CoverCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.service.CoverService;
import com.lessismore.commont.service.DetailService;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.service.ProtypeService;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;
@Controller
@RequestMapping(value="/cover")
public class CoverController {
	@Autowired
	private CoverService coverService;	
	@Autowired
	private ProtypeService protypeService;
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
	@RequestMapping(value="/coverList",method=RequestMethod.GET)
	public @ResponseBody JsonResult list(Integer typeId){
		JsonResult result=new JsonResult();
		//根据类型获取封面信息,分页
		CoverCriteria criteria=new CoverCriteria();
		criteria.setType(Entity.Value.eq(typeId));			
		List<Cover> covers=coverService.selectList(criteria);	
		//接收图片路径
		//List urlsList=new ArrayList();		
		//接受内容集合
		//List<String> contents=new ArrayList<String>();
		/*Map mapMin=new HashMap();
		List listMin=new ArrayList();
		Map mapMax=new HashMap();
		List listMax=new ArrayList();*/
		List list=new ArrayList();
		for(int i=0;i<covers.size();i++){
			//封面内容
			String contentMin=covers.get(i).getContentmin();
			String contentMax=covers.get(i).getContentmax();
			Picture picture=pictureService.selectOne(covers.get(i).getPid());
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
			Map urlMap=new HashMap();
			urlMap.put("sm", urls[0]);
			urlMap.put("md", urls[1]);
			urlMap.put("lg", urls[2]);
			Map map=new HashMap();
			map.put("contentMax", contentMax);
			map.put("content", contentMin);
			map.put("img", urlMap);
			map.put("cId", covers.get(i).getId());
			list.add(i, map);
			//获取所属封面的案例对象
			//DetailCriteria detailCriteria=new DetailCriteria();
			//System.out.println("cid:"+covers.get(i).getId());
			/*detailCriteria.setCid(Entity.Value.eq(covers.get(i).getId()));
			//获取案例集合
			List<Detail> details=detailService.selectList(detailCriteria);
			//封面所属图面
			Picture picture=pictureService.selectOne(covers.get(i).getPid());
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());								
			mapMax.put("content", content1);
			mapMax.put("img", urls);				
			for(int j=0;j<details.size();j++){
				String con=details.get(j).getContdet();
				System.out.println("内容"+con);
				Integer picId=details.get(j).getPid();
				//得到所属图片对象				
				Picture picture1=pictureService.selectOne(picId);
				//图片路径
				String[] urls1=FileUploadUtil.getFileUrls(picture.getPicurl());									
				mapMin.put("contdet", con);
				mapMin.put("image", urls1);
				listMin.add(mapMin);
			}			
			mapMax.put("detail", listMin);								
		}	
		for(int k=0;k<mapMax.size();k++){
			listMax.add(k, mapMax);
		}
		
		List listMax=new ArrayList();//最外层集合
		Map mapMax=new HashMap();//最外层MAP
		listMax.add(mapMax);
		mapMax.put("contents", value)
		mapMax.put("img", value);
		mapMax.put("detail", value)
		List listMin=new ArrayList();*/		
		}
		result.setData(list);
		return result;
	}
}
