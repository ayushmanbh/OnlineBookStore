package com.bookstore.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.models.User;
import com.bookstore.server.Server;
import com.bookstore.services.UserDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        UserDao.connection = Server.getConnect();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		Random ran = new Random();
		int userid = ran.nextInt(99999999);
		
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUserId(userid);
		user.setEmail(mail);
		user.setPass(pass);
		user.setAddress(address);
		user.setUname(uname);
		user.setPhone(phone);
		
		int status = userDao.addCustomer(user);
		if (status > 0) {
			String msg = "Successfully registered. Please login.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").include(request, response);
		}else {
			String msg = "Oops something went wrong. Please try again.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").include(request, response);
		}
	}

}
