package ua.nure.zabara.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class Visuality {

    int width;
    int length;
    String material;
    boolean bloodGoing;


    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
class WoodenHandle extends Visuality{

    @XmlAttribute(name = "woodType", required = true)
    String woodType;


    public void setMaterial() {
        this.material = "wooden";
    }
    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }
}


class NotWoodenHandle extends Visuality{

}

