package com.commont.service.impl;

import java.util.Date;
import java.util.List;


import com.commont.dao.AdminDao;
import com.commont.model.Admin;
import com.commont.model.AdminRefRole;
import com.commont.model.Entity.AdminCriteria;
import com.commont.model.Entity.AdminRefRoleCriteria;
import com.commont.model.Entity.Value;
import com.commont.service.AdminRefRoleService;
import com.commont.service.AdminService;
import com.commont.util.ErrorCode;
import com.commont.util.JsonResult;
import com.commont.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Integer, Admin> implements AdminService {
	
	@Autowired
	private AdminRefRoleService adminRefRoleService;

	public JsonResult Login(String passport, String passwd) throws Exception {
		JsonResult result = new JsonResult();
		if (StringUtil.isBlank(passport)) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (StringUtil.isBlank(passwd)) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		AdminCriteria criteria = new AdminCriteria();
		criteria.setUserName(Value.eq(passport));
		criteria.setUserPwd(Value.eq(passwd));
		Admin admin = selectOne(criteria);
		if (admin == null) {
			result.addErrorCode(ErrorCode.CUSTOM_USER_PWD_ERROR);
			return result;
		}
		result.setData(admin);
		return result;
	}


	public JsonResult saveOrUpdate(Admin admin, Integer[] roleids) {
		JsonResult result = new JsonResult();
		if (StringUtil.isBlank(admin.getUserName()) 
				|| StringUtil.isBlank(admin.getPhone()) 
				|| StringUtil.isBlank(admin.getUserPwd())) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (roleids == null || roleids.length < 1) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (StringUtil.isBlank(admin.getId())) {
			// 新增
			// 用户名不能重复
			AdminCriteria criteria = new AdminCriteria();
			criteria.setUserName(Value.eq(admin.getUserName()));
			Admin bean = selectOne(criteria);
			if (bean != null) {
				result.addErrorCode(ErrorCode.CUSTOM_EXIST);
				return result;
			}
			admin.setCreateTime(new Date());
			admin.setState(1);
			Integer adminId = save(admin);
			if (adminId != null) {
				for (Integer roleId : roleids) {
					AdminRefRole arf = new AdminRefRole();
					arf.setAdminid(adminId);
					arf.setRoleid(roleId);
					adminRefRoleService.save(arf);
				}
			}
		}else {
			// update
			int update = update(admin);
			if (update == 1) {
				AdminRefRoleCriteria criteria = new AdminRefRoleCriteria();
				criteria.setAdminid(Value.eq(admin.getId()));
				List<AdminRefRole> refRoles = adminRefRoleService.selectList(criteria);
				for (AdminRefRole ref : refRoles) {
					adminRefRoleService.delete(ref.getId());
				}
				for (Integer roleId : roleids) {
					AdminRefRole arf = new AdminRefRole();
					arf.setAdminid(admin.getId());
					arf.setRoleid(roleId);
					adminRefRoleService.save(arf);
				}
			}
		}
		return result;
	}

}