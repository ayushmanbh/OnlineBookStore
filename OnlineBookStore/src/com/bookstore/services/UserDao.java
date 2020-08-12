package com.bookstore.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.models.Book;
import com.bookstore.models.User;

public class UserDao {
	
	public static Connection connection = null;
	
	public int addCustomer(User user)
	  {
		  int status=0;
		  try
		  { 
			  PreparedStatement ps=connection.prepareStatement("insert into users values(?,?,?,?,?,?)");
			   ps.setInt(1, user.getUserId()); 
			   ps.setString(2, user.getUname());
			   ps.setString(3, user.getPass());
			   ps.setString(4, user.getEmail());
			   ps.setString(5, user.getAddress());
			   ps.setString(6, user.getPhone());
			  status=ps.executeUpdate();
			  
			  
		  }catch(Exception e)
		  {
			  System.out.println(e);
		  }		  
		  return status;  
	  }
	
	public boolean checkUser(String uname, String pass)
	  {
		  boolean valid = false;
		  try
		  {
	            PreparedStatement ps = connection.prepareStatement("select * from users where uname=? and pass=?");
	            ps.setString(1, uname);
	            ps.setString(2, pass);
	            ResultSet rs = ps.executeQuery();
	            valid = rs.next();

	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        return valid;           
		  }
	
	public User getUserByName(String uname) {
		User user = null;
		try
		  {
	            PreparedStatement ps = connection.prepareStatement("select * from users where uname=?");
	            ps.setString(1, uname);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
					user = new User();
					user.setUserId(rs.getInt(1));
	               	 user.setUname(rs.getString(2));
	               	 user.setEmail(rs.getString(4));
	               	 user.setAddress(rs.getString(5));
	               	 user.setPhone(rs.getString(6));
				}

	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        return user;  
	}
	
	public Book getBookByTitle(String title) {
		Book book = null;
		try
		  {
	            PreparedStatement ps = connection.prepareStatement("select * from books where title=?");
	            ps.setString(1, title);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
					book = new Book();
					book.setPrice(rs.getDouble("price"));
					book.setStock(rs.getInt("stock"));
				}

	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        return book;  
	}


}
