package com.hailian.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;

/**
 * excel导出模板配置表
 * @author zuoqb123
 * @date 2018-10-11
 */
@TableName("common_interface_excel_table")
public class CommonInterfaceExcelTable extends BaseModel<CommonInterfaceExcelTable> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
   private String id;
    /**
     * 表名称
     */
   private String name;
    /**
     * excel模板系统路径
     */
   @TableField("templet_path")
   private String templetPath;
    /**
     * 查询指标标识
     */
   @TableField("data_type")
   private String dataType;
   @TableField(exist=false)
   private List<CommonInterfaceExcelSheet> sheets;

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

   public List<CommonInterfaceExcelSheet> getSheets() {
	return sheets;
}

public void setSheets(List<CommonInterfaceExcelSheet> sheets) {
	this.sheets = sheets;
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
