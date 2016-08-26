package com.yif.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yif.bean.User;
import com.yif.bean.Userinfo;
import com.yif.common.AppConstants;
import com.yif.dao.mapper.UserMapper;
import com.yif.dao.mapper.UserinfoMapper;
import com.yif.dto.UserInfoRegistDto;
import com.yif.services.IUserService;

@Service("userService")
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserinfoMapper userinfoMapper;
	
	//添加用户
	@Override
	public void addUser(UserInfoRegistDto dto) {	

		
		User user=new User();
		user.setAccout(dto.getAccout());//账户名
		user.setPassword(dto.getPassword());//密码
		user.setUsername(dto.getUsername());
		user.setRole(dto.getRole());
		user.setIsuse(dto.getIsuse());
		user.setAddtime(dto.getAddtime());		
		
		userMapper.insert(user);		
		
		Userinfo userinfo=new Userinfo();
		userinfo.setRealname(dto.getRealname());
		userinfo.setAddress(dto.getAddress());
		userinfo.setAddtime(dto.getAddtime());
		userinfo.setAge(dto.getAge());
		userinfo.setCounty(dto.getCounty());
		userinfo.setCity(dto.getCity());
		userinfo.setIdcard(dto.getIdcard());
		userinfo.setSex(dto.getSex());
		userinfo.setUserId(user.getId());
		userinfo.setBirthdate(dto.getBirthdate());
		userinfo.setProvince(dto.getProvince());		
		
		userinfoMapper.insert(userinfo);
		
	}

}
