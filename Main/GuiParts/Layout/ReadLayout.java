package Main.GuiParts.Layout;

import Hardware.Hardware;
import Main.Commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadLayout implements Commands{
	Home home = new Home();

	public ReadLayout(){
		//File file = new File(LAYOUT);
		final String dir = System.getProperty("user.dir");
		File fileIn = new File(dir + LAYOUT);

		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFactory.newDocumentBuilder();
			Document doc = dBuild.parse(fileIn);

			//Puts the text nodes together 
			doc.getDocumentElement().normalize();

			NodeList list = doc.getElementsByTagName("room");	//Get all rooms	
			
			//Get all room information
			for(int i=0; i<list.getLength(); i++){
				Node node = list.item(i);
				
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;

					String rName = elem.getAttribute("rName");
					//System.out.println(rName + " ");
					home.addRoom(rName);
					
					//Get Devices -----------------------------------------------
					NodeList devList = elem.getElementsByTagName("device");
					
					for(int dev=0; dev < devList.getLength(); dev++){
						Node devNode = devList.item(dev);
						
						if(node.getNodeType() == Node.ELEMENT_NODE){
							Element devE = (Element) devNode;
							
							String devName = devE.getAttribute("Dname");
							String devType = devE.getTextContent();
							//System.out.println("\t" + devName + ", " + devType);
							Class<?> hardware = Class.forName("Hardware." + devType);
							home.addDevice(devName, hardware);
						}
					}
					//System.out.println();					
				} //If loop, checking if node is an element
			} // For loop, traversing Nodes
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args){
		ReadLayout r = new ReadLayout();
	}
}