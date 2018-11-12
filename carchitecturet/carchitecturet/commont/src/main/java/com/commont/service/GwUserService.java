package com.commont.service;

import com.commont.model.GwUser;
import com.commont.util.JsonResult;




public interface GwUserService extends BaseService<Integer, GwUser> {
//保存用户
JsonResult saveOrUpdate(GwUser gwUser);

}