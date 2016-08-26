package com.yif.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yif.bean.Userinfo;
import com.yif.dao.mapper.UserinfoMapper;
import com.yif.services.IUserinfoService;

@Service("userinfoService")
public class UserinfoService implements IUserinfoService{

	@Autowired
	private UserinfoMapper userinfoMapper;
	
	@Override
	public void addUserInfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		userinfoMapper.insert(userinfo);
	}

}
