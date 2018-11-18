package com.hailian.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.enterise.web.htmlgen.xls.ExcelToHtml;
import com.github.pagehelper.PageInfo;
import com.hailian.annotation.AuthPower;
import com.hailian.base.BaseController;
import com.hailian.common.PublicResult;
import com.hailian.common.UUIDUtils;
import com.hailian.conf.Constant;
import com.hailian.entity.DocUploadFile;
import com.hailian.entity.EtaxExcelFile;
import com.hailian.enums.PublicResultConstant;
import com.hailian.service.IDocUploadFileService;
import com.hailian.service.IEtaxExcelFileService;
import com.hailian.utils.FileUtil;
import com.lianxin.tax.EtaxFileUtils;
import com.lianxin.tax.TaxFilesModel;
import com.lianxin.tax.TempletModel;
/**
 *
 * @date 2018-11-18
 * @author zuoqb123
 * @todo 保税处理之后的文件信息表表路由
 */
@Controller
@Api(value = "保税处理之后的文件信息表表",description="保税处理之后的文件信息表表 @author zuoqb123")
public class EtaxExcelFileController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(EtaxExcelFileController.class);

    @Autowired
    public IEtaxExcelFileService iEtaxExcelFileService;
    @Autowired
    public IDocUploadFileService iDocUploadFileService;
    
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "生成报税文件", notes = "生成报税文件", httpMethod = "POST")
	@RequestMapping(value = "/api/v1/dtax/uploadEtax", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
	public Object uploadEtax(@RequestParam(value = "file", required = true) MultipartFile file) {
    	try {
    		// 获取文件名
    		String allName = file.getOriginalFilename();
    		// 进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
			long size = file.getSize();
			if (StringUtils.isEmpty(allName) || size == 0) {
				return new PublicResult<>(PublicResultConstant.ERROR,"文件不能为空！", null);
			}
    		String fileName=FileUtil.getFileName(allName);
    		String fileType=FileUtil.getFileExt(allName); 
    		System.out.println("allName="+allName+",fileName="+fileName+",fileType="+fileType);
    		if(FileUtil.isCompress(allName)){
    			InputStream is = null;
				//根据新建的文件实例化输入流
				is = file.getInputStream();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				String dateStr=sdf.format(new Date());
				String uploadName=fileName+"("+dateStr+")."+fileType;
				String orgZipPath=FileUtil.saveEtaxZip(is,FileUtil.FILE_UPLOAD_ORG_PATH+ File.separator+Constant.DEFAULT_ETAX_TEMP_NAME, uploadName,dateStr);
				//解压文件到当前目录
				String unCompressFilePath=FileUtil.dealCompressFile(orgZipPath, orgZipPath);//compressFilePath解压后文件路径
				String htmlName="";//转化后html页面名称
				System.out.println("原压缩文件所在目录="+orgZipPath);
				System.out.println("解压文件到当前目录="+unCompressFilePath);
				
				//处理解压后文件 生成excel
				String targetPath=FileUtil.FILE_UPLOAD_TARGET_PATH+ File.separator
						+Constant.DEFAULT_ETAX_TEMP_NAME+File.separator+dateStr;//生成文件路径
				Map<String, Object> data=EtaxFileUtils.dealFiles(unCompressFilePath);
				if(data!=null&&data.get("success")!=null&&
						"true".equals(data.get("success").toString())){
					//将上一步处理结果再次处理，加工为最终模板数据结构
					@SuppressWarnings("unchecked")
					List<TaxFilesModel> orgTaxs=(List<TaxFilesModel>) data.get("taxFiles");
					if(orgTaxs!=null&&orgTaxs.size()>0){
						//将读取的文件实体加工为最终模板导出的数据结构
						TempletModel templetModel=EtaxFileUtils.getTempletModelByTaxs(orgTaxs);
						// 根据解析数据生成excel文件
						EtaxFileUtils.createExcel(templetModel,targetPath);//FileUtil.CREATE_ETAX_PATH
						System.out.println("targetPath="+targetPath);
						System.out.println("excel文件名称="+templetModel.getAllName());
						//将生成的excel转html
						htmlName=ExcelToHtml.excel2Html(targetPath+ File.separator,templetModel.getAllName(),templetModel.getAllName());
						DocUploadFile entity=new DocUploadFile();
						entity.setId(UUIDUtils.getUuid());
						entity.setCreateDate(new Date());
						entity.setCreateBy("联信报税");
						entity.setOriginalname(templetModel.getExcelName());
						entity.setUploadName(templetModel.getAllName());
						entity.setExt("xlsx");
						entity.setPath(targetPath);
						//entity.setSize(Integer.valueOf(size+""));
						entity.setHtmlName(htmlName);
						//保存html
						if(iDocUploadFileService.insert(entity)){
							//保存结果信息
							EtaxExcelFile etax=new EtaxExcelFile();
							etax.setId(UUIDUtils.getUuid());
							etax.setCreateDate(new Date());
							etax.setCreateBy("联信报税");
							etax.setVersion(dateStr);
							etax.setOrgCompressType(fileType);
							etax.setOrgCompressName(fileName);
							etax.setOrgCompressPath(orgZipPath);
							etax.setUncompressPath(unCompressFilePath);
							etax.setTargetPath(targetPath);
							etax.setTargetFileName(templetModel.getAllName());
							etax.setFileId(entity.getId());
							if(iEtaxExcelFileService.insert(etax)){
								return new PublicResult<>(PublicResultConstant.SUCCESS, etax);
							}else{
								return new PublicResult<>(PublicResultConstant.ERROR, "保存ETAX入库错误!");
							}
						}else{
							return new PublicResult<>(PublicResultConstant.ERROR, "转HTML文件保存失败！");
						}
					}
				}else{
					return new PublicResult<>(PublicResultConstant.ERROR,null, data.get("msg"));
				}
				if(is!=null){
					is.close();
				}
    		}else{
				return new PublicResult<>(PublicResultConstant.ERROR,"请选择压缩文件文件", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return new PublicResult<>(PublicResultConstant.ERROR, null);
	}
    /**
     * @date   2018-11-18
     * @author zuoqb123
     * @todo   新增保税处理之后的文件信息表表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "新增保税处理之后的文件信息表表", notes = "新增保税处理之后的文件信息表表", httpMethod = "POST")
	@RequestMapping(value = "/api/v1/etaxExcelFile/add", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
	public PublicResult<EtaxExcelFile> add(HttpServletRequest request,@RequestBody EtaxExcelFile entity) {
		try {
			if(StringUtils.isBlank(entity.getId())){
				//新增
				entity.setCreateBy(getLoginUser(request).getId());
				if(iEtaxExcelFileService.saveOrUpdate(entity)){
					return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
				}else{
					return new PublicResult<>(PublicResultConstant.ERROR, null);
				}
			}else{
				return new PublicResult<>(PublicResultConstant.PARAM_ERROR, "新增主键必须为空!",null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
    
    /**
     * @date   2018-11-18
     * @author zuoqb123
     * @todo   删除保税处理之后的文件信息表表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "删除保税处理之后的文件信息表表", notes = "删除保税处理之后的文件信息表表", httpMethod = "DELETE")
    @RequestMapping(value = "/api/v1/etaxExcelFile/delete/{id}", method = RequestMethod.DELETE,produces = { "application/json;charset=UTF-8" })
	public PublicResult<EtaxExcelFile> delete(HttpServletRequest request,@PathVariable("id") String id) {
		try {
			 if(iEtaxExcelFileService.deleteLogic(id)){
				 return new PublicResult<>(PublicResultConstant.SUCCESS, null);
			 }else{
				 return new PublicResult<>(PublicResultConstant.ERROR, null);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
	
	 /**
     * @date   2018-11-18
     * @author zuoqb123
     * @todo   更新保税处理之后的文件信息表表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "更新保税处理之后的文件信息表表", notes = "更新保税处理之后的文件信息表表", httpMethod = "PUT")
	@RequestMapping(value = "/api/v1/etaxExcelFile/update", method = RequestMethod.PUT,produces = { "application/json;charset=UTF-8" })
	public PublicResult<EtaxExcelFile> update(HttpServletRequest request,EtaxExcelFile entity) {
		try {
			if(entity!=null&&StringUtils.isNotBlank(entity.getId())){
				//更新
				entity.setUpdateBy(getLoginUser(request).getId());
				if(iEtaxExcelFileService.saveOrUpdate(entity)){
					return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
				}else{
					return new PublicResult<>(PublicResultConstant.ERROR, null);
				}
			}else{
				return new PublicResult<>(PublicResultConstant.PARAM_ERROR, "修改主键不能为空!",null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
    
    
    /**
     * @date   2018-11-18
     * @author zuoqb123
     * @todo   查询单个保税处理之后的文件信息表表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个保税处理之后的文件信息表表", notes = "查询单个保税处理之后的文件信息表表", httpMethod = "GET")
  	@RequestMapping(value = "/api/v1/etaxExcelFile/get/{id}", method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" } )
  	public PublicResult<EtaxExcelFile> get(HttpServletRequest request,@PathVariable("id") String id) {
  		try {
  			return new PublicResult<>(PublicResultConstant.SUCCESS, iEtaxExcelFileService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
		
  	}
	
    /**
     * @date   2018-11-18
     * @author zuoqb123
     * @todo   分页查询保税处理之后的文件信息表表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "分页查询保税处理之后的文件信息表表", notes = "分页查询保税处理之后的文件信息表表", httpMethod = "GET")
  	@RequestMapping(value = "/api/v1/etaxExcelFile/list", method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
    public PublicResult<PageInfo<EtaxExcelFile>> list(EtaxExcelFile entity,@RequestParam(value="pageNum",required = false,defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue="10") Integer pageSize,HttpServletRequest request) {
		try {
			PageInfo<EtaxExcelFile> page=iEtaxExcelFileService.pageList(this, request, entity, pageNum, pageSize);
			return new PublicResult<>(PublicResultConstant.SUCCESS, page);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(),null);
		}

	}
    @AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
    @RequestMapping(value = "/api/v1/etaxExcelFile/addView" , method = RequestMethod.GET)
	public String addView() {
		return "etax/add";
	}
  
}

