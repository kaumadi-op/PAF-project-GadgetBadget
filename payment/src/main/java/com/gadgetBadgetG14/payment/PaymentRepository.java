package com.gadgetBadgetG14.payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

	List<Payment> payments;
	public PaymentRepository() {
		
		payments = new ArrayList<>();
		
		Payment p1 = new Payment();
		p1.setCardHolderName("Alwis");
		p1.setCardNumber(1234567891);
		p1.setCvv(123);
		p1.setExpDate(12);
		
		payments.add(p1);
	}
	
	public List<Payment> getAllPayments(){
		return payments;
	}
	
	public Payment createPayment(Payment p1) {
		payments.add(p1);
		System.out.println(payments);
		return p1;
	}
}
