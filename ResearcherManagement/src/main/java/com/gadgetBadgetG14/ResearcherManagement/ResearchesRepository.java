package com.gadgetBadgetG14.ResearcherManagement;

import java.util.ArrayList;
import java.util.List;



import java.sql.*;

public class ResearchesRepository {
	
	public Connection getconnection() {
		Connection con = null;
		String url = "Jdbc:mysql://localhost:3306/researchmanagement";
		String username = "root";
		String password = "";

		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
		System.out.println(e);
		}
		System.out.println("success");
		return con;
		}
	
	List<AddResearches> researches;

	public ResearchesRepository() {
		
		Connection con = getconnection();
		
		researches = new ArrayList<>();
		
		AddResearches r1 = new AddResearches();
		r1.setResearcherid(1);
		r1.setName("Senal Wijesiri");
		r1.setContactno("0771452391");
		r1.setEmail("senalwijesiri98@gmail.com");
		
		AddResearches r2 = new AddResearches();
		r2.setResearcherid(2);
		r2.setName("Ravish Gomes");
		r2.setContactno("0760217991");
		r2.setEmail("ravishgomes@gmail.com");
		
		AddResearches r3 = new AddResearches();
		r3.setResearcherid(3);
		r3.setName("Sumudu Sampath");
		r3.setContactno("0712305564");
		r3.setEmail("sumudusampath@gmail.com");
		
		researches.add(r1);
		researches.add(r2);
		researches.add(r3);
		
	}
	
	public List<AddResearches> getAllAddResearches(){
		return researches;
	}
	
	public AddResearches createAddResearches(AddResearches r1) {
		String insertSql = "INSERT INTO `researches`(`researcherid`, `Name`, `ContactNo`, `Email`) VALUES (?,?,?,?)";
		Connection con = getconnection();
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, r1.researcherid);
			st.setString(2,r1.name);
			st.setString(3,r1.contactno);
			st.setString(4,r1.email);
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		researches.add(r1);
		System.out.println(researches);
		return r1;
	}
	public AddResearches getresearcherid(int researcherid) {
		String getsql = "SELECT * FROM `researches` WHERE researcherid = '"+researcherid+"' ";
		AddResearches ud = new AddResearches();
		Connection con = getconnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet r1 = st.executeQuery(getsql);
			
			while(r1.next()) {
				
				ud.setResearcherid(r1.getInt(1));
				ud.setName(r1.getString(2));
				ud.setContactno(r1.getString(4));
				ud.setEmail(r1.getString(5));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ud;

		
	}
	public String deleteAddResearches(int researcherid) {
		String output = "";
		try {
			Connection con = getconnection();
			
			String deleteAddResearches = "DELETE FROM researches WHERE researcherid = '"+researcherid+"'";
			PreparedStatement ps = con.prepareStatement(deleteAddResearches);
			ps.execute();
			
			output = "Delete Successful";
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	public String updateAddResearches(AddResearches researches) {
		
		String output ="";
		
		try {
			Connection con = getconnection();
			
			String updateAddResearches = "UPDATE `researches` SET `researcherid`='"+ researches.getResearcherid()+"',Name='"+ researches.getName()+"',ContactNo='"+ researches.getContactno()+"',Email='"+ researches.getEmail()+"' WHERE researcherid='"+researches.getResearcherid()+"'";
			//UPDATE `researches` SET `researcherid`='"+ researches.getResearcherid()+"',Name='"+ researches.getName()+'",ContactNo='"+ researches.getContactno()+"Email='"+researches.getEmail()+"' WHERE researcherid='"+researches.getResearcherid()+"'";
			PreparedStatement st = con.prepareStatement(updateAddResearches);
			
			
			
			st.executeUpdate();
			output = "Update Successfully";
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return output;
		
	}
	public String readAddResearches() {
		String output = "";
		
		try {
			//connect to DB
			Connection con = getconnection();
			
			if (con == null)
			{return "Error while connecting to the database for reading."; }
			output = "<table border='1'><tr><th>Researcher ID</th><th>Researcher Name</th><th>ContactNo</th><th>Email</th>" +
			"<th>Update</th><th>Remove</th></tr>";	
			String query = "SELECT * FROM `researches`";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			//iterate through the rows in the result set
			while (rs.next())
			{
				String researcherid = Integer.toString(rs.getInt("researcherid"));
				String name = rs.getString("Name");
				String contactno = rs.getString("ContactNo");
				String email = rs.getString("Email");
				
				//Add into the html table
				
				output +="<tr><td>" + researcherid + "</td>";
				output +="<td>" + name + "</td>";
				output +="<td>" + contactno + "</td>";
				output +="<td>" + email + "</td>";
				
				//buttons
				
				output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
				+ "<td><form method='post' action='items.jsp'>"	
				+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
				+ "<input name='itemID' type='hidden' value='" + researcherid + "'>" + "</form></td></tr>";
										
			}
			//close th db connection
			con.close();
			
			//complete the html table
				output += "</table>";
		}
		catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
}
