package com.gadgetBadgetG14.payment;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PaymentRepository {
	public Connection getConnection() {
		
		Connection con = null;
		
		String url = "Jdbc:mysql://localhost:3307/paymentapi";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Successful");
		return con;
	}
	
	
	List<Payment> payments;
	public PaymentRepository() {
			
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
		
		Connection con = getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(insertSql);
			pst.setInt(1, p1.paymentId);
			pst.setInt(2, p1.amount);
			pst.setString(3, p1.payType);
			
			pst.executeUpdate();
			
			String output = "Inserted Successfully";
			
		}catch (Exception e) {
			System.out.println(e);
		}
		payments.add(p1);
		System.out.println(payments);
		return p1;
	}
	
	public Payment getpaymentId(int paymentId) {
		String getsql = "SELECT * FROM `payment` WHERE paymentId = '"+paymentId+"'";
		Payment pd = new Payment();
		Connection con = getConnection();
		
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(getsql);
			
			while(rs.next()) {
				
				pd.setPaymentId(rs.getInt(0));
				pd.setAmount(rs.getInt(1));
				pd.setPayType(rs.getString(2));
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}
	
	public String deletePayment(int paymentId) {
		
		String output = "";
		
		try {
			Connection con = getConnection();
			
			String deletePayment = "DELETE FROM `payment` WHERE paymentId = '"+paymentId+"' ";
			PreparedStatement pst = con.prepareStatement(deletePayment);
			pst.execute();
			
			output = "Successfully Deleted";
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public void updatePayment(Payment payment) {
		
		try {
			Connection con = getConnection();
			
			String updatePayment = "UPDATE `payment` SET `paymentID`='"+payment.getPaymentId()+"',`Amount`='"+payment.getAmount()+"',`paymentType`='"+payment.getPayType()+"' WHERE paymentID = '"+payment.getPaymentId()+"'";
			PreparedStatement st = con.prepareStatement(updatePayment);
			
			st.executeUpdate();
			
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
