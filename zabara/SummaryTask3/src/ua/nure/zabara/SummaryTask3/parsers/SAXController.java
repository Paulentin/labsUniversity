/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.zabara.SummaryTask3.parsers;

import ua.nure.zabara.SummaryTask3.classes.Weapons;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.zabara.SummaryTask3.settings.IFileParser;
import static ua.nure.zabara.SummaryTask3.settings.Settings.xmlFileName;

/**
 *
 * @author brainless
 */
public class SAXController extends DefaultHandler implements IFileParser {

    private String thisElement;
    private Commander commander;

    public SAXController() {
        commander = new Commander();
        thisElement = "";
    }

    @Override
    public void startDocument() {
    }

    @Override
    public void endDocument() {
    }

    @Override
    public void startElement(String namespaceURI, String localName, String QName, Attributes atts) throws SAXException {
        commander.startElement(namespaceURI, localName, QName, atts);
        thisElement = QName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String QName) throws SAXException {
        commander.endElement(namespaceURI, localName, QName);
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        commander.update(thisElement, String.copyValueOf(ch, start, length));
    }

    @Override
    public Weapons getWeapons() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse(xmlFileName, this);
        } catch (SAXException | ParserConfigurationException | IOException se) {
        }
        return commander.getWeapons();
    }
}
