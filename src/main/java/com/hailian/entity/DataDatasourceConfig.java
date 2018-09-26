package com.hailian.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;

/**
 * 数据源配置
 * @author zuoqb123
 * @date 2018-09-26
 */
@TableName("data_datasource_config")
public class DataDatasourceConfig extends BaseModel<DataDatasourceConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
   private String id;
    /**
     * 创建用户
     */
   @TableField("user_id")
   private String userId;
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
     * 最大连接数
     */
   @TableField("max_num")
   private Integer maxNum;
    /**
     * 是否可用
     */
   private String useable;
    /**
     * 数据库版本
     */
   @TableField("db_version")
   private String dbVersion;
    /**
     * 是否支持事务
     */
   @TableField("suport_transaction")
   private String suportTransaction;


   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
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

   public Integer getMaxNum() {
      return maxNum;
   }

   public void setMaxNum(Integer maxNum) {
      this.maxNum = maxNum;
   }

   public String getUseable() {
      return useable;
   }

   public void setUseable(String useable) {
      this.useable = useable;
   }

   public String getDbVersion() {
      return dbVersion;
   }

   public void setDbVersion(String dbVersion) {
      this.dbVersion = dbVersion;
   }

   public String getSuportTransaction() {
      return suportTransaction;
   }

   public void setSuportTransaction(String suportTransaction) {
      this.suportTransaction = suportTransaction;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "DataDatasourceConfig{" +
         ", id=" + id +
         ", userId=" + userId +
         ", name=" + name +
         ", enname=" + enname +
         ", dbType=" + dbType +
         ", dbDiver=" + dbDiver +
         ", dbUrl=" + dbUrl +
         ", dbName=" + dbName +
         ", dbPassword=" + dbPassword +
         ", maxNum=" + maxNum +
         ", useable=" + useable +
         ", dbVersion=" + dbVersion +
         ", suportTransaction=" + suportTransaction +
         "}";
   }
}
