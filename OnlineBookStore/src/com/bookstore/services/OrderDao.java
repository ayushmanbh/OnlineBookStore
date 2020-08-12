package com.bookstore.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.models.Order;
import com.bookstore.models.User;

public class OrderDao {
	public static Connection connection = null;
	
	public int addOrder(Order order)
	  {
		  int status=0;
		  try
		  { 
			  PreparedStatement ps=connection.prepareStatement("insert into orders values(?,?,?,?,?,?)");
			   ps.setInt(1, order.getOrderid()); 
			   ps.setInt(2, order.getUserid());
			   ps.setString(3, order.getTitle());
			   Date date = Date.valueOf(order.getOrderdate());
			   ps.setDate(4, date);
			   ps.setDouble(5, order.getTotalamount());
			   ps.setString(6, order.getStatus());
			  status=ps.executeUpdate();
			  
			  
		  }catch(Exception e)
		  {
			  System.out.println(e);
		  }		  
		  return status;  
	  }
	
	public List<Order> getOrdersByUserid(int userid){
		List<Order> orders = new ArrayList<Order>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from orders where userid=?");
			   ps.setInt(1, userid);
			   ResultSet rs = ps.executeQuery();
			   while (rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderid"));
				order.setTitle(rs.getString("title"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
}
