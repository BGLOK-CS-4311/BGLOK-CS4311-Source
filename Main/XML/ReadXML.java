package Main.XML;

import Main.XML.XMLTags;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML implements XMLTags{
	File file; 
	
	ReadXML(String fileName){
		file = new File(fileName);
		
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFactory.newDocumentBuilder();
			Document doc = dBuild.parse(file);
			
			//Puts the text nodes together 
			doc.getDocumentElement().normalize();
			
			//
			NodeList list = doc.getElementsByTagName(PERIOD);
			System.out.println();
			
			for(int i=0; i < list.getLength(); i++){
				Node node = list.item(i);
				
				System.out.println("\n" + node.getNodeName());
				
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					
					
				} //If loop, checking if node is an element
			} // For loop, traversing Nodes
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
