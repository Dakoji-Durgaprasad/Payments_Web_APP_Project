package com.pack.servs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.dto.User;
import com.pack.dao.PaymentsWebAppDAO;

@WebServlet("/SendMoneyServlet")
public class SendMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendMoneyServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("user");

		if (sessionUser != null) {
			double txnAmount = Double.parseDouble(request.getParameter("txnamount"));
			String from = request.getParameter("txnFrom");
			String to = request.getParameter("txnTo");
			double userWalletTosendMoney = Double.parseDouble(request.getParameter("userWalletTosendMoney"));
			double userBankAcctToSendMoney = Double.parseDouble(request.getParameter("userBankAcctToSendMoney"));
			PaymentsWebAppDAO dao = new PaymentsWebAppDAO();
			if (from.equals("wallet")) {
				
				try {
					if (dao.verifyUserWalletBalance(sessionUser.getUserId(), userWalletTosendMoney)) {

						if (to.equals("wallet")) {

						} else if (to.equals("bank")) {

						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (from.equals("bank")) {
				try {
					if (dao.verifyUserCurBankBalance(sessionUser.getUserId(), userBankAcctToSendMoney)) {

						if (to.equals("wallet")) {

						} else if (to.equals("bank")) {

						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				response.setContentType("text/html");
				request.setAttribute("username", sessionUser);
				response.getWriter().write("<p style='color:red;'> Invalid Credentials Enter Valid User address(like wallet, bank) to send money. </p>");
				RequestDispatcher rd = request.getRequestDispatcher("/sendmoney.jsp");
				rd.include(request, response);
			}

		} else {
			response.setContentType("text/html");
			response.getWriter().write("<p style='color:red;'>Invalid Credentials</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}
	}

}
