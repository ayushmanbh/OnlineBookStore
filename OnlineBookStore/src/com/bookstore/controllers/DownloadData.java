package com.bookstore.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/download")
public class DownloadData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DownloadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			response.sendRedirect("downloaddata.jsp");
		}else {
			String err = "Please login first.";
			request.setAttribute("msg", err);
			request.getRequestDispatcher("customer_login.jsp").include(request, response);
		}
	}

}
