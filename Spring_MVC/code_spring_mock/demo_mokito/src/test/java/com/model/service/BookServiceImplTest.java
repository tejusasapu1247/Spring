package com.model.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.model.persistance.BookDaoImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

	@Spy
	private BookDaoImpl dao;

	@InjectMocks
	private BookServiceImpl bookService;

	@Before
	public void before() {
		List<String> allbooks = Arrays.asList("java", "rich dad poor dad", "java adv");
		
	   // dao = mock(BookDao.class);
		when(dao.getAllBooks()).thenReturn(allbooks);

		 bookService = new BookServiceImpl(dao);
	}

	@Test
	public void testAllJavaBooks() {

		Assert.assertEquals(2, bookService.getBooksNoTopic("java").size());
	}
}
