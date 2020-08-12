package com.bookstore.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.models.Book;
import com.bookstore.models.Order;
import com.bookstore.server.Server;
import com.bookstore.services.OrderDao;
import com.bookstore.services.UserDao;

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddToCart() {
        super();
        UserDao.connection = Server.getConnect();
        OrderDao.connection = Server.getConnect();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null ) {
			int status = 0;
			String[] booktitles = request.getParameterValues("titles");
			for (int i = 0; i < booktitles.length; i++) {				
				UserDao userDao = new UserDao();
				OrderDao orderDao = new OrderDao();
				Order order = new Order();
				Random random = new Random();
				int orderid= random.nextInt(99999999);
				order.setOrderid(orderid);
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				order.setOrderdate(df.format(date));
				order.setStatus("pending");
				Book book = userDao.getBookByTitle(booktitles[i]);
				order.setTotalamount(book.getPrice());
				order.setUserid((Integer)session.getAttribute("userid"));
				order.setTitle(booktitles[i]);
				status += orderDao.addOrder(order);
			}
			if (status == booktitles.length) {
				String err = "Order added to your cart.";
				request.setAttribute("msg", err);
				request.getRequestDispatcher("bookstore.jsp").include(request, response);
			}
			
		}else {
			String err = "Your session has timed out. Please login again.";
			request.setAttribute("msg", err);
			request.getRequestDispatcher("customer_login.jsp").include(request, response);
		}
		
		
		
	}

}
