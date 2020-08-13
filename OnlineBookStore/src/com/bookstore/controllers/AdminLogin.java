package com.bookstore.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.models.Book;
import com.bookstore.models.Order;
import com.bookstore.models.User;
import com.bookstore.server.Server;
import com.bookstore.services.AdminDao;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminLogin() {
        super();
        AdminDao.connection = Server.getConnect();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("uname") != null && request.getParameter("pass") != null) {
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			if (uname.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("name", uname);
							
				AdminDao adminDao = new AdminDao();
				List<Book> books = adminDao.getAllBooks();
				List<User> users = adminDao.getAllUsers();
				List<Order> orders = adminDao.getAllCompletedOrders();
				session.setAttribute("books", books);
				session.setAttribute("users", users);
				session.setAttribute("orders", orders);
				System.out.println(adminDao.revenue());
				session.setAttribute("revenue", adminDao.revenue());
				response.sendRedirect("adminoffice.jsp");
//				request.getRequestDispatcher("adminoffice.jsp").include(request, response);
			}else {
				String err = "You are not admin.";
				request.setAttribute("err", err);
				request.getRequestDispatcher("error.jsp").include(request, response);
			}
		}else {			
			HttpSession session = request.getSession(false);
			if (session != null) {
				request.getRequestDispatcher("adminoffice.jsp").include(request, response);
			}else {
				String err = "You are not admin.";
				request.setAttribute("err", err);
				request.getRequestDispatcher("error.jsp").include(request, response);
			}	
		}	
	}

}
