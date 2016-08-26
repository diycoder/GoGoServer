package com.yif.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yif.dto.BussDto;
import com.yif.services.IMReleaseInfo;
import com.yif.util.ActionUtils;

@Controller
@RequestMapping(value="shop")
public class ShopController {

	@Autowired
	private IMReleaseInfo mRleaseInfo;
	
	@RequestMapping(value="/addshop.do", method ={ RequestMethod.GET,RequestMethod.POST})
	public void addUser(@ModelAttribute("dto")BussDto dto,HttpServletRequest request){	
		System.out.println("123");
		
		List<Map> params = ActionUtils.getInstance().getParamByArrayList("phone", request);//可以获取多个标签
		
//		String[] phone=request.getParameterMap().get("phone");//适用于单个组合
		

		mRleaseInfo.addMRleaseInfo();
	}
}
