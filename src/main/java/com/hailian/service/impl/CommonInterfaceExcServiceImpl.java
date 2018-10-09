package com.hailian.service.impl;

import com.hailian.entity.CommonInterfaceExc;
import com.hailian.mapper.CommonInterfaceExcMapper;
import com.hailian.service.ICommonInterfaceExcService;
import com.hailian.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import com.hailian.common.UUIDUtils;
import com.hailian.conf.Constant;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hailian.base.BaseController;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
/**
 * @date 2018-10-09
 * @author zuoqb123
 * 统一接口服务实现类
 */
@Service
@Transactional
public class CommonInterfaceExcServiceImpl extends BaseServiceImpl<CommonInterfaceExcMapper, CommonInterfaceExc> implements ICommonInterfaceExcService,Constant {

    @Autowired
    private CommonInterfaceExcMapper commonInterfaceExcMapper;
    
     /**
     * @date 2018-10-09
     * @author zuoqb123
     * @todo   统一接口新增或者修改
     */
	@Override
	public boolean saveOrUpdate(CommonInterfaceExc entity) {
		if(StringUtils.isBlank(entity.getId())){
			//新增
			entity.setId(UUIDUtils.getUuid());
			entity.setCreateDate(new Date());
			return commonInterfaceExcMapper.insert(entity)>0;
		}else{
			entity.setUpdateDate(new Date());
			return commonInterfaceExcMapper.updateById(entity)>0;
		}
	}
	/**
     * @date 2018-10-09
     * @author zuoqb123
     * @todo   统一接口逻辑删除
     */
	@Override
	public boolean deleteLogic(String id) {
		CommonInterfaceExc entity=new CommonInterfaceExc();
		entity.setId(id);
		entity.setDelFlag(DEL_FLAG);
		entity.setUpdateDate(new Date());
		return commonInterfaceExcMapper.updateById(entity)>0;
	}
	/**
     * @date 2018-10-09
     * @author zuoqb123
     * @todo   统一接口单条数据查询
     */
	@Override
	public CommonInterfaceExc getById(String id) {
		EntityWrapper<CommonInterfaceExc> wrapper = new EntityWrapper<CommonInterfaceExc>();
		wrapper.where("del_flag={0}",UN_DEL_FLAG);
		wrapper.eq("id", id);
		return selectOne(wrapper);
	}
	/**
     * @date   @date 2018-10-09
     * @author zuoqb123
     * @todo   统一接口分页查询
     */
	@Override
	public Page<CommonInterfaceExc> pageList(BaseController c, HttpServletRequest request, CommonInterfaceExc entity,Integer pageNum,Integer pageSize) {
		EntityWrapper<CommonInterfaceExc> wrapper = searchWrapper(c,request, entity);
		Page<CommonInterfaceExc> page=new Page<CommonInterfaceExc>(pageNum, pageSize);
		page=selectPage(page,wrapper);
		return page;
	}
	
	 /**
     * @date 2018-10-09
     * @author zuoqb123
     * @todo   统一接口构建查询条件-以后扩展
     */
    private EntityWrapper<CommonInterfaceExc> searchWrapper(BaseController c,HttpServletRequest request, CommonInterfaceExc entity) {
		EntityWrapper<CommonInterfaceExc> wrapper = new EntityWrapper<CommonInterfaceExc>();
		wrapper.where("del_flag={0}", UN_DEL_FLAG);
		if(c.getLoginUser(request)!=null&&StringUtils.isNotBlank(c.getLoginUser(request).getId())){
			if(!c.isAdmin(request))
			 wrapper.and("create_by", c.getLoginUser(request).getId());
		}
		//根据模糊查询
		if(entity.getId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getId()))){
			wrapper.like("id", String.valueOf(entity.getId()));
		}
		//根据归属数据源 默认当前数据库模糊查询
		if(entity.getDbDatasourceId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbDatasourceId()))){
			wrapper.like("db_datasource_id", String.valueOf(entity.getDbDatasourceId()));
		}
		//根据查询指标标识模糊查询
		if(entity.getDataType()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDataType()))){
			wrapper.like("data_type", String.valueOf(entity.getDataType()));
		}
		//根据命名空间模糊查询
		if(entity.getDataSpace()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDataSpace()))){
			wrapper.like("data_space", String.valueOf(entity.getDataSpace()));
		}
		//根据需要执行的sql语句，需要传参的位置使用#{参数名}，动态日期类型date_dt_kpi固定参数名称。模糊查询
		if(entity.getDataSql()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDataSql()))){
			wrapper.like("data_sql", String.valueOf(entity.getDataSql()));
		}
		//根据横竖数据格式转换，默认纵向排列（V：垂直排列，H水平排列）模糊查询
		if(entity.getTransformData()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getTransformData()))){
			wrapper.like("transform_data", String.valueOf(entity.getTransformData()));
		}
		if(StringUtils.isNoneBlank(entity.getOrderBy())){
			wrapper.orderBy(entity.getOrderBy(), entity.isAsc());
		}else{
			wrapper.orderBy("create_date", true);
		}
		if(entity.getStartDate()!=null){
			wrapper.ge("create_date", entity.getStartDate());
		}
		if(entity.getEndDate()!=null){
			wrapper.le("create_date", entity.getEndDate());
		}
		System.out.println(wrapper.originalSql());
		return wrapper;
	}
   
}
