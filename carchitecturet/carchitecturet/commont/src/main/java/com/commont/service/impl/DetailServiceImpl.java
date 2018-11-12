package com.commont.service.impl;

import java.io.IOException;


import com.commont.dao.DetailDao;
import com.commont.dao.PictureDao;

import com.commont.model.Detail;
import com.commont.model.Picture;
import com.commont.service.DetailService;
import com.commont.util.ErrorCode;
import com.commont.util.FileUploadUtil;
import com.commont.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DetailServiceImpl extends BaseServiceImpl<Integer, Detail> implements DetailService {
	
	@Autowired
	private DetailDao dao;	
	@Autowired
	private PictureDao pictureDao;
	
	public JsonResult saveDo(Detail detail,MultipartFile file){
		JsonResult result=new JsonResult();
		//id为空,添加
		if(detail.getId()==null){
			if(file!=null){
				String imageKey="";
				try {
					imageKey = FileUploadUtil.uploadFile(file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Picture picture=new Picture();
				picture.setPicurl(imageKey);
				Integer addNum=pictureDao.save(picture);
				detail.setPid(addNum);			
			}
			Integer upRow=dao.save(detail);
			if(upRow<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;
		}
		//修改
		if(file!=null){
			String imageKey="";
			try {
				imageKey = FileUploadUtil.uploadFile(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Picture picture=new Picture();
			Picture picture=pictureDao.selectOne(detail.getPid());
			System.out.println("pic id:"+picture.getId());
			System.out.println("picture:"+picture);
			picture.setPicurl(imageKey);
			pictureDao.update(picture);				
		}
		Integer upPnum=dao.update(detail);
		if(upPnum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;			
	}
}