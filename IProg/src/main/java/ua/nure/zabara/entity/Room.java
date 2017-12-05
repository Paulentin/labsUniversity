package hotel.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Room", propOrder = {
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
    private boolean barFridge;
    private Set<Renter> whorent;

    public Room() {
        this.whorent = new HashSet<>();
    }

    public Room(int id, int stars, int stuffAmount) {
        this.id = id;
        this.stars = stars;
        this.staffAmount = stuffAmount;
        this.whorent = new HashSet<>();
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

    public boolean isBarFridge() {
        return barFridge;
    }

    public void setBarFridge(boolean barFridge) {
        this.barFridge = barFridge;
    }

    public Set<Renter> getWhorent() {
        return whorent;
    }


    public boolean addRenter(Renter u) {
        return whorent.add(u);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Room room = (Room) o;
        return id == room.id &&
                stars == room.stars &&
                Objects.equals(whorent, room.whorent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stars, whorent);
    }
}

