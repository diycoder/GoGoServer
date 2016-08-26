package com.yif.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yif.bean.User;
import com.yif.bean.Userinfo;
import com.yif.common.MD5;
import com.yif.dto.UserInfoRegistDto;
import com.yif.services.IUserService;
import com.yif.services.IUserinfoService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserinfoService userinfoService;
	
	@RequestMapping(value="/adduser.do", method ={ RequestMethod.GET,RequestMethod.POST})
	public void addUser(@ModelAttribute("dto")UserInfoRegistDto dto){	
		
		//判断密码是否为空，如果为空，密码为123456，然后再加密
		if(dto.getPassword().isEmpty()){
			dto.setPassword(MD5.GetMD5Code("123456"));
		}else{
			dto.setPassword(MD5.GetMD5Code(dto.getPassword()));
		}
		
		userService.addUser(dto);
		
		// 接收返回的主键
		//System.out.println(user.getId());
	}
	
	@RequestMapping(value="/testuser.do", method ={ RequestMethod.GET,RequestMethod.POST})
	public void testUser(HttpServletRequest request,HttpServletResponse response){	
		
		//判断密码是否为空，如果为空，密码为123456，然后再加密
	System.out.println(123);
		
		// 接收返回的主键
		//System.out.println(user.getId());
	}
}
