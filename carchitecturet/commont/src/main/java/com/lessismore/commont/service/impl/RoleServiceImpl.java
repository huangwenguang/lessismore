package com.lessismore.commont.service.impl;

import java.util.Date;


import com.lessismore.commont.model.Entity.RoleCriteria;
import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.Role;
import com.lessismore.commont.service.RoleService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.util.StringUtil;
import com.lessismore.commont.dao.RoleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Integer, Role> implements RoleService {
	
	@Autowired
	private RoleDao dao;
	public JsonResult saveOrUpdate(Role role) {
		JsonResult result = new JsonResult();
		if (StringUtil.isBlank(role.getRoleName())) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (StringUtil.isBlank(role.getId())) {
			// 新增
			// 角色名不能重复
			RoleCriteria criteria = new RoleCriteria();
			criteria.setRoleName(Value.eq(role.getRoleName()));
			Role bean = selectOne(criteria);
			if (bean != null) {
				result.addErrorCode(ErrorCode.ROLENAME_EXITS);
				return result;
			}
			role.setCreateTime(new Date());
			role.setStatus(1);
			save(role);
		}else {
			// update
			update(role);
		}
		return result;
	}

}