package windows;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.*;

public class ButtonGenerator {
	private DbManager dbMgr;

	JPanel panel = new JPanel(new GridLayout(0, 4));

	private JLabel book;

	public JPanel getImg() {
		for (int i = 1; i < 101; i++) {
			String path = String.format("./asset/book/%d.jpg", i);
			String sql = "SELECT b_name FROM 2023지방_2.book WHERE d_no = %d";
			ResultSet rs = dbMgr.getRs(sql);
			
			book = new JLabel();
			
			String Book = "";
			try {
				Book = rs.getString("b_name");
				rs.next();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			String text = String.format(Book, i);
			ImageButton btn = new ImageButton(path);
			
			
			panel.add(btn);
			
		}
		return panel;
	}
}