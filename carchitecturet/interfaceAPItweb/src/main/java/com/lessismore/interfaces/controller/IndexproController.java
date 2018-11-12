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

import com.lessismore.commont.model.Indexpro;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.service.IndexproService;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;
/**
 * 获取首页项目图片接口
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/indexpro")
public class IndexproController {
	@Autowired
	private IndexproService indexproService;
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody JsonResult list(){
		JsonResult result=new JsonResult();
		List<Indexpro> list=indexproService.selectAll();
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
			map.put("name", list.get(i).getProname());
			map.put("Logo", mapUrl);
			dataList.add(i, map);
		}
		result.setData(dataList);
		return result;
	}
}
