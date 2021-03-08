package com.model.service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

import com.model.persistance.BookDaoImpl;

public class BookServiceImpl implements BookService {

	private BookDaoImpl dao;
	
	public BookServiceImpl(BookDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<String> getBooksNoTopic(String topic) {
		return dao.getAllBooks().stream()
				.filter(title -> title.contains(topic))
				.collect(Collectors.toList());
	}

}






