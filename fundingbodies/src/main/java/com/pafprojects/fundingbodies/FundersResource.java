package com.pafprojects.fundingbodies;


import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/funder")
public class FundersResource {
	
	FunderRepository sr = new FunderRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funders> getAllFunders()
	{
			
		return sr.getAllFunders();
		
	}
	@POST
	@Path("/funders")
	@Consumes(MediaType.APPLICATION_JSON)
	public Funders createFunders(Funders f1) {
	
	return sr.createFunders(f1);
	}
	
}















