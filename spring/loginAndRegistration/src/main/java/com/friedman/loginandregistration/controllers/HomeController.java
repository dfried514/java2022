package com.friedman.loginandregistration.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friedman.loginandregistration.models.Book;
import com.friedman.loginandregistration.models.LoginUser;
import com.friedman.loginandregistration.models.User;
import com.friedman.loginandregistration.services.BookService;
import com.friedman.loginandregistration.services.UserService;

@Controller
public class HomeController {
 
  @Autowired
  private UserService userServ;
  
  @Autowired
  private BookService bookServ;
 
 @GetMapping("/")
 public String index(Model model) {
 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "index.jsp";
 }
 
 @GetMapping("/books")
 public String books(Model model, HttpSession session) {
	 Long userId = (Long)session.getAttribute("userId");
	 if (userId == null)
		 return "redirect:/";
	 User user = userServ.findUser(userId);
	 if (user == null)
		 return "redirect:/";
	 model.addAttribute("user", user);
	 List<Book> books = bookServ.allBooks();
	 model.addAttribute("books", books);
	 return "books.jsp";
 }
 
 @GetMapping("/books/{bookId}")
 public String getBook(Model model, @PathVariable("bookId") Long bookId, HttpSession session) {
	 Long userId = (Long)session.getAttribute("userId");
	 if (userId == null)
		 return "redirect:/";
	 User user = userServ.findUser(userId);
	 if (user == null)
		 return "redirect:/";
	 model.addAttribute("user", user);
	 Book book = bookServ.findBook(bookId);
	 model.addAttribute("book", book);
	 return "book.jsp";
 }
 
 @GetMapping("/books/edit/{bookId}")
 public String editBook(@PathVariable("bookId") Long bookId, Model model, HttpSession session) {
	 Long userId = (Long)session.getAttribute("userId");
	 if (userId == null)
		 return "redirect:/";
	 User user = userServ.findUser(userId);
	 if (user == null)
		 return "redirect:/";
	 model.addAttribute("user", user);
	 Book book = bookServ.findBook(bookId);
	 model.addAttribute("book", book);
	 return "editBook.jsp";
 }
 
 @GetMapping("/books/new")
 public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
	 Long userId = (Long)session.getAttribute("userId");
	 if (userId == null)
		 return "redirect:/";
	 User user = userServ.findUser(userId);
	 if (user == null)
		 return "redirect:/";
	 model.addAttribute("user", user);
	 return "newBook.jsp";
 }
 
 @RequestMapping(value="/books/edit/{bookId}", method=RequestMethod.PUT)
 public String updateBook(@PathVariable("bookId") Long bookId,
		 @Valid @ModelAttribute("book") Book book, BindingResult result) {
	 if (result.hasErrors())
		 return "editBook.jsp";
	 else {
		 bookServ.updateBook(bookId, book);
		 return "redirect:/books";
	 }
 }
 
 @PostMapping("/books/new")
 public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	 if (result.hasErrors())
		 return "newBook.jsp";
	 bookServ.createBook(book);
	 return "redirect:/books";
 }
  
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
	 User user = userServ.register(newUser, result);
     if(result.hasErrors()) {
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     session.setAttribute("userId", user.getId());
     return "redirect:/books";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     User user = userServ.login(newLogin, result);
 
     if(result.hasErrors() || user == null) {
         model.addAttribute("newUser", new User());
         return "index.jsp";
     }
 
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", user.getId());
     return "redirect:/books";
 }
 
 @RequestMapping(value = "/logout")
 public String logout(HttpSession session) {
	 session.removeAttribute("userId");
	 return "redirect:/";
 }
 
}

