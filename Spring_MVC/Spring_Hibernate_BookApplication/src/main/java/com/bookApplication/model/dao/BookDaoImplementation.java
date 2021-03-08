package com.bookApplication.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // @Component + excpetion wrapping
			// (PersistenceExceptionTranslationPostProcessor)
public class BookDaoImplementation implements BookDao {
	private SessionFactory factory;

	@Autowired
	public BookDaoImplementation(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		System.out.println("getting books");
		return getSession().createQuery("from Book").list();
	}

	@Override
	public void addBook(Book book) {
		getSession().save(book);
	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookByID(id);
		getSession().delete(book);
	}

	@Override
	public void updateBook(int id, Book book) {
		Book bookToUpdated = getBookByID(id);
		bookToUpdated.setPrice(book.getPrice());
		getSession().update(bookToUpdated);
	}

	@Override
	public Book getBookByID(int id) {
		Book book = getSession().get(Book.class, id);

		if (book != null)
			return book;
		else
			throw new BookNotFoundException("book with id:" + id + " is not found");
	}

}
