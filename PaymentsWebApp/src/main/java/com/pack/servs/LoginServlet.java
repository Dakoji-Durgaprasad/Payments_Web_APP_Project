package com.pack.servs;

import com.pack.dao.*;
import com.pack.dto.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userNameOrPhoneNo = request.getParameter("username");
		String password = request.getParameter("pswd");

		System.out.println(userNameOrPhoneNo);
		System.out.println(password);
		
		Cookie ck = new Cookie("username",userNameOrPhoneNo);
		response.addCookie(ck);
		
		PaymentsWebAppDAO dao = new PaymentsWebAppDAO();
		try {
			if(dao.loginValidate(userNameOrPhoneNo, password)) {
//				User user = dao.getUserByUserNameOrUserPhNo(userNameOrPhoneNo);
				
//				request.setAttribute("user", user);
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
			} else {
				response.setContentType("text/html");  
				response.getWriter().write("<p style='color:red;'> Login failed try again !!! <p>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
