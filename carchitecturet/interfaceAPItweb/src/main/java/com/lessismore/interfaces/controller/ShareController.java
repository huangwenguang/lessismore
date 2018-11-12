package com.lessismore.interfaces.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.By;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.Share;
import com.lessismore.commont.model.TecCoope;
import com.lessismore.commont.model.Entity.ShareCriteria;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.service.ShareService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;
/**
 * 分享平台
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
	public @ResponseBody JsonResult getByparams(Share share){
		JsonResult jsonResult=new JsonResult();	
		//根据类型，平台，状态获取
		ShareCriteria criteria=new ShareCriteria();		
		criteria.setPlatform(Entity.Value.eq(share.getPlatform()));
		//state=1,表示状态开启
		criteria.setState(Entity.Value.eq(1));
		criteria.setType(Value.orderBy(By.ASC));
		List<Share> list=shareService.selectList(criteria);
		/*//接收数据的集合		
		Map map=new HashMap();
		if(list.size()>0){
			//获取logo
			Picture picture=pictureService.selectOne(list.get(0).getPid()); 
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
			Map mapUrl=new HashMap();
			mapUrl.put("sm",urls[0]);
			mapUrl.put("md",urls[1]);
			mapUrl.put("lg",urls[2]);			
			map.put("logo", mapUrl);
			map.put("dataObj", list.get(0));
		}else{
			jsonResult.addErrorCode(ErrorCode.DATA_NO);
			return jsonResult;
		}
		jsonResult.setData(map);*/
		
		//接收数据的集合
		List dataList=new ArrayList();
		for(int i=0;i<list.size();i++){
			//遍历每一个对象的图片id
			Picture picture=pictureService.selectOne(list.get(i).getPid()); 
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
			Map mapUrl=new HashMap();
			mapUrl.put("sm",urls[0]);
			mapUrl.put("md",urls[1]);
			mapUrl.put("lg",urls[2]);
			Map map=new HashMap();
			map.put("content", list.get(i).getContent());
			map.put("platform", list.get(i).getPlatform());
			map.put("title", list.get(i).getTitle());
			map.put("type", list.get(i).getType());
			map.put("url", list.get(i).getUrl());
			map.put("Logo", mapUrl);
			dataList.add(i, map);
		}
		jsonResult.setData(dataList);
		return jsonResult;
	}
}
