package com.friedman.loginandregistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friedman.loginandregistration.models.Book;
import com.friedman.loginandregistration.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent())
			return optionalBook.get();
		return null;
	}
	public Book updateBook(Long id, Book book) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			book.setId(id);
			return bookRepo.save(book);
		} 
		return null;
	}
}

