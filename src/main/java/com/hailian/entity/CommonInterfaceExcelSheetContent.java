package com.hailian.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;
/**
 * Excel导出sheet详情配置
 * @author zuoqb123
 * @date 2018-10-14
 */
@TableName("common_interface_excel_sheet_content")
public class CommonInterfaceExcelSheetContent extends BaseModel<CommonInterfaceExcelSheetContent> {

    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
   @ApiModelProperty(name="编码",value="id",dataType="String")
    private String id;
    /**
     * 行位置
     */
   @ApiModelProperty(name="行位置",value="xIp",dataType="Integer")
   @TableField("x_ip")
    private Integer xIp;
    /**
     * 列位置
     */
   @ApiModelProperty(name="列位置",value="yIp",dataType="Integer")
   @TableField("y_ip")
    private Integer yIp;
    /**
     * 对应sheet表ID
     */
   @ApiModelProperty(name="对应sheet表ID",value="sheetId",dataType="String")
   @TableField("sheet_id")
    private String sheetId;
    /**
     * 对应列名称
     */
   @ApiModelProperty(name="对应列名称",value="columnName",dataType="String")
   @TableField("column_name")
    private String columnName;


   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Integer getxIp() {
      return xIp;
   }

   public void setxIp(Integer xIp) {
      this.xIp = xIp;
   }

   public Integer getyIp() {
      return yIp;
   }

   public void setyIp(Integer yIp) {
      this.yIp = yIp;
   }

   public String getSheetId() {
      return sheetId;
   }

   public void setSheetId(String sheetId) {
      this.sheetId = sheetId;
   }

   public String getColumnName() {
      return columnName;
   }

   public void setColumnName(String columnName) {
      this.columnName = columnName;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "CommonInterfaceExcelSheetContent{" +
         ", id=" + id +
         ", xIp=" + xIp +
         ", yIp=" + yIp +
         ", sheetId=" + sheetId +
         ", columnName=" + columnName +
         "}";
   }
}
