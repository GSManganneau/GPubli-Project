package beans;

public class Authors {
	private int ldapId;
	private int authorId;
	private String firstname;
	private String lastname;
	private int count;
	private Teams team = new Teams();

	public int getLdapId() {
		return ldapId;
	}

	public void setLdapId(int ldapId) {
		this.ldapId = ldapId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
