package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import com.mysql.jdbc.Statement;
/**
 * Servlet implementation class DashBoardController
 */
public class DashBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DashBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CentralBean details = null;
		ResultSet rs=null;
		try {
			Connection con = ConnectionDB.InitializeDatabase();
			HttpSession httpSession=request.getSession();
			String username=(String) httpSession.getAttribute("user");
			
			PreparedStatement pst = con.prepareStatement("select * from patients where username=?");
			pst.setString(1, username);
			
			rs= pst.executeQuery();
			if(rs.next()) {
			details=new CentralBean(rs.getString("name"), rs.getString("email"), 
					                            rs.getString("phone")	, rs.getString("disease"),
					                            rs.getString("username"));
		
			
			List<CentralBean> record=Arrays.asList(details);
			
			request.setAttribute("record", record);
			request.getRequestDispatcher("pdashboard.jsp").forward(request, response);
			
			con.close();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}

		
	
	
	}

	

}
