package org.example.search.service;

import org.example.search.model.Book;
import org.example.search.service.exception.BookNotFoundException;


import java.util.List;
import java.util.Optional;

public interface BookService {

	Optional<Book> getByTitle(String title);

	List<Book> getAll();

	List<Book> findByAuthor(String author);

	List<Book> findByTitleAndAuthor(String title, String author);

	Book create(Book book);

	void deleteById(String id);

	Book update(String id, Book book) throws BookNotFoundException;
}