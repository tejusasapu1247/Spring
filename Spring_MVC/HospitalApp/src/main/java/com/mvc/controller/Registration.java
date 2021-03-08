package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.mvc.Bean.CentralBean;
import com.mvc.DBConnection.ConnectionDB;
import com.mysql.jdbc.Statement;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Name = request.getParameter("rname");
		String Email = request.getParameter("remail");
		String PhoneNumber = request.getParameter("rphone number");
		String Disease = request.getParameter("disease");
		String UserName = request.getParameter("rusername");
		String Password = request.getParameter("rpassword");
		String ConfirmPassword = request.getParameter("rcpassword");

		try {
			Connection con = ConnectionDB.InitializeDatabase();

			PreparedStatement st = con.prepareStatement("insert into patients values(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, Name);
			st.setString(2, Email);
			st.setString(3, PhoneNumber);
			st.setString(4, Disease);
			st.setString(5, UserName);
			st.setString(6, Password);
			st.setString(7, ConfirmPassword);
			st.executeUpdate();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("patientHome.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
