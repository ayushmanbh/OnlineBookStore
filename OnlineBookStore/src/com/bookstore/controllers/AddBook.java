package com.bookstore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.models.Book;
import com.bookstore.server.Server;
import com.bookstore.services.AdminDao;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/addbook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        AdminDao.connection = Server.getConnect();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bpub = request.getParameter("bpub");
		double bprice = Double.parseDouble(request.getParameter("bprice"));
		String bcat = request.getParameter("bcat");
		int bstock = Integer.parseInt(request.getParameter("bstock"));
		
		Book book = new Book();
		book.setTitle(bname);
		book.setAuthor(bauthor);
		book.setPublisher(bpub);
		book.setPrice(bprice);
		book.setCategory(bcat);
		book.setStock(bstock);
		
		HttpSession session = request.getSession(false);
		if(session == null){
			out.print("<h3>Please login first</h3>");
			out.print("<a href=\"static/html/index.html\">Home</a>");
		}else {
			AdminDao adminDao = new AdminDao();
			int status = adminDao.addBook(book);
			List<Book> books = adminDao.getAllBooks();
			
			session.setAttribute("books", books);
			if (status > 0) {
				String msg = "Successfully added to database";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("adminoffice.jsp").include(request, response);
			}else {
				String msg = "Not added to database";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("adminoffice.jsp").include(request, response);
			}
		}
		
		
		
	}

}
