package windows;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {
	public ImageButton(String imagePath) {
		setBorderPainted(false); // Remove button border
		setPreferredSize(new Dimension(100, 100)); // Set button size
		super.setIcon(new ImageIcon(imagePath));
	}

	public static ImageButton[] CreateImageButtons(String[] imagePaths) {
		ImageButton[] imageButtons = null;

		return imageButtons;
	}
}