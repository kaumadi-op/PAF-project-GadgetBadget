package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Client {

	
	//A common method to connect to the DB
		private Connection connect() 
		 { 
		 Connection con = null; 
		 try
		 { 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 
		 //Provide the correct details: DBServer/DBName, username, password 
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/buyer? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", ""); 
		 } 
		 catch (Exception e) 
		 {e.printStackTrace();} 
		 return con; 
		 } 
		public String insertClient( String id,String fname, String lname, String NIC, String address, String contactNumber,String email, String username, String password) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for inserting."; } 
		 // create a prepared statement
		 String query = " insert into client (`id`,`fname`,`lname`,`NIC`,`address`,`contactNumber`,`email`,`username`,`password`)"
		 + " values (?, ?, ?, ?, ?,?,?,?,?)"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 //preparedStmt.setInt(1, 0); 
		preparedStmt.setString(1, id); 
		 preparedStmt.setString(2, fname); 
		 preparedStmt.setString(3, lname); 
		 preparedStmt.setString(4, NIC); 
		 preparedStmt.setString(5, address);
		 preparedStmt.setString(6, contactNumber);
		 preparedStmt.setString(7,  email);
		 preparedStmt.setString(8, username);
		 preparedStmt.setString(9, password);
		 
		// execute the statement3
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Inserted successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while inserting the client."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String readClient() 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for reading."; } 
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>fname</th><th>lname</th>" +
		 "<th>NIC</th>" + 
		 "<th>address</th>" +"<th>contactNumber</th>" +"<th>email</th>" +"<th>username</th>" +"<th>password</th>" +
		 "<th>Update</th><th>Remove</th></tr>"; 
		 
		 String query = "select * from client"; 
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query); 
		 // iterate through the rows in the result set
		 while (rs.next()) 
		 { 
		 String id = Integer.toString(rs.getInt("id")); 
		 String fname = rs.getString("fname"); 
		 String lname = rs.getString("lname"); 
		 String NIC = rs.getString("NIC"); 
		 String address = rs.getString("address"); 
		 String contactNumber = rs.getString("contactNumber"); 
		 String email = rs.getString("email"); 
		 String username = rs.getString("username"); 
		 String password = rs.getString("password"); 
		 
		 
		 // Add into the html table
		// output += "<tr><td>" + id + "</td>"; 
		 output += "<td>" + fname + "</td>"; 
		 output += "<td>" + lname + "</td>"; 
		 output += "<td>" + NIC + "</td>"; 
		 output += "<td>" + address + "</td>"; 
		 output += "<td>" + contactNumber + "</td>"; 
		 output += "<td>" +  email + "</td>"; 
		 output += "<td>" + username + "</td>"; 
		 output += "<td>" + password + "</td>"; 
		
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>" + "<td><form method='post' action='Client.java'>  "
		 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>" + "<input name='id' type='hidden' value='" + id  + "'>" + "</form></td></tr>";  } 
		 con.close(); 
		 // Complete the html table
		 output += "</table>"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while reading the client."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String updateClient(String id, String fname, String lname,String NIC, String address, String contactNumber,String email, String username, String password)
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 // create a prepared statement
		 String query = "UPDATE client SET fname=?,lname=?,NIC=?,address=?,contactNumber=?,email=?,username=?,password=?  WHERE id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values

		
		 preparedStmt.setString(1, fname); 
		 preparedStmt.setString(2, lname); 
		 preparedStmt.setString(3, NIC); 
		 preparedStmt.setString(4, address);
		 preparedStmt.setString(5, contactNumber);
		 preparedStmt.setString(6,  email);
		 preparedStmt.setString(7, username);
		 preparedStmt.setString(8, password);
		 preparedStmt.setInt(9, Integer.parseInt(id));
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while updating the client."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String deleteClient(String id) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for deleting."; } 
		 // create a prepared statement
		 String query = "delete from client where id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(id)); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Deleted successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while deleting the client."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
}
