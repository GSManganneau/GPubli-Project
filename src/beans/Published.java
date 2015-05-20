package beans;

public class Published {


private Publications publications =  new Publications();
private Authors authors = new Authors();


public Publications getPublications() {
	return publications;
}
public void setPublications(Publications publications) {
	this.publications = publications;
}
public Authors getAuthors() {
	return authors;
}
public void setAuthors(Authors authors) {
	this.authors = authors;
}
}
