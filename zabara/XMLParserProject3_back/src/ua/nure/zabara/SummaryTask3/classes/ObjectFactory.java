package ua.nure.zabara.SummaryTask3.classes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Weapons_QNAME = new QName("", "weapons");
    private final static QName _Knife_QNAME = new QName("", "knife");

    public ObjectFactory() {
    }

    public Weapons createWeapons() {
        return new Weapons();
    }

    public KnifeType createKnifeType() {
        return new KnifeType();
    }

    public VisualType createVisualType() {
        return new VisualType();
    }

    @XmlElementDecl(namespace = "", name = "weapons")
    public JAXBElement<Weapons> createWeapons(Weapons value) {
        return new JAXBElement<Weapons>(_Weapons_QNAME, Weapons.class, null, value);
    }

    @XmlElementDecl(namespace = "", name = "knife")
    public JAXBElement<KnifeType> createKnife(KnifeType value) {
        return new JAXBElement<KnifeType>(_Knife_QNAME, KnifeType.class, null, value);
    }
}
