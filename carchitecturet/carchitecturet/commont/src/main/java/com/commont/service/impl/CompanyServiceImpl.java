package com.commont.service.impl;

import com.commont.dao.CompanyDao;
import com.commont.model.Company;
import com.commont.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Integer, Company> implements CompanyService {
	
	@Autowired
	private CompanyDao dao;

}