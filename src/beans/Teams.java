package beans;

public class Teams {

	public String teamName;
	public int count;
	public int teamId;
	public String thumbnail;

	@Override
	public String toString() {
		return "Teams [name=" + teamName + ", teamId=" + teamId + ", thumbnail="
				+ thumbnail + "]";
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String name) {
		this.teamName = name;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
