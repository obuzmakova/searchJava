package org.example.search.controller;

import org.example.search.model.Book;
import org.example.search.service.BookService;
import org.example.search.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/books")
public class BookController {

	/*private ElasticsearchOperations elasticsearchOperations;

	public BookController(ElasticsearchOperations elasticsearchOperations) {
		this.elasticsearchOperations = elasticsearchOperations;
	}

	@PostMapping
	public String save(@RequestBody Book book) {

		IndexCoordinates indexCoordinates = elasticsearchOperations.getIndexCoordinatesFor(book.getClass());

		IndexQuery indexQuery = new IndexQueryBuilder()
				.withId(book.getId())
				.withObject(book)
				.build();
		String documentId = elasticsearchOperations.index(indexQuery, indexCoordinates);
		return documentId;
	}*/

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAll();
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping
	public Book createBook(@Valid @RequestBody BookDto book) {
		return bookService.create(BookDto.transform(book));
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{title}")
	public Optional<Book> getBookByTitle(@PathVariable String title) {
		return bookService.getByTitle(title);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/query")
	public List<Book> getBooksByAuthorAndTitle(@RequestParam(value = "title") String title, @RequestParam(value = "author") String author) {
		return bookService.findByTitleAndAuthor(title, author);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/{id}")
	public Book updateBook(@PathVariable String id, @RequestBody BookDto book) throws BookNotFoundException {
		return bookService.update(id, BookDto.transform(book));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	public void deleteBook(@PathVariable String id) {
		bookService.deleteById(id);
	}

	public static class BookDto {

		@NotBlank
		private String annotation;

		@NotBlank
		private String author;

		@NotBlank
		private String title;

		@Positive
		private int year;

		static Book transform(BookDto bookDto) {
			Book book = new Book();
			book.setAnnotation(bookDto.annotation);
			book.setAuthor(bookDto.author);
			book.setTitle(bookDto.title);
			book.setYear(bookDto.year);
			return book;
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
}