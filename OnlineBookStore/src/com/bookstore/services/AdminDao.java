package com.bookstore.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.bookstore.models.Book;

public class AdminDao {
	public static Connection connection = null;
	
	  public int addBook(Book book)
	  {
		  int status=0;
		  try
		  {
			  Random rand = new Random();
			  int rand1 = rand.nextInt(10000);
			  String[] catArray = book.getCategory().split("");
			  String id = catArray[0] + catArray[1] + catArray[2] + Integer.toString(rand1);
			  PreparedStatement ps=connection.prepareStatement("insert into books values(?,?,?,?,?,?)");
//			   ps.setString(1, UUID.randomUUID().toString()); 
			   ps.setString(1, id); 
			   ps.setString(2, book.getTitle());
			   ps.setString(3, book.getAuthor());
			   ps.setString(4, book.getPublisher());
			   ps.setString(5, book.getCategory());
			   ps.setDouble(6, book.getPrice());
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
				                    	 b1.setId(res.getString(1));
				                    	 b1.setTitle(res.getString(2));
				                    	 b1.setAuthor(res.getString(3));
				                    	 b1.setPublisher(res.getString(4));
				                    	 b1.setCategory(res.getString(5));
				                    	 b1.setPrice(res.getDouble(6)); 
				                    	 bookDetails.add(b1);
				                       }
	
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return bookDetails;	
		}

}
