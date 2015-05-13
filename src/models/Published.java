package models;

public class Published {
private int pu_id;
private int author_id;
public int getPu_id() {
	return pu_id;
}
public void setPu_id(int pu_id) {
	this.pu_id = pu_id;
}
public int getAuthor_id() {
	return author_id;
}
public void setAuthor_id(int author_id) {
	this.author_id = author_id;
}
@Override
public String toString() {
	return "Published [pu_id=" + pu_id + ", author_id=" + author_id + "]";
}
}
