package beans;

public class Publications {

	@Override
	public String toString() {

		return "Publications [id=" + publicationId + ", type=" + type
				+ ", date=" + date + ", resume=" + resume + ", title=" + title
				+ "]";
	}

	private int publicationId;
	private Types type = new Types();
	private String date;
	private String resume;
	private String title;
	private String url;
	private int count;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setId(int id) {
		this.publicationId = id;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
