
package ua.nure.zabara.lab;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RoomServiceClient", targetNamespace = "http://server.zabara.nure.ua/", wsdlLocation = "http://localhost:9000/RoomServiceClient?wsdl")
public class RoomServiceClient
    extends Service
{

    private final static URL TAXISERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException TAXISERVICESERVICE_EXCEPTION;
    private final static QName TAXISERVICESERVICE_QNAME = new QName("http://server.zabara.nure.ua/", "RoomServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9000/RoomService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TAXISERVICESERVICE_WSDL_LOCATION = url;
        TAXISERVICESERVICE_EXCEPTION = e;
    }

    public RoomServiceClient() {
        super(__getWsdlLocation(), TAXISERVICESERVICE_QNAME);
    }

    public RoomServiceClient(WebServiceFeature... features) {
        super(__getWsdlLocation(), TAXISERVICESERVICE_QNAME, features);
    }

    public RoomServiceClient(URL wsdlLocation) {
        super(wsdlLocation, TAXISERVICESERVICE_QNAME);
    }

    public RoomServiceClient(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TAXISERVICESERVICE_QNAME, features);
    }

    public RoomServiceClient(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RoomServiceClient(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HotelService
     */
    @WebEndpoint(name = "RoomServicePort")
    public TheService getProductServicePort() {
        return super.getPort(new QName("http://server.zabara.nure.ua/", "RoomServicePort"), TheService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HotelService
     */
    @WebEndpoint(name = "RoomServicePort")
    public TheService getProductServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.zabara.nure.ua/", "RoomServicePort"), TheService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TAXISERVICESERVICE_EXCEPTION!= null) {
            throw TAXISERVICESERVICE_EXCEPTION;
        }
        return TAXISERVICESERVICE_WSDL_LOCATION;
    }

}
