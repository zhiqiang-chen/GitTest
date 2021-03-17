package com.example.springbootdemo.util;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;

/**
 * TODO
 *
 * @author czq
 * @date 2021/2/7 17:36
 */
public class PdfUtils {
    // 利用模板生成pdf
    public static void fillTemplate() {
        // 模板路径
        String templatePath = "D:/测试3.pdf";
        // 生成的新文件路径
        String newPDFPath = "D:/ceshi.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            String[] str = { "123456789", "TOP__ONE", "男", "1991-01-01", "130222111133338888", "河北省保定市" };
            int i = 0;
            Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();
                System.out.println(name);
                form.setField(name, str[i++]);
            }
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(1);
        } catch (DocumentException e) {
            System.out.println(2);
        }

    }

    //如果没有模板，就行自己生成pdf文件保存到磁盘
    public static void test1(){//生成pdf
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:/1.pdf"));
            document.open();
            for(int i=0;i<3;i++){
                document.add(new Paragraph("hello word"+i));
                document.add(new Paragraph("hello word"));
                document.add(new Paragraph("hello word"));
                document.add(new Paragraph("hello word"));
                document.add(new Paragraph(""));
            }
            document.close();
        } catch (Exception e) {
            System.out.println("file create exception");
        }
    }

    //上述方法中包含中文时就会出现问题，所以可以使用下面这行代码实现
    public static void test1_1(){
        BaseFont bf;
        Font font = null;
        try {
            bf = BaseFont.createFont( "STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);//创建字体
            font = new Font(bf,12);//使用字体
        } catch (Exception e) {
            e.printStackTrace();
        }
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:/2.pdf"));
            document.open();
            document.add(new Paragraph("hello word 你好 世界",font));//引用字体
            document.close();
        } catch (Exception e) {
            System.out.println("file create exception");
        }
    }


    //主方法
    public static void main(String[] args) {
        //fillTemplate();
        test1();
        //test1_1();
    }
}
