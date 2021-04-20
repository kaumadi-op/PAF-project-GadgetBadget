package com.gadgetBadgetG14.projectManagement;



import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/projects")

public class ProjectResource {
	
	ProjectRepository pr = new ProjectRepository();
	
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getAllprojects() {
		return pr.getAllProjects();
    }
	
	
	@POST
	@Path("/project")
	@Consumes(MediaType.APPLICATION_JSON)
	public Project createProject(Project p1) {
		return pr.createProject(p1);
	}
	
	

}
