package com.bookstore.controllers;

import java.io.IOException;
import java.util.Iterator;
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

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PayServlet() {
        super();
        OrderDao.connection = Server.getConnect();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		OrderDao orderDao = new OrderDao();
		if (session != null) {
			int status = 0;
			List<Order> orders = (List<Order>)session.getAttribute("userOrders");
			for (Order order : orders) {
				status += orderDao.updateStatus(order.getOrderid());
			}
			if (status == orders.size()) {
				String msg = "Thank you! Your order has been placed.";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("pay.jsp").include(request, response);
			}else {
				String msg = "Oops something went wrong.";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("pay.jsp").include(request, response);
			}
		}else {
			String msg = "Please login first.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("customer_login.jsp").include(request, response);
		}
	}

}
