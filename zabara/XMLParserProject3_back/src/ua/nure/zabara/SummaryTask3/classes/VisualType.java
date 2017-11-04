package ua.nure.zabara.SummaryTask3.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualType", propOrder = {
    "length",
    "width",
    "handle",
    "bloodsink"
})
public class VisualType {

    protected double length;
    protected double width;
    @XmlElement(required = true)
    protected String handle;
    protected boolean bloodsink;

    public double getLength() {
        return length;
    }

    public void setLength(double value) {
        this.length = value;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        this.width = value;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String value) {
        this.handle = value;
    }

    public boolean isBloodsink() {
        return bloodsink;
    }

    public void setBloodsink(boolean value) {
        this.bloodsink = value;
    }

    @Override
    public String toString() {
        String result = "visuals:";
        result = result + "\n\t" + handle + "\n\t" + length + "\n\t" + width + "\n\t" + bloodsink;
        return result;
    }
}
