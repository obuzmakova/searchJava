package org.example.search.repository;

import org.example.search.model.Book;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@ComponentScan
public interface BookRepository extends ElasticsearchRepository<Book, String> {

	List<Book> findByAuthor(String author);

	Optional<Book> findByYear(int year);

	Optional<Book> findByTitle(String title);
}
