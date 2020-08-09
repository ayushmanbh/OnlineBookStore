package com.bookstore.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

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

}
