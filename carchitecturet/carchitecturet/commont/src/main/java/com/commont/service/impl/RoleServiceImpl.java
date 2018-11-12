package com.commont.service.impl;

import java.util.Date;


import com.commont.dao.RoleDao;
import com.commont.model.Entity.RoleCriteria;
import com.commont.model.Entity.Value;
import com.commont.model.Role;
import com.commont.service.RoleService;
import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;
import com.commont.util.StringUtil;

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