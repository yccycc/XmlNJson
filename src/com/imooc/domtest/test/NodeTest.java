package com.imooc.domtest.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeTest {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse("node.xml");
		NodeList bookList = document.getElementsByTagName("book");
		for (int i = 0; i < bookList.getLength(); i++) {
			System.out.println("=================���濪ʼ������" + (i + 1) + "���������=================");
			Node book = bookList.item(i);
			NamedNodeMap attrs = book.getAttributes();
			System.out.println("�� " + (i + 1) + "���鹲��" + attrs.getLength() + "������");
			for (int j = 0; j < attrs.getLength(); j++) {
				Node attr = attrs.item(j);
				System.out.print("��������" + attr.getNodeName());
				System.out.println("--����ֵ" + attr.getNodeValue());
			}
			NodeList childNodes = book.getChildNodes();
			System.out.println("��" + (i+1) + "���鹲��" + 
			childNodes.getLength() + "���ӽڵ�");
			for (int k = 0; k < childNodes.getLength(); k++) {
				System.out.println("��" + (k + 1) + "���ڵ�Ľڵ�����" 
				+ childNodes.item(k).getNodeName());
//				if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE)
//				{
					System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(k).getTextContent());
				//}
			}
		}
	}
}
