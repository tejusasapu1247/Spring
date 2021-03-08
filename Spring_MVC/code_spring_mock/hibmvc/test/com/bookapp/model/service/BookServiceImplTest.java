package com.bookapp.model.service;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookType;
//integration test!
@ContextConfiguration(locations= {"classpath:model-config.xml"})
@RunWith(SpringRunner.class)
@Transactional
public class BookServiceImplTest {

	@Autowired
	private BookService bookService;
	//we want to test crud operation
	
	//get all books
	@Test
	public void getAllBooksTest() {
		List<Book>books=bookService.getAllBooks();
		Assert.assertEquals(4, books.size());
	}

	//@Rollback(true) => by default
	//spring test: @Tranactional in spring test: it is intellegent it know that it should not commit changes to db
	//@Rollback(true) => foolish idea
	@Test
	public void addBookTest() {
		
		Book book=new Book("EQ1T23", "java", "raj", new Date(), 600.0, BookType.IT);
		Book bookAdded= bookService.addBook(book);
		
		boolean isEqual=book.equals(bookAdded);
		
		Assert.assertTrue(isEqual);
		
		
	}

	@Test
	public void updateBookTest() {
		
		Book book=bookService.getBookById(4);
		Double originalPrice=book.getPrice();
		book.setPrice(book.getPrice()+100);
		Book bookAdded= bookService.updateBook(4, book);
		
		Assert.assertNotEquals(originalPrice, bookAdded.getPrice());
		
	}
	
}
