package com.gadgetBadgetG14.ResearcherManagement;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/researches")
public class ResearchesResource {
	
	ResearchesRepository sr = new ResearchesRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AddResearches> getAllResearches() {
		
		return sr.getAllAddResearches();
		
		
		//List<AddResearches> researches = new ArrayList<AddResearches>();
		
		//AddResearches r1 = new AddResearches();
		//r1.setResearcherid(1);
		//r1.setName("Senal Wijesiri");
		//r1.setContactno("0771452391");
		//r1.setEmail("senalwijesiri98@gmail.com");
		
		//AddResearches r2 = new AddResearches();
		//r2.setResearcherid(2);
		//r2.setName("Ravish Gomes");
		//r2.setContactno("0760217991");
		//r2.setEmail("ravishgomes@gmail.com");
		
		//AddResearches r3 = new AddResearches();
		//r3.setResearcherid(3);
		//r3.setName("Sumudu Sampath");
		//r3.setContactno("0712305564");
		//r3.setEmail("sumudusampath@gmail.com");
		
		//researches.add(r1);
		//researches.add(r2);
		//researches.add(r3);
		
	
	}
	
	@POST
	@Path("/research")
	@Consumes(MediaType.APPLICATION_JSON)
	public AddResearches createAddResearches(AddResearches r1) {	
		
		return sr.createAddResearches(r1);
	}
	
	@GET
	@Path("/researcher/{researcherid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResearcher(@PathParam("researcherid") String researcherid) {
		AddResearches res = new AddResearches();
		res = sr.getresearcherid(Integer.parseInt(researcherid));
		Gson test = new Gson();
		String jsonObject = test.toJson(res);
		return jsonObject;
	}
	@DELETE
	@Path("/deleteAddResearches/{researcherid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProduct(@PathParam("researcherid") int researcherid) {
		return sr.deleteAddResearches(researcherid);
	}
	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProduct(AddResearches product) 
	{ 
	// cr.updateCustomer(product); 
	 return "Updated";
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AddResearches> getallcustomer(){
		return sr.getAllAddResearches();
	}
}


