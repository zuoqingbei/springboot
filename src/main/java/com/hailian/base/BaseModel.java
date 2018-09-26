package com.hailian.base;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
/**
 * 
 * @time   2018年9月26日 下午2:26:29
 * @author zuoqb
 * @todo   通用实体类
 */
@SuppressWarnings({ "serial", "rawtypes" })
public abstract class BaseModel<T extends Model> extends Model<T> {
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
	@TableField(exist = false)
	private String orderBy;
	@TableField(exist = false)
	private boolean asc=true   ;//是否为升序;
	@TableField(exist = false)
	private Date startDate;
	@TableField(exist = false)
	private Date endDate;

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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
