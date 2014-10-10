package ParserSAX;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class Main {
	public static void main(String[] args) {
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			DocHandler dh = new DocHandler();
			List v;
			if (dh != null)
				parser.parse("Tariff.xml", dh);
			v = dh.getNotes();
			for (int i = 0; i < v.size(); i++)
				System.out.println(((Tariff) v.get(i)).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
