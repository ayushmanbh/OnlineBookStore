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
		
		Book book = new Book();
		book.setTitle(bname);
		book.setAuthor(bauthor);
		book.setPublisher(bpub);
		book.setPrice(bprice);
		book.setCategory(bcat);
		
		AdminDao adminDao = new AdminDao();
		int status = adminDao.addBook(book);
		List<Book> books = adminDao.getAllBooks();
		HttpSession session = request.getSession(false);
		session.setAttribute("books", books);
		if (status > 0) {
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Book added to database');");
			   out.println("location='adminoffice.jsp';");
			   out.println("</script>");
		}else {
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Some error occured. Book not added to database');");
			   out.println("location='adminoffice.jsp';");
			   out.println("</script>");
		}
		
	}

}
