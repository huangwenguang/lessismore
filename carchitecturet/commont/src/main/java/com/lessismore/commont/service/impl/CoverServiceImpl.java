package com.lessismore.commont.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.lessismore.commont.model.Cover;
import com.lessismore.commont.model.Entity;
import com.lessismore.commont.model.Entity.CoverCriteria;
import com.lessismore.commont.model.Picture;
import com.lessismore.commont.service.CoverService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.FileUploadUtil;
import com.lessismore.commont.util.JsonResult;
import com.lessismore.commont.dao.CoverDao;
import com.lessismore.commont.dao.PictureDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class CoverServiceImpl extends BaseServiceImpl<Integer, Cover> implements CoverService {
	
	@Autowired
	private CoverDao dao;
	@Autowired
	private PictureDao pictureDao;
	
	public JsonResult saveDo(Cover cover,MultipartFile file){
		JsonResult result=new JsonResult();
		//id为空,添加
		if(cover.getId()==null){
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
				cover.setPid(addNum);			
			}
			Integer upRow=dao.save(cover);
			if(upRow<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;
		}
		//id非空，修改
		/*//不添加图片时
		if(file==null){
			Integer upRow=dao.update(cover);
			if(upRow==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;
		}*/
		//修改时，传入图片时才更改，不传照片则不更改	
		if(file!=null){
			String imageKey="";
			try {
				imageKey = FileUploadUtil.uploadFile(file.getBytes());
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Picture picture=pictureDao.selectOne(cover.getPid());
				picture.setPicurl(imageKey);
				pictureDao.update(picture);			
		}						
		Integer upPnum=dao.update(cover);
		if(upPnum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;				
	}
}