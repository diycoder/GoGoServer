package com.yif.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomUtil {
	private static final int offset = 9803803; // offset为固定值，避免被猜到种子来源（和密码学中的加salt有点类似）
	private static final int MAX_CODE = 999999;
	
	public static String code() {
		long seed = System.currentTimeMillis() + offset;
		SecureRandom secureRandom;
		
		String code = "";
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			
			secureRandom.setSeed(seed);
			int random = 0;
			while(random <= 100000){
				random = secureRandom.nextInt(MAX_CODE);
			}
			
			code = String.valueOf(random);
			
			//return SecurityUtil.MD5(code);
			
		} catch (NoSuchAlgorithmException e) {
			
		}
		
		return code;
	}
}
