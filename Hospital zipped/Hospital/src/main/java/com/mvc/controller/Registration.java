package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.DBConnection.ConnectionDB;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name=request.getParameter("rname").toString();
		String Email=request.getParameter("remail");
		String PhoneNumber=request.getParameter("rphone number");
		String Disease=request.getParameter("disease");
		String UserName=request.getParameter("rusername");
		String Password=request.getParameter("rpassword");
		String ConfirmPassword=request.getParameter("rcpassword");
		
		
		try{
			Connection con=ConnectionDB.InitializeDatabase();
			
			PreparedStatement st=con.prepareStatement("insert into patients values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
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
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		List <String> details=new ArrayList<String>();
		details.add(Name);
		details.add(Email);
		details.add(PhoneNumber);
		details.add(Disease);
		details.add(UserName);
		
		
		for(String d : details) {
			System.out.println(d);
		}
		request.setAttribute("details", details);	
		RequestDispatcher rd=request.getRequestDispatcher("pdashboard.jsp");
		rd.forward(request, response);
		
	
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
