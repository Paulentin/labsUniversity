/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.zabara.SummaryTask3.parsers;

import ua.nure.zabara.SummaryTask3.classes.KnifeType;
import ua.nure.zabara.SummaryTask3.classes.VisualType;
import ua.nure.zabara.SummaryTask3.classes.Weapons;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import static ua.nure.zabara.SummaryTask3.settings.Settings.*;

/**
 *
 * @author paulentin
 */
public class Commander {

    private Weapons weapons;
    private KnifeType knife;
    private List<KnifeType> knifes;
    private VisualType visual;

    public Commander() {
        knifes = new ArrayList<>();
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public boolean update(String QName, String value) {
        if (QName.equalsIgnoreCase(TYPE)) {
            knife.setType(value);
        } else if (QName.equalsIgnoreCase(VALUE)) {
            knife.setValue(Boolean.parseBoolean(value));
        } else if (QName.equalsIgnoreCase(HANDY)) {
            knife.setHandy(value);
        } else if (QName.equalsIgnoreCase(LENGTH)) {
            visual.setLength(Double.parseDouble(value));
        } else if (QName.equalsIgnoreCase(WIDTH)) {
            visual.setWidth(Double.parseDouble(value));
        } else if (QName.equalsIgnoreCase(HANDLE)) {
            visual.setHandle(value);
        } else if (QName.equalsIgnoreCase(BLOODSINK)) {
            visual.setBloodsink(Boolean.parseBoolean(value));
        } else if (QName.equalsIgnoreCase(ID)) {
            knife.setId(value);
        } else {
            return false;
        }
        return true;
    }

    public boolean startElement(String namespaceURI, String localName, String QName, Attributes atts) {
        if (QName.equalsIgnoreCase(WEAPONS)) {
            weapons = new Weapons();
        } else if (QName.equalsIgnoreCase(KNIFE)) {
            knife = new KnifeType();
            if (atts != null) {
                knife.setId(atts.getValue(ID));
            }
        } else if (QName.equalsIgnoreCase(VISUAL)) {
            visual = new VisualType();
        } else {
            return false;
        }
        return true;
    }

    public boolean endElement(String namespaceURI, String localName, String QName) {
        if (QName.equalsIgnoreCase(WEAPONS)) {
            weapons.setKnife(knifes);
        } else if (QName.equalsIgnoreCase(KNIFE)) {
            knifes.add(knife);
        } else if (QName.equalsIgnoreCase(VISUAL)) {
            knife.setVisual(visual);
        } else {
            return false;
        }
        return true;
    }
}
