package com.bookstore.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.models.User;
import com.bookstore.server.Server;
import com.bookstore.services.OrderDao;
import com.bookstore.services.UserDao;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CustomerLogin() {
        super();
        UserDao.connection = Server.getConnect();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		UserDao userDao = new UserDao();
		if (userDao.checkUser(uname, pass)) {
			HttpSession session = request.getSession();
			User user = userDao.getUserByName(uname);
			session.setAttribute("userid", user.getUserId());
			session.setAttribute("name", uname);
			response.sendRedirect("bookstore.jsp");
		}else {
			String err = "Incorrect username or password. If you are a new user, please register first.";
			request.setAttribute("msg", err);
			request.getRequestDispatcher("customer_login.jsp").include(request, response);
		}
	}

}
