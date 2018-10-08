package com.hailian.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hailian.annotation.AuthPower;
import com.hailian.annotation.Log;
import com.hailian.base.BaseController;
import com.hailian.common.PublicResult;
import com.hailian.entity.CommonInterfaceExc;
import com.hailian.entity.DbDatasourceConfig;
import com.hailian.entity.SysPlatInfo;
import com.hailian.enums.PublicResultConstant;
import com.hailian.interceptors.AppInterceptors;
import com.hailian.service.ICommonInterfaceExcService;
import com.hailian.service.IDbDatasourceConfigService;
import com.hailian.service.ISysPlatInfoService;
import com.hailian.utils.JdbcUtil;
import com.hailian.utils.RexUtils;
/**
 *
 * @author zuoqb123
 * @date 2018-09-26
 * @todo 统一接口API
 */
@Controller
@RequestMapping("/api/{version}/common/interface")
@Api(value = "统一接口API",description="统一接口API @author zuoqb")
public class CommonInterfaceController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(CommonInterfaceController.class);

    @Autowired
    public ICommonInterfaceExcService iCommonInterfaceExcService;
    @Autowired
    public IDbDatasourceConfigService iDbDatasourceConfigService;
    @Autowired
    public ISysPlatInfoService iSysPlatInfoService;

	/**
	 * 
	 * @time   2018年9月13日 上午10:39:24
	 * @author zuoqb
	 * @todo   根据数据源与SQL查询数据 或者查询当前库中SQL结果
	 * isVertical-数据格式，true-垂直 false-横向数据
	 */
    @ResponseBody
	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	@ApiOperation(value = "根据数据源与SQL查询数据", notes = "根据数据源与SQL查询数据", httpMethod = "GET")
	@RequestMapping(value = "/getBySql", method = RequestMethod.GET)
    @ApiImplicitParams({
    	@ApiImplicitParam(name="sql",value="执行的SQL语句",dataType="String",paramType="query",required = true),
    	@ApiImplicitParam(name="dataSourceId",value="SQL要查询的数据库编码，默认为当前库",dataType="String",paramType="query",required = false),
    	@ApiImplicitParam(name="params",value="动态参数 格式 time::20180731;;cbkCode::BD1011001",dataType="String",paramType="query",required = false),
    	@ApiImplicitParam(name="isVertical",value="数据格式，true-垂直 false-横向数据",dataType="boolean",paramType="query",required = false,defaultValue="true")})
	public PublicResult<?> getBySql(@RequestParam(value="sql",required = true) String sql,@RequestParam(value="dataSourceId",required = false) String dataSourceId,
			@RequestParam(value="params",required = false) String params,@RequestParam(value="isVertical",required = false,defaultValue="true") boolean isVertical,
			HttpServletRequest request) {
		/**
    	 * 开始处理SQL
    	 */
    	//解析SQL中的${}与#{}
    	//匹配所有${}与匹配所有#{}正则表达式
    	String rexg="\\#\\{([^\\}]+)\\}|\\$\\{([^\\}]+)\\}";
    	//按照顺序查找出所有# $ 比如  [#{time}, #{cbkCode}, ${startIndex}, ${pageSize}]
    	List<String> matcher=RexUtils.getString(sql, rexg);
    	PublicResult<Map<String,String>> dealParamsResult=dealParams(params);
    	PublicResult<Map<String, List<Map<String, Object>>>> formatSqlResult= formatSql(sql, matcher, dealParamsResult);
    	if(!PublicResultConstant.SUCCESS.msg.equals(formatSqlResult.getMsg())){
    		return new PublicResult<>(PublicResultConstant.INVALID_PARAM_EMPTY,formatSqlResult.getErrorMsg(), null);
    	}
    	//将SQL中所有${}与所有#{}替换为？
    	sql=RexUtils.getReplace(sql, rexg,"?");
    	/**
    	 * 处理SQL结束
    	 */
    	if(!isVertical){
    		return execeSqlVertical(sql, dataSourceId, matcher, dealParamsResult,request,"getBySql",VERTICAL_DATA_FORMAT);
    	}
    	return execeSqlVertical(sql, dataSourceId, matcher, dealParamsResult,request,"getBySql",null);
	}

	/**
	 * @time   2018年9月27日 上午9:13:27
	 * @author zuoqb
	 * @todo   统一接口查询数据
	 * 平台-数据源-接口
	 * @param dataType-接口类型  params-动态参数 格式 time::20180731;;cbkCode::BD1011001,,startIndex::1;;pageSize::10
	 * SQL中不要带“;” 否则会报错
	 */
    @ResponseBody
   	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
   	@ApiOperation(value = "统一接口查询数据", notes = "统一接口查询数据", httpMethod = "GET")
   	@RequestMapping(value = "/getByDataType", method = RequestMethod.GET)
    @ApiImplicitParams({
    	@ApiImplicitParam(name="dataType",value="查询指标标识",dataType="String",paramType="query",required = true),
    	@ApiImplicitParam(name="params",value="动态参数 格式 time::20180731;;cbkCode::BD1011001",dataType="String",paramType="query",required = false)})
    @Log(description = "API接口:/searchIndexUseHistory/data/addOrUpdate")
    public PublicResult<?>  getByDataType(@RequestParam(value="dataType",required = true) String dataType,@RequestParam(value="params",required = false) String params,HttpServletRequest request) {
    	if(StringUtils.isBlank(dataType)){
			return new PublicResult<>(PublicResultConstant.INVALID_PARAM_EMPTY,"dataType参数不能为空!", null);
		}
    	//根据dataType查询接口配置信息
    	EntityWrapper<CommonInterfaceExc> inteWrapper = new EntityWrapper<CommonInterfaceExc>();
    	inteWrapper.where("del_flag={0}", UN_DEL_FLAG);
    	inteWrapper.eq("data_type", dataType);
		CommonInterfaceExc entity=iCommonInterfaceExcService.selectOne(inteWrapper);
    	if(entity==null){
    		return new PublicResult<>(PublicResultConstant.PARAM_ERROR,dataType+"无效，请配置接口信息！", null);
    	}
    	/**
    	 * 开始处理SQL
    	 */
    	String sql=entity.getDataSql();
    	//解析SQL中的${}与#{}
    	//匹配所有${}与匹配所有#{}正则表达式
    	String rexg="\\#\\{([^\\}]+)\\}|\\$\\{([^\\}]+)\\}";
    	//按照顺序查找出所有# $ 比如  [#{time}, #{cbkCode}, ${startIndex}, ${pageSize}]
    	List<String> matcher=RexUtils.getString(sql, rexg);
    	PublicResult<Map<String,String>> dealParamsResult=dealParams(params);
    	PublicResult<Map<String, List<Map<String, Object>>>> formatSqlResult= formatSql(sql, matcher, dealParamsResult);
    	if(!PublicResultConstant.SUCCESS.msg.equals(formatSqlResult.getMsg())){
    		return formatSqlResult;
    	}
    	//将SQL中所有${}与所有#{}替换为？
    	sql=RexUtils.getReplace(sql, rexg,"?");
    	/**
    	 * 处理SQL结束
    	 */
    	String dataSourceId=entity.getDbDatasourceId();
    	PublicResult<?> execeResult=execeSqlVertical(sql, dataSourceId, matcher, dealParamsResult,request,"getByDataType",entity.getTransformData());
    	if(!PublicResultConstant.SUCCESS.msg.equals(execeResult.getMsg())){
    		return new PublicResult<>(PublicResultConstant.PARAM_ERROR,execeResult.getErrorMsg(), null);
    	}
    	Map<String,Object> result=new HashMap<String,Object>();
    	result.put(entity.getDataSpace(), execeResult.getData());
    	return new PublicResult<>(PublicResultConstant.SUCCESS, result);
   	}
    
    /**
     * 
     * @time   2018年9月27日 下午2:38:39
     * @author zuoqb
     * @todo   执行SQL返回执行垂直格式数据结果[{},{},{}]  
     */
    public PublicResult<?> execeSqlVertical(String sql, String dataSourceId, List<String> matcher,
			PublicResult<Map<String, String>> dealParamsResult,HttpServletRequest request,String methodName,String entity) {
	    	AuthPower authPower =null;
		try {
			Method[] methods=CommonInterfaceController.class.getMethods();
			for(Method method:methods){
				if(method.getName().equals(methodName)){
					authPower = method.getAnnotation(AuthPower.class);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new PublicResult<>(PublicResultConstant.ERROR,e.getMessage(), null);
		}
		if(StringUtils.isNotBlank(dataSourceId)){
    		EntityWrapper<DbDatasourceConfig> dataSourceWrapper = new EntityWrapper<DbDatasourceConfig>();
    		dataSourceWrapper.where("del_flag={0}", UN_DEL_FLAG);
    		dataSourceWrapper.eq("id", dataSourceId);
    		DbDatasourceConfig config =iDbDatasourceConfigService.selectOne(dataSourceWrapper);
    		if(config==null){
    			return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"数据源无效，请配置数据源！", null);
    		}
    		//查询平台信息 校验平台合法性
        	EntityWrapper<SysPlatInfo> platWrapper = new EntityWrapper<SysPlatInfo>();
        	platWrapper.where("del_flag={0}", UN_DEL_FLAG);
        	platWrapper.eq("id", config.getSysPlatId());
        	SysPlatInfo sysPlatInfo=iSysPlatInfoService.selectOne(platWrapper);
        	if(sysPlatInfo==null){
    			return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"平台无效，请联系管理员！", null);
    		}
        	/**
        	 * 验证平台秘钥 需要以后扩展
        	 */
        	if(authPower!=null&&!authPower.avoidSign()){
				//不免签名认证
        		String signAuth = request.getHeader(AppInterceptors.DEFAULT_AUTH_NAME);//签名
        		if(StringUtils.isNotBlank(signAuth)){
        			if(!signAuth.equals(sysPlatInfo.getSecretKey())){
        				return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"平台签名"+signAuth+"无效，请联系管理员！", null);
        			}
        		}
			}
    		Connection conn = JdbcUtil.getConn(config);
    		if(conn==null){
    			return new PublicResult<>(PublicResultConstant.FAILED,"数据库连接失败！",null);
    		}
    		PreparedStatement pstmt = null;
    		ResultSet rs = null;
    		try {
    			//将where后面的‘与’替换
    			Pattern p=Pattern.compile("where",Pattern.CASE_INSENSITIVE);
    			Matcher m=p.matcher(sql);
    			while(m.find()){
    	            String whereStr=m.group();
    	            String[] splits=sql.split(whereStr);
    	            sql=splits[0]+whereStr+splits[1].replaceAll("‘", "'").replaceAll("’", "'");
    	        }
    			pstmt = conn.prepareStatement(sql);
    			//设置参数 外层循环
    			for(int index=0;index<matcher.size();index++){
    				String matcherKey=matcher.get(index);
    				String variableValue = getParamValueByKey(dealParamsResult, matcherKey);
    				if(matcherKey.trim().startsWith("#")){
    					//#替换sql语句中的参数，只能是字符串
    					pstmt.setString(index+1, variableValue);
    				}
    				if(matcherKey.trim().startsWith("$")){
    					//$替换sql语句中的内容，只能是数字
    					pstmt.setInt(index+1, Integer.valueOf(variableValue));
    				}
    			}
    			rs = pstmt.executeQuery();
    			List<Map<String, Object>> verticalData = JdbcUtil.parseResultSet2List(rs);
    			//转成横向数据格式
    	    	Map<String,List<Object>> horizontalData=new HashMap<String, List<Object>>();
    	    	if(VERTICAL_DATA_FORMAT.equals(entity)){
    	    		return verticalToHorizontal(verticalData, horizontalData);
    	    	}else{
    	    		return new PublicResult<>(PublicResultConstant.SUCCESS, verticalData);
    	    	}
    		} catch (Exception e) {
    			e.printStackTrace();
    			logger.error(e.getMessage());
    			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(),null);
    		}finally {
    			try {
    				JdbcUtil.close(conn, pstmt, rs);
    			} catch (Exception e) {
    				e.printStackTrace();
    				logger.error(e.getMessage());
    				return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(),null);
    			}
    		}
    	}else{
    		try {
    			//数据源为空 默认当前数据库
    			/**
            	 * 验证平台秘钥 需要以后扩展
            	 */
    			if(authPower!=null&&!authPower.avoidSign()){
    				//不免签名认证
    				String signAuth = request.getHeader(AppInterceptors.DEFAULT_AUTH_NAME);//签名
    				if(StringUtils.isNotBlank(signAuth)){
    					if(!signAuth.equals(Default_X_SIGN)){
    						return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"平台签名"+signAuth+"无效，请联系管理员！", null);
    					}
    				}
    			}
        		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        		if(dealParamsResult.getData()!=null&&dealParamsResult.getData().size()>0){
        			Object[] values=new Object[matcher.size()];//这边必须为Object[]
        			//设置参数 外层循环
        			for(int index=0;index<matcher.size();index++){
        				String matcherKey=matcher.get(index);
        				if(matcherKey.trim().startsWith("#")){
        					//#替换sql语句中的参数，只能是字符串
        					values[index]=getParamValueByKey(dealParamsResult, matcherKey);
        				}
        				if(matcherKey.trim().startsWith("$")){
        					//$替换sql语句中的内容，只能是数字
        					values[index]=Integer.valueOf(getParamValueByKey(dealParamsResult, matcherKey));
        				}
        			}
        			list=jdbcTemplate.queryForList(sql,values);
        		}else{
        			list=jdbcTemplate.queryForList(sql);
        		}
        		//转成横向数据格式
    	    	Map<String,List<Object>> horizontalData=new HashMap<String, List<Object>>();
    	    	if(VERTICAL_DATA_FORMAT.equals(entity)){
    	    		return verticalToHorizontal(list, horizontalData);
    	    	}else{
    	    		return new PublicResult<>(PublicResultConstant.SUCCESS, list);
    	    	}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(),null);
			}
    	}
	}
    
    /**
     * 
     * @time   2018年9月27日 下午5:28:55
     * @author zuoqb
     * @todo   纵向数据转横向
     * @return_type   PublicResult<?>
     */
	public PublicResult<?> verticalToHorizontal(List<Map<String, Object>> verticalData,
			Map<String, List<Object>> horizontalData) {
		if(verticalData.size()>0){
			Iterator<String> iter = verticalData.get(0).keySet().iterator();
			while(iter.hasNext()){
				String key=iter.next();
				horizontalData.put(key, new ArrayList<Object>());
			}
		}
		for(Map<String, Object> map:verticalData){
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()){
				String key=iter.next();
				Object value = map.get(key);
				if(value==null){
					value="";
				}
				horizontalData.get(key).add(value);
			}
		}
		return new PublicResult<>(PublicResultConstant.SUCCESS, horizontalData);
	}
    
    /**
     * @time   2018年9月27日 下午1:10:34
     * @author zuoqb
     * @todo   校验SQL个数
     */
	public PublicResult<Map<String, List<Map<String, Object>>>> formatSql(String sql,
			List<String> matcher, PublicResult<Map<String, String>> dealParamsResult) {
		if(StringUtils.isBlank(sql)){
    		return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"SQL语句为空！", null);
    	}
    	if(!sql.trim().toUpperCase().startsWith("SELECT")){
			return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"SQL语句错误，只能执行查询语句！", null);
		}
		if(!PublicResultConstant.SUCCESS.msg.equals(dealParamsResult.getMsg())){
			return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"params格式必须为key1::value1;;key2::value2格式!", null);
		}
		//验证SQL需要参数必须都传递 扩展
    	if(!canMatchSqlParams(matcher, dealParamsResult)){
    		return new PublicResult<>(PublicResultConstant.PARAM_ERROR,"params传递的参数与SQL中需要的参数不匹配！", null);
    	}
    	
    	return new PublicResult<>(PublicResultConstant.SUCCESS,null);
	}
    /**
     * @time   2018年9月27日 下午1:02:26
     * @author zuoqb
     * @todo   根据key获取参数值
     * @return_type   String
     */
	public String getParamValueByKey(PublicResult<Map<String, String>> dealParamsResult, String matcherKey) {
		//获取变量名称
		String variableName=replaceSymbol(matcherKey);
		//获取变量值
		String variableValue=dealParamsResult.getData().get(variableName);
		return variableValue;
	}
    /**
     * @time   2018年9月27日 下午1:00:30
     * @author zuoqb
     * @todo   处理SQL中解析的变量 将特殊符号去除
     */
	public String replaceSymbol(String matcherKey) {
		return matcherKey.replaceAll("#", "").replaceAll("\\$", "").replaceAll("\\{", "").replaceAll("\\}", "");
	}
    /**
     * 
     * @time   2018年9月27日 下午12:10:45
     * @author zuoqb
     * @todo   校验传递的参数与SQL中需要的参数是否匹配
     */
	private boolean canMatchSqlParams(List<String> matcher, PublicResult<Map<String, String>> dealParamsResult) {
		if(matcher.size()>dealParamsResult.getData().size()){
			//传递的参数个数小于SQL中需要的参数数量
			return false;
		}
		//判断SQL中需要的参数必须都传递
		for(String sqlParam:matcher){
			String variableName=replaceSymbol(sqlParam);
			if(!dealParamsResult.getData().containsKey(variableName)){
				return false;
			}
		}
		return true;
	}
    
    
    /**
     * @time   2018年9月27日 上午11:34:00
     * @author zuoqb
     * @todo   处理请求参数params 封装为Map格式
     */
    private static PublicResult<Map<String,String>> dealParams(String params) {
    	Map<String,String> map=new HashMap<String, String>();
    	if(StringUtils.isBlank(params)){
    		return new PublicResult<>(PublicResultConstant.SUCCESS, map);
    	}
		String[] keyValues=params.split(";;");
		boolean isLegal=true;
		for(String para:keyValues){
			if(para.indexOf("::")!=-1){
				String[] split=para.split("::");
				if(split.length>1){
					map.put(split[0], split[1]);
				}else{
					if(para.endsWith("::")){
						map.put(split[0], "");
					}else{
						isLegal=false;
						break;
					}
				}
			}else{
				isLegal=false;
				break;
			}
		}
		if(isLegal){
			return new PublicResult<>(PublicResultConstant.SUCCESS, map);
		}else{
			return new PublicResult<>(PublicResultConstant.PARAM_ERROR, null);
		}
	}
}

