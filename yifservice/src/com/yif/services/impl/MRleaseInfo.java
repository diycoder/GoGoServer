package com.yif.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yif.bean.Mrelease;
import com.yif.common.AppConstants;
import com.yif.dao.mapper.MreleaseMapper;
import com.yif.services.IMReleaseInfo;

//商家
@Service("mRleaseInfo")
public class MRleaseInfo implements IMReleaseInfo {

	@Autowired
	private MreleaseMapper mreleaseMapper;
	
	
	@Override
	public int addMRleaseInfo() {
		
		//想商家发布信息表中添加数据
		Mrelease m=new Mrelease();
		m.setAddtime(new Date());
		m.setyUId(2);//用户ID
		m.setTitle("租房");
		m.setContent("三室一厅，精装修");
		m.setKeyWord("大  好 ");//关键词
		m.setIsshow(0);
		m.setPrice(300.0);//价格
		m.setmAddress("北京市海淀区");
		m.setType(AppConstants.housetype.zuf);
		m.setAssist(0);//赞的数量
		
		mreleaseMapper.insert(m);
		
		System.out.println(m.getId());
		
		return m.getId();
	}

}
