package com.hailian.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;
/**
 * 数据源配置
 * @author zuoqb123
 * @date 2018-10-14
 */
@TableName("db_datasource_config")
public class DbDatasourceConfig extends BaseModel<DbDatasourceConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
   @ApiModelProperty(name="编号",value="id",dataType="String")
   private String id;
    /**
     * 归属平台
     */
   @ApiModelProperty(name="归属平台",value="sysPlatId",dataType="String")
   @TableField("sys_plat_id")
   private String sysPlatId;
    /**
     * 数据源名称
     */
   @ApiModelProperty(name="数据源名称",value="name",dataType="String")
   private String name;
    /**
     * 数据源英文名称
     */
   @ApiModelProperty(name="数据源英文名称",value="enname",dataType="String")
   private String enname;
    /**
     * 数据源类型
     */
   @ApiModelProperty(name="数据源类型",value="dbType",dataType="String")
   @TableField("db_type")
   private String dbType;
    /**
     * 数据源驱动
     */
   @ApiModelProperty(name="数据源驱动",value="dbDiver",dataType="String")
   @TableField("db_diver")
   private String dbDiver;
    /**
     * 数据连接地址
     */
   @ApiModelProperty(name="数据连接地址",value="dbUrl",dataType="String")
   @TableField("db_url")
   private String dbUrl;
    /**
     * 用户名
     */
   @ApiModelProperty(name="用户名",value="dbName",dataType="String")
   @TableField("db_name")
   private String dbName;
    /**
     * 连接密码
     */
   @ApiModelProperty(name="连接密码",value="dbPassword",dataType="String")
   @TableField("db_password")
   private String dbPassword;
    /**
     * 数据库版本
     */
   @ApiModelProperty(name="数据库版本",value="dbVersion",dataType="String")
   @TableField("db_version")
   private String dbVersion;
    /**
     * 最大连接数
     */
   @ApiModelProperty(name="最大连接数",value="maxNum",dataType="Integer")
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
