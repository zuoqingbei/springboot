package com.hailian.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;

/**
 * Excel导出sheet也配置表
 * @author zuoqb123
 * @date 2018-10-11
 */
@TableName("common_interface_excel_sheet")
public class CommonInterfaceExcelSheet extends BaseModel<CommonInterfaceExcelSheet> {

    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
   private String id;
    /**
     * 标签名称
     */
   private String name;
    /**
     * 对应表ID
     */
   @TableField("table_id")
   private String tableId;
    /**
     * 命名空间
     */
   @TableField("data_space")
   private String dataSpace;
    /**
     * 排序
     */
   @TableField("order_no")
   private Integer orderNo;
   @TableField(exist=false)
   private List<CommonInterfaceExcelSheetContent>  sheetContens;
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

   public String getTableId() {
      return tableId;
   }

   public void setTableId(String tableId) {
      this.tableId = tableId;
   }

   public String getDataSpace() {
      return dataSpace;
   }

   public void setDataSpace(String dataSpace) {
      this.dataSpace = dataSpace;
   }

   public Integer getOrderNo() {
      return orderNo;
   }

   public void setOrderNo(Integer orderNo) {
      this.orderNo = orderNo;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   public List<CommonInterfaceExcelSheetContent> getSheetContens() {
	return sheetContens;
}

public void setSheetContens(List<CommonInterfaceExcelSheetContent> sheetContens) {
	this.sheetContens = sheetContens;
}

@Override
   public String toString() {
      return "CommonInterfaceExcelSheet{" +
         ", id=" + id +
         ", name=" + name +
         ", tableId=" + tableId +
         ", dataSpace=" + dataSpace +
         ", orderNo=" + orderNo +
         "}";
   }
}
