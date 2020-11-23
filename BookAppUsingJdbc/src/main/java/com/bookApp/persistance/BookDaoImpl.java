package com.bookApp.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookApp.exceptions.BookNotFoundException;
import com.bookApp.exceptions.DataAccessException;

import sun.security.ssl.CookieExtension;

@Repository
public class BookDaoImpl implements BookDao {
	private DataSource datasource;

	@Autowired
	public BookDaoImpl(DataSource datasource) {
		this.datasource = datasource;
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		Book book = null;
		try {
			Connection connection = datasource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_db");
			while (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"));

				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public Book addBook(Book book) {
		Connection connection;
		try {
			connection = datasource.getConnection();
			String addBook_query = "insert into book_db(isbn, title, author,price)values(?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(addBook_query, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, book.getIsbn());
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getAuthor());
			pst.setDouble(4, book.getPrice());
			int noOfRowsEffected = pst.executeUpdate();
			if (noOfRowsEffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				rs.next();
				book.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		return book;
	}

	public void deleteBook(int id) {
		Book book = getBookById(id);
		Connection connection;
		try {
			connection = datasource.getConnection();
			PreparedStatement pst = connection.prepareStatement("delete from book_db where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	public void updateBook(int id, Book book) {
		Connection connection;
		try {
			connection = datasource.getConnection();
			String update_query = "update book_db set price =? where id=?";
			PreparedStatement pst = connection.prepareStatement(update_query);
			pst.setDouble(1, book.getPrice());
			pst.setInt(2, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Book getBookById(int id) {
		Book book = null;
		Connection connection;
		try {
			connection = datasource.getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from book_db where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"));
			} else {
				throw new DataAccessException("book with id " + id + " is not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

}
