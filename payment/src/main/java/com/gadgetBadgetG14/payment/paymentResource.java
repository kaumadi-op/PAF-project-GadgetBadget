package com.gadgetBadgetG14.payment;

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
	
	@GET
	@Path("/payment/{paymentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCities(@PathParam("paymentId") String paymentId) {   //***
		Payment res = new Payment();
		res = pr.getpaymentId(Integer.parseInt(paymentId));
		Gson test = new Gson();
		String jsonObject = test.toJson(res);
		return jsonObject;
		
	}
	
	@DELETE
	@Path("/deletePayment/{paymentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deletePayment(@PathParam("paymentId") int paymentId) {
		return pr.deletePayment(paymentId);
	}
	
	@PUT
	@Path("/updatePayment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(Payment payType) {
		return "Updated Successfully";
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayments() {	
		return pr.getAllPayments();
	} 
	
}
