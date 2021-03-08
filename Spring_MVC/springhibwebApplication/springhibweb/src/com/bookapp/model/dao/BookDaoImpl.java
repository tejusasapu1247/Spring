package com.bookapp.model.dao;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
//right now no tx mgt in dao layer
//infact tx must be in service layer... service layer =BL +CCC
@Repository // @Component + excpetion wrapping (PersistenceExceptionTranslationPostProcessor)
public class BookDaoImpl implements BookDao {
	private SessionFactory factory;
	@Autowired
	public BookDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return  getSession().createQuery("from Book").list();
	}

	@Override
	public void addBook(Book book) {
		getSession().save(book);
	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id);
		getSession().delete(book);
	}

	@Override
	public void updateBook(int id, Book book) {
		Book bookToUpdated = getBookById(id);
		bookToUpdated.setPrice(book.getPrice());
		getSession().update(bookToUpdated);
	}

	@Override
	public Book getBookById(int id) {

		Book book = getSession().get(Book.class, id);

		if (book != null)
			return book;
		else
			throw new BookNotFoundException("book with id:" + id + " is not found");
	}
}
