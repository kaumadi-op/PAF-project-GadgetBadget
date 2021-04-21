package com.gadgetBadgetG14.payment;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PaymentRepository {

	Connection con = null;
	
	List<Payment> payments;
	public PaymentRepository() {
		
		String url = "Jdbc:mysql://localhost:3307/paymentapi";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		payments = new ArrayList<>();
		
		Payment p1 = new Payment();
		p1.setPaymentId(123);
		p1.setAmount(5000);
		p1.setPayType("Cash");
		
		payments.add(p1);
	}
	
	public List<Payment> getAllPayments(){
		return payments;
	}
	
	public Payment createPayment(Payment p1) {
		
		String insertSql = "INSERT INTO `payment`(`paymentID`, `Amount`, `paymentType`) VALUES (?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, p1.paymentId);
			st.setInt(2, p1.amount);
			st.setString(3, p1.payType);
			
			st.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		payments.add(p1);
		System.out.println(payments);
		return p1;
	}
}
