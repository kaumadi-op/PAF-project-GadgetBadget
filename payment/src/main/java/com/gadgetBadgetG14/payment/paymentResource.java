package com.gadgetBadgetG14.payment;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/payments")
public class paymentResource {
	
	PaymentRepository pr = new PaymentRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayment() {	
		
		return pr.getAllPayments();
		
	}
	
	@POST
	@Path("/payment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment createPayment(Payment p1) {
	
		return pr.createPayment(p1);
	}
	
	
}
