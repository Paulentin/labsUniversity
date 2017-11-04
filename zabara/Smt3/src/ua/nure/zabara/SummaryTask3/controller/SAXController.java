package ua.nure.zabara.SummaryTask3.controller;

import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import org.xml.sax.helpers.XMLReaderFactory;
import ua.nure.zabara.SummaryTask3.entity.Weapons;


public class SAXController extends DefaultHandler {

    public SAXController(String xmlFileName) {
    }

    @Override
	public void startDocument() {
		System.out.println("Pars started");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) {

		String s = localName;
		for (int i = 0; i < attrs.getLength(); i++) {
			s += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
		}
		System.out.println(s.trim());

	}

	@Override
	public void characters(char[ ] ch, int start, int length) {
		System.out.print(new String(ch, start, length));
	}
	@Override
	public void endElement(String uri, String localName, String qName) {
		System.out.print(localName);
	}
	@Override
	public void endDocument() {
		System.out.println("\nParsing ended");
	}


	public static void main(String[] args) {
		try {
			// создание SAX-анализатора

			XMLReader reader = XMLReaderFactory.createXMLReader();
			SAXController handler = new SAXController();
			reader.setContentHandler(handler);
			reader.parse("input.xml");
		} catch (SAXException e) {
			System.err.print("ошибка SAX парсера " + e);
		} catch (IOException e) {
			System.err.print("ошибка I/О потока " + e);
		}
	}

    public void parse(boolean b) {
    }

    public Weapons getWeapons() {
    }
}