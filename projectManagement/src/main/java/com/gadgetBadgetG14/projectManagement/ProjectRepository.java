package com.gadgetBadgetG14.projectManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;  
import java.sql.*;

public class ProjectRepository {
	
	public Connection getconnection() {
	
	Connection con = null;
	String url = "Jdbc:mysql://localhost:3306/gadget_badget";
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
	
	List<Project> projects;
	
	public ProjectRepository() {
		
		
		String url = "Jdbc:mysql://localhost:3306/gadget_badget";
		String username = "root";
		String password = "";
		Connection con = getconnection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		projects = new ArrayList<>();
		
		Project p1 = new Project();
		
		p1.setP_id(1);
		p1.setP_name("GadgetBadget");
		p1.setType("Web App");
		p1.setStartDate("2020-05-01");
		p1.setEndDate("2020-12-01");
		p1.setDescription("Abcd");
		p1.setResearcher_id(2);
		projects.add(p1);
	}
	
	public List<Project> getAllProjects(){
		
		return projects;
	}
	
	public Project createProject(Project p1) {
		
		String insertSql = "INSERT INTO `projects`(`p_id`, `p_name`,`type`,`startDate`,`endDate`, `description`, `researcher_id`) VALUES (?,?,?,?,?,?,?)";
		Connection con = getconnection();
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, p1.p_id);
			st.setString(2, p1.p_name);
			st.setString(3, p1.type);
			st.setString(4, p1.startDate);
			st.setString(5, p1.endDate);
			st.setString(6, p1.description);
			st.setInt(7, p1.researcher_id);
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		projects.add(p1);
		System.out.println(projects);
		return (p1);
	}

	public Project getprojectid(int p_id) {
		String getsql = "SELECT * FROM `projects` WHERE `p_id` = '"+p_id+"' ";
		Project pr = new Project();
		Connection con = getconnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet p1 = st.executeQuery(getsql);
			
			while(p1.next()) {
				
				pr.setP_id(p1.getInt(1));
				pr.setP_name(p1.getString(2));
				pr.setType(p1.getString(3));
				pr.setStartDate(p1.getString(4));
				pr.setEndDate(p1.getString(5));
				pr.setDescription(p1.getString(6));
				pr.setResearcher_id(p1.getInt(7));
				
			}
			
			//con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}

	
	public String deleteProject(int p_id) {
		String output = "";
		try {
			Connection con = getconnection();
			
			String deleteProject = "DELETE FROM projects WHERE p_id = '"+p_id+"'";
			PreparedStatement ps = con.prepareStatement(deleteProject);
			ps.execute();
			
			output = "Delete Successful";
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
		
	public String updateProject(Project project) {
		String output = "";
		
		try {
			Connection con = getconnection();
			
			String updateProject = "UPDATE `projects` SET `p_id`='"+project.getP_id()+"',p_name='"+project.getP_name()+"',type='"+project.getType()+"',startDate='"+project.getStartDate()+"',endDate='"+project.getEndDate()+"',description='"+project.getDescription()+"',researcher_id='"+project.getResearcher_id()+"' WHERE p_id='"+project.getP_id()+"'";
			PreparedStatement st = con.prepareStatement(updateProject);

			st.executeUpdate();
			output = "Updated Successful";
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return output;

	}
}
