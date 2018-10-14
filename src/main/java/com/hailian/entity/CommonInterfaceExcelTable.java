package com.hailian.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;
/**
 * excel导出模板配置表
 * @author zuoqb123
 * @date 2018-10-14
 */
@TableName("common_interface_excel_table")
public class CommonInterfaceExcelTable extends BaseModel<CommonInterfaceExcelTable> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
   @ApiModelProperty(name="唯一标识",value="id",dataType="String")
    private String id;
    /**
     * 表名称
     */
   @ApiModelProperty(name="表名称",value="name",dataType="String")
    private String name;
    /**
     * excel模板系统路径
     */
   @ApiModelProperty(name="excel模板系统路径",value="templetPath",dataType="String")
   @TableField("templet_path")
    private String templetPath;
    /**
     * 查询指标标识
     */
   @ApiModelProperty(name="查询指标标识",value="dataType",dataType="String")
   @TableField("data_type")
   private String dataType;
   @TableField(exist=false)
   private List<CommonInterfaceExcelSheet> sheets;

   public List<CommonInterfaceExcelSheet> getSheets() {
	return sheets;
}

public void setSheets(List<CommonInterfaceExcelSheet> sheets) {
	this.sheets = sheets;
}

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

   public String getTempletPath() {
      return templetPath;
   }

   public void setTempletPath(String templetPath) {
      this.templetPath = templetPath;
   }

   public String getDataType() {
      return dataType;
   }

   public void setDataType(String dataType) {
      this.dataType = dataType;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "CommonInterfaceExcelTable{" +
         ", id=" + id +
         ", name=" + name +
         ", templetPath=" + templetPath +
         ", dataType=" + dataType +
         "}";
   }
}
