package com.commont.dao.impl;

import java.util.List;

import com.commont.dao.MenuDao;
import com.commont.model.Menu;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Integer, Menu> implements MenuDao {
	
	public List<Menu> getMenusByRoleIds(List<Integer> ids) {
		return sqlSessionTemplate.selectList(statement("getMenusByRoleids"), ids);
	}
}