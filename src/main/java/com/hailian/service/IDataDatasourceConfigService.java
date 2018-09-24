package com.hailian.service;

import org.jon.lv.pagination.Page;
import com.hailian.entity.DataDatasourceConfig;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 数据源配置 服务类
 * </p>
 * @author zuoqb123
 * @date 2018-09-24
 */
public interface IDataDatasourceConfigService extends IService<DataDatasourceConfig> {
 	List<DataDatasourceConfig> selectListBySQL(Integer id);
	/**
     * @todo   分页查询
     * @author zuoqb123
     * @date   2018-09-24
     */
	List<DataDatasourceConfig> queryPage(Page<DataDatasourceConfig> page);
}
