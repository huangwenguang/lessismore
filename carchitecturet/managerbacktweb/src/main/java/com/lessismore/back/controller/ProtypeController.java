package com.lessismore.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lessismore.commont.model.Entity.Pagination;
import com.lessismore.commont.model.Entity.ProtypeCriteria;
import com.lessismore.commont.model.Protype;
import com.lessismore.commont.service.ProtypeService;
import com.lessismore.commont.util.ErrorCode;
import com.lessismore.commont.util.JsonResult;

/**
 * 开发类型处理类
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/protype")
public class ProtypeController {
	@Autowired
	private ProtypeService protypeService;
	/**
	 * 获取所有开发类型列表
	 * @param request
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Pagination pagination){
		System.out.println("类型变化");
		ProtypeCriteria criteria=new ProtypeCriteria();
		Pagination list=protypeService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		return "protype/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return "protype/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Protype protype){	
		JsonResult result=new JsonResult();
		if(protype!=null&&protype.getId()==null){
			Integer addRum=protypeService.save(protype);
			if(addRum<1){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		Integer upNum=protypeService.update(protype);
		if(upNum<1){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		Protype protype=protypeService.selectOne(id);
		request.setAttribute("bean", protype);
		return "protype/view";
	}
	/**
	 * 删除类型
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(Integer id){
		JsonResult result=new JsonResult();
		if(protypeService.delete(id)<1){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
