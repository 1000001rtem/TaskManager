package ru.eremin.tm.server.endpoint;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.2.3
 * 2019-05-08T18:07:28.886+03:00
 * Generated source version: 3.2.3
 */
@WebServiceClient(name = "SessionEndpointService",
        wsdlLocation = "http://localhost:80/SessionEndpoint?WSDL",
        targetNamespace = "http://endpoint.server.tm.eremin.ru/")
public class SessionEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.server.tm.eremin.ru/", "SessionEndpointService");
    public final static QName SessionEndpointPort = new QName("http://endpoint.server.tm.eremin.ru/", "SessionEndpointPort");

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:80/SessionEndpoint?WSDL");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SessionEndpointService.class.getName())
                    .log(java.util.logging.Level.INFO,
                            "Can not initialize the default wsdl from {0}", "http://localhost:80/SessionEndpoint?WSDL");
        }
        WSDL_LOCATION = url;
    }

    public SessionEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SessionEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SessionEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public SessionEndpointService(WebServiceFeature... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SessionEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SessionEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }


    /**
     * @return returns SessionEndpoint
     */
    @WebEndpoint(name = "SessionEndpointPort")
    public SessionEndpoint getSessionEndpointPort() {
        return super.getPort(SessionEndpointPort, SessionEndpoint.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns SessionEndpoint
     */
    @WebEndpoint(name = "SessionEndpointPort")
    public SessionEndpoint getSessionEndpointPort(WebServiceFeature... features) {
        return super.getPort(SessionEndpointPort, SessionEndpoint.class, features);
    }

}
