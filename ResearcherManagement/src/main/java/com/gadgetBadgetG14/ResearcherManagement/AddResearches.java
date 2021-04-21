package com.gadgetBadgetG14.ResearcherManagement;

public class AddResearches {
	
	public int researcherid;
	public String name;
	public String contactno;
	public String email;
	public int getResearcherid() {
		return researcherid;
	}
	public void setResearcherid(int researcherid) {
		this.researcherid = researcherid;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "AddResearches [researcherid=" + researcherid + ", name=" + name + ", contactno=" + contactno
				+ ", email=" + email + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
