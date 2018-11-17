package com.lianxin.tax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFtoTXT {
	//初始化excel
    public static WritableWorkbook wwb = null;
    public static WritableSheet ws;
    public static void main(String[] args) {
        //将当前目录下的pdf文件转成txt文件
    	String path="C://Users//Administrator//Desktop//报税//pdf//";
    	String name="serwere";
        File f = new File(path+name+".pdf"); //获得当前路径
        PDFtoTXT(path,f);
        initExcel(path);
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
	//将pdf文件输出为txt
    public static void PDFtoTXT(String path,File pdf) {
        PDDocument pd;
        BufferedWriter wr;
        try {
            File input = pdf; 
            // The PDF file from where
            // you would like to
            // extract
            File output = new File(pdf.getName().split("\\.")[0] + ".txt");
            // The text file where
            // you are going to
            // store the
            // extracted data
            pd = PDDocument.load(input);
            //pd.save("CopyOf" + pdf.getName().split("\\.")[0] + ".pdf"); // Creates a copy called
            // "CopyOfInvoice.pdf"
            PDFTextStripper stripper = new PDFTextStripper();
            wr = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path+output)));
            stripper.writeText(pd, wr);
            if (pd != null) {
                pd.close();
            }
            // I use close() to flush the stream.
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void initExcel(String path){
        try {
            //首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
            wwb = Workbook.createWorkbook(new File(path+"excel.xlsx"));
            if(wwb != null){
                //创建一个可写入的工作表
                //Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
                ws = wwb.createSheet("sheet1", 0);
                //下面开始添加单元格
                //这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
                ws.addCell(new Label(0, 0, "项目")); //将生成的单元格添加到工作表中
                ws.addCell(new Label(1, 0, "栏次"));
                ws.addCell(new Label(2, 0, "一般项目-本月数"));
                ws.addCell(new Label(3, 0, "一般项目-年累"));
                ws.addCell(new Label(4, 0, "即征即退项目-本月数"));
                ws.addCell(new Label(5, 0, "即征即退项目-年累"));
                ws.setColumnView(0, 150);
                ws.setColumnView(1, 60);
                ws.setColumnView(2, 120);
                ws.setColumnView(3, 120);
                ws.setColumnView(4, 120);
                ws.setColumnView(5, 120);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
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
