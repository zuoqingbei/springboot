package com.hailian.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.hailian.annotation.AuthPower;
import com.hailian.base.BaseController;
import com.hailian.common.PublicResult;
import com.hailian.entity.DbDatasourceConfig;
import com.hailian.entity.MenuAutority;
import com.hailian.enums.PublicResultConstant;
import com.hailian.utils.JdbcUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 菜单权限 2019/01/02
 * @author lzg
 */
@Controller
@Api(value = "菜单权限",description="菜单权限 @author lzg")
public class MenuAuthorityController extends BaseController{
	  
	 
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "菜单权限", notes = "菜单权限", httpMethod = "GET")
	@RequestMapping(value = "/bigSreen/sys/v1/menuAuthority", method = RequestMethod.GET)
	public PublicResult<List<MenuAutority>>   getMenuAuthority(HttpServletRequest request,HttpServletResponse response) {
    	
    	List<MenuAutority> list = new ArrayList<MenuAutority>();
    	String userCode = (String) getSession(request, response, PORTAL_USER_690);//"A0026973";
    	if(StringUtils.isEmpty(userCode)) {
    		return new PublicResult<>(PublicResultConstant.NO_DATA, null);
    	}
    	//生成数据源
    	DbDatasourceConfig dbConfig = new DbDatasourceConfig();
    	dbConfig.setDbUrl(AUTHORITY_FROM_DB_lOCATION);
    	dbConfig.setDbName(AUTHORITY_FROM_DB_NAME);
    	dbConfig.setDbPassword(AUTHORITY_FROM_DB_PASSWORD);
    	dbConfig.setDbDiver(JdbcConstants.MYSQL_DRIVER);
    	dbConfig.setDbType(JdbcConstants.MYSQL);
    	Connection conn = JdbcUtil.getConn(dbConfig);
    	if(conn==null) {return new PublicResult<>(PublicResultConstant.FAILED,"权限来源数据源连接失败", null);}
    	
    	String querySql = "select "
    			+ " `application_id`, `application_name`, `user_code`, `dim_type_name`, `dim_value`, `dim_value_code` "
    			+ " from `v_exts_dp_cdwl` "
    			+ " where user_code = ?";
    	PreparedStatement preparedStatement = null;
    	
		try {
			
			System.out.println(querySql);
			//获取结果集存入resultList
			preparedStatement = conn.prepareStatement(querySql);
			
			preparedStatement.setString(1, userCode);
			
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	
	    	List<Map<Object,Object>> resultList = convertList(resultSet);
	    	
	    	JdbcUtil.close(conn, preparedStatement, resultSet);
	    	
	    	//生成oracle数据源
	    	DbDatasourceConfig oracleDbConfig = new DbDatasourceConfig();
	    	oracleDbConfig.setDbUrl(AUTHORITY_TARGET_DB_lOCATION);
	    	oracleDbConfig.setDbName(AUTHORITY_TARGET_DB_NAME);
	    	oracleDbConfig.setDbPassword(AUTHORITY_TARGET_DB_PASSWORD);
	    	oracleDbConfig.setDbDiver(JdbcConstants.ORACLE_DRIVER);
	    	oracleDbConfig.setDbType(JdbcConstants.ORACLE);
	    	Connection oracleConn = JdbcUtil.getConn(oracleDbConfig);
	    	if(oracleConn==null) {return new PublicResult<>(PublicResultConstant.FAILED,"权限目标数据源连接失败", null);}
	    	
	    	String deleteSql = "delete from CDWL_XW_JURISDICTION where user_code=?";
	    	
	    	//删除userCode对应的信息
	    	PreparedStatement oraclePreparedStatement = oracleConn.prepareStatement(deleteSql);
	    	
	    	oraclePreparedStatement.setString(1, userCode);
	    	
	    	
	    	oraclePreparedStatement.executeUpdate();
	    	

	    	 MenuAutority  menuAutority = null;
	    	 
	    	//增加对应的信息
	    	String preAddSql = "INSERT INTO \"CDWL\".\"CDWL_XW_JURISDICTION\"(\"USER_CODE\", \"DIM_TYPE_NAME\", \"DIM_VALUE\", \"DIM_VALUE_CODE\", \"CREATE_DATE\") VALUES (?,?,?,?,?)";
	    	
	    	oraclePreparedStatement = oracleConn.prepareStatement(preAddSql);
	    	
	    	java.sql.Date date = new  java.sql.Date(System.currentTimeMillis());
	    	
	    	
	    	for (Map<Object, Object> map : resultList) {
	    		
	    		String tempUserCode = (String)map.get("user_code");
	    		String tempType = (String)map.get("dim_type_name");
	    		String tempValueCode = (String)map.get("dim_value_code");
	    		String tempValue = (String)map.get("dim_value");
				//筛选需要返回的数据
		         menuAutority = new MenuAutority();
		    	 if(userCode.equals(tempUserCode)&&"模块".equals(tempType)) {
		    		 menuAutority.setUser_code(userCode);
		    		 menuAutority.setDim_value_code(tempValueCode);
		    		 menuAutority.setDim_value(tempValue);
		    		 list.add(menuAutority);
		    	 }
		    	 
		    	//拼接sql
		    	oraclePreparedStatement.setObject(1,map.get("user_code"));
		    	oraclePreparedStatement.setObject(2,map.get("dim_type_name"));
		    	oraclePreparedStatement.setObject(3,map.get("dim_value"));
		    	oraclePreparedStatement.setObject(4,map.get("dim_value_code"));
		    	oraclePreparedStatement.setDate(5,date);
		    	oraclePreparedStatement.addBatch();
				
			}
	    	
	    	//批量执行
	    	oraclePreparedStatement.executeBatch();
	    	
	    	JdbcUtil.close(conn, oraclePreparedStatement, null);
	    	
	    	return new PublicResult<>(PublicResultConstant.SUCCESS, list);
	    	
		} catch (SQLException e) {
			e.printStackTrace();
			return new PublicResult<>(PublicResultConstant.FAILED, null);
		}
		
  }
   
    
    private static List<Map<Object,Object>> convertList(ResultSet rs) throws SQLException{
    	List<Map<Object,Object>> list = new ArrayList<>();
    	ResultSetMetaData md = rs.getMetaData();//获取结果集元数据对象
    	int columnCount = md.getColumnCount();//获取行的数量
    	while (rs.next()) {
    	Map<Object,Object> rowData = new HashMap<>();//声明Map
    	for (int i = 1; i <= columnCount; i++) {
    	rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
    	}
    	list.add(rowData);
    	}
    	return list;
    	}
    
    
}
 