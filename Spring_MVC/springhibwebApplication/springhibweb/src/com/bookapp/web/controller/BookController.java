package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.dao.Book;
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

	//post part of addbook/updatebook
	@PostMapping("addbook")
	public String addBookPost(@ModelAttribute(name = "book") Book book) {
		if (book.getId() == 0) {
			bookService.addBook(book);
		} else {
			bookService.updateBook(book.getId(), book);
		}
		return "redirect:/allbooks";
	}
}
