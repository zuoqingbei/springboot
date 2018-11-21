package com.lianxin.tax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.core.io.ClassPathResource;

import com.hailian.conf.Constant;
import com.hailian.utils.ExcleUtils;
import com.hailian.utils.FileUtil;
import com.hailian.utils.ReadMergeRegionExcel;

public class EtaxFileUtils {
	public static boolean isDev=false;
	public static void main(String[] args) {
		try {
			String path="C://Users//Administrator//Desktop//lianxin//upload";
			Map<String, Object> data=dealFiles(path+"//orgFiles"+ File.separator+Constant.DEFAULT_ETAX_TEMP_NAME+"//2081118");//FileUtil.ETAX_FILE_UPLOAD
			if(data!=null&&data.get("success")!=null&&
					"true".equals(data.get("success").toString())){
				//将上一步处理结果再次处理，加工为最终模板数据结构
				@SuppressWarnings("unchecked")
				List<TaxFilesModel> orgTaxs=(List<TaxFilesModel>) data.get("taxFiles");
				if(orgTaxs!=null&&orgTaxs.size()>0){
					TempletModel templetModel=getTempletModelByTaxs(orgTaxs);
					//生成excel
					createExcel(templetModel, path+"//targetFiles"+File.separator+"//"+Constant.DEFAULT_ETAX_TEMP_NAME);//FileUtil.CREATE_ETAX_PATH
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @time   2018年11月17日 下午3:32:52
	 * @author zuoqb
	 * @todo   将读取的文件实体加工为最终模板导出的数据结构
	 * @return_type   TempletModel
	 */
	public static TempletModel getTempletModelByTaxs(List<TaxFilesModel> orgTaxs) {
		System.out.println(orgTaxs.size());
		TempletModel templetModel=new TempletModel();
		if(orgTaxs==null||orgTaxs.size()==0){
			return templetModel;
		}
		List<String> years=new ArrayList<String>();
		//处理全部年月
		for(TaxFilesModel tax:orgTaxs){
			if(tax.getStartYear()!=null&&!years.contains(tax.getStartYear())){
				years.add(tax.getStartYear());
			}
		}
		//年排序
		years.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(Integer.valueOf(o1)>Integer.valueOf(o2)){
					return 0;
				}else{
					return -1;
				}
				
			}
		});
		System.out.println(years);
		templetModel.setYears(years);
		
		/**按照年设置月Map处理START**/
		//初始化
		Map<String,List<TaxFilesModel>> mapTax=new HashMap<String,List<TaxFilesModel>>();
		for(String year:years){
			mapTax.put(year, new ArrayList<TaxFilesModel>());
		}
		//按照年放入月份
		for(TaxFilesModel tax:orgTaxs){
			List<TaxFilesModel> monthDateList=mapTax.get(tax.getStartYear());
			if(monthDateList==null){
				monthDateList=new ArrayList<TaxFilesModel>();
			}
			monthDateList.add(tax);
			mapTax.put(tax.getStartYear(), monthDateList);
		}
		//排序
		for(String year:years){
			List<TaxFilesModel> monthDateList=mapTax.get(year);
			if(monthDateList==null){
				monthDateList=new ArrayList<TaxFilesModel>();
			}
			//按照月份从小到大排序
			monthDateList.sort(new Comparator<TaxFilesModel>() {
				@Override
				public int compare(TaxFilesModel o1, TaxFilesModel o2) {
					if(Integer.valueOf(o1.getStartMonth())>Integer.valueOf(o2.getStartMonth())){
						return 0;
					}else{
						return -1;
					}
					
				}
			});
			mapTax.put(year, monthDateList);
			for(TaxFilesModel m:monthDateList){
				System.out.println("year="+year+",month="+m.getStartMonth());
			}
		}
		templetModel.setMapTax(mapTax);
		/**按照年设置月Map处理END**/
		
		
		if(years!=null&&years.size()>0){
			
			/**处理当前年数据START**/
			String maxYear=years.get(years.size()-1);//取最大年份
			if(maxYear==null){
				maxYear="";
			}
			List<TaxFilesModel> yearMonthDateList=mapTax.get(maxYear);//获取最大年份对应文件数据
			if(yearMonthDateList==null){
				yearMonthDateList=new ArrayList<TaxFilesModel>();
			}
			List<TaxFilesModel> currentSixMonthTaxs=getPreSixMonthData(maxYear, yearMonthDateList,null);
			if(currentSixMonthTaxs==null){
				currentSixMonthTaxs=new ArrayList<TaxFilesModel>();
			}
			for(TaxFilesModel t:currentSixMonthTaxs){
				System.out.println("最大年份："+t.getStartYear()+"-----"+t.getStartMonth());
			}
			templetModel.setCurrentSixMonthTaxs(currentSixMonthTaxs);
			//设置标题4
			String title4=maxYear;
			if(currentSixMonthTaxs!=null&&currentSixMonthTaxs.size()>0){
				//title4+="."+currentSixMonthTaxs.get(0).getStartMonth()+"-";
				title4+=".1-"+currentSixMonthTaxs.get(currentSixMonthTaxs.size()-1).getStartMonth();
			}
			templetModel.setTitle4(title4);
			/**处理当前年数据END**/
			
			
			
			/**上一年月份数据与最后一个月数据 START**/
			//上一年
			String lastYear=(Integer.valueOf(maxYear)-1)+"";
			//设置标题2
			templetModel.setTitle2(lastYear+".1-12");
			List<TaxFilesModel> lastMonthDateList=mapTax.get(lastYear);
			if(lastMonthDateList==null){
				lastMonthDateList=new ArrayList<TaxFilesModel>();
			}
			List<TaxFilesModel> lastYearSixMonthTaxs=getPreSixMonthData(lastYear, lastMonthDateList,
					yearMonthDateList.get(yearMonthDateList.size()-1).getStartMonth());
			if(lastYearSixMonthTaxs==null){
				lastYearSixMonthTaxs=new ArrayList<TaxFilesModel>();
			}
			for(TaxFilesModel t:lastYearSixMonthTaxs){
				System.out.println("上一年年份："+t.getStartYear()+"-----"+t.getStartMonth());
			}
			//设置标题3
			String title3=lastYear;
			if(lastYearSixMonthTaxs!=null&&lastYearSixMonthTaxs.size()>0){
				//title3+="."+lastYearSixMonthTaxs.get(0).getStartMonth()+"-";
				title3+=".1-"+lastYearSixMonthTaxs.get(lastYearSixMonthTaxs.size()-1).getStartMonth();
			}
			templetModel.setTitle3(title3);
			templetModel.setLastYearSixMonthTaxs(lastYearSixMonthTaxs);
			
			//上一年最后一个月（必须是十二月）数据
			for(TaxFilesModel t:lastMonthDateList){
				if("12".equals(t.getStartMonth())){
					System.out.println("存在倒推一年最后一个月数据，文件名称:"+t.getName());
					templetModel.setLastOneYearDecember(t);
					break;
				}
			};
			/**上一年月份数据与最后一个月数据 END**/
			
			
			
			/**上两年最后一个月数据 START**/
			String lastTwoYear=(Integer.valueOf(maxYear)-2)+"";
			//设置标题1
			templetModel.setTitle1(lastTwoYear+".1-12");
			List<TaxFilesModel> lastTwoMonthDateList=mapTax.get(lastTwoYear);
			if(lastTwoMonthDateList==null){
				lastTwoMonthDateList=new ArrayList<TaxFilesModel>();
			}
			//上两年最后一个月（必须是十二月）数据
			for(TaxFilesModel t:lastTwoMonthDateList){
				if("12".equals(t.getStartMonth())){
					System.out.println("存在倒推两年最后一个月数据，文件名称:"+t.getName());
					templetModel.setLastTwoYearDecember(t);
					break;
				}
			};
			/**上两年最后一个月数据 END**/
		}
		
		
		//获取纳税人名称+title4-作为Excel名称
		if(templetModel.getCurrentSixMonthTaxs()!=null&&templetModel.getCurrentSixMonthTaxs().size()>0){
			String excelName=templetModel.getCurrentSixMonthTaxs().get(templetModel.getCurrentSixMonthTaxs().size()-1).getCompanyName()+"("+templetModel.getTitle4()+")";
			templetModel.setExcelName(excelName);
		}else{
			templetModel.setExcelName(orgTaxs.get(0).getCompanyName());
		}
		return templetModel;
	}
	/**
	 * @time   2018年11月17日 下午5:04:08
	 * @author zuoqb
	 * @todo   TODO
	 * @return_type   void
	 */
	public static List<TaxFilesModel> getPreSixMonthData(String maxYear, List<TaxFilesModel> yearMonthDateList,String endMonth) {
		List<TaxFilesModel> currentSixMonthTaxs=new ArrayList<TaxFilesModel>();
		if(yearMonthDateList!=null&&yearMonthDateList.size()>0){
			//获取最后一个月
			TaxFilesModel taxFilesModel=yearMonthDateList.get(yearMonthDateList.size()-1);
			if(taxFilesModel!=null&&StringUtils.isNotBlank(taxFilesModel.getStartMonth())){
				int maxMonth=Integer.valueOf(taxFilesModel.getStartMonth());
				if(endMonth!=null){
					maxMonth=Integer.valueOf(endMonth);//当获取上一年的连续六个月数据时候  要参照当前年最后一个月比较
				}
				int minMonth=maxMonth-5;
				if(minMonth<=0){
					minMonth=1;
				}
				//不足半年补全  超过半年 截取最后六个月  间隔月处理为连续月份
				for(int x=minMonth;x<maxMonth+1;x++){
					TaxFilesModel month=new TaxFilesModel();
					month.setStartYear(maxYear);
					month.setStartMonth(String.valueOf(x));
					for(TaxFilesModel m:yearMonthDateList){
						if(x==Integer.valueOf(m.getStartMonth())&&maxYear.equals(m.getStartYear())){
							month=m;
							break;
						}
					}
					currentSixMonthTaxs.add(month);
				}
			}
		}
		return currentSixMonthTaxs;
	}
	/**
	 * 
	 * @time   2018年11月17日 上午11:33:08
	 * @author zuoqb
	 * @todo   根据解析数据生成excel文件
	 * targetPath:要生成的文件目录
	 * @return_type   void
	 */
	public static void createExcel(TempletModel templetModel,String targetPath){
		InputStream is =null;
		OutputStream out=null;
		Workbook workbook=null;
		String fileName="etax.xlsx";
		if(templetModel!=null){
			fileName=templetModel.getExcelName()+".xlsx";
		}
		templetModel.setAllName(fileName);
		String filePath=null;
        try {
        	if(!isDev){
        		ClassPathResource resource = new ClassPathResource("/etax/Etax_VAT.xlsx");
        		//读取模板 并转成workbook
        		is = resource.getInputStream();//获取原模板文件输入流
        		filePath=FileUtil.saveEtaxNoDate(is,targetPath, fileName);
        	    workbook = WorkbookFactory.create(resource.getInputStream());   
        	}else{
        		String templetePath="C://Users//Administrator//Desktop//lianxin//Etax_VAT data.xlsx";
        		is=new FileInputStream(new File(templetePath));
        		filePath=FileUtil.saveEtaxNoDate(is,targetPath, fileName);
        	    workbook = WorkbookFactory.create(new FileInputStream(new File(templetePath))); 
        	}
        	//设置sheet名称
        	workbook.setSheetName(0,templetModel.getExcelName());
        	/**写入第一块数据 -年化销售额比较START **/
        	//写入标题
        	setExcelCellValue(workbook, 0, 6, 1, templetModel.getTitle1());
        	setExcelCellValue(workbook, 0, 7, 1, templetModel.getTitle2());
        	setExcelCellValue(workbook, 0, 8, 1, templetModel.getTitle3());
        	setExcelCellValue(workbook, 0, 9, 1, templetModel.getTitle4());
        	
        	//写入第一行数据-倒推两年
        	if(templetModel.getLastTwoYearDecember()!=null){
        		writePart1YearData(workbook,6,templetModel.getLastTwoYearDecember());
        	}
        	
        	//写入第二行数据-倒推一年
        	if(templetModel.getLastOneYearDecember()!=null){
        		writePart1YearData(workbook,7,templetModel.getLastOneYearDecember());
        	}
        	
        	//写入第三行数据
        	if(templetModel.getLastYearSixMonthTaxs()!=null&&templetModel.getLastYearSixMonthTaxs().size()>0){
        		writePart1YearData(workbook,8,templetModel.getLastYearSixMonthTaxs().get(templetModel.getLastYearSixMonthTaxs().size()-1));
        	}
        	
        	//写入第四行数据
        	if(templetModel.getCurrentSixMonthTaxs()!=null&&templetModel.getCurrentSixMonthTaxs().size()>0){
        		writePart1YearData(workbook,9,templetModel.getCurrentSixMonthTaxs().get(templetModel.getCurrentSixMonthTaxs().size()-1));
        	}
        	
        	/**写入第一块数据 -年化销售额比较END **/
        	
        	
        	/**写入第二块数据 -纳税申报表销售额START **/
        	
        	for(int x=0;x<templetModel.getCurrentSixMonthTaxs().size();x++){
        		writePart2MonthData(workbook, x+15, templetModel.getCurrentSixMonthTaxs().get(x));
        	}
        	
        	/**写入第二块数据 -纳税申报表销售额END **/
        	
        	
        	
        	/**写入第三块数据 -开票汇总表销售额START **/
        	//暂无
        	/**写入第三块数据 -开票汇总表销售额END **/
        	
        	//重新生成文件
        	out = new FileOutputStream(filePath+File.separator+fileName);
        	workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	//关闭输入流等（略）
            	if(is!=null){
            		is.close();
            	}
            	if(out!=null){
            		out.close();
            	}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	public static String dealNums(String pre){
		if(StringUtils.isNotBlank(pre)){
			BigDecimal a=new BigDecimal(pre); 
			DecimalFormat df=new DecimalFormat(",###,##0.00"); //保留2位小数  
			return df.format(a);
		}
		return pre;
	}
	/**
	 * 
	 * @time   2018年11月17日 下午6:10:12
	 * @author zuoqb
	 * @todo  写入年化销售额比较数据
	 * @return_type   void
	 */
	public static void writePart1YearData(Workbook workbook,int row, TaxFilesModel tax) {
		setExcelCellValue(workbook, 0, row, 2,dealNums(tax.getXiaoshoueYear()));//销售额年累
		setExcelCellValue(workbook, 0, row, 3,dealNums(tax.getShuieYear()));//税额年累
		setExcelCellValue(workbook, 0, row, 4,dealNums(tax.getDisanxiangYear()));//第三项年累
		setExcelCellValue(workbook, 0, row, 5,dealNums(tax.getDisixiangYear()));//第四项年累
		setExcelCellValue(workbook, 0, row, 6,dealNums(tax.getJyzsYear()));//简易征收年累
		setExcelCellValue(workbook, 0, row, 7,dealNums(tax.getJysYear()));//简易税年累
		setExcelCellValue(workbook, 0, row, 13,dealNums(tax.getJinxiangshuiYear()));//进项税年累
		setExcelCellValue(workbook, 0, row, 8,dealNums(tax.getJzjtxseYear()));//即征即退销售额年累
		setExcelCellValue(workbook, 0, row, 9,dealNums(tax.getJzjtseYear()));//即征即退税额年累
	}
	
	/**
	 * 
	 * @time   2018年11月17日 下午6:10:12
	 * @author zuoqb
	 * @todo  第二部分-到月数据-写入纳税申报表销售额数据
	 * @return_type   void
	 */
	public static void writePart2MonthData(Workbook workbook,int row, TaxFilesModel tax) {
		setExcelCellValue(workbook, 0, row, 1,"ETAX"+tax.getStartMonth());
		setExcelCellValue(workbook, 0, row, 2,dealNums(tax.getXiaoshoueMonth()));//销售额
		setExcelCellValue(workbook, 0, row, 3,dealNums(tax.getShuieMonth()));//税额
		setExcelCellValue(workbook, 0, row, 4,dealNums(tax.getDisanxiangMonth()));//第三项
		setExcelCellValue(workbook, 0, row, 5,dealNums(tax.getDisixiangMonth()));//第四项
		setExcelCellValue(workbook, 0, row, 6,dealNums(tax.getJyzsMonth()));//简易征收
		setExcelCellValue(workbook, 0, row, 7,dealNums(tax.getJysMonth()));//简易税
		setExcelCellValue(workbook, 0, row, 8,dealNums(tax.getJzjtxseMonth()));//即征即退销售额
		setExcelCellValue(workbook, 0, row, 9,dealNums(tax.getJzjtseMonth()));//即征即退税额
	}
	
	/**
	 * @time   2018年11月17日 下午2:54:09
	 * @author zuoqb
	 * @todo   设置excel中相应单元格数据
	 * @return_type   void
	 */
	public static void setExcelCellValue(Workbook workbook, int sheetIndex, int rowNum, int columnNum, String cellValue) {
		Sheet sheet = workbook.getSheetAt(sheetIndex); // 工作表
		Row r=sheet.getRow(rowNum);
		if(r==null){
			r=sheet.createRow(rowNum);
		}
		Cell cell=r.getCell(columnNum);
		if(cell==null){
			cell=r.createCell(columnNum);
		}
		cell.setCellValue(cellValue);
	}
	/**
	 * 
	 * @time   2018年11月17日 上午11:07:01
	 * @author zuoqb
	 * @throws Exception 
	 * @todo   处理指定目录下面文件，将文件解析为bean
	 * @return_type   Map<String,Object>
	 */
	public static Map<String, Object> dealFiles(String sourceFilePath) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TaxFilesModel> taxFiles = new ArrayList<TaxFilesModel>();
		File sourceFile = new File(sourceFilePath);
		if (sourceFile.exists() == false) {
			result.put("success", false);
			result.put("msg", "文件目录不存在");
		} else {
			List<File> sourceFiles = FileUtil.getAllFileByPath(new ArrayList<File>(),sourceFilePath);
			if (null == sourceFiles || sourceFiles.size() < 1) {
				result.put("success", false);
				result.put("msg", "文件目录下文件为空!");
			} else {
				 for(File file:sourceFiles){
					 if(file.isFile()&&ExcleUtils.validateExcel(file.getName())||FileUtil.isPdf(file.getName())){
						 //只处理excel  pdf
						 TaxFilesModel tax=fielToTaxFiles(file);
						 if(tax.isApply()){
							 //只处理主表
							 taxFiles.add(tax);
						 }
					 }
            	 }
				result.put("success", true);
			}
		}
		result.put("taxFiles", taxFiles);
		return result;
	}
	public static TaxFilesModel fielToTaxFiles(File file) throws Exception{
		TaxFilesModel taxFiles=new TaxFilesModel();
		//设置文件相关公用属性
		setCommonPropertities(file, taxFiles);
		if(ExcleUtils.validateExcel(file.getPath())){
			//处理excel
			excelFileToTaxFiles(file,taxFiles);
		}else{
			//处理pdf
			PDFToEtax.pdfFileToTaxFiles(file, taxFiles);
		}
		return taxFiles;
	}
	/**
	 * 
	 * @time   2018年11月16日 下午5:50:10
	 * @author zuoqb
	 * @throws Exception 
	 * @todo   处理excel文件读取需要内容
	 * @return_type   TaxFiles
	 */
	public static TaxFilesModel excelFileToTaxFiles(File file,TaxFilesModel taxFiles) throws Exception{
		if(file!=null&&!file.exists()){
			return taxFiles;
		}
		InputStream is = null;
		// 根据新建的文件实例化输入流
		is = new FileInputStream(file);
		// 根据版本选择创建Workbook的方式
		Workbook wb = WorkbookFactory.create(is);
		/*// 根据文件名判断文件是2003版本还是2007版本
		if (taxFiles.isExcel2007()) {
			wb = new XSSFWorkbook(is);
		} else {
			try {
				wb = new HSSFWorkbook(is);
			} catch (Exception e) {
			}finally{
				//他们文件生成的有问题，明明是xls但是结构却是xlsx  万马奔腾.....
				is = new FileInputStream(file);
				wb = new XSSFWorkbook(is);
			}
		}*/
		getExcelProperties2Bean(taxFiles, wb);
		is.close();
		return taxFiles;
	}
	
	/**
	 * 
	 * @time   2018年11月16日 下午6:14:02
	 * @author zuoqb
	 * @todo   读取excel指定位置数值
	 * @return_type   String
	 */
	public static String readExcelValueByPosition(int rows,int columns,Workbook wb,int sheetIndex){
		String cellValue="";
		// 得到第一个shell
		Sheet sheet = wb.getSheetAt(sheetIndex);
		// 得到Excel的行数
		int totalRows = sheet.getPhysicalNumberOfRows();
		if(totalRows>=rows){
			Row row = sheet.getRow(rows);
			if(row!=null){
				boolean isMerge = ReadMergeRegionExcel.isMergedRegion(sheet, rows, columns);  
				Cell cell = row.getCell(columns);
				if(isMerge) {  
					cellValue= ReadMergeRegionExcel.getMergedRegionValue(sheet, rows, columns); 
				}else {
					
					cellValue=ReadMergeRegionExcel.getCellValue(cell);
				}
			}
		}
		cellValue=StringUtils.deleteWhitespace(cellValue.trim());
		if(StringUtils.isBlank(cellValue)){
			cellValue="0";
		}
		return cellValue;
	}
	/**
	 * 
	 * @time   2018年11月16日 下午5:51:27
	 * @author zuoqb
	 * @todo   设置文件相关公用属性
	 * @return_type   TaxFiles
	 */
	public static TaxFilesModel setCommonPropertities(File file,TaxFilesModel taxFiles){
		if(ExcleUtils.validateExcel(file.getPath())){
			taxFiles.setPdf(false);
			if(ExcleUtils.isExcel2003(file.getPath())){
				taxFiles.setFileType("xls");
				taxFiles.setExcel2007(false);
			}else{
				taxFiles.setFileType("xlsx");
				taxFiles.setExcel2007(true);
			}
		}else{
			taxFiles.setPdf(true);
			taxFiles.setFileType("pdf");
		}
		taxFiles.setName(file.getName());
		taxFiles.setFile(file);
		taxFiles.setSize(file.length());
		return taxFiles;
	}
	/**
	 * 
	 * @time   2018年11月16日 下午6:53:42
	 * @author zuoqb
	 * @todo   将excel文件中相应cell数值写入实体类
	 * @return_type   void
	 */
	private static void getExcelProperties2Bean(TaxFilesModel taxFiles, Workbook wb) {
		/**
		 * 解析excel通用属性
		 */
		String fujian=StringUtils.deleteWhitespace(readExcelValueByPosition(0, 0, wb, 0));
		String title=StringUtils.deleteWhitespace(readExcelValueByPosition(1, 15, wb, 0));
		if(fujian.indexOf("附件1")!=-1&&title.indexOf("一般纳税人适用")!=-1
				&&fujian.indexOf("增值税纳税申报表")!=-1){
			//一般纳税人适用
			System.out.println(taxFiles.getName()+"-------一般纳税人适用");
			generalTaxpayer(taxFiles, wb);
		}else{
			//（适用于增值税一般纳税人）
			String zzs=readExcelValueByPosition(2, 0, wb, 0);
			if(zzs.indexOf("增值税纳税申报表")!=-1&&zzs.indexOf("附列资料")==-1){
				System.out.println(taxFiles.getName()+"-----------增值税纳税申报表");
				addedGeneralTaxpayer(taxFiles, wb);
			}else{
				//加密的
				String sec=readExcelValueByPosition(4, 4, wb, 0);
				if(sec.indexOf("增值税纳税申报表")!=-1&&sec.indexOf("附列资料")==-1){
					System.out.println(taxFiles.getName()+"-----------加密版增值税纳税申报表");
					addedSecGeneralTaxpayer(taxFiles, wb);
				}
			}
		}
	}
	/**
	 * @time   2018年11月16日 下午8:08:21
	 * @author zuoqb
	 * @todo   适用于增值税一般纳税人
	 * @return_type   void
	 */
	public static void addedGeneralTaxpayer(TaxFilesModel taxFiles, Workbook wb) {
		taxFiles.setApply(true);//业务主表
		//处理日期
		String startDate=readExcelValueByPosition(7, 0, wb, 0);
		startDate=startDate.replaceAll("税款所属时间：", "").replaceAll("税款所属期间:", "").replaceAll("年", "").replaceAll("月", "").replaceAll("日", "").split("至")[0].replaceAll(" ", "");
		if(StringUtils.isNotBlank(startDate)){
			taxFiles.setStartDate(startDate);
			taxFiles.setStartYear(startDate.substring(0,4));
			taxFiles.setStartMonth(Integer.valueOf(startDate.substring(4,6))+"");
		}
		//公司名称
		String companyName=readExcelValueByPosition(9, 0, wb, 0);
		companyName=companyName.replaceAll("纳税人名称：", "").replaceAll("（公章）：", "").replaceAll("（公章）", "");;
		taxFiles.setCompanyName(companyName);
		
		/**
		 * 解析excel 数据字段
		 */
		/**
		 * 销售额-（一）按适用税率计税销售额
		 */
		String xiaoshoueYear=readExcelValueByPosition(13, 4, wb, 0);//销售额年累-（一）按适用税率计税销售额
		taxFiles.setXiaoshoueYear(xiaoshoueYear);
		String xiaoshoueMonth=readExcelValueByPosition(13, 3, wb, 0);//销售额月累-（一）按适用税率计税销售额
		taxFiles.setXiaoshoueMonth(xiaoshoueMonth);
		/**
		 * 税额-销项税额
		 */
		String shuieYear=readExcelValueByPosition(23, 4, wb, 0);//税额年累-销项税额
		taxFiles.setShuieYear(shuieYear);
		String shuieMonth=readExcelValueByPosition(23, 3, wb, 0);//税额月累-销项税额
		taxFiles.setShuieMonth(shuieMonth);
		
		/**
		 * 第三项-（三）免、抵、退办法出口销售额
		 */
		String disanxiangYear=readExcelValueByPosition(19, 4, wb, 0);//第三项年累-（三）免、抵、退办法出口销售额
		taxFiles.setDisanxiangYear(disanxiangYear);
		String disanxiangMonth=readExcelValueByPosition(19, 3, wb, 0);//第三项月累-（三）免、抵、退办法出口销售额
		taxFiles.setDisanxiangMonth(disanxiangMonth);
		
		/**
		 * 第四项-（四）免税销售额
		 */
		String disixiangYear=readExcelValueByPosition(20, 4, wb, 0);//第四项年累-（四）免税销售额
		taxFiles.setDisixiangYear(disixiangYear);
		String disixiangMonth=readExcelValueByPosition(20, 3, wb, 0);//第四项月累-（四）免税销售额
		taxFiles.setDisixiangMonth(disixiangMonth);
		
		
		/**
		 * 简易征收-（二）按简易办法计税销售额
		 */
		String jyzsYear=readExcelValueByPosition(17, 4, wb, 0);//简易征收年累-（二）按简易办法计税销售额
		taxFiles.setJyzsYear(jyzsYear);
		String jyzsMonth=readExcelValueByPosition(17, 3, wb, 0);//简易征收月累-（二）按简易办法计税销售额
		taxFiles.setJyzsMonth(jyzsMonth);
		
		/**
		 * 简易税-简易计税办法计算的应纳税额
		 */
		String jysYear=readExcelValueByPosition(34, 4, wb, 0);//简易税年累-简易计税办法计算的应纳税额
		taxFiles.setJysYear(jysYear);
		String jysMonth=readExcelValueByPosition(34, 3, wb, 0);//简易税月累-简易计税办法计算的应纳税额
		taxFiles.setJysMonth(jysMonth);
		
		
		/**
		 * 即征即退销售额  
		 */
		float jzjtxseYear0=Float.parseFloat(readExcelValueByPosition(13, 6, wb, 0));
		float jzjtxseYear1=Float.parseFloat(readExcelValueByPosition(17, 6, wb, 0));
		String jzjtxseYear=(jzjtxseYear0+jzjtxseYear1)+"";
		taxFiles.setJzjtxseYear(jzjtxseYear);
		float jzjtxseMonth0=Float.parseFloat(readExcelValueByPosition(13, 5, wb, 0));
		float jzjtxseMonth1=Float.parseFloat(readExcelValueByPosition(17, 5, wb, 0));
		String jzjtxseMonth=(jzjtxseMonth0+jzjtxseMonth1)+"";
		taxFiles.setJzjtxseMonth(jzjtxseMonth);
		
		/**
		 * 即征即退税额  
		 */
		float jzjtseYear0=Float.parseFloat(readExcelValueByPosition(23, 6, wb, 0));
		float jzjtseYear1=Float.parseFloat(readExcelValueByPosition(33, 6, wb, 0));
		String jzjtseYear=(jzjtseYear0+jzjtseYear1)+"";
		taxFiles.setJzjtseYear(jzjtseYear);
		float jzjtseMonth0=Float.parseFloat(readExcelValueByPosition(23, 5, wb, 0));
		float jzjtseMonth1=Float.parseFloat(readExcelValueByPosition(33, 5, wb, 0));
		String jzjtseMonth=(jzjtseMonth0+jzjtseMonth1)+"";
		taxFiles.setJzjtseMonth(jzjtseMonth);
		
		
		/**
		 * 进项税-进项税额
		 */
		float jinxiangshuiYear0=Float.parseFloat(readExcelValueByPosition(24, 4, wb, 0));
		float jinxiangshuiYear1=Float.parseFloat(readExcelValueByPosition(24, 6, wb, 0));
		String jinxiangshuiYear=(jinxiangshuiYear0+jinxiangshuiYear1)+"";//进项税年累-进项税额
		taxFiles.setJinxiangshuiYear(jinxiangshuiYear);
	}
	/**
	 * @time   2018年11月16日 下午8:08:21
	 * @author zuoqb
	 * @todo   适用于增值税一般纳税人-加密版-比如成都
	 * @return_type   void
	 */
	public static void addedSecGeneralTaxpayer(TaxFilesModel taxFiles, Workbook wb) {
		taxFiles.setApply(true);//业务主表
		//处理日期
		String startDate=readExcelValueByPosition(7, 7, wb, 0);
		startDate=startDate.replaceAll("税款所属时间：", "").replaceAll("税款所属期间:", "").replaceAll("年", "").replaceAll("月", "").replaceAll("日", "").split("至")[0].replaceAll(" ", "");
		if(StringUtils.isNotBlank(startDate)){
			taxFiles.setStartDate(startDate);
			taxFiles.setStartYear(startDate.substring(0,4));
			taxFiles.setStartMonth(Integer.valueOf(startDate.substring(4,6))+"");
		}
		//公司名称
		String companyName=readExcelValueByPosition(9, 7, wb, 0);
		companyName=companyName.replaceAll("纳税人名称：", "").replaceAll("（公章）：", "").replaceAll("（公章）", "");;
		taxFiles.setCompanyName(companyName);
		
		/**
		 * 解析excel 数据字段
		 */
		/**
		 * 销售额-（一）按适用税率计税销售额
		 */
		String xiaoshoueYear=readExcelValueByPosition(13, 14, wb, 0);//销售额年累-（一）按适用税率计税销售额
		taxFiles.setXiaoshoueYear(xiaoshoueYear);
		String xiaoshoueMonth=readExcelValueByPosition(13, 13, wb, 0);//销售额月累-（一）按适用税率计税销售额
		taxFiles.setXiaoshoueMonth(xiaoshoueMonth);
		/**
		 * 税额-销项税额
		 */
		String shuieYear=readExcelValueByPosition(23, 14, wb, 0);//税额年累-销项税额
		taxFiles.setShuieYear(shuieYear);
		String shuieMonth=readExcelValueByPosition(23, 13, wb, 0);//税额月累-销项税额
		taxFiles.setShuieMonth(shuieMonth);
		
		/**
		 * 第三项-（三）免、抵、退办法出口销售额
		 */
		String disanxiangYear=readExcelValueByPosition(19, 14, wb, 0);//第三项年累-（三）免、抵、退办法出口销售额
		taxFiles.setDisanxiangYear(disanxiangYear);
		String disanxiangMonth=readExcelValueByPosition(19, 13, wb, 0);//第三项月累-（三）免、抵、退办法出口销售额
		taxFiles.setDisanxiangMonth(disanxiangMonth);
		
		/**
		 * 第四项-（四）免税销售额
		 */
		String disixiangYear=readExcelValueByPosition(20, 14, wb, 0);//第四项年累-（四）免税销售额
		taxFiles.setDisixiangYear(disixiangYear);
		String disixiangMonth=readExcelValueByPosition(20, 13, wb, 0);//第四项月累-（四）免税销售额
		taxFiles.setDisixiangMonth(disixiangMonth);
		
		
		/**
		 * 简易征收-（二）按简易办法计税销售额
		 */
		String jyzsYear=readExcelValueByPosition(17, 14, wb, 0);//简易征收年累-（二）按简易办法计税销售额
		taxFiles.setJyzsYear(jyzsYear);
		String jyzsMonth=readExcelValueByPosition(17, 13, wb, 0);//简易征收月累-（二）按简易办法计税销售额
		taxFiles.setJyzsMonth(jyzsMonth);
		
		/**
		 * 简易税-简易计税办法计算的应纳税额
		 */
		String jysYear=readExcelValueByPosition(34, 14, wb, 0);//简易税年累-简易计税办法计算的应纳税额
		taxFiles.setJysYear(jysYear);
		String jysMonth=readExcelValueByPosition(34,13, wb, 0);//简易税月累-简易计税办法计算的应纳税额
		taxFiles.setJysMonth(jysMonth);
		
		
		/**
		 * 即征即退销售额  
		 */
		float jzjtxseYear0=Float.parseFloat(readExcelValueByPosition(13, 16, wb, 0));
		float jzjtxseYear1=Float.parseFloat(readExcelValueByPosition(17, 16, wb, 0));
		String jzjtxseYear=(jzjtxseYear0+jzjtxseYear1)+"";
		taxFiles.setJzjtxseYear(jzjtxseYear);
		float jzjtxseMonth0=Float.parseFloat(readExcelValueByPosition(13, 15, wb, 0));
		float jzjtxseMonth1=Float.parseFloat(readExcelValueByPosition(17, 15, wb, 0));
		String jzjtxseMonth=(jzjtxseMonth0+jzjtxseMonth1)+"";
		taxFiles.setJzjtxseMonth(jzjtxseMonth);
		
		/**
		 * 即征即退税额  
		 */
		float jzjtseYear0=Float.parseFloat(readExcelValueByPosition(23, 16, wb, 0));
		float jzjtseYear1=Float.parseFloat(readExcelValueByPosition(33, 16, wb, 0));
		String jzjtseYear=(jzjtseYear0+jzjtseYear1)+"";
		taxFiles.setJzjtseYear(jzjtseYear);
		float jzjtseMonth0=Float.parseFloat(readExcelValueByPosition(23, 15, wb, 0));
		float jzjtseMonth1=Float.parseFloat(readExcelValueByPosition(33, 15, wb, 0));
		String jzjtseMonth=(jzjtseMonth0+jzjtseMonth1)+"";
		taxFiles.setJzjtseMonth(jzjtseMonth);
		
		
		/**
		 * 进项税-进项税额
		 */
		float jinxiangshuiYear0=Float.parseFloat(readExcelValueByPosition(24, 14, wb, 0));
		float jinxiangshuiYear1=Float.parseFloat(readExcelValueByPosition(24, 16, wb, 0));
		String jinxiangshuiYear=(jinxiangshuiYear0+jinxiangshuiYear1)+"";//进项税年累-进项税额
		taxFiles.setJinxiangshuiYear(jinxiangshuiYear);
		
	}
	/**
	 * @time   2018年11月16日 下午8:08:21
	 * @author zuoqb
	 * @todo   一般纳税人
	 * @return_type   void
	 */
	public static void generalTaxpayer(TaxFilesModel taxFiles, Workbook wb) {
		taxFiles.setApply(true);//业务主表
		//处理日期
		String startDate=readExcelValueByPosition(3, 0, wb, 0);
		startDate=startDate.replaceAll("税款所属期间:", "").replaceAll("年", "").replaceAll("月", "").replaceAll("日", "").split("至")[0].replaceAll(" ", "");
		if(StringUtils.isNotBlank(startDate)){
			taxFiles.setStartDate(startDate);
			taxFiles.setStartYear(startDate.substring(0,4));
			taxFiles.setStartMonth(Integer.parseInt(startDate.substring(4,6))+"");
		}
		//公司名称
		String companyName=readExcelValueByPosition(5, 4, wb, 0).replaceAll("（公章）：", "").replaceAll("（公章）", "");
		taxFiles.setCompanyName(companyName);
		
		/**
		 * 解析excel 数据字段
		 */
		/**
		 * 销售额-（一）按适用税率计税销售额
		 */
		String xiaoshoueYear=readExcelValueByPosition(9, 25, wb, 0);//销售额年累-（一）按适用税率计税销售额
		taxFiles.setXiaoshoueYear(xiaoshoueYear);
		String xiaoshoueMonth=readExcelValueByPosition(9, 24, wb, 0);//销售额月累-（一）按适用税率计税销售额
		taxFiles.setXiaoshoueMonth(xiaoshoueMonth);
		/**
		 * 税额-销项税额
		 */
		String shuieYear=readExcelValueByPosition(19, 25, wb, 0);//税额年累-销项税额
		taxFiles.setShuieYear(shuieYear);
		String shuieMonth=readExcelValueByPosition(19, 24, wb, 0);//税额月累-销项税额
		taxFiles.setShuieMonth(shuieMonth);
		
		/**
		 * 第三项-（三）免、抵、退办法出口销售额
		 */
		String disanxiangYear=readExcelValueByPosition(15, 25, wb, 0);//第三项年累-（三）免、抵、退办法出口销售额
		taxFiles.setDisanxiangYear(disanxiangYear);
		String disanxiangMonth=readExcelValueByPosition(15, 24, wb, 0);//第三项月累-（三）免、抵、退办法出口销售额
		taxFiles.setDisanxiangMonth(disanxiangMonth);
		
		/**
		 * 第四项-（四）免税销售额
		 */
		String disixiangYear=readExcelValueByPosition(16, 25, wb, 0);//第四项年累-（四）免税销售额
		taxFiles.setDisixiangYear(disixiangYear);
		String disixiangMonth=readExcelValueByPosition(16, 24, wb, 0);//第四项月累-（四）免税销售额
		taxFiles.setDisixiangMonth(disixiangMonth);
		
		/**
		 * 简易征收-（二）按简易办法计税销售额
		 */
		String jyzsYear=readExcelValueByPosition(13, 25, wb, 0);//简易征收年累-（二）按简易办法计税销售额
		taxFiles.setJyzsYear(jyzsYear);
		String jyzsMonth=readExcelValueByPosition(13, 24, wb, 0);//简易征收月累-（二）按简易办法计税销售额
		taxFiles.setJyzsMonth(jyzsMonth);
		
		/**
		 * 简易税-简易计税办法计算的应纳税额
		 */
		String jysYear=readExcelValueByPosition(29, 25, wb, 0);//简易税年累-简易计税办法计算的应纳税额
		taxFiles.setJysYear(jysYear);
		String jysMonth=readExcelValueByPosition(29, 24, wb, 0);//简易税月累-简易计税办法计算的应纳税额
		taxFiles.setJysMonth(jysMonth);
		
		
		/**
		 * 即征即退销售额  
		 */
		float jzjtxseYear0=Float.parseFloat(readExcelValueByPosition(9, 27, wb, 0));
		float jzjtxseYear1=Float.parseFloat(readExcelValueByPosition(13, 27, wb, 0));
		String jzjtxseYear=(jzjtxseYear0+jzjtxseYear1)+"";
		taxFiles.setJzjtxseYear(jzjtxseYear);
		float jzjtxseMonth0=Float.parseFloat(readExcelValueByPosition(9, 26, wb, 0));
		float jzjtxseMonth1=Float.parseFloat(readExcelValueByPosition(13, 26, wb, 0));
		String jzjtxseMonth=(jzjtxseMonth0+jzjtxseMonth1)+"";
		taxFiles.setJzjtxseMonth(jzjtxseMonth);
		
		/**
		 * 即征即退税额  
		 */
		float jzjtseYear0=Float.parseFloat(readExcelValueByPosition(19, 27, wb, 0));
		float jzjtseYear1=Float.parseFloat(readExcelValueByPosition(29, 27, wb, 0));
		String jzjtseYear=(jzjtseYear0+jzjtseYear1)+"";
		taxFiles.setJzjtseYear(jzjtseYear);
		float jzjtseMonth0=Float.parseFloat(readExcelValueByPosition(19, 26, wb, 0));
		float jzjtseMonth1=Float.parseFloat(readExcelValueByPosition(29, 26, wb, 0));
		String jzjtseMonth=(jzjtseMonth0+jzjtseMonth1)+"";
		taxFiles.setJzjtseMonth(jzjtseMonth);
		
		
		/**
		 * 进项税-进项税额
		 */
		float jinxiangshuiYear0=Float.parseFloat(readExcelValueByPosition(20, 25, wb, 0));
		float jinxiangshuiYear1=Float.parseFloat(readExcelValueByPosition(20, 27, wb, 0));
		String jinxiangshuiYear=(jinxiangshuiYear0+jinxiangshuiYear1)+"";//进项税年累-进项税额
		taxFiles.setJinxiangshuiYear(jinxiangshuiYear);
	}
}
