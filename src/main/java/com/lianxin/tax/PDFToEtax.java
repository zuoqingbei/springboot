package com.lianxin.tax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
/**
 * @time   2018年11月20日 上午9:46:59
 * @author zuoqb
 * @todo   处理PDF转成报税实体
 */
public class PDFToEtax {
	//初始化excel
    public static WritableWorkbook wwb = null;
    public static WritableSheet ws;
    public static void main(String[] args) {
        //将当前目录下的pdf文件转成txt文件
    	String path="C:/Users/Administrator/Desktop/lianxin/upload/testpdf/";
    	String name="报税09";
        File f = new File(path+name+".pdf"); //获得当前路径
        Map<String,Object> map=getPdfContent(path,f);
        File txt = new File(path+name+".txt"); //获得当前路径
        TXTtoEXCEL(path,txt);
       /* try {
            //从内存中写入文件中
            wwb.write();
            //关闭资源，释放内存
            wwb.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }*/

    }
	/**
	 * @time   2018年11月20日 上午9:57:04
	 * @author zuoqb
	 * @todo   读取pdf文件内容
	 */
    public static Map<String,Object> getPdfContent(String path,File pdf) {
    	Map<String,Object> map=new HashMap<String,Object>();
        PDDocument document=null;
        String content = null;
        BufferedWriter wr=null;
        String textName=null;
        try {
            File input = pdf; 
            textName=pdf.getName().split("\\.")[0] + ".txt";
            File output = new File(textName);
            document = PDDocument.load(input);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfTextStripper.setStartPage(1);
			pdfTextStripper.setEndPage(1);//只读取第一页
			content = pdfTextStripper.getText(document);
			System.out.println(content);
			//生成text只是为了数据核对
            wr = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path+output)));
            pdfTextStripper.writeText(document, wr);
            map.put("textName", textName);
            map.put("path", path);
            map.put("content", content);
            map.put("success", true);
            map.put("msg", "操作成功！");
            if (document != null) {
            	document.close();
            }
            if(wr!=null){
            	wr.close();
            }
        } catch (Exception e) {
        	map.put("content", "");
        	map.put("success", false);
        	map.put("msg", e.getMessage());
            e.printStackTrace();
        }finally{
        	try {
        		if (document != null) {
                	document.close();
                }
                if(wr!=null){
                	wr.close();
                }
			} catch (Exception e2) {
			}
        }
        return map;
    }
    //爬取目录下的txt文件中关键字并输出到excel文件中
    public static String project = null;
    public static int count = 0;
    public static void TXTtoEXCEL(String path,File txt) {
    	project = "";
        count=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(txt));
            System.out.println(txt.getName());
            String line = "";

            while((line = br.readLine()) != null) {
                Pattern p0 = Pattern.compile(".*(（一）按适用税率征税销售额).*");
                Matcher m0 = p0.matcher(line);
                if (m0.find()) {
                    System.out.println(line);                   
                    System.out.println("项目值=" + m0.group(1));
                    project = m0.group(1);
                    continue;
                }

                

            }


            if(br != null) {
                br.close();
                br = null;
            }
        } catch (IOException e) {
           e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
