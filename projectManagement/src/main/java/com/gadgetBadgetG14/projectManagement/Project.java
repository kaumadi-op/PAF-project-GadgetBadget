package com.gadgetBadgetG14.projectManagement;

import java.time.LocalDate;

public class Project {
	
	public int p_id;
	public String p_name;
	public String type;
	public String startDate;
	public String endDate;
	public String description;
	public int researcher_id;
	
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public int getResearcher_id() {
		return researcher_id;
	}
	public void setResearcher_id(int researcher_id) {
		this.researcher_id = researcher_id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Project [p_id=" + p_id + ", p_name=" + p_name + ", type=" + type + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", description=" + description + ", researcher_id=" + researcher_id + "]";
	}
	
	
	

}
