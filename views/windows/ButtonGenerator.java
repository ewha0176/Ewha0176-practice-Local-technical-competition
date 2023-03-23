package windows;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ButtonGenerator {

	JPanel panel = new JPanel(new GridLayout(0, 4));

	public JPanel getImg() {
		for (int i = 1; i < 101; i++) {
			String path = String.format("./asset/book/%d.jpg", i);
			ImageButton btn = new ImageButton(path);
			panel.add(btn);

		}
		return panel;
	}
}
