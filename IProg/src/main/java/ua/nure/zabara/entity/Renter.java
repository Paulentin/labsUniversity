package ua.nure.zabara.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;
import java.util.Objects;
    @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Renter", propOrder = {
        "name",
        "telNumber",
        "dateStart",
        "dateEnd",
})
public class Renter {
    private String name;
    private String telNumber;
    private long dateStart;
    private long dateEnd;

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
        this.dateEnd = dateEnd.getTime()     ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Renter renter = (Renter) o;
        return Objects.equals(dateStart, renter.dateStart) &&
                Objects.equals(dateEnd, renter.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd);
    }

        @Override
        public String toString() {
            return "Renter{" +
                    "name='" + name + '\'' +
                    ", telNumber='" + telNumber + '\'' +
                    ", dateStart=" + dateStart +
                    ", dateEnd=" + dateEnd +
                    '}';
        }
    }
