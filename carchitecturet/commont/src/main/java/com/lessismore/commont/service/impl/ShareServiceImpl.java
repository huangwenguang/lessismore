package com.lessismore.commont.service.impl;

import com.lessismore.commont.model.Share;
import com.lessismore.commont.service.ShareService;
import com.lessismore.commont.dao.ShareDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareServiceImpl extends BaseServiceImpl<Integer, Share> implements ShareService {
	
	@Autowired
	private ShareDao dao;

}