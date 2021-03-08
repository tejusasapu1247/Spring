package com.model.service;

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

import com.model.persistence.BookDaoImpl;
import com.model.servie.BookServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	
	@Spy
	private BookDaoImpl bookDao;
	
	@InjectMocks
	private BookServiceImpl bookservice;
	
	@Before
	public  void before(){
		List<String> allbooks = Arrays.asList("java", "rich dad poor dad", "java adv");
		
		when(bookDao.getAllBooks()).thenReturn(allbooks);
		bookservice=new BookServiceImpl(bookDao);
	}

	@Test
	public void testAllJavaBooks() {
		Assert.assertEquals(2, bookservice.getNOTopic("java").size());
	}

}
