package hotel.entity;

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
    private Set<Room> roomSet;

    public Hotel() {

        this(new HashSet<>(Arrays.asList(
                new Room(1, 5, 3),
                new Room(2, 3, 2))));
    }

    public Hotel(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomList) {
        this.roomSet = roomList;
    }

    public void addRoom(Room room) {
        roomSet.add(room);
    }

    public void removeRoom(Room room) {
        roomSet.remove(room);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Hotel hotel = (Hotel) o;
        return Objects.equals(roomSet, hotel.roomSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomSet);
    }
}
