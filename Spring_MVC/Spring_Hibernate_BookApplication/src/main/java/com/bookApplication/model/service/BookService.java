package com.bookApplication.model.service;

import java.util.*;

import com.bookApplication.model.dao.Book;

public interface BookService {
	public List<Book> getAllBooks();

	public Book getBookByID(int id);

	public void deleteBook(int id);

	public void addBook(Book book);

	public void updateBook(int id, Book book);

}
