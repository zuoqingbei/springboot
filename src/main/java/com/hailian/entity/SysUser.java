package com.hailian.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;
/**
 * 用户表
 * @author zuoqb123
 * @date 2018-10-14
 */
@TableName("sys_user")
public class SysUser extends BaseModel<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
   @ApiModelProperty(name="编号",value="id",dataType="String")
   private String id;
    /**
     * 登录名
     */
   @ApiModelProperty(name="登录名",value="loginName",dataType="String")
   @TableField("login_name")
   private String loginName;
    /**
     * 密码
     */
   @ApiModelProperty(name="密码",value="password",dataType="String")
   private String password;
    /**
     * 工号
     */
   @ApiModelProperty(name="工号",value="no",dataType="String")
   private String no;
    /**
     * 姓名
     */
   @ApiModelProperty(name="姓名",value="name",dataType="String")
   private String name;
    /**
     * 邮箱
     */
   @ApiModelProperty(name="邮箱",value="email",dataType="String")
   private String email;
    /**
     * 电话
     */
   @ApiModelProperty(name="电话",value="phone",dataType="String")
   private String phone;
    /**
     * 手机
     */
   @ApiModelProperty(name="手机",value="mobile",dataType="String")
   private String mobile;
    /**
     * 用户类型
     */
   @ApiModelProperty(name="用户类型",value="userType",dataType="String")
   @TableField("user_type")
   private String userType;
    /**
     * 用户头像
     */
   @ApiModelProperty(name="用户头像",value="photo",dataType="String")
   private String photo;
    /**
     * 最后登陆IP
     */
   @ApiModelProperty(name="最后登陆IP",value="loginIp",dataType="String")
   @TableField("login_ip")
   private String loginIp;
    /**
     * 最后登陆时间
     */
   @ApiModelProperty(name="最后登陆时间",value="loginDate",dataType="Date")
   @TableField("login_date")
   private Date loginDate;
    /**
     * 是否可登录
     */
   @ApiModelProperty(name="是否可登录",value="loginFlag",dataType="String")
   @TableField("login_flag")
   private String loginFlag;
   @ApiModelProperty(name="登录凭据",value="accessToken",dataType="String")
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
      return "SysUser{" +
         ", id=" + id +
         ", loginName=" + loginName +
         ", password=" + password +
         ", no=" + no +
         ", name=" + name +
         ", email=" + email +
         ", phone=" + phone +
         ", mobile=" + mobile +
         ", userType=" + userType +
         ", photo=" + photo +
         ", loginIp=" + loginIp +
         ", loginDate=" + loginDate +
         ", loginFlag=" + loginFlag +
         "}";
   }
}
