package com.imooc.domtest.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class YCDOM {

	public static void main(String[] args) {
		//创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//创建一个DocumentBuilder的对象
		try {
			//创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			//通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
			Document document = db.parse("ycbooks.xml");
			//获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			//通过nodelist的getLength()方法可以获取bookList的长度
			System.out.println("一共有" + bookList.getLength() + "本书");
			//遍历每一个book节点
			for (int i = 0; i < bookList.getLength(); i++) {
				System.out.println("=================下面开始遍历第" + (i + 1) + "本书的内容=================");
				//通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
				Node book = bookList.item(i);
//				获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第 " + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
//				遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					//通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					//获取属性名
					System.out.print("属性名：" + attr.getNodeName());
					//获取属性值
					System.out.println("--属性值" + attr.getNodeValue());
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}  catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
