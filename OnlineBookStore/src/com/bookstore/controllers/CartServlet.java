package com.bookstore.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.models.Order;
import com.bookstore.server.Server;
import com.bookstore.services.OrderDao;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
        OrderDao.connection =Server.getConnect();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			OrderDao orderDao = new OrderDao();
			List<Order> userOrders = orderDao.getOrdersByUserid((Integer)session.getAttribute("userid"));
			session.setAttribute("userOrders", userOrders);
			response.sendRedirect("cart.jsp");
		}else {
			String msg = "Please login first.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").include(request, response);
		}
	}

}
