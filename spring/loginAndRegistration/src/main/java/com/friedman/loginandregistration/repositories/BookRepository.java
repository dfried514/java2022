package com.friedman.loginandregistration.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.friedman.loginandregistration.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();
	
	Optional<Book> findById(Long id);
}
