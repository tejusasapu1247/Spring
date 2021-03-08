package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.DBConnection.ConnectionDB;

/**
 * Servlet implementation class patientLogin
 */
public class PatientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con=ConnectionDB.InitializeDatabase();
			String Username=request.getParameter("username");
			PreparedStatement ps=con.prepareStatement("select * from patients where username=?");
			ps.setString(1, Username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("patientHome.jsp");
				rd.forward(request, response);
				
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
