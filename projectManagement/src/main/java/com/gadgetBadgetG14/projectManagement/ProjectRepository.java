package com.gadgetBadgetG14.projectManagement;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProjectRepository {
	
	Connection con = null;
	
	List<Project> projects;
	
	public ProjectRepository() {
		
		String url = "Jdbc:mysql://localhost:3306/gadget_badget";
		String username = "root";
		String password = "";
		
		
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
		
		String insertSql = "INSERT INTO 'projects'('p_id', 'p_name', 'description', 'researcher_id') VALUES (?,?,?,?)";
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

}
