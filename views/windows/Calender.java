package windows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calender extends JFrame {

	private Font Font1;
	private JFrame frame;

	private void setComp() {
		Font1 = new Font("맑은 고딕", Font.BOLD, 25);

	}

	private void setInit() {
		super.setTitle("대출연장");
		super.setResizable(false);
		super.setSize(600, 600);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("./asset/logo.png");
	    super.setIconImage(img.getImage());
	}
	
	private void setDesign() {
		
	}

	private void setEvents() {
		
	}
	
	public Calender() {
		setComp();
		setInit();
		setDesign();
		setEvents();
	}
}
