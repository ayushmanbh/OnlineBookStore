package com.bookstore.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.bookstore.models.Book;
import com.bookstore.models.Order;
import com.bookstore.models.User;

public class AdminDao {
	public static Connection connection = null;
	
	  public int addBook(Book book)
	  {
		  int status=0;
		  try
		  {
			  PreparedStatement ps = connection.prepareStatement("insert into books values(?,?,?,?,?,?)"); 
			   ps.setString(1, book.getTitle());
			   ps.setString(2, book.getAuthor());
			   ps.setString(3, book.getPublisher());
			   ps.setString(4, book.getCategory());
			   ps.setDouble(5, book.getPrice());
			   ps.setInt(6, book.getStock());
			  status=ps.executeUpdate();  
		  }catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  return status;  
	  }
	  
	  public List<Book> getAllBooks()
		{
			List<Book> bookDetails = new ArrayList<Book>();
			try
			{
				 PreparedStatement ps=connection.prepareStatement("select * from books");
				                       ResultSet res = ps.executeQuery();
				                       while(res.next())
				                       {
				                    	 Book b1 = new Book();
				                    	 b1.setTitle(res.getString(1));
				                    	 b1.setAuthor(res.getString(2));
				                    	 b1.setPublisher(res.getString(3));
				                    	 b1.setCategory(res.getString(4));
				                    	 b1.setPrice(res.getDouble(5));
				                    	 b1.setStock(res.getInt(6));
				                    	 bookDetails.add(b1);
				                       }
	
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return bookDetails;	
		}
	  
	  public List<User> getAllUsers(){
		  List<User> userDetails = new ArrayList<User>();
			try
			{
				 PreparedStatement ps=connection.prepareStatement("select * from Users");
				                       ResultSet res = ps.executeQuery();
				                       while(res.next())
				                       {
				                    	 User u1 = new User();
				                    	 u1.setUserId(res.getInt(1));
				                    	 u1.setUname(res.getString(2));
				                    	 u1.setEmail(res.getString(4));
				                    	 u1.setAddress(res.getString(5));
				                    	 u1.setPhone(res.getString(6));
				                    	 userDetails.add(u1);
				                       }
	
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return userDetails;	
	  }
	  
	  public List<Order> getAllCompletedOrders(){
		  List<Order> orderDetails = new ArrayList<Order>();
			try
			{
				 PreparedStatement ps=connection.prepareStatement("select * from orders where status = 'completed'");
				                       ResultSet res = ps.executeQuery();
				                       while(res.next())
				                       {
				                    	 Order o1 = new Order();
				                    	 o1.setOrderid(res.getInt(1));
				                    	 o1.setUserid(res.getInt(2));
				                    	 o1.setOrderdate(res.getDate(4).toString());
				                    	 o1.setTotalamount(res.getDouble(5));
				                    	 o1.setStatus(res.getString(6));
				                    	 orderDetails.add(o1);
				                       }
	
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return orderDetails;	
	  }
	  
	  
	  public double revenue() {
		  double revenue = 0;
		  try {
			PreparedStatement ps = connection.prepareStatement("select sum(totalamt) as revenue from orders where status = 'completed'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				revenue = rs.getDouble("revenue");	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return revenue;
	  }
}
