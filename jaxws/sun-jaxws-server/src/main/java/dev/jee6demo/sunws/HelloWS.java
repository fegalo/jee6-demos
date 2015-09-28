package dev.jee6demo.sunws;
 
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
 
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloWS {
    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name="name") String name){
        return "Hello "+ name;
    }
}