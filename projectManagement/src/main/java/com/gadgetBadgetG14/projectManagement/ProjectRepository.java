package com.gadgetBadgetG14.projectManagement;

import java.util.ArrayList;
import java.util.List;
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
		p1.setP_name("Kaumadi");
		p1.setDescription("Abcd");
		p1.setResearcher_id(2);
		projects.add(p1);
	}
	
	public List<Project> getAllProjects(){
		
		return projects;
	}
	
	public Project createProject(Project p1) {
		
		String insertSql = "INSERT INTO `projects`(`p_id`, `p_name`, `description`, `researcher_id`) VALUES (?,?,?,?)";
		Connection con = getconnection();
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, p1.p_id);
			st.setString(2, p1.p_name);
			st.setString(3, p1.description);
			st.setInt(4, p1.researcher_id);
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		projects.add(p1);
		System.out.println(projects);
		return (p1);
	}

	public Project getprojectid(int p_id) {
		String getsql = "SELECT * FROM project WHERE p_id = '"+p_id+"' ";
		Project pr = new Project();
		Connection con = getconnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet p1 = st.executeQuery(getsql);
			
			while(p1.next()) {
				
				pr.setP_id(p1.getInt(1));
				pr.setP_name(p1.getString(2));
				pr.setDescription(p1.getString(3));
				pr.setResearcher_id(p1.getInt(4));
				
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
			
			String deleteProject = "DELETE FROM project WHERE id = '"+p_id+"'";
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
			
			String updateProject = "UPDATE project SET p_id='"+project.getP_id()+"',p_name='"+project.getP_name()+"',description='"+project.getDescription()+"',researcher_id='"+project.getResearcher_id()+"' WHERE id='"+project.getP_id()+"'";
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
