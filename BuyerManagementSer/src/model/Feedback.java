package model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Feedback {

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
			public String insertFeedback(String fedID, String name, String contactNo, String email, String comment, String ratetype) 
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 {return "Error while connecting to the database for inserting."; } 
			 // create a prepared statement
			 String query = " insert into feedback (`fedID`,`name`,`contactNo`,`email`,`comment`,`ratetype`)"
			 + " values (?,?,?,?,?,?)"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			// preparedStmt.setInt(1, 0); 
			preparedStmt.setString(1, fedID); 
			 preparedStmt.setString(2, name); 
			 preparedStmt.setString(3, contactNo); 
			 preparedStmt.setString(4,  email);
			 preparedStmt.setString(5, comment);
			 preparedStmt.setString(6, ratetype);
			 
			 
			// execute the statement3
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Inserted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "Error while inserting the feedback."; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
			public String readFeedback() 
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 {return "Error while connecting to the database for reading."; } 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>name</th><th>contactNo</th>" +
			 "<th>email</th>" + 
			 "<th>comment</th>" +"<th>ratetype</th>" +
			 "<th>Update</th><th>Remove</th></tr>"; 
			 
			 String query = "select * from feedback"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 String fedID = Integer.toString(rs.getInt("fedID"));
			 String name = rs.getString("name"); 
			 String contactNo= rs.getString("contactNo");
			 String email = rs.getString("email"); 
			 String comment = rs.getString("comment"); 
			 String ratetype = rs.getString("ratetype"); 
			 
			 
			 
			 // Add into the html table
			
			 output += "<td>" + name + "</td>"; 
			 output += "<td>" + contactNo + "</td>"; 
			 output += "<td>" + email + "</td>"; 
			 output += "<td>" + comment + "</td>"; 
			 output += "<td>" + ratetype + "</td>"; 
			
			 // buttons
			 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>" + "<td><form method='post' action='feedback1.jsp'>  "
			 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>" + "<input name='fedID' type='hidden' value='" + fedID  + "'>" + "</form></td></tr>";  } 
			 con.close(); 
			 // Complete the html table
			 output += "</table>"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "Error while reading the feedback."; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
			public String updateFeedback(String fedID, String name,String contactNo, String email, String comment, String ratetype)
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 {return "Error while connecting to the database for updating."; } 
			 // create a prepared statement
			 String query = "UPDATE feedback SET name=?,contactNo=?,email=?,comment=?,ratetype=?  WHERE fedID=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values

			
			 preparedStmt.setString(1, name); 
			 preparedStmt.setString(2, contactNo); 
			 preparedStmt.setString(3, email); 
			 preparedStmt.setString(4, comment);
			 preparedStmt.setString(5, ratetype);
			preparedStmt.setInt(6, Integer.parseInt(fedID)); 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Updated successfully"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "Error while updating the feedback."; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
			public String deleteFeedback(String fedID) 
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 {return "Error while connecting to the database for deleting."; } 
			 // create a prepared statement
			 String query = "delete from feedback where fedID=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(fedID));  // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Deleted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "Error while deleting the feedback."; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 }
			 
}
