package com.hailian.domain;

/**
 * @time   2018年9月13日 上午11:18:12
 * @author zuoqb
 * @todo   数据库配置
 */
public class DbConfig {
	/**
	 * 数据库类型
	 */
	private String dbType;
	/**
	 * 数据源驱动
	 */
	private String dbDiver;
	/**
	 * 数据库地址
	 */
	private String dbUrl;
	/**
	 * 数据库账号
	 */
	private String userName;
	/**
	 * 数据库密码
	 */
	private String password;
	public DbConfig() {
		super();
	}
	public DbConfig(String dbType, String dbDiver, String dbUrl, String userName, String password) {
		super();
		this.dbType = dbType;
		this.dbDiver = dbDiver;
		this.dbUrl = dbUrl;
		this.userName = userName;
		this.password = password;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getDbDiver() {
		return dbDiver;
	}
	public void setDbDiver(String dbDiver) {
		this.dbDiver = dbDiver;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
