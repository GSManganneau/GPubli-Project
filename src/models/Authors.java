package models;

public class Authors {
private int eldap_id;
private int author_id;
private String firstname;
private String lastname;
private int team_id=1;
@Override
public String toString() {
	return "Authors [eldap_id=" + eldap_id + ", author_id=" + author_id
			+ ", firstname=" + firstname + ", lastname=" + lastname
			+ ", team_id=" + team_id + "]";
}
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
public int getTeam_id() {
	return team_id;
}
public void setTeam_id(int team_id) {
	this.team_id = team_id;
}

}
