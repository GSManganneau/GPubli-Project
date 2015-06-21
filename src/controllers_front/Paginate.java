package controllers_front;

public class Paginate {

	public int getElementsByPage() {
		return elementsByPage;
	}

	public void setElementsByPage(int elementsByPage) {
		this.elementsByPage = elementsByPage;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public int getPreviousPageNumber() {
		return previousPageNumber;
	}

	public void setPreviousPageNumber(int previousPageNumber) {
		this.previousPageNumber = previousPageNumber;
	}

	public int getNextPageNumber() {
		return nextPageNumber;
	}

	public void setNextPageNumber(int nextPageNumber) {
		this.nextPageNumber = nextPageNumber;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getServlet() {
		return servlet;
	}

	public void setServlet(String servlet) {
		this.servlet = servlet;
	}

	private int elementsByPage;
	private int currentPageNumber;
	private int previousPageNumber;
	private int nextPageNumber;
	private int numberOfPages;
	private String servlet;
	private int parameter;

	@Override
	public String toString() {
		return "Paginate [elementsByPage=" + elementsByPage
				+ ", currentPageNumber=" + currentPageNumber
				+ ", previousPageNumber=" + previousPageNumber
				+ ", nextPageNumber=" + nextPageNumber + ", numberOfPages="
				+ numberOfPages + ", servlet=" + servlet + "]";
	}

	public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		this.parameter = parameter;
	}

}
