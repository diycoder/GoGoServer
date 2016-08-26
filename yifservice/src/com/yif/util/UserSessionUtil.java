package com.yif.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.code.kaptcha.Constants;
import com.yif.bean.Admin;
import com.yif.bean.User;
import com.yif.common.AppConstants;
import com.yif.dao.web.Pagination;
import com.yif.dao.web.SearchDTO;
import com.yif.dao.web.WebConstants;

public class UserSessionUtil {
	public static final int currentUserId(){
		return currentUser().getId();
	}
	
	public static final int currentAdminUserId(){
		return currentAdmin().getId();
	}

	public static final String currentUserName(){
		return "";
	}

	public static final Locale currentLocale(){
		return Locale.CHINESE;
	}

	public static User currentUser() {
		User user = null;
		Object obj = getObjectFromSession(WebConstants.USER_SESSION_KEY);
		if (obj != null) {
			user = (User) obj;
		} 

		return user;
	}
	
	
	public static Object getObjectByKey(String key) {
		return getObjectFromSession(key);
	}
	
	
	public static Admin currentAdmin() {
		Admin admin = null;
		Object obj = getObjectFromSession(WebConstants.ADMIN_SESSION_KEY);
		if (obj == null) {
			setAdmin(admin);
		} else {
			admin = (Admin) obj;
		}
		return admin;
	}

	private static Object getObjectFromSession(String attributeKey) {
		HttpSession session = getSession();
		if (session != null) {
			return session.getAttribute(attributeKey);
		}

		return null;
	}

	public static void setUser(User user) {
		addSessionAttribute(WebConstants.USER_SESSION_KEY, user);
	}
	
	public static void setAdmin(Admin admin) {
		addSessionAttribute(WebConstants.ADMIN_SESSION_KEY, admin);
	}
	
	
	public static void setSearchToSession(SearchDTO searchDTO) {
		addSessionAttribute(WebConstants.SEARCH_CONDITION_KEY, searchDTO);
	}

	public static void setPaginationSession(Pagination page) {
		addSessionAttribute(WebConstants.SEARCH_CONDITION_PAGE_KEY, page);
	}
	
	public static void setObjectToSession(Object obj,String key) {
		addSessionAttribute(key, obj);
	}
	

	private static void addSessionAttribute(String attributeKey, Object object) {
		HttpSession session = getSession();
		if (session != null) {
			session.setAttribute(attributeKey, object);
		}
	}
	private static HttpSession getSession() {
		HttpServletRequest request = getRequest();

		if (request != null) {
			return request.getSession();
		}

		return null;
	}

	private static HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();

		return request;
	}

	public static void updateUser(User user) {
		if(currentUser() != null){
			addSessionAttribute(WebConstants.USER_SESSION_KEY, user);
		}
	}

	public static boolean isVerifyCodeValid(String verifyCode){
		//校验验证码
		String code = (String) getObjectFromSession(Constants.KAPTCHA_SESSION_KEY); //获取生成的验证码  
		if(StringUtils.equals(verifyCode, code)){
			getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
			return true;
		} else {
			return false;
		}
	}

	public static boolean isShortMsgCodeValid(String key, String code, String mobileNum){

		return true;
		//return dto.isValid(code, mobileNum);
	}

	public static void invalidateSession() {
		HttpSession session = getSession();
		
		if(session != null){
			session.invalidate();
		}
	}

	//当前用户是否登录
	public static boolean getCurrentUserIsLogin(){
		return UserSessionUtil.currentUser()==null?false:true;
	}
	
	//获取环境语言
	public static String getSysLanguage(){
        Locale locale = LocaleContextHolder.getLocale(); 
		if(locale != null){
			return locale.getLanguage() + "_" + locale.getCountry();
		} else {
			return "AppConstants.LOCALE_LANGUAGE.en_US";
		}
	}
	
	
	
}
