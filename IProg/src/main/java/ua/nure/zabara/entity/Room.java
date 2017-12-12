package ua.nure.zabara.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Room", propOrder = {
        "id",
        "rented",
        "stars",
        "staffAmount",
        "barfridge",
        "price"
})
public class Room {
    private int id;
    private int stars;
    private int staffAmount;
    private BigDecimal price;
    private String barfridge;
    private Set<Renter> rented;

    public Room() {
        this.rented = new HashSet<>();
    }

    public Room(int id, int stars, int stuffAmount) {
        this.id = id;
        this.stars = stars;
        this.staffAmount = stuffAmount;
        this.rented = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getStaffAmount() {
        return staffAmount;
    }

    public void setStaffAmount(int staffAmount) {
        this.staffAmount = staffAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String isBarfridge() {
        return barfridge;
    }

    public void setBarfridge(String barfridge) {
        this.barfridge = barfridge;
    }

    public Set<Renter> getRented() {
        return rented;
    }


    public boolean addRenter(Renter u) {
        return rented.add(u);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Room room = (Room) o;
        return id == room.id &&
                stars == room.stars &&
                Objects.equals(rented, room.rented);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stars, rented);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", stars=" + stars +
                ", staffAmount=" + staffAmount +
                ", price=" + price +
                ", barfridge='" + barfridge +
                getRentersString()+
                '}';
    }

    private String getRentersString() {
        StringBuilder sb = new StringBuilder();
        for (Renter renter : rented) {
            sb.append(renter.toString());
        }
        return sb.toString();
    }
}

