package com.bookstore.server;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Server {
	public static Connection getConnect() {
		Connection connection = null;
		try {
//			String filepath = "db.properties";
//			FileReader reader=new FileReader(filepath);
//			Properties p=new Properties();
//			p.load(reader);
//			String drivername=p.getProperty("driver");
//			String url=p.getProperty("dburl");
//			String user=p.getProperty("user");
			String drivername = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/bookstore?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			Class.forName(drivername);
			connection = DriverManager.getConnection(url, user, "");

			System.out.println("Connected to the database.");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

}
