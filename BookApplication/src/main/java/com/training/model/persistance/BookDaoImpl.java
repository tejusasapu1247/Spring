package com.training.model.persistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDao{
	private static int counter;
	private Map<Integer, Book> booksMap;
	
	public  void setCounter(int counter) {
		BookDaoImpl.counter = counter;
	}

	public void setBooksMap(Map<Integer, Book> booksMap) {
		this.booksMap = booksMap;
	}

	public List<Book> getAllBooks() {
		return new ArrayList<Book> (booksMap.values());
	}

	public Book addBook(Book book) {
		book.setId(++counter);
		booksMap.put(counter, book);
		return booksMap.get(counter);
	}

	public void deleteBook(int id) {
		booksMap.remove(id);
		
	}

	public void updateBook(int id, Book book) {
		booksMap.put(id, book);
		
	}

	public Book getBookById(int id) {
		return booksMap.get(id);
	}

}
