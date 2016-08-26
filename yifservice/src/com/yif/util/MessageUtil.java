package com.yif.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.yif.dao.web.WebConstants;

@Component
public class MessageUtil {
	    //注册
		public static final String SHORT_MSG_REG_CODE = "short.msg.reg.code";
		//密码找回
		public static final String SHORT_MSG_FORGET_PASSWORD_CODE = "short.msg.forget.password.code";
		public static final String SHORT_MSG_UPDATE_MOBILE_CODE = "short.msg.update.mobile.code";
		public static final String SHORT_MSG_UPDATE_MOBILE_NEXT_CODE = "short.msg.update.mobile.next.code";
		public static final String SHORT_MSG_WITHDRAW_CODE = "short.msg.withdraw.code";
		public static final String SHORT_MSG_SEND_FORGET_PAY_PASSWORD_CODE = "short.msg.send.forget.pay.password.code";
		public static final String SHORT_MSG_INVITE_FRIEND_CODE = "short.msg.invite.friend.code";
	    //发送用户理财金信息
		public static final String SHORT_MSG_SEND_USER_BONUS_MSG = "send.user.bonus.msg";
		
		@Autowired
		private MessageSource messageSource;
		
		
		public String getMessage(String key, Locale locale, Object... params){
			return messageSource.getMessage(key, params, locale);
		}
		
		public String getMessage(String key, Object... params){
			try{
				return messageSource.getMessage(key, params, Locale.CHINA);
			}catch(Exception e){
			}
			return null;
		}
		
		//短信
		public static String getShortMessageKey(String key){
			return WebConstants.SYS_SMS_CODE_SESSION_KEY + key;
		}
		
}
