
package server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.4
 * Thu Feb 11 15:07:28 EET 2016
 * Generated source version: 3.1.4
 */

@XmlRootElement(name = "updateRoomCountResponse", namespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateRoomCountResponse", namespace = "http://service.ua.nure.zabara.server.order.nure.ua/")

public class UpdateRoomCountResponse {

    @XmlElement(name = "return")
    private boolean _return;

    public boolean getReturn() {
        return this._return;
    }

    public void setReturn(boolean new_return)  {
        this._return = new_return;
    }

}

