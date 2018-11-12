package com.lessismore.commont.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.lessismore.commont.model.Entity.Value;
import com.lessismore.commont.model.RoleRefMenu;
import com.lessismore.commont.service.RoleRefMenuService;
import com.lessismore.commont.model.Entity.RoleRefMenuCriteria;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.dao.RoleRefMenuDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleRefMenuServiceImpl extends BaseServiceImpl<Integer, RoleRefMenu> implements RoleRefMenuService {
	
	@Autowired
	private RoleRefMenuDao dao;

	public JsonResult saveRoleMenuByMgt(Integer[] menuIds, Integer roleId) {
		JsonResult result = new JsonResult();
		try {
			// 验证数据有效性
			if (menuIds == null || roleId == null) {
				result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
				return result;
			}
			// 采用，先删除，后添加的模式
			// 先删除已有的
			List<Integer> refMenuIds = this.getNeedDelIds(roleId);
			if (refMenuIds.size() > 0) {
				for (Integer refMenuId : refMenuIds) {
					delete(refMenuId);
				}
			}
			// 再对新选择的做保存
			List<RoleRefMenu> needSaveList = this.getNewRM(menuIds, roleId);
			for (int i = 0; i < menuIds.length; i++) {
				this.save(needSaveList.get(i));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取要删除的ID数组
	 * @return
	 */
	private List<Integer> getNeedDelIds(Integer roleId){
		RoleRefMenuCriteria criteria = new RoleRefMenuCriteria();
		criteria.setRoleId(Value.eq(roleId));
		List<RoleRefMenu> list = selectList(criteria);
		List<Integer> delList = new ArrayList<Integer>();
		for(RoleRefMenu rm : list){
			delList.add(rm.getId());
		}
		return delList;
	}

	/**
	 * 组装要新增的列表
	 */
	private List<RoleRefMenu> getNewRM(Integer[] menuIds, Integer roleId){
		List<RoleRefMenu> list = new ArrayList<RoleRefMenu>();
		for(Integer menuId : menuIds){
			RoleRefMenu rmMenu = new RoleRefMenu();
			rmMenu.setMenuId(menuId);
			rmMenu.setRoleId(roleId);
			list.add(rmMenu);
		}
		return list;
	}

}