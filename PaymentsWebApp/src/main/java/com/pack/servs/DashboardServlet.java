package com.pack.servs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.dto.User;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DashboardServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession  session = request.getSession();
		User sessionUser = (User)session.getAttribute("user");
		
		if(sessionUser != null) {
			response.setContentType("text/html");  
			request.setAttribute("username", sessionUser);
			RequestDispatcher rd =  request.getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");  
			response.getWriter().write("<p style='color:red;'>Invalid Credentials</p>");
			RequestDispatcher rd =  request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}
	}

}
