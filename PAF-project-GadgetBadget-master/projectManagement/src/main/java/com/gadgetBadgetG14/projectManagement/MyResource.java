package com.gadgetBadgetG14.projectManagement;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/** 

@SpringBootApplication

*/


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }
    
    /**
    @RequestMapping("/")
    public String ptojectRes() {
    	JSONObject jsonobject = new JSONObject();
    	jsonobject.put("message","Hello World");
    	return JSONObject.toString();


    }
    
    public static void main (String[] args) {
    	String.Application.run(Application.class, args);
    
    }
    
    */
}
