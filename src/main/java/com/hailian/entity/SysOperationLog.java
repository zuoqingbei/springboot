package com.hailian.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;
/**
 * 操作日志
 * @author zuoqb123
 * @date 2018-10-14
 */
@TableName("sys_operation_log")
public class SysOperationLog extends BaseModel<SysOperationLog> {

    private static final long serialVersionUID = 1L;

   @ApiModelProperty(name="",value="id",dataType="String")
   private String id;
    /**
     * 日志类型
     */
   @ApiModelProperty(name="日志类型",value="logDescription",dataType="String")
   @TableField("log_description")
   private String logDescription;
    /**
     * 日志名称
     */
   @ApiModelProperty(name="日志名称",value="actionArgs",dataType="String")
   @TableField("action_args")
   private String actionArgs;
    /**
     * 用户id
     */
   @ApiModelProperty(name="用户id",value="userName",dataType="String")
   @TableField("user_name")
   private String userName;
    /**
     * 类名称
     */
   @ApiModelProperty(name="类名称",value="className",dataType="String")
   @TableField("class_name")
   private String className;
    /**
     * 方法名称
     */
   @ApiModelProperty(name="方法名称",value="method",dataType="String")
   private String method;
   @ApiModelProperty(name="",value="ip",dataType="String")
   private String ip;
    /**
     * 创建时间
     */
   @ApiModelProperty(name="创建时间",value="createTime",dataType="Long")
   @TableField("create_time")
   private Long createTime;
    /**
     * 是否成功
     */
   @ApiModelProperty(name="是否成功",value="succeed",dataType="String")
   private String succeed;
    /**
     * 备注
     */
   @ApiModelProperty(name="备注",value="message",dataType="String")
   private String message;


   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getLogDescription() {
      return logDescription;
   }

   public void setLogDescription(String logDescription) {
      this.logDescription = logDescription;
   }

   public String getActionArgs() {
      return actionArgs;
   }

   public void setActionArgs(String actionArgs) {
      this.actionArgs = actionArgs;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getClassName() {
      return className;
   }

   public void setClassName(String className) {
      this.className = className;
   }

   public String getMethod() {
      return method;
   }

   public void setMethod(String method) {
      this.method = method;
   }

   public String getIp() {
      return ip;
   }

   public void setIp(String ip) {
      this.ip = ip;
   }

   public Long getCreateTime() {
      return createTime;
   }

   public void setCreateTime(Long createTime) {
      this.createTime = createTime;
   }

   public String getSucceed() {
      return succeed;
   }

   public void setSucceed(String succeed) {
      this.succeed = succeed;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "SysOperationLog{" +
         ", id=" + id +
         ", logDescription=" + logDescription +
         ", actionArgs=" + actionArgs +
         ", userName=" + userName +
         ", className=" + className +
         ", method=" + method +
         ", ip=" + ip +
         ", createTime=" + createTime +
         ", succeed=" + succeed +
         ", message=" + message +
         "}";
   }
}
