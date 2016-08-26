package com.yif.common;

public interface AppConstants {
	String USER_SESSION_KEY = "USER_SESSION_KEY";
	String ADMIN_SESSION_KEY = "ADMIN_SESSION_KEY";

	String FORGET_VERIFIED_KEY = "FORGET_VERIFIED_KEY";
	// 系统语言
	String SYS_LANGUAGE_SESSION_KEY = "SYS_LANGUAGE_SESSION_KEY";

	String COOKIE_REMEMBER_USER__PASSWORD__NAME = "COOKIE_REMEMBER_USER__PASSWORD__NAME";

	// 人员角色
	interface ROLETYPE {
		int admin = 1; // 管理员
		int normal = 2; // 普通用户
		int shop = 3; // 商家用户
	}

	// 用户是否可以处于封号状态
	interface SEALTYPE {
		int normal = 0; // 正常状态
		int seal = 1; // 封号状态
	}

	// 用户是否可以处于封号状态
		interface sex {
			int man = 0; // 正常状态
			int boman = 1; // 封号状态
		}
		
		// 商家房子类型
				interface housetype {
					int zuf = 1; // 租房
					int qif = 2; // 期房
					int xianf = 3; //现房
					int esf=4;//二手房
				}
				
				// 图片类型
				interface imagetype {
					int btimage= 1; // 标题图
					int tuji = 2; // 图集
					int address = 3; //地理位置图片
				
				}
				
}
