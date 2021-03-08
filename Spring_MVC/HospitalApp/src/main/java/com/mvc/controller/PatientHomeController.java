package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.Bean.CentralBean;
import com.mvc.DBConnection.ConnectionDB;

public class PatientHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = ConnectionDB.InitializeDatabase();
			HttpSession httpSession=request.getSession();
			String username=(String) httpSession.getAttribute("user");
			request.setAttribute("name", username);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	
	
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
