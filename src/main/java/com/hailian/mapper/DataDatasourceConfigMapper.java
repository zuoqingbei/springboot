package com.hailian.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.jon.lv.pagination.Page;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hailian.entity.DataDatasourceConfig;

import java.util.List;

/**
 * <p>
  * 数据源配置 Mapper 接口
 * </p>
 * @author zuoqb123
 * @date 2018-09-24
 */
@Mapper
public interface DataDatasourceConfigMapper extends BaseMapper<DataDatasourceConfig> {
	@ResultMap(value = "BaseResultMap")
    @Select("SELECT * FROM data_datasource_config WHERE  id = #{id}")
    List<DataDatasourceConfig> selectListBySQL(Integer id);
    /**
	 * 
	 * @date 2018-09-24
	 * @author zuoqb123
	 * @todo   分页查询数据源配置
	 */
	List<DataDatasourceConfig> queryPage(Page<DataDatasourceConfig> page);
}


