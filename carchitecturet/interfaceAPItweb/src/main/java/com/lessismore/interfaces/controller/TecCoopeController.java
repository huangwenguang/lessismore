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
import com.lessismore.commont.model.Entity.PictureCriteria;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.model.TecCoope;
import com.lessismore.commont.model.TypePic;
import com.lessismore.commont.model.Entity.TypePicCriteria;
import com.lessismore.commont.service.PictureService;
import com.lessismore.commont.service.TecCoopeService;
import com.lessismore.commont.service.TypePicService;
import com.lessismore.commont.service.WeTeamsService;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

/**
 * 获取技术外派
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/tecCoope")
public class TecCoopeController {
	@Autowired
	private TecCoopeService tecCoopeService;
	@Autowired
	private TypePicService typePicService;
	@Autowired
	private PictureService pictureService;
	/**
	 * 获取技术外派信息
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody JsonResult getAll(){
		JsonResult jsonResult=new JsonResult();	
		//获取技术外派
		List<TecCoope> coopes=tecCoopeService.selectAll();
		//接收数据的集合
		List dataList=new ArrayList();
		//遍历我的团队，获取对应的图片
		for(int i=0;i<coopes.size();i++){
			//遍历每一个对象的图片id
			Picture picture=pictureService.selectOne(coopes.get(i).getPid()); 
			String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
			Map mapUrl=new HashMap();
			mapUrl.put("sm",urls[0]);
			mapUrl.put("md",urls[1]);
			mapUrl.put("lg",urls[2]);
			Map map=new HashMap();
			
			//获取对应的图片,type=2
			TypePicCriteria criteria=new TypePicCriteria();
			criteria.setImgType(Entity.Value.eq(2));
			criteria.setForId(Entity.Value.eq(coopes.get(i).getId()));
			List<TypePic> list=typePicService.selectList(criteria);	
			List picList=new ArrayList();
			for(int j=0;j<list.size();j++){
				String[] typics=FileUploadUtil.getFileUrls(list.get(j).getImgKey());
				Map mappic=new HashMap();
				mappic.put("sm",urls[0]);
				mappic.put("md",urls[1]);
				mappic.put("lg",urls[2]);
				picList.add(j, mappic);
			}
			map.put("imgs", picList);
			map.put("name", coopes.get(i).getCompanyName());
			map.put("content", coopes.get(i).getContent());
			map.put("Logo", mapUrl);
			dataList.add(i, map);
			/*Map map=new HashMap();
			//获取对应的图片,type=2
			TypePicCriteria criteria=new TypePicCriteria();
			criteria.setImgType(Entity.Value.eq(2));
			//criteria.setForId(Entity.Value.eq(coopes.get(i).getId()));
			List<TypePic> list=typePicService.selectList(criteria);		
			List mapdats=new ArrayList();
			for(int j=0;j<list.size();j++){
				String[] urls=FileUploadUtil.getFileUrls(list.get(j).getImgKey());
				Map mapPic=new HashMap();
				mapPic.put("sm",urls[0]);
				mapPic.put("md",urls[1]);
				mapPic.put("lg",urls[2]);
				mapdats.add(mapPic);
			}
			//获取LOGO
			Picture picture=pictureService.selectOne(coopes.get(i).getPid());
			if(picture!=null&&picture.getPicurl()!=null&&!"".equals(picture.getPicurl())){
				String[] logos=FileUploadUtil.getFileUrls(picture.getPicurl());
				map.put("logo",logos);
			}			
			map.put("name", coopes.get(i).getCompanyName());			
			map.put("content", coopes.get(i).getContent());
			map.put("pictures", mapdats);
			mapAll.put("obj", map);*/
			
		}
		jsonResult.setData(dataList);
		return jsonResult;
	}
}
