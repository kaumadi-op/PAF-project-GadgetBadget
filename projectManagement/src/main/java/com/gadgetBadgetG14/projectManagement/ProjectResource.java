package com.gadgetBadgetG14.projectManagement;



import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/project")

public class ProjectResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getAllprojects() {
		
		List<Project> projects = new ArrayList<Project>(); 
        
		Project p1 = new Project();
		p1.setP_id(1);
		p1.setP_name("Kaumadi");
		p1.setDescription("Abcd");
		
		projects.add(p1);
		
		return projects;
    }
	
	
	@POST
	@Path("/project")
	@Consumes(MediaType.APPLICATION_JSON)
	public Project createProject(Project p1) {
		System.out.println(p1);
		return p1;
	}

}
