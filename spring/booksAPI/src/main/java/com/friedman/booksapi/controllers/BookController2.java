package com.friedman.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friedman.booksapi.models.Book;
import com.friedman.booksapi.services.BookService;

@Controller
public class BookController2 {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
		return "index.jsp";
	}

	@GetMapping("/books/{bookId}")
	public String show(@PathVariable("bookId") Long bookId, Model model) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@GetMapping("/books/new") 
	public String newBook() {
		return "new.jsp";
	}
	
	@PostMapping("/books/processForm")
	public String processForm(
	    @RequestParam(value="title") String title,
	    @RequestParam(value="description") String description, 
	    @RequestParam(value="language") String language,
	    @RequestParam(value="numberOfPages") Integer numberOfPages) {
		
		Book book = new Book(title, description, language, numberOfPages);
		bookService.createBook(book);
	    
	    return "redirect:/books";
	}
}
