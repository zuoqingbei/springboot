package com.hailian.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;

/**
 * 数据源配置
 * @author zuoqb123
 * @date 2018-09-27
 */
@TableName("db_datasource_config")
public class DbDatasourceConfig extends BaseModel<DbDatasourceConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
   private String id;
    /**
     * 归属平台
     */
   @TableField("sys_plat_id")
   private String sysPlatId;
    /**
     * 数据源名称
     */
   private String name;
    /**
     * 数据源英文名称
     */
   private String enname;
    /**
     * 数据源类型
     */
   @TableField("db_type")
   private String dbType;
    /**
     * 数据源驱动
     */
   @TableField("db_diver")
   private String dbDiver;
    /**
     * 数据连接地址
     */
   @TableField("db_url")
   private String dbUrl;
    /**
     * 用户名
     */
   @TableField("db_name")
   private String dbName;
    /**
     * 连接密码
     */
   @TableField("db_password")
   private String dbPassword;
    /**
     * 数据库版本
     */
   @TableField("db_version")
   private String dbVersion;
    /**
     * 最大连接数
     */
   @TableField("max_num")
   private Integer maxNum;


   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getSysPlatId() {
      return sysPlatId;
   }

   public void setSysPlatId(String sysPlatId) {
      this.sysPlatId = sysPlatId;
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

   public String getDbName() {
      return dbName;
   }

   public void setDbName(String dbName) {
      this.dbName = dbName;
   }

   public String getDbPassword() {
      return dbPassword;
   }

   public void setDbPassword(String dbPassword) {
      this.dbPassword = dbPassword;
   }

   public String getDbVersion() {
      return dbVersion;
   }

   public void setDbVersion(String dbVersion) {
      this.dbVersion = dbVersion;
   }

   public Integer getMaxNum() {
      return maxNum;
   }

   public void setMaxNum(Integer maxNum) {
      this.maxNum = maxNum;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "DbDatasourceConfig{" +
         ", id=" + id +
         ", sysPlatId=" + sysPlatId +
         ", name=" + name +
         ", enname=" + enname +
         ", dbType=" + dbType +
         ", dbDiver=" + dbDiver +
         ", dbUrl=" + dbUrl +
         ", dbName=" + dbName +
         ", dbPassword=" + dbPassword +
         ", dbVersion=" + dbVersion +
         ", maxNum=" + maxNum +
         "}";
   }
}
