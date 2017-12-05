package parser.dom;

import hotel.entity.Hotel;
import hotel.entity.Renter;
import hotel.entity.Room;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import parser.HotelMarshaller;
import parser.Util;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class DomMarshaller implements HotelMarshaller {

    private static final String BS_NS = "http://nure.ua/zabara/hotel";

    public static void main(String[] arg) throws IOException {
        HotelMarshaller parser = new DomMarshaller();
        parser.marshal(Util.createHotel(), "src/main/resources/xml/dom.xml");

    }

    @Override
    public void marshal(Hotel hotel, String filePath) throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(true);

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = sf.newSchema(new File("src/main/resources/xsd/hotel.xsd"));
            factory.setSchema(schema);
            factory.setNamespaceAware(true);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        try {
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element hotelElement = doc.createElementNS(BS_NS, "hotel");
            doc.appendChild(hotelElement);

            hotel.getRoomSet().forEach(room -> hotelElement.appendChild(getRoomElement(room, doc)));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private Element getRoomElement(Room room, Document doc) {
        Element roomOfHotel = doc.createElementNS(BS_NS, "room");
        roomOfHotel.setAttribute("id", String.valueOf(room.getId()));
        room.getWhorent().forEach(renter -> roomOfHotel.appendChild(getRenterElement(renter, doc)));
        roomOfHotel.appendChild(getSimpleElement(doc, BS_NS, "stars", room.getStars()));
        roomOfHotel.appendChild(getSimpleElement(doc, BS_NS, "staffAmount", room.getStaffAmount()));
        roomOfHotel.appendChild(getSimpleElement(doc, BS_NS, "barFridge", room.isBarFridge()));
        Double d = 0.0;
        if (room.getPrice() != null) {
            d = room.getPrice().doubleValue();
        }
        roomOfHotel.appendChild(getSimpleElement(doc, BS_NS, "price", d));
        return roomOfHotel;
    }

    private Element getSimpleElement(Document doc, String ns, String tagName, Object value) {
        Element element = doc.createElementNS(ns, tagName);
        element.setTextContent(String.valueOf(value));
        return element;
    }

    private Element getRenterElement(Renter renter, Document doc) {
        Element renterOfRoom = doc.createElementNS(BS_NS, "rented");
        renterOfRoom.appendChild(getSimpleElement(doc, BS_NS, "name", renter.getName()));
        renterOfRoom.appendChild(getSimpleElement(doc, BS_NS, "telNumber", renter.getTelNumber()));
        renterOfRoom.appendChild(getSimpleElement(doc, BS_NS, "dateStart", renter.getStartDate().toLocalDate()));
        renterOfRoom.appendChild(getSimpleElement(doc, BS_NS, "dateEnd", renter.getEndDate()));

        return renterOfRoom;
    }

}