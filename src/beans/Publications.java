package beans;

public class Publications {

	@Override
	public String toString() {
		return "Publications [id=" + id + ", type=" + type + ", date=" + date
				+ ", resume=" + resume + ", journal=" + journal
				+ ", book_title=" + book_title + ", title=" + title + "]";
	}
	private int id;
	private int type;
	private String date;
	private String resume;
	private String journal;
	private String book_title;
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
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
