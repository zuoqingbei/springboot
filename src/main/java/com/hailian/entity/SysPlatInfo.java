package com.hailian.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;

/**
 * 平台信息
 * @author zuoqb123
 * @date 2018-09-27
 */
@TableName("sys_plat_info")
public class SysPlatInfo extends BaseModel<SysPlatInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 平台编号
     */
   private String id;
    /**
     * 平台名称
     */
   private String name;
    /**
     * 平台英文名称
     */
   private String enname;
    /**
     * 接口版本
     */
   private String versions;
    /**
     * 平台秘钥
     */
   @TableField("secret_key")
   private String secretKey;
    /**
     * 平台联系人
     */
   private String contacts;
    /**
     * 联系人电话
     */
   @TableField("contacts_tel")
   private String contactsTel;
    /**
     * 联系人邮箱
     */
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
