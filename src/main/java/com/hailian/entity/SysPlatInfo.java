package com.hailian.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;
/**
 * 平台信息
 * @author zuoqb123
 * @date 2018-10-14
 */
@TableName("sys_plat_info")
public class SysPlatInfo extends BaseModel<SysPlatInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 平台编号
     */
   @ApiModelProperty(name="平台编号",value="id",dataType="String")
   private String id;
    /**
     * 平台名称
     */
   @ApiModelProperty(name="平台名称",value="name",dataType="String")
   private String name;
    /**
     * 平台英文名称
     */
   @ApiModelProperty(name="平台英文名称",value="enname",dataType="String")
   private String enname;
    /**
     * 接口版本
     */
   @ApiModelProperty(name="接口版本",value="versions",dataType="String")
   private String versions;
    /**
     * 平台秘钥 X-Sign
     */
   @ApiModelProperty(name="平台秘钥 X-Sign",value="secretKey",dataType="String")
   @TableField("secret_key")
   private String secretKey;
    /**
     * 平台联系人
     */
   @ApiModelProperty(name="平台联系人",value="contacts",dataType="String")
   private String contacts;
    /**
     * 联系人电话
     */
   @ApiModelProperty(name="联系人电话",value="contactsTel",dataType="String")
   @TableField("contacts_tel")
   private String contactsTel;
    /**
     * 联系人邮箱
     */
   @ApiModelProperty(name="联系人邮箱",value="contactsMail",dataType="String")
   @TableField("contacts_mail")
   private String contactsMail;


   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEnname() {
      return enname;
   }

   public void setEnname(String enname) {
      this.enname = enname;
   }

   public String getVersions() {
      return versions;
   }

   public void setVersions(String versions) {
      this.versions = versions;
   }

   public String getSecretKey() {
      return secretKey;
   }

   public void setSecretKey(String secretKey) {
      this.secretKey = secretKey;
   }

   public String getContacts() {
      return contacts;
   }

   public void setContacts(String contacts) {
      this.contacts = contacts;
   }

   public String getContactsTel() {
      return contactsTel;
   }

   public void setContactsTel(String contactsTel) {
      this.contactsTel = contactsTel;
   }

   public String getContactsMail() {
      return contactsMail;
   }

   public void setContactsMail(String contactsMail) {
      this.contactsMail = contactsMail;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "SysPlatInfo{" +
         ", id=" + id +
         ", name=" + name +
         ", enname=" + enname +
         ", versions=" + versions +
         ", secretKey=" + secretKey +
         ", contacts=" + contacts +
         ", contactsTel=" + contactsTel +
         ", contactsMail=" + contactsMail +
         "}";
   }
}
