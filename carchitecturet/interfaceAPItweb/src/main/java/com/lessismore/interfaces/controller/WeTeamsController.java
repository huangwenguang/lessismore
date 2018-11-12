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
import com.lessismore.commont.model.Entity.TypePicCriteria;
import com.lessismore.commont.model.TypePic;
import com.lessismore.commont.model.WeTeams;
import com.lessismore.commont.service.CompanyService;
import com.lessismore.commont.service.TypePicService;
import com.lessismore.commont.service.WeTeamsService;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;

/**
 * 获取我的团队
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/weTeams")
public class WeTeamsController {
	@Autowired
	private WeTeamsService weTeamsService;
	@Autowired
	private TypePicService typePicService;
	/**
	 * 获取信息
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody JsonResult getAll(){
		JsonResult jsonResult=new JsonResult();
		//接收数据的集合
		Map map=new HashMap();
		//获取我的团队信息
		List<WeTeams> teams=weTeamsService.selectAll();		
		//遍历我的团队，获取对应的图片
		for(int i=0;i<teams.size();i++){
			//获取对应的图片,type=1,for_id=我的团队的主键
			TypePicCriteria criteria=new TypePicCriteria();
			criteria.setImgType(Entity.Value.eq(1));
			criteria.setForId(Entity.Value.eq(teams.get(i).getId()));
			List<TypePic> list=typePicService.selectList(criteria);	
			List picList=new ArrayList();
			for(int j=0;j<list.size();j++){
				String[] typics=FileUploadUtil.getFileUrls(list.get(j).getImgKey());
				Map mappic=new HashMap();
				mappic.put("sm",typics[0]);
				mappic.put("md",typics[1]);
				mappic.put("lg",typics[2]);
				picList.add(j, mappic);
			}
			map.put("content", teams.get(i).getContent());
			map.put("pictures", picList);
		}
		jsonResult.setData(map);
		return jsonResult;
	}
}
