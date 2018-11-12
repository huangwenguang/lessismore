package com.lessismore.commont.service.impl;

import java.util.Date;

import com.lessismore.commont.model.AdminRefRole;
import com.lessismore.commont.model.Entity.GwUserCriteria;
import com.lessismore.commont.model.GwUser;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.service.GwUserService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.dao.GwUserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GwUserServiceImpl extends BaseServiceImpl<Integer, GwUser> implements GwUserService {

	
	@Autowired
	private GwUserDao dao;
	


	public JsonResult saveOrUpdate(GwUser gwUser) {
		GwUserCriteria 	criteria=new GwUserCriteria();
		JsonResult result = new JsonResult();
		GwUser bear = selectOne(criteria);
		if (bear != null) {
			result.addErrorCode(ErrorCode.CUSTOM_EXIST);			
			return result;
		}
		gwUser.setCreateTime(new Date());
	
		Integer adminId = save(gwUser);
	
		
		return result;
	}
	


}