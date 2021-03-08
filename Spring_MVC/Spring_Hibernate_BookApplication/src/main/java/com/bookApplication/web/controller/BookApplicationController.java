package com.bookApplication.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookApplication.model.dao.Book;
import com.bookApplication.model.service.BookService;

@Controller
public class BookApplicationController {
		
	private BookService bookservice;
	
	@Autowired
	public BookApplicationController(BookService bookservice) {
		this.bookservice = bookservice;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/allbooks";
		
	}
	
	@GetMapping("allbooks")
	public ModelAndView allbooks(ModelAndView mv) {
		System.out.println("allbooks method is called....");
		mv.setViewName("showAllBooks");
		mv.addObject("books", bookservice.getAllBooks());
		return mv;
	}
	@GetMapping("addbook")
	public String addBookGet(ModelMap map) {
		  map.addAttribute("book", new Book());
		return "addbook";
	}
	
	@GetMapping("updatebook")
	public String updateBookGet(HttpServletRequest req,ModelMap map) {
		int id=Integer.parseInt(req.getParameter("id"));
		Book book=bookservice.getBookByID(id);
		map.addAttribute("book", book);
		return "updatebook";
	}
	
	@GetMapping("deletebook")
	public String deleteBook(HttpServletRequest req) {
		 int id=Integer.parseInt(req.getParameter("id"));
		 bookservice.deleteBook(id);
		 return "redirect:/allbooks";
	}
	@PostMapping("addbook")
	public String addBookPost(@ModelAttribute(name = "book") Book book) {
		if (book.getId() == 0) {
			bookservice.addBook(book);
		} else {
			bookservice.updateBook(book.getId(), book);
		}
		return "redirect:/allbooks";
	}
}
