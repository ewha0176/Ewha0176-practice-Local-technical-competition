package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	
	private Connection con;
	private Statement stmt;

	public DbManager() throws SQLException {
		
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306?allowLoadLocalInfile=true", "user", "12345678@");
	stmt = con.createStatement();
	}
	
	public void setUpdate(String sql) throws SQLException {
	stmt.executeUpdate(sql);	
	}

	public void getRs(String sql) throws SQLException {
	stmt.executeQuery(sql);
	}

}
