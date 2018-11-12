package com.commont.dao;

import java.util.List;

import com.commont.model.Menu;

public interface MenuDao extends BaseDao<Integer, Menu> {
	List<Menu> getMenusByRoleIds(List<Integer> ids);
}