package com.imooc.domtest.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeTest2 {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse("node2.xml");
		NodeList bookList = document.getElementsByTagName("book");
		Node book = bookList.item(0);
		if (book.getNodeType() == Node.TEXT_NODE) {
			System.out.println("TEXT_NODE");
		}
		if (book.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println("---ELEMENT_NODE---");
			System.out.println(book.getNodeName());
			System.out.println(book.getTextContent());
		}
		NodeList childNodes = book.getChildNodes();
		System.out.println("本书共有" + childNodes.getLength() + "个子节点");
		for (int k = 0; k < childNodes.getLength(); k++) {
			if (childNodes.item(k).getNodeType() == Node.TEXT_NODE) {
				System.out.println("第" + (k + 1) + "个节点的节点名：" + childNodes.item(k).getNodeName());
				System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
			}
			if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("第" + (k + 1) + "个节点的节点名："+childNodes.item(k).getNodeName());
				System.out.println("--节点值是："+childNodes.item(k).getTextContent());
				System.out.println("--节点子节点个数："+childNodes.item(k).getChildNodes().getLength());
				System.out.println("$"+childNodes.item(k).getChildNodes().item(0).getNodeName());
				System.out.println("$"+childNodes.item(k).getChildNodes().item(0).getTextContent());
			}
		}
	}
}
