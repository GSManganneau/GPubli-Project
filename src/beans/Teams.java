package beans;

public class Teams {
	
	public String name;
	public int team_id;
	public String thumbnail;
	@Override
	public String toString() {
		return "Teams [name=" + name + ", team_id=" + team_id + ", thumbnail="
				+ thumbnail + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
