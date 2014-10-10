package ParserDOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Dom {
static int i=-1, j=-1, k=-1;
	
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBiulder = factory.newDocumentBuilder();
		Document doc = documentBiulder.parse (new File ("tariff.xml"));
				
		String titleEl = doc.getDocumentElement().getNodeName();
				
		NodeList nodeList1 = doc.getElementsByTagName("tariff");
		NodeList nodeList2 = doc.getElementsByTagName("callprices");
		NodeList nodeList3 = doc.getElementsByTagName("parameters");
		
		String tariffname = "", tariffing = "";
		int payroll = 0, outsidenetwork = 0, tofixedphones = 0, favouritenumbers = 0, connectpayment = 0;
		double insidenetwork = 0, smsprice = 0; 
		
		System.out.println ("tariffname 		payroll insidenetwork 	outsidenetwork 	tofixedphones 	smsprice 	favouritenumbers  	tariffing 			connectpayment");
  				
		while (i < nodeList1.getLength()-1){
				i++;
				Element element1 = (Element)nodeList1.item(i);
					
					tariffname = element1.getElementsByTagName("tariffname").item(0).getChildNodes().item(0).getNodeValue();
					payroll = Integer.parseInt(element1.getElementsByTagName("payroll").item(0).getChildNodes().item(0).getNodeValue());
					smsprice = Double.parseDouble(element1.getElementsByTagName("smsprice").item(0).getChildNodes().item(0).getNodeValue());
					
					if (j < nodeList2.getLength()){
						j++;
					Element element2 = (Element)nodeList2.item(j);
					
					insidenetwork = Double.parseDouble(element2.getElementsByTagName("insidenetwork").item(0).getChildNodes().item(0).getNodeValue());
					outsidenetwork = Integer.parseInt(element2.getElementsByTagName("outsidenetwork").item(0).getChildNodes().item(0).getNodeValue());
					tofixedphones = Integer.parseInt(element2.getElementsByTagName("tofixedphones").item(0).getChildNodes().item(0).getNodeValue());
					}
					
					if (k < nodeList3.getLength()){
						k++;
					Element element3 = (Element)nodeList3.item(k);
					
					favouritenumbers = Integer.parseInt(element3.getElementsByTagName("favouritenumbers").item(0).getChildNodes().item(0).getNodeValue());
					tariffing = element3.getElementsByTagName("tariffing").item(0).getChildNodes().item(0).getNodeValue();
					connectpayment = Integer.parseInt(element3.getElementsByTagName("connectpayment").item(0).getChildNodes().item(0).getNodeValue());
					
					}
					
					System.out.println (tariffname + "	" + payroll + "	" + insidenetwork + "		" + outsidenetwork + "		" + tofixedphones + "		" + smsprice + "		" + favouritenumbers + "			" + tariffing + "		" + connectpayment);

} 	
}		
}


	

