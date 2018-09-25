package com.hailian.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 数据源配置
 * </p>
 * @author zuoqb123
 * @date 2018-09-25
 */
@TableName("data_datasource_config")
public class DataDatasourceConfig extends Model<DataDatasourceConfig> {

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
     * 创建者
     */
   @TableField("create_by")
   private String createBy;
    /**
     * 创建时间
     */
   @TableField("create_date")
   private Date createDate;
    /**
     * 更新者
     */
   @TableField("update_by")
   private String updateBy;
    /**
     * 更新时间
     */
   @TableField("update_date")
   private Date updateDate;
    /**
     * 备注信息
     */
   private String remarks;
    /**
     * 删除标记
     */
   @TableField("del_flag")
   private String delFlag;
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

   public String getCreateBy() {
      return createBy;
   }

   public void setCreateBy(String createBy) {
      this.createBy = createBy;
   }

   public Date getCreateDate() {
      return createDate;
   }

   public void setCreateDate(Date createDate) {
      this.createDate = createDate;
   }

   public String getUpdateBy() {
      return updateBy;
   }

   public void setUpdateBy(String updateBy) {
      this.updateBy = updateBy;
   }

   public Date getUpdateDate() {
      return updateDate;
   }

   public void setUpdateDate(Date updateDate) {
      this.updateDate = updateDate;
   }

   public String getRemarks() {
      return remarks;
   }

   public void setRemarks(String remarks) {
      this.remarks = remarks;
   }

   public String getDelFlag() {
      return delFlag;
   }

   public void setDelFlag(String delFlag) {
      this.delFlag = delFlag;
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
         ", createBy=" + createBy +
         ", createDate=" + createDate +
         ", updateBy=" + updateBy +
         ", updateDate=" + updateDate +
         ", remarks=" + remarks +
         ", delFlag=" + delFlag +
         ", dbVersion=" + dbVersion +
         ", suportTransaction=" + suportTransaction +
         "}";
   }
}
