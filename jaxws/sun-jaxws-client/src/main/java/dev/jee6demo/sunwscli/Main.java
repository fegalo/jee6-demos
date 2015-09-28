package dev.jee6demo.sunwscli;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import dev.jee6demo.sunwsgen.*;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		String url="http://localhost:8080/sun-jaxws-server/HelloWS?WSDL";
		HelloWSService helloWebServiceService =new HelloWSService(
				new URL(url),
				new QName("http://sunws.jee6demo.dev/", "HelloWSService"));
		
		HelloWS helloWebService = helloWebServiceService.getHelloWSPort();
		String response=helloWebService.sayHello("John");
		
		System.out.println(response);

	}

}
