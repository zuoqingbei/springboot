package com.hailian.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;

/**
 * 用户表
 * @author zuoqb123
 * @date 2018-09-28
 */
@TableName("sys_user")
public class SysUser extends BaseModel<SysUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	private String id;
	/**
	 * 登录名
	 */
	@TableField("login_name")
	private String loginName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 工号
	 */
	private String no;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 用户类型
	 */
	@TableField("user_type")
	private String userType;
	/**
	 * 用户头像
	 */
	private String photo;
	/**
	 * 最后登陆IP
	 */
	@TableField("login_ip")
	private String loginIp;
	/**
	 * 最后登陆时间
	 */
	@TableField("login_date")
	private Date loginDate;
	/**
	 * 是否可登录
	 */
	@TableField("login_flag")
	private String loginFlag;

	@TableField(exist = false)
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysUser{" + ", id=" + id + ", loginName=" + loginName + ", password=" + password + ", no=" + no
				+ ", name=" + name + ", email=" + email + ", phone=" + phone + ", mobile=" + mobile + ", userType="
				+ userType + ", photo=" + photo + ", loginIp=" + loginIp + ", loginDate=" + loginDate + ", loginFlag="
				+ loginFlag + "}";
	}
}
