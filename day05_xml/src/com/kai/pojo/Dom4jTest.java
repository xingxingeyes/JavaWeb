package com.kai.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/6
 **/
public class Dom4jTest {

    /**
     * 1.读取xml文件生成document对象
     */
    @Test
    public void test1() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);

    }

    /**
     * 读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws Exception {
        // 1. 读取books.xml文件
        SAXReader reader = new SAXReader();
        // 在Junit测试中，相对路径是从模块名开始
        Document document = reader.read("src/books.xml");
        // 2. 通过document对象获取根元素
        Element rootElement = document.getRootElement();
        // 3. 通过根元素获取book标签对象
        // element()通过标签名查找单个子元素，elements()查找多个
        List<Element> books = rootElement.elements("book");
        // 4. 遍历处理每个book标签转化为book类
//        for (Element book : books) {
//
//        }
        books.forEach(book->{
            // asXML()把标签对象转化为标签字符串
            Element nameElement = book.element("name");
            // getText(); 可以获取标签的文本内容
            String nameText = nameElement.getText();
            // 直接获取指定标签名的文本内容
            String authorText = book.elementText("author");
            String priceText = book.elementText("price");


            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue,nameText,authorText,BigDecimal.valueOf(Double.parseDouble(priceText))));

        });


    }



}
