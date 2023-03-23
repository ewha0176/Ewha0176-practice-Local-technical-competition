package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	private Connection con;
	private Statement stmt;

	public DbManager() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?allowLoadLocalInfile=true", "user",
					"12345678@");
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUpdate(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
		}
	}

	public ResultSet getRs(String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
		}
		return rs;
	}

	public int executeSql(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}
}
