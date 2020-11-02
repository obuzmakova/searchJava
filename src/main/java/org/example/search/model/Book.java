package org.example.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Document(indexName = "books", type = "book")
public class Book {

	@Id
	private String id;

	private String annotation;

	private String author;

	private String title;

	private int year;

	public String getId() {
		return id;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
