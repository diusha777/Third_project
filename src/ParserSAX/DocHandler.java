package ParserSAX;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class DocHandler extends DefaultHandler implements ConstNote {
	List notes = new ArrayList();
	Tariff curr = new Tariff();
	int current = -1;

	public List getNotes() {
		return notes;
	}

	@Override
	public void startDocument() {
		System.out.println("parsing started");
	}

	@Override
	public void endDocument() {
		System.out.println("parsing ended");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
		if (qName.equals("tariff")) {
			curr = new Tariff();
			curr.setId(attrs.getValue(0));
		}
		if (qName.equals("tariffname"))
			current = TARIFFNAME;
		else if (qName.equals("payroll"))
			current = PAYROLL;
		else if (qName.equals("insidenetwork"))
			current = INSIDENETWORK;
		else if (qName.equals("outsidenetwork"))
			current = OUTSIDENETWORK;
		else if (qName.equals("tofixedphones"))
			current = TOFIXEDPHONES;
		else if (qName.equals("smsprice"))
			current = SMSPRICE;
		else if (qName.equals("favouritenumbers"))
			current = FAVOURITENUMBERS;
		else if (qName.equals("tariffing"))
			current = TARIFFING;
		else if (qName.equals("connectpayment"))
			current = CONNECTPAYMENT;
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("tariff"))
			notes.add(curr);
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		String s = new String(ch, start, length);
		try {
			switch (current) {
			case TARIFFNAME:
				curr.setTitle(s);
				break;
			case PAYROLL:
				curr.setPayroll(Integer.parseInt(s));
				break;
			case INSIDENETWORK:
				curr.cp.setInsidenetwork(Double.parseDouble(s));
				break;
			case OUTSIDENETWORK:
				curr.cp.setOutsidenetwork(Integer.parseInt(s));
				break;
			case TOFIXEDPHONES:
				curr.cp.setTofixedphones(Integer.parseInt(s));
				break;
			case SMSPRICE:
				curr.setSmsprice(Double.parseDouble(s));
				break;
			case FAVOURITENUMBERS:
				curr.par.setFavouritenumbers(Integer.parseInt(s));
				break;
			case TARIFFING:
				curr.par.setTariffing(s);
				break;
			case CONNECTPAYMENT:
				curr.par.setConnectpayment(Integer.parseInt(s));
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
		} current = -1;
	}
}