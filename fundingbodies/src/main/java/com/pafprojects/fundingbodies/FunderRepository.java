package com.pafprojects.fundingbodies;

import java.util.ArrayList;
import java.util.List;


import java.sql.*;

public class FunderRepository {
	
	Connection con = null;
	List<Funders> funders;

	public FunderRepository() {
		
		String url = "Jdbc:mysql://localhost:3306/fundingbodies";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			System.out.println(e);
			
		}
		
	funders = new ArrayList<>();
	
	Funders f1 = new Funders();
	f1.setName("Kithmi");
	f1.setEmail("123@gmail.com");
	f1.setId(1);
	
	Funders f2 = new Funders();
	f2.setName("Kaumadi");
	f2.setEmail("1234@gmail.com");
	f2.setId(2);
	
	Funders f3 = new Funders();
	f3.setName("Isuri");
	f3.setEmail("12345@gmail.com");
	f3.setId(3);
	
	 funders.add(f1);
	 funders.add(f2);
	 funders.add(f3);
	
	}
	public List<Funders> getAllFunders(){
		return funders;
	}
	public Funders createFunders(Funders f1) {
		String insertSql = "INSERT INTO `funders`(`id`, `name`, `email`) VALUES (?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, f1.id);
			st.setString(2, f1.name);
			st.setString(3, f1.email);
			
			st.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
			
			
		}	
		
		funders.add(f1);
		System.out.println(funders);
		return f1;
	}
	public Funders getfundersid(int id)
	{
		
		String getsql = "select * from funders where id = '"+id+"' ";
		Funders cd = new Funders();
		Connection con = getconnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet f1 = st.executeQuery(getsql);
			
			while(f1.next()) {
				
				cd.setId(f1.getInt(1));
				cd.setName(f1.getString(2));
				cd.setEmail(f1.getString(3));
				
			}
			
			//con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cd;
		
	}
	public Connection getconnection() {
		   Connection con = null;
			String url ="Jdbc:mysql://localhost:3306/customerapiproject";
			String username = "root";
			String password = "";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
				
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("success");
			return con;
		}
	public String deleteFunders(int id) {
		String output = "";
		try {
			Connection con = getconnection();
			
			String deleteFunders = "DELETE FROM funders WHERE id = '"+id+"'";
			PreparedStatement ps = con.prepareStatement(deleteFunders);
			ps.execute();
			
			output = "Delete Successful";
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
public void updateFunders(Funders funders) {
		
		try {
			Connection con = getconnection();
			
			String updateFunders = "UPDATE funders SET id='"+funders.getId()+"',name='"+funders.getName()+"',email='"+funders.getEmail()+"' WHERE id='"+funders.getId()+"'";
			PreparedStatement st = con.prepareStatement(updateFunders);
			
			
			
			st.executeUpdate();
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	}















	






	
