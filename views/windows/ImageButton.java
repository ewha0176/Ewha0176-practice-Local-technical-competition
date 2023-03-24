package windows;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.*;

public class ImageButton extends JButton {
	public ImageButton(String imagePath) {
		setBorderPainted(false); // Remove button border
		setPreferredSize(new Dimension(195, 280));// Set button size
		super.setIcon(new ImageIcon(imagePath));
	}

	public static ImageButton[] CreateImageButtons(String[] imagePaths) {
		ImageButton[] imageButtons = null;

		return imageButtons;
	}
}