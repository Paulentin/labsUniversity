package ua.nure.zabara.SummaryTask3.classes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Weapons", propOrder = {
    "knife"
})
public class Weapons {

    @XmlElement(required = true)
    protected List<KnifeType> knife;

    public List<KnifeType> getKnife() {
        if (knife == null) {
            knife = new ArrayList<>();
        }
        return this.knife;
    }

    public void setKnife(List<KnifeType> knife) {
        this.knife = knife;
    }

    @Override
    public String toString() {
        String result = "knifes :\n";
        for (KnifeType kn : getKnife()) {
            result = result + kn + "\n";
        }
        return result;
    }
}
