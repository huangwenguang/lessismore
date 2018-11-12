package com.lessismore.back.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Entity.RequeparaCriteria;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.Interface;
import com.lessismore.commont.model.ParamType;
import com.lessismore.commont.model.Entity.ReturnparaCriteria;
import com.lessismore.commont.model.Requepara;
import com.lessismore.commont.model.Returnpara;
import com.lessismore.commont.service.InterfaceService;
import com.lessismore.commont.service.ParamTypeService;
import com.lessismore.commont.service.RequeparaService;
import com.lessismore.commont.service.ReturnparaService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;

@Controller
@RequestMapping("interface")
public class InterfaceController {
	@Autowired
	private InterfaceService interfaceService;
	@Autowired
	private ReturnparaService returnparaService;
	@Autowired
	private RequeparaService requeparaService;
	@Autowired
	private ParamTypeService paramTypeService;
	/**
	 * 根据ID进入页面
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request,int id){
		Interface bean=interfaceService.selectOne(id);
		//请求参数
		ReturnparaCriteria criteria=new ReturnparaCriteria();
		criteria.setForId(Value.eq(id));
		List<Returnpara> list=returnparaService.selectList(criteria);
		request.setAttribute("retu", list);
		List<Integer> retuIds=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			retuIds.add(list.get(i).getId());
		}
		//参数字段列表
		List<ParamType> types=paramTypeService.selectAll();
		request.setAttribute("types", types);
		//id最大值
		if(retuIds.size()>0){
			request.setAttribute("retuMaxId", Collections.max(retuIds));
		}		
		//返回参数
		RequeparaCriteria criteria2=new RequeparaCriteria();
		criteria2.setFoId(Value.eq(id));
		List<Requepara> list2=requeparaService.selectList(criteria2);
		List<Integer> reqIds=new ArrayList<Integer>();
		for(int i=0;i<list2.size();i++){
			reqIds.add(list2.get(i).getId());
		}
		//id最大值
		if(reqIds.size()>0){
			request.setAttribute("reqMaxId", Collections.max(reqIds));
		}		
		request.setAttribute("id", id);
		request.setAttribute("req", list2);
		request.setAttribute("reqSize", list2.size());
		request.setAttribute("bean", bean);
		return "interface/yemian";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Interface bean,Integer[] retuIds,String[] retuContents,Integer[] retuIss,String[] retuNames,String[] retuTypes,
														Integer[] requeIds,String[] reqContents,Integer[] reqIsnulls,String[] reqNames,String[] reqTypes){	
		JsonResult result=new JsonResult();		
		//增加
		Interface interface1=interfaceService.selectOne(bean.getId());
		Integer addRum=null;
		if(interface1==null){			
			addRum=interfaceService.save(bean);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}				
		Integer upNum=interfaceService.update(bean);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		//增加或者修改返回参数
		for(int i=0;i<retuIds.length;i++){
			//查询,判断是否有数据
			Returnpara returnpara=returnparaService.selectOne(retuIds[i]);
			//如果为空,添加
			if(returnpara==null){
				Returnpara returnpara1=new Returnpara();
				returnpara1.setId(retuIds[i]);
				if(addRum==null){
					returnpara1.setForId(bean.getId());
				}else{
					returnpara1.setForId(addRum);
				}
				if(retuContents.length>0){
					returnpara1.setRetuContent(retuContents[i]);
				}
				if(retuIss.length>0){
					returnpara1.setRetuIs(retuIss[i]);
				}
				if(retuNames.length>0){
					returnpara1.setRetuName(retuNames[i]);
				}
				if(retuTypes.length>0){
					returnpara1.setRetuType(retuTypes[i]);
				}
				returnparaService.save(returnpara1);
			}else{
				//修改
				returnpara.setForId(bean.getId());
				if(retuContents.length>0){
					returnpara.setRetuContent(retuContents[i]);
				}
				if(retuIss.length>0){
					returnpara.setRetuIs(retuIss[i]);
				}
				if(retuNames.length>0){
					returnpara.setRetuName(retuNames[i]);
				}
				if(retuTypes.length>0){
					returnpara.setRetuType(retuTypes[i]);
				}
				returnparaService.update(returnpara);
			}			
		}
		//增加或者修改请求参数
		for(int i=0;i<requeIds.length;i++){
			Requepara requepara=requeparaService.selectOne(requeIds[i]);
			//增加
			if(requepara==null){
				Requepara requepara1=new Requepara();
				requepara1.setId(retuIds[i]);
				if(addRum==null){
					requepara1.setFoId(bean.getId());
				}else{
					requepara1.setFoId(addRum);
				}
				
				if(reqContents.length>0){
					requepara1.setReqContent(reqContents[i]);
				}
				if(reqIsnulls.length>0){
					requepara1.setReqIsnull(reqIsnulls[i]);
				}
				if(reqNames.length>0){
					requepara1.setReqName(reqNames[i]);
				}
				if(reqTypes.length>0){
					requepara1.setReqType(reqTypes[i]);
				}				
				requeparaService.save(requepara1);
				//修改
			}else{
				requepara.setFoId(bean.getId());
				if(reqContents.length>0){
					requepara.setReqContent(reqContents[i]);
				}
				if(reqIsnulls.length>0){
					requepara.setReqIsnull(reqIsnulls[i]);
				}
				if(reqNames.length>0){
					requepara.setReqName(reqNames[i]);
				}
				if(reqTypes.length>0){
					requepara.setReqType(reqTypes[i]);
				}				
				requeparaService.update(requepara);					
			}					
		}
		return result;
	}
	/**
	 * 删除请求参数
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delReq",method=RequestMethod.GET)
	public @ResponseBody JsonResult delReq(Integer id){
		JsonResult jsonResult=new JsonResult();
		Requepara requepara=requeparaService.selectOne(id);
		//有数据
		if(requepara!=null){
			//删除
			Integer num=requeparaService.delete(id);
			if(num==null){
				jsonResult.addErrorCode(ErrorCode.SYS_ERR);
			}
		}
		return jsonResult;
	}
	/**
	 * 删除返回参数
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delRetu",method=RequestMethod.GET)
	public @ResponseBody JsonResult delRet(Integer id){
		JsonResult jsonResult=new JsonResult();
		Returnpara returnpara=returnparaService.selectOne(id);
		//有数据
		if(returnpara!=null){
			//删除
			Integer num=returnparaService.delete(id);
			if(num==null){
				jsonResult.addErrorCode(ErrorCode.SYS_ERR);
			}
		}
		return jsonResult;
	}
	/**
	 * 进入推送页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/tsPage", method = RequestMethod.GET)
	public String tsPage(HttpServletRequest request,int id){
		Interface bean=interfaceService.selectOne(id);
		//无数据，停留原地
		if(bean==null){			
			return "interface/yemian";
		}else{
			//有数据，进入推送页面
			request.setAttribute("bean", bean);
			return "interface/push";
		}
		
	}
}
