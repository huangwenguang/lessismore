package com.lessismore.interfaces.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.util.OKHttpUtil;
import com.lessismore.commont.util.PropertyUtil;
import com.lessismore.commont.util.ScanSignInfo;
import com.lessismore.commont.util.WxJSUtil;



@Controller
@RequestMapping("/weixinscan")
public class WeiXinScanController {
	
	@RequestMapping(value = "/getscansign", method = RequestMethod.GET)
	@ResponseBody
	public  JsonResult getscansign(HttpServletRequest request,String signurl) {
		JsonResult jsonresult = new JsonResult();
		ScanSignInfo signinfo=new ScanSignInfo();
		
		//生成微信扫描签名
		String APPID=PropertyUtil.getProperty("weixin.APPID");
		String APPSECRET=PropertyUtil.getProperty("weixin.APPSECRET");
		signinfo.setAppid(APPID);
		String firsturl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
		String firstres = OKHttpUtil.httpGet(firsturl);
		JSONObject firstobject = JSONObject.fromObject(firstres);
		//获取token
		String access_token=firstobject.get("access_token").toString();
		String secondurl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi";
		String secondres = OKHttpUtil.httpGet(secondurl);
		JSONObject secondobject = JSONObject.fromObject(secondres);
		//获取jsapi_ticket
		String jsapi_ticket=secondobject.get("ticket").toString();
        Map<String, String> ret = WxJSUtil.sign(jsapi_ticket,signurl);
         for (Map.Entry entry : ret.entrySet()) {
        	 	if("nonceStr".equals(entry.getKey())){
        	 		signinfo.setNonceStr(entry.getValue().toString());
        	 	}
        	 	if("signature".equals(entry.getKey())){
        	 		signinfo.setSignature(entry.getValue().toString());
        	 	}
        	 	if("timestamp".equals(entry.getKey())){
        	 		signinfo.setTimestamp(entry.getValue().toString());
        	 	}
            }
		
         jsonresult.setData(signinfo);
		
		return jsonresult;
	}
}
