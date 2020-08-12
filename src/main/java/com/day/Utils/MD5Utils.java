package com.day.Utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MD5Utils {

	/**
	 * 
	 * @Title: getMD5Str
	 * @Description:TODO (对字符串进行md5加密)
	 * @param @param strValue
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @author Day  
	 * @date 2020年8月5日 下午4:39:07
	 * @return String  返回值类型
	 * @throws
	 */
	public static String getMD5Str(String strValue) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
		return newstr;
	}

	public static void main(String[] args) {
		try {
			String md5 = getMD5Str("imooc");
			System.out.println(md5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
