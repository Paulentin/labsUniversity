package parser.dom;

import hotel.entity.Hotel;
import hotel.entity.Renter;
import hotel.entity.Room;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.HotelUnmarshaller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DomUnmarshaller implements HotelUnmarshaller {

    private static final String BS_NS = "http://nure.ua/zabara/hotel";

    public static void main(String[] arg) {
        HotelUnmarshaller parser = new DomUnmarshaller();
        Hotel hotel = parser.unmarshal("src/main/resources/xml/hotel.xml");
        for (Room room : hotel.getRoomSet()) {
            System.out.println("Room: " + room.getId() + " " + "Stars: " + room.getStars() + " Price:" + room.getPrice());
        }
    }

    @Override
    public Hotel unmarshal(String filePath) {
        Hotel hotel = new Hotel();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            if (doc != null) {
                Element hotelRoomElement = doc.getDocumentElement();
                if (hotelRoomElement != null) {
                    NodeList roomNodeList = hotelRoomElement.getChildNodes();
                    for (int i = 0; i < roomNodeList.getLength(); i++) {
                        if (roomNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            Room room = parseRoom((Element) roomNodeList.item(i));
                            if (room != null) {
                                hotel.getRoomSet().add(room);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    private Room parseRoom(Element roomElement) {
        Room room = new Room();
        room.setId(Integer.parseInt(roomElement.getAttribute("id")));

        room.getWhorent().addAll(getRentors(roomElement, "rented"));

        room.setStars(
                Integer.parseInt(
                        getValue(roomElement, "stars")));
        room.setStaffAmount(
                Integer.parseInt(
                        getValue(roomElement, "staffAmount")));
        room.setBarFridge(
                Boolean.getBoolean(
                        getValue(roomElement, "barFridge")));
        room.setPrice(
                BigDecimal.valueOf(
                        Double.parseDouble(
                                getValue(roomElement, "price"))));
        return room;
    }

    private Set<Renter> getRentors(Element parent, String nodeName) {
        Set<Renter> renters = new HashSet<>();
        NodeList elements = parent.getElementsByTagNameNS(BS_NS, nodeName);

        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            if (node != null) {
                renters.add(
                        new Renter(
                                getValue(parent, "name"),
                                getValue(parent, "telNumber"),
                                Date.valueOf(getValue(parent, "dateStart")),
                                Date.valueOf(getValue(parent, "dateEnd"))));
            }
        }
        return renters;
    }

    private List<String> getValues(Element parent, String nodeName) {
        List<String> values = new ArrayList<>();
        NodeList elements = parent.getElementsByTagNameNS(BS_NS, nodeName);
        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            if (node != null) {
                values.add(node.getTextContent());
            } else {
                values.add("");
            }
        }
        return values;
    }

    private String getValue(Element parent, String nodeName) {
        return getValues(parent, nodeName).get(0);
    }
}

