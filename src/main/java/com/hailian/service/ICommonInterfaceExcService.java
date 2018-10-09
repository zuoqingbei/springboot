package com.hailian.service;

import com.hailian.entity.CommonInterfaceExc;
import com.hailian.base.BaseService;
import com.baomidou.mybatisplus.plugins.Page;
import com.hailian.base.BaseController;
import javax.servlet.http.HttpServletRequest;


/**
 * @date 2018-10-09
 * @author zuoqb123
 * 统一接口服务类
 */
public interface ICommonInterfaceExcService extends BaseService<CommonInterfaceExc> {
 	 /**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   统一接口新增或者修改
     */
	boolean saveOrUpdate(CommonInterfaceExc entity);
	/**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   统一接口逻辑删除
     */
	boolean deleteLogic(String id);
	/**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   统一接口单条数据查询
     */
	CommonInterfaceExc getById(String id);
	/**
     * @date   2018-10-09
     * @author zuoqb123
     * @todo   统一接口分页查询
     */
	Page<CommonInterfaceExc> pageList(BaseController c,HttpServletRequest request,CommonInterfaceExc entity,Integer pageNum,Integer pageSize);
}
