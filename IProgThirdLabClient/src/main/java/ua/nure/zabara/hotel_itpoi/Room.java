
package ua.nure.zabara.hotel_itpoi;

import javax.xml.bind.annotation.*;
import java.util.Set;


/**
 * <p>Java class for Room complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Room">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hired" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Room", propOrder = {
        "id",
        "rented",
        "stars",
        "staffamount",
        "barfridge",
        "price"
})
public class Room {

    @XmlAttribute(name = "id")
    protected int id;
    @XmlElement(required = true)
    protected String price;
    protected int stars;
    protected int staffamount;
    protected Set<Renter> rented;
    protected String barfridge;

    public Room(int id, String price, int stars, int staffamount, Set<Renter> rented, String barfridge) {
        super();
        this.id = id;
        this.price = price;
        this.stars = stars;
        this.staffamount = staffamount;
        this.rented = rented;
        this.barfridge = barfridge;
    }

    public Room() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getStaffamount() {
        return staffamount;
    }

    public void setStaffamount(int staffamount) {
        this.staffamount = staffamount;
    }

    public Set<Renter> getRented() {
        return rented;
    }

    public void setRented(Set<Renter> rented) {
        this.rented = rented;
    }

    public String isBarfridge() {
        return barfridge;
    }

    public void setBarfridge(String barfridge) {
        this.barfridge = barfridge;
    }
}
