package com.lessismore.back.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lessismore.commont.model.Admin;




/**
 * 	登陆检查拦截器
 * @author lenovo
 *
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{

	private static final Logger LOG = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String requestMethod = request.getMethod(); // 获取请求方式
		LOG.info(String.format("requestMethod:%s", requestMethod));
		String url = request.getRequestURL().toString();
		System.out.println("url---"+ url);
		if (url.contains("getLogin") || url.contains("welcome")) {
			return true;
		}
		
		Admin admin = (Admin) request.getSession().getAttribute("USER");
		if (admin == null) {
			response.sendRedirect("/lessismoreback/");
		}
		return true;
	}
}
