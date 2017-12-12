
package ua.nure.zabara.hotel_itpoi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;
import java.util.Objects;


/**
 * <p>Java class for Renter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Renter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="blacklist" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Renter", propOrder = {
    "name",
    "telNumber",
    "dateStart",
    "dateEnd"
})
public class Renter {

    @XmlElement(required = true)
    protected String name;
    protected String telNumber;
    protected long dateStart;
    protected long dateEnd;

    public Renter() {
    }

    public Renter(String name, String telNumber, Date dateStart, Date dateEnd) {
        this.name = name;
        this.telNumber = telNumber;
        this.dateStart = dateStart.getTime();
        this.dateEnd = dateEnd.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public long getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart.getTime();
    }

    public long getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Renter renter = (Renter) o;
        return Objects.equals(name, renter.name) &&
                Objects.equals(telNumber, renter.telNumber) &&
                Objects.equals(dateStart, renter.dateStart) &&
                Objects.equals(dateEnd, renter.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, telNumber, dateStart, dateEnd);
    }
}
