package com.bookapp.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.dao.Book;

@ContextConfiguration(locations = {"classpath:model-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class BookServiceImplTest {
	
	@Autowired
	private BookService bookService;
	
	@Test
	public void getAllBooksTest() {
		List<Book> books= bookService.getAllBooks();
		Assert.assertEquals(5, books.size());
	}
	

}
