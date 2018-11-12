package com.lessismore.commont.service.impl;

import java.io.IOException;

import com.lessismore.commont.model.Company;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.service.CompanyService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.dao.CompanyDao;
import com.lessismore.commont.dao.PictureDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Integer, Company> implements CompanyService {
	
	@Autowired
	private CompanyDao dao;
}