package com.hailian.service;

import java.util.List;

import org.jon.lv.pagination.Page;

import com.baomidou.mybatisplus.service.IService;
import com.hailian.entity.DataDatasourceConfig;

/**
 * <p>
 * 数据源配置 服务类
 * </p>
 *
 * @author zuoqb123
 * @since 2018-09-21
 */
public interface IDataDatasourceConfigService extends IService<DataDatasourceConfig> {
	 List<DataDatasourceConfig> selectListBySQL(Integer id);
	 /**
	  * @time   2018年9月24日 下午4:52:38
	  * @author zuoqb
	  * @todo   分页查询
	  * @return_type   List<DataDatasourceConfig>
	  */
	 List<DataDatasourceConfig> queryPage(Page<DataDatasourceConfig> page);
}
