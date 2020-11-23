package com.bookApp.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookApp.persistance.Book;
import com.bookApp.persistance.BookDao;
import com.bookApp.persistance.BookDaoImpl;
import com.bookApp.service.BookService;
import com.bookApp.service.BookServiceImpl;

public class BookController {

	public static void main(String[] args) {
		AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("book.xml");
		BookService dao=ctx.getBean("bookService",BookServiceImpl.class);
		
		System.out.println("....getting all books...");
		dao.getAllBooks().forEach(System.out::println);
		
//		Book book=new Book("DSR23","Core JAVA","Manoj",1200);
//		dao.addBook(book);
//		System.out.println("....getting all books after adding a book...");
//		dao.getAllBooks().forEach(System.out::println);
//		
		
		System.out.println("....getting book by id...");
		System.out.println(dao.getBookById(9));
		
//		dao.deleteBook(2);
//		System.out.println("....getting all books after deleting the book...");
//		dao.getAllBooks().forEach(System.out::println);
//		
		Book bookUpdate=new Book("TMKA23","ADV JAVA","Moksha",8000);
		dao.updateBook(4, bookUpdate);
		
		System.out.println("....getting all books after updating the book...");
		dao.getAllBooks().forEach(System.out::println);
		
		
		
	}

}
