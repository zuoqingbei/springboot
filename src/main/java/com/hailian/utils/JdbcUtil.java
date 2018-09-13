package com.hailian.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.util.StringUtils;

import com.hailian.domain.DbConfig;

/**
 * @time   2018年9月13日 上午10:38:25
 * @author zuoqb
 * @todo   原始JDBC连接工具
 */
public class JdbcUtil {
	private static Connection conn = null;
	//测试环境
	private static String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	public static String DATASOURCE_URL = "jdbc:mysql://10.130.96.74:3306/lianxin?characterEncoding=utf8";
	public static String DATASOURCE_USERNAME = "root";
	public static String DATASOURCE_PASSWORD = "hl123456";
	
	/**
	 * 统一接口jdbc连接配置
	 */
	public static Connection getConn(DbConfig config) {
		if(config==null){
			return null;
		}
		if(StringUtils.isEmpty(config.getDbUrl())||StringUtils.isEmpty(config.getUserName())
				||StringUtils.isEmpty(config.getDbDiver())){
			return null;
		}
		try {
			Connection conn = null;
			Class.forName(config.getDbDiver());
			conn = DriverManager.getConnection(config.getDbUrl(), config.getUserName(), config.getPassword());
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 
	 * @time   2018年9月13日 上午11:09:37
	 * @author zuoqb
	 * @todo   关闭
	 */
	public static void close(Connection conn
			,Statement stat,ResultSet rs){
		 try {
			 if (rs!=null) {
				rs.close();
			 }
			 if (stat!=null) {
				stat.close();
			 }
			 if (conn!=null) {
				 //保证从池当中拿出的连接都是自动提交的
				conn.setAutoCommit(true);
				conn.close();
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
