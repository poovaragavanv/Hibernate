package com.rags.tablepersubclas;

public class SpecialEditionBook extends Book {

	private String newfeatures;

	public SpecialEditionBook() {
	}

	public SpecialEditionBook(String title, String author, double cost,
			String features) {
		super(title, author, cost);

		newfeatures = features;
	}

	public void setNewfeatures(String s) {
		newfeatures = s;
	}

	public String getNewfeatures() {
		return newfeatures;
	}
}
