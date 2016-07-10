package com.investigation.investigationsystem.common.utils;

import java.security.MessageDigest;
/**
 * 
 * @author: 
 * @date: 2015年12月29日
 */
public class MD5Util {

	/**
	 * MD5加密 生成32位md5密码
	 * @param Str
	 * @return
	 * @author  2015年12月29日
	 */
	 
	public static String encryptByMD5(String Str){
		MessageDigest md5 = null;
		try{
			md5 = MessageDigest.getInstance("MD5");
		}catch (Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = Str.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++){
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	/**
	 * 测试
	 */
/*	@Test
	public  void main() {
		String s = new String("212727");
		System.out.println("原始：" + s);
		System.out.println("MD5后：" + encryptByMD5(s));

	}*/
}
