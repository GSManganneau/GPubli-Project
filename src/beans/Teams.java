package beans;

public class Teams {
	
	public String name;
	public int teamId;
	public String thumbnail;
	@Override
	public String toString() {
		return "Teams [name=" + name + ", teamId=" + teamId + ", thumbnail="
				+ thumbnail + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
