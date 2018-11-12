package com.commont.service;

import org.springframework.web.multipart.MultipartFile;

import com.commont.model.Detail;
import com.commont.util.JsonResult;

public interface DetailService extends BaseService<Integer, Detail> {
	public JsonResult saveDo(Detail detail,MultipartFile file);
}