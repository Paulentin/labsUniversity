package ua.nure.zabara.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel", propOrder = {
        "room"
})
@XmlRootElement(name = "hotel")
public class Hotel {
    private Set<Room> room;

    public Hotel() {

        this(new HashSet<>(Arrays.asList(
                new Room(1, 5, 3),
                new Room(2, 3, 2))));
    }

    public Hotel(Set<Room> room) {
        this.room = room;
    }

    public Set<Room> getRooms() {
        return room;
    }

    public void setRooms(Set<Room> roomList) {
        this.room = roomList;
    }

    public void addRoom(Room room) {
        this.room.add(room);
    }

    public void removeRoom(Room room) {
        this.room.remove(room);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Hotel hotel = (Hotel) o;
        return Objects.equals(room, hotel.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room);
    }
}
