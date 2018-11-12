package com.lessismore.commont.service;

import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Partners;
import com.lessismore.commont.util.JsonResult;

public interface PartnersService extends BaseService<Integer, Partners> {
	public JsonResult saveDo(Partners partners,MultipartFile file);
}