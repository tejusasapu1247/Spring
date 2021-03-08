package com.training.model.service;

import java.util.List;

import com.training.model.persistance.Book;
import com.training.model.persistance.BookDao;

public class BookServiceImpl implements BookService{
	BookDao dao;
	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	public List<Book> getAllBooks() {
		
		return dao.getAllBooks();
	}

	public Book addBook(Book book) {
		
		return dao.addBook(book);
	}

	public void deleteBook(int id) {
		dao.deleteBook(id);
		
	}

	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
		
	}

	public Book getBookById(int id) {
		
		return dao.getBookById(id);
	}

}
