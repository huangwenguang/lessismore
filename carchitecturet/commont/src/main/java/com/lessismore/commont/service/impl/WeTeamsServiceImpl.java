package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.WeTeams;
import com.lessismore.commont.service.WeTeamsService;
import com.lessismore.commont.dao.WeTeamsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeTeamsServiceImpl extends BaseServiceImpl<Integer, WeTeams> implements WeTeamsService {
	
	@Autowired
	private WeTeamsDao dao;

}