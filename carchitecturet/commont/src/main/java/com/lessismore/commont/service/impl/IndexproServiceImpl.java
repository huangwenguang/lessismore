package com.lessismore.commont.service.impl;

import java.io.IOException;

import com.lessismore.commont.model.Indexpro;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.service.IndexproService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.dao.IndexproDao;
import com.lessismore.commont.dao.PictureDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IndexproServiceImpl extends BaseServiceImpl<Integer, Indexpro> implements IndexproService {
	
	@Autowired
	private IndexproDao dao;
	@Autowired
	private PictureDao pictureDao;
	public JsonResult saveDo(Indexpro indexpro,MultipartFile file){
		JsonResult result=new JsonResult();
		//id为空,添加
		if(indexpro.getId()==null){
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
				indexpro.setPid(addNum);			
			}
			Integer upRow=dao.save(indexpro);
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
			System.out.println("pid:"+indexpro.getPid());
			Picture picture=pictureDao.selectOne(indexpro.getPid());			
			picture.setPicurl(imageKey);
			pictureDao.update(picture);				
		}
		Integer upPnum=dao.update(indexpro);
		if(upPnum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;			
	}
}