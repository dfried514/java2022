package com.friedman.booksapi.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.friedman.booksapi.models.Book;
import com.friedman.booksapi.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
 
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	// updates a book
	public Book updateBook(Long id, String title, String description, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			Book b = new Book(title, description, lang, numOfPages);
			b.setId(id);
			return bookRepository.save(b);
		} else {
			return null;
		}
	}
	// delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}


