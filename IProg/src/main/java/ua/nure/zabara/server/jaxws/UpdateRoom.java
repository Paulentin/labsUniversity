
package server.jaxws;

import hotel.entity.Room;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.4
 * Thu Feb 11 15:07:28 EET 2016
 * Generated source version: 3.1.4
 */

@XmlRootElement(name = "updateRoom", namespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateRoom", namespace = "http://service.ua.nure.zabara.server.order.nure.ua/")

public class UpdateRoom {

    @XmlElement(name = "Room")
    private Room room;

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room newRoom)  {
        this.room = newRoom;
    }

}

