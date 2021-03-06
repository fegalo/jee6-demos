
package dev.jee6demo.sunwsgen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.5-b03-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "HelloWS", targetNamespace = "http://sunws.jee6demo.dev/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWS {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String sayHello(
        @WebParam(name = "name", partName = "name")
        String name);

}
