package com.bookstore.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.server.Server;
import com.bookstore.services.OrderDao;

/**
 * Servlet implementation class BookstoreServlet
 */
@WebServlet("/bookstore")
public class BookstoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookstoreServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession(false);
			if (session != null) {
				response.sendRedirect("bookstore.jsp");
			}else {
				String err = "You are not Logged in. Please login first.";
				request.setAttribute("msg", err);
				request.getRequestDispatcher("customer_login.jsp").include(request, response);
			}	
			
	}

}
