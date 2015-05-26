package beans;

public class Authors {
	private int eldap_id;
	private int author_id;
	private String firstname;
	private String lastname;
	private Teams team = new Teams();
	private Publications publication = new Publications();
	private Type type = new Type();
	
	
	public int getEldap_id() {
		return eldap_id;
	}
	public void setEldap_id(int eldap_id) {
		this.eldap_id = eldap_id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Teams getTeam() {
		return team;
	}
	public void setTeam(Teams team) {
		this.team = team;
	}
	public Publications getPublication() {
		return publication;
	}
	public void setPublication(Publications publication) {
		this.publication = publication;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

}
