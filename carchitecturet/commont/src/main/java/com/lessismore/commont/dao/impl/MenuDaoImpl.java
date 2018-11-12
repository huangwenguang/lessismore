package com.lessismore.commont.dao.impl;

import java.util.List;

import com.lessismore.commont.model.Menu;
import com.lessismore.commont.dao.MenuDao;

import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Integer, Menu> implements MenuDao {
	
	public List<Menu> getMenusByRoleIds(List<Integer> ids) {
		return sqlSessionTemplate.selectList(statement("getMenusByRoleids"), ids);
	}
}