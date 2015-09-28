package dev.jee6demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * http://localhost:8080/jaxrs-server/myresources/myapp
 * http://localhost:8080/jaxrs-server/myresources/myapp/myname/john
 * http://localhost:8080/jaxrs-server/myresources/myapp/myquery?var=aaa
 *
 */
@Path("/myapp")
public class Endpoint {

	@GET()
    @Produces("text/plain")
    public String sayHello() {
        return "Hello World!";
    }
	
    @GET
    @Produces("text/plain")
    @Path("myname/{name}")
    public String getEmployeelastname(@PathParam("name") String lastName) {
		return lastName;
    }
    @GET
    @Produces("text/plain")
    @Path("myquery")
    public String buscarPersonaClasico(@QueryParam("var")String var) {
    	return var;
    }

}
