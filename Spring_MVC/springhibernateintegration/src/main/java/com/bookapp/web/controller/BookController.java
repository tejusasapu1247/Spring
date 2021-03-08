package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookNotFoundException;
import com.bookapp.model.dao.BookType;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/allbooks";
	}
	
	@GetMapping("allbooks")
	public ModelAndView allbooks(ModelAndView mv) {
		mv.setViewName("showall");
		mv.addObject("books", bookService.getAllBooks());
		return mv;
	}
	@GetMapping("searchbook/{id}")
	public ModelAndView getBook(@PathVariable("id") int id,ModelAndView mv) {
		Book book=bookService.getBookById(id);
		
		mv.setViewName("showBook");
		mv.addObject("SearchedBook", book);
		return mv;
	}
	
	
	
	// del the book
	@GetMapping("deletebook")
	public String delBook(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		bookService.deleteBook(id);
		return "redirect:/allbooks";
	}

	// update the book: get and post

	// add an new book
	@GetMapping("updatebook")
	public String addBookGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		Book book = bookService.getBookById(id);
		map.addAttribute("book", book);
		return "updatebook";
	}

	// add an new book
	@GetMapping("addbook")
	public String addBookGet(ModelMap map) {
		// we are binding a form bean ( a poj ie used to collect the data from ui) with
		// the form
		map.addAttribute("book", new Book());
		return "addbook";
	}

	// post part of addbook/updatebook
	@PostMapping("addbook")
	public String addBookPost(@Valid @ModelAttribute(name = "book") Book book, BindingResult bindingResult) {
		// hey spring if there is a validation error : go back to addbook.jsp
		if (bindingResult.hasErrors()) {
			return "addbook";
		} else {
			if (book.getId() == 0) {
				bookService.addBook(book);
			} else {
				bookService.updateBook(book.getId(), book);
			}
			return "redirect:/allbooks";
		}
	}

	//hey spring mvc plz execute the method for every req...
	//and put this return 
	
	@ModelAttribute(value="booktypes")
	public BookType[] booktype() {
		System.out.println("--------------called for each req of this controller ---i can call db");
		return BookType.values();	
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ModelAndView bookNotFoundHAndler(Exception er,HttpServletRequest req) {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("bookNotFound");
		mv.addObject("error", er.getMessage());
		return mv;
	}
	
	
}
