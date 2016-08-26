package com.yif.util;

import org.apache.commons.lang.StringUtils;

import com.yif.common.AppConstants;

public class LocaleUtil {
	public static String switchLocale(String locale){
		if(StringUtils.isNotBlank(locale)){
			if(StringUtils.equals(locale, "AppConstants.LOCALE_LANGUAGE.en_US")){
				return  "AppConstants.LOCALE_LANGUAGE.zh_CN";
			} else {
				return  "AppConstants.LOCALE_LANGUAGE.en_US";
			}
		}
		
		return "AppConstants.LOCALE_LANGUAGE.zh_CN";
	}
}
