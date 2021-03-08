package com.training.model.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.model.persistance.Book;
import com.training.model.service.BookService;

public class BookController {

	public static void main(String[] args) {
			ApplicationContext cnt= new ClassPathXmlApplicationContext("book.xml");
			BookService books=(BookService) cnt.getBean("bookservice");
			
			System.out.println("....getting all books...");
			books.getAllBooks().forEach(System.out::println);;
			
			System.out.println("....getting by id...");
			System.out.println(books.getBookById(2));
			
			
			Book b=new Book("awed1", "comics", "raj", 20000);
			books.addBook(b);
			
			Book b1=new Book("MHNF$", "BioGraphy", "Moksha", 60000);
			books.addBook(b1);
			
			System.out.println("....getting all books after adding new books...");
			books.getAllBooks().forEach(System.out::println);
			
			books.deleteBook(3);
			System.out.println("....getting all books after deleting the book...");
			books.getAllBooks().forEach(System.out::println);
			
			Book updateBook=new Book("MHNF3", "Marketing", "Moksha", 70000);
			books.updateBook(2, updateBook);
			System.out.println("....getting all books after updating the book...");
			books.getAllBooks().forEach(System.out::println);
			
			
			
	}

}
