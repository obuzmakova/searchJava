package org.example.search.service.impl;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.example.search.model.Book;
import org.example.search.service.BookService;
import org.example.search.repository.BookRepository;
import org.example.search.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultBookService implements BookService {

	private final BookRepository bookRepository;

	private final ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	public DefaultBookService(BookRepository bookRepository, ElasticsearchTemplate elasticsearchTemplate) {
		this.bookRepository = bookRepository;
		this.elasticsearchTemplate = elasticsearchTemplate;
	}

	@Override
	public Optional<Book> getByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(book -> books.add(book));
		return books;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByTitleAndAuthor(String title, String author) {
		BoolQueryBuilder criteria = QueryBuilders.boolQuery();
		criteria.must().add(QueryBuilders.matchQuery("title", title));
		criteria.must().add(QueryBuilders.matchQuery("author", author));
		return elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder().withQuery(criteria).build(), Book.class);
	}

	@Override
	public Book create(Book book) { return bookRepository.save(book); }

	@Override
	public void deleteById(String id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book update(String id, Book book) throws BookNotFoundException {
		Book oldBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Книга с таким id отсуствует"));
		oldBook.setAnnotation(book.getAnnotation());
		oldBook.setAuthor(book.getAuthor());
		oldBook.setTitle(book.getTitle());
		oldBook.setYear(book.getYear());
		return bookRepository.save(book);
	}
}
