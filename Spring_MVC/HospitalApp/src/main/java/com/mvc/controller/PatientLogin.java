package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.DBConnection.ConnectionDB;

public class PatientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PatientLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 PrintWriter out = response.getWriter();  
			Connection con=ConnectionDB.InitializeDatabase();
			String Username=request.getParameter("username");
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("user", Username);
			PreparedStatement ps=con.prepareStatement("select * from patients where username=?");
			ps.setString(1, Username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("patientHome.jsp");
				
			}
			

		} catch (ClassNotFoundException e) {
						e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
