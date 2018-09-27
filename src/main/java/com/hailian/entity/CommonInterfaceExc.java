package com.hailian.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hailian.base.BaseModel;

/**
 * 统一接口
 * @author zuoqb123
 * @date 2018-09-27
 */
@TableName("common_interface_exc")
public class CommonInterfaceExc extends BaseModel<CommonInterfaceExc> {

    private static final long serialVersionUID = 1L;

   private String id;
    /**
     * 归属数据源 默认当前数据库
     */
   @TableField("db_datasource_id")
   private String dbDatasourceId;
    /**
     * 查询指标标识
     */
   @TableField("data_type")
   private String dataType;
    /**
     * 命名空间
     */
   @TableField("data_space")
   private String dataSpace;
    /**
     * 需要执行的sql语句，需要传参的位置使用#{参数名}，动态日期类型date_dt_kpi固定参数名称。
     */
   @TableField("data_sql")
   private String dataSql;
    /**
     * 横竖数据格式转换，默认纵向排列（V：垂直排列，H水平排列）
     */
   @TableField("transform_data")
   private String transformData;


   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getDbDatasourceId() {
      return dbDatasourceId;
   }

   public void setDbDatasourceId(String dbDatasourceId) {
      this.dbDatasourceId = dbDatasourceId;
   }

   public String getDataType() {
      return dataType;
   }

   public void setDataType(String dataType) {
      this.dataType = dataType;
   }

   public String getDataSpace() {
      return dataSpace;
   }

   public void setDataSpace(String dataSpace) {
      this.dataSpace = dataSpace;
   }

   public String getDataSql() {
      return dataSql;
   }

   public void setDataSql(String dataSql) {
      this.dataSql = dataSql;
   }

   public String getTransformData() {
      return transformData;
   }

   public void setTransformData(String transformData) {
      this.transformData = transformData;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "CommonInterfaceExc{" +
         ", id=" + id +
         ", dbDatasourceId=" + dbDatasourceId +
         ", dataType=" + dataType +
         ", dataSpace=" + dataSpace +
         ", dataSql=" + dataSql +
         ", transformData=" + transformData +
         "}";
   }
}
