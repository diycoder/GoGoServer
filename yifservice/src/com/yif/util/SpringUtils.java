/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.yif.util;

import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

/**
 * Utils - Spring
 * 
 */
@Component("springUtils")
@Lazy(false)
public final class SpringUtils implements ApplicationContextAware, DisposableBean {

	private static final Logger log = Logger
			.getLogger(SpringUtils.class);
	
	/** applicationContext */
	private static ApplicationContext applicationContext;

	/**
	 * 不可实例化
	 */
	private SpringUtils() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtils.applicationContext = applicationContext;
	}

	public void destroy() throws Exception {
		applicationContext = null;
	}

	/**
	 * 获取applicationContext
	 * 
	 * @return applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取实例
	 * 
	 * @param name
	 *            Bean名称
	 * @return 实例
	 */
	public static Object getBean(String name) {
		Assert.hasText(name);
		return applicationContext.getBean(name);
	}

	/**
	 * 获取实例
	 * 
	 * @param name
	 *            Bean名称
	 * @param type
	 *            Bean类型
	 * @return 实例
	 */
	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);
		return applicationContext.getBean(name, type);
	}

	/**
	 * 获取国际化消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 国际化消息
	 */
	public static String getMessage(String code, HttpServletRequest request,Object... args) {
		LocaleResolver localeResolver = getBean("localeResolver", LocaleResolver.class);
		Locale locale = localeResolver.resolveLocale(request);
		String msg = null;
		try{
			msg=applicationContext.getMessage(code, args, locale);
		}catch(Exception e){
			log.error(code,e);
		}
		return msg;
	}


	/**
	 * 根据需要生成随机码
	 */
	static Random r = new Random();
	static String ssource = "0123456789";
	static char[] src = ssource.toCharArray();
	//产生随机字符串
	
	public static String getRandomString (int length)
	{
		char[] buf = new char[length];
		int rnd;
		for(int i=0;i<length;i++)
		{
			rnd = Math.abs(r.nextInt()) % src.length;

			buf[i] = src[rnd];
		}
		return new String(buf);
	}


	
	/**
	 * 获取国际化消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 国际化消息
	 */
	/*public static String getMessageConAndCode(String constants,Object obj) {
		if(obj != null){
			 return getMessage(constants + StringUtil.ObjectToStringUtil(obj));
		}
	   return "";
	}*/
}