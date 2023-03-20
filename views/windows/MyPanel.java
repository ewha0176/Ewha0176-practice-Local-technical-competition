package windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private Image image;
	private Image MyPanel;

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.setSize(900,400);
		g.drawImage(image, 0, 0, 900, 400, null);
	}
	
	public MyPanel(String filePath) {
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fucking image");
		}
	}
}
