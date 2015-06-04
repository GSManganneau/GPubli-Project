package beans;

public class Publications {

	@Override
	public String toString() {
		return "Publications [publicationId=" + publicationId + ", typeId=" + typeId + ", date=" + date
				+ ", resume=" + resume + ", journal="
				+ ", book_title=" + ", title=" + title + "]";
	}
	private int publicationId;
	private int typeId;
	private String date;
	private String resume;
	private String title;
	private String url;
	
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
	public int getId() {
		return publicationId;
	}
	public void setId(int publicationId) {
		this.publicationId = publicationId;
	}
	public int getType() {
		return typeId;
	}
	public void setType(int typeId) {
		this.typeId = typeId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
