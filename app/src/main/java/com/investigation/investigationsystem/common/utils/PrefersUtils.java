package com.investigation.investigationsystem.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.investigation.investigationsystem.MyApplication;


/**
 *
 *
 */

public class PrefersUtils {

//	获取项目包名  get package name
//	private static final String PACKAGE_NAME = MyApplication.getInstance() .getPackageInfo().packageName + ".config";


	//这里以用户名命名，每个用户保存一份内容 文件名 等加入applicationutils可以使用
	public static SharedPreferences getSharedPreferences() {
		return MyApplication.getInstance().getBaseContext().getSharedPreferences(
				"PACKAGE_NAME" , Context.MODE_PRIVATE);
	}

	/*****************************************************************************************
	 * 公共方法区 String Boolean Long Int clear缓存
	 ***************************************************************************************/
	public static String getString(String key) {
		return getSharedPreferences().getString(key, "");
	}

	public static Boolean getBoolean(String key) {
		return getSharedPreferences().getBoolean(key, false);
	}

	public static int getInt(String key) {
		return getSharedPreferences().getInt(key, 0);
	}

	public static long getLong(String key) {
		return getSharedPreferences().getLong(key, 0L);
	}

	public static void putString(String key, String value) {
		getSharedPreferences().edit().putString(key, value).commit();
	}

	public static void putBoolean(String key, Boolean value) {
		getSharedPreferences().edit().putBoolean(key, value).commit();
	}

	public static void putInt(String key, int value) {
		getSharedPreferences().edit().putInt(key, value).commit();
	}

	public static void putLong(String key, long value) {
		getSharedPreferences().edit().putLong(key, value).commit();
	}

	// 清除所有缓存数据
	public static void clear() {
		getSharedPreferences().edit().clear().commit();
	}


}
