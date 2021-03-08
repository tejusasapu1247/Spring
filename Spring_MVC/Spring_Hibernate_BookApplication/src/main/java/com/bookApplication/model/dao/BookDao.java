package com.bookApplication.model.dao;
import java.util.*;

public interface BookDao {
	public List<Book> getAllBooks();
	public Book getBookByID(int id);
	public void deleteBook(int id);
	public void addBook(Book book);
	public void updateBook(int id,Book book);
	 
	
}
