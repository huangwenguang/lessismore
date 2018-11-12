package com.commont.service.impl;

import java.util.Date;

import com.commont.dao.GwUserDao;
import com.commont.model.AdminRefRole;
import com.commont.model.Entity.GwUserCriteria;
import com.commont.model.GwUser;
import com.commont.model.Entity.Value;
import com.commont.service.GwUserService;
import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;

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