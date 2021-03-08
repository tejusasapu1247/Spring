package com.bookApplication.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookApplication.model.dao.Book;
import com.bookApplication.model.dao.BookDao;
@Service
@Transactional
public class BookServiceImplementation implements BookService{

	private BookDao bookDao;
	
	@Autowired
	public BookServiceImplementation(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book getBookByID(int id) {
		return bookDao.getBookByID(id);
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
		
	}

	@Override
	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
		
	}

}
