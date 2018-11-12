package com.lessismore.back.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import msg.Aliemail;
import msg.MsgUtils;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Admin;
import com.lessismore.commont.model.Logrecord;
import com.lessismore.commont.model.Push;
import com.lessismore.commont.model.Entity.By;
import com.lessismore.commont.model.Entity.LogrecordCriteria;
import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.PushCriteria;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.service.PushService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;




@Controller
@RequestMapping("push")
public class PushController {
	@Autowired
	private PushService pushService;
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(HttpServletRequest request,Push push,String messType){
		Admin u = (Admin) request.getSession().getAttribute("USER");
		JsonResult result=new JsonResult();
		push.setCreateDate(new Date());
		push.setSender(u.getUserName());
		push.setType(messType);
		//推送方式为邮件
		if(messType.indexOf("@")!=-1){
			String messCode=Aliemail.getInstance().sendEmail(messType);
			if(messCode==null){
				result.addErrorCode(ErrorCode.IM_SENX_FAILED);
			}else{
				//生成通知记录				
				pushService.save(push);
			}
		}else{
			//手机推送
			JSONObject obj = MsgUtils.getInstance().sendMsgCode(MsgUtils.TEMP_COMMON_ID,messType);
			String code = obj.getString("code");
			if (code.equals(MsgUtils.MSG_SEND_SUCCESS)){
				//发送成功
				//生成通知记录
				pushService.save(push);
			}else{
				result.addErrorCode(ErrorCode.IM_SENX_FAILED);
			}
		}
		return result;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Logrecord bean, Pagination pagination){
		PushCriteria criteria=new PushCriteria();
		//按照操作时间倒序	
		criteria.setCreateDate(Value.orderBy(By.DESC));		
		Pagination list = pushService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);		
		return "push/list";
	}
}
