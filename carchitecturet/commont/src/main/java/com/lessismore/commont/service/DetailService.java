package com.lessismore.commont.service;

import org.springframework.web.multipart.MultipartFile;

import com.lessismore.commont.model.Detail;
import com.lessismore.commont.util.JsonResult;

public interface DetailService extends BaseService<Integer, Detail> {
	public JsonResult saveDo(Detail detail,MultipartFile file);
}