
package dev.jee6demo.sunwsgen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.5-b03-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HelloWSService", targetNamespace = "http://sunws.jee6demo.dev/", wsdlLocation = "http://localhost:8080/sun-jaxws-server/HelloWS?wsdl")
public class HelloWSService
    extends Service
{

    private final static URL HELLOWSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(dev.jee6demo.sunwsgen.HelloWSService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = dev.jee6demo.sunwsgen.HelloWSService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/sun-jaxws-server/HelloWS?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/sun-jaxws-server/HelloWS?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        HELLOWSSERVICE_WSDL_LOCATION = url;
    }

    public HelloWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWSService() {
        super(HELLOWSSERVICE_WSDL_LOCATION, new QName("http://sunws.jee6demo.dev/", "HelloWSService"));
    }

    /**
     * 
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSPort")
    public HelloWS getHelloWSPort() {
        return super.getPort(new QName("http://sunws.jee6demo.dev/", "HelloWSPort"), HelloWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSPort")
    public HelloWS getHelloWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://sunws.jee6demo.dev/", "HelloWSPort"), HelloWS.class, features);
    }

}
