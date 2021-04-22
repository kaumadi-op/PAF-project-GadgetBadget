

	package com;
	//For REST Service
	import javax.ws.rs.*;
    import javax.ws.rs.core.MediaType;
	//For JSON
	import com.google.gson.*;
	//For XML
	import org.jsoup.*;
	import org.jsoup.parser.*;
	import org.jsoup.nodes.Document;

	import model.Client;

    @Path("/Client")
	public class CustomerService {

		Client clientObj = new Client(); 
		
		@GET
		@Path("/") 
		@Produces(MediaType.TEXT_HTML) 
		public String readClient() 
		 { 
		 return clientObj.readClient(); 
		 }
		
		@POST
		@Path("/") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
		@Produces(MediaType.TEXT_PLAIN)
		public String insertClient(@FormParam("id") String id,
				@FormParam("fname") String fname, 
				 @FormParam("lname") String lname, 
				 @FormParam("NIC") String NIC, 
				 @FormParam("address") String address,
		         @FormParam("contactNumber") String contactNumber, 
	            @FormParam("email") String email,
	            @FormParam("username") String username,
	           @FormParam("password") String password) 

		
				{ 
				 String output = clientObj.insertClient(id,fname, lname, NIC,address,contactNumber,email,username,password); 
				return output; 
				}
		
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateClient(String clientData) 
		{ 
		//Convert the input string to a JSON object 
		 JsonObject clientObject = new JsonParser().parse(clientData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String id= clientObject.get("id").getAsString(); 
		 String fname = clientObject.get("fname").getAsString(); 
		 String lname = clientObject.get("lname").getAsString(); 
		 String NIC = clientObject.get("NIC").getAsString(); 
		 String address = clientObject.get("address").getAsString();
		 String contactNumber = clientObject.get("contactNumber").getAsString();
		 String email = clientObject.get("email").getAsString();
		 String username = clientObject.get("username").getAsString();
		 String password = clientObject.get("password").getAsString();
		 
		 String output =clientObj.updateClient(id,fname, lname, NIC,address,contactNumber,email,username,password); 
		return output; 
		}
		
		
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteClient(String clientData) 
		{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(clientData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <itemID>
		 String id = doc.select("id").text(); 
		 String output = clientObj.deleteClient(id); 
		return output; 
		}


	}


