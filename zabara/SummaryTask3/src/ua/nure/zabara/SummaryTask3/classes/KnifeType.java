package ua.nure.zabara.SummaryTask3.classes;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnifeType", propOrder = {
    "type",
    "handy",
    "visual",
    "value"
})
public class KnifeType {

    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String handy;
    @XmlElement(required = true)
    protected VisualType visual;
    protected boolean value;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getHandy() {
        return handy;
    }

    public void setHandy(String value) {
        this.handy = value;
    }

    public VisualType getVisual() {
        return visual;
    }

    public void setVisual(VisualType value) {
        this.visual = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    @Override
    public String toString() {
        String result = "knife:";
        result = result + " id: " + id + "\n" + handy + "\n" + type + "\n" + value + "\n" + visual;
        return result;
    }
}
