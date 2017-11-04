/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.zabara.SummaryTask3.parsers;

import ua.nure.zabara.SummaryTask3.classes.Weapons;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import ua.nure.zabara.SummaryTask3.settings.IFileParser;
import static ua.nure.zabara.SummaryTask3.settings.Settings.ID;
import static ua.nure.zabara.SummaryTask3.settings.Settings.xmlFileName;

/**
 *
 * @author paulentin
 */
public class StAXController implements IFileParser {

    private Commander commander;

    public StAXController() {
        commander = new Commander();
    }

    @Override
    public Weapons getWeapons() {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(xmlFileName);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    commander.startElement("", "", startElement.getName().toString(), null);
                    if (startElement.getAttributeByName(new QName(ID)) != null) {
                        commander.update(ID, startElement.getAttributeByName(new QName(ID)).getValue());
                    }
                    String tag = event.asStartElement().getName().getLocalPart();
                    event = eventReader.nextEvent();
                    commander.update(tag, event.asCharacters().getData());
                    continue;
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    commander.endElement("", "", endElement.getName().getLocalPart());
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
        }
        return commander.getWeapons();
    }
}
