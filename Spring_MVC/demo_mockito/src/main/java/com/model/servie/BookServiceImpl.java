package com.model.servie;

import java.util.List;
import java.util.stream.Collectors;

import com.model.persistence.BookDaoImpl;



public class BookServiceImpl implements BookService{
	private BookDaoImpl dao;
	
	public BookServiceImpl(BookDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<String> getNOTopic(String topic) {
	
		return dao.getAllBooks().stream()
				.filter(t->t.contains(topic))
				.collect(Collectors.toList());
	}

	
	
	
}
