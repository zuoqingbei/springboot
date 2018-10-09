package com.hailian.service;

import com.hailian.entity.SysUser;
import com.hailian.base.BaseService;
import com.baomidou.mybatisplus.plugins.Page;
import com.hailian.base.BaseController;
import javax.servlet.http.HttpServletRequest;


/**
 * @date 2018-10-09
 * @author zuoqb123
 * 用户表服务类
 */
public interface ISysUserService extends BaseService<SysUser> {
 	 /**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   用户表新增或者修改
     */
	boolean saveOrUpdate(SysUser entity);
	/**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   用户表逻辑删除
     */
	boolean deleteLogic(String id);
	/**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   用户表单条数据查询
     */
	SysUser getById(String id);
	/**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   用户表分页查询
     */
	Page<SysUser> pageList(BaseController c,HttpServletRequest request,SysUser entity,Integer pageNum,Integer pageSize);
}
