package com.hailian.conf;

import java.text.SimpleDateFormat;

import com.alibaba.druid.util.JdbcConstants;

/**
 * 
 * @className Constant.java
 * @author zuoqb
 */
public interface Constant {
	public static String USER_INFO="hailian_user";
	public static final  String UN_DEL_FLAG="0";//未删除标识
	public static final  String DEL_FLAG="1";//删除标识
	//public static final  String DB_TYPE = JdbcConstants.MYSQL;
	public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final String Default_X_SIGN="hlsofttech";//默认SQL接口签名
	public static final String VERTICAL_DATA_FORMAT="H";//横向数据格式
}
