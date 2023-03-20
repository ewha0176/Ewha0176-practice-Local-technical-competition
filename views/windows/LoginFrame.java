package windows;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	
	private Font Font1;
	private JLabel lTop;
	private JPanel LoginFrame;
	private JLabel id;
	private JTextField idT;
	private JLabel pw;
	private JTextField pwT;
	private JButton Login;


	private void setComp() {
		// TODO Auto-generated method stub
		Font1 = new Font("맑은 고딕", Font.BOLD, 25);
		
		 LoginFrame = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		//title
		gbc.gridy = 0;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;
		
		lTop = new JLabel("로그인");
		lTop.setFont(Font1);
		LoginFrame.add(lTop, gbc);
		gbc.gridwidth = 1;
		
		// id
		gbc.gridy= 1;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		id = new JLabel("아이디", JLabel.LEFT);
		gbc.gridx = 0;
		LoginFrame.add(id, gbc);
		
		idT = new JTextField(20);
		gbc.gridx = 1;
		LoginFrame.add(idT, gbc);
		
		// pw
		gbc.gridy= 2;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pw = new JLabel("비밀번호", JLabel.LEFT);
		gbc.gridx = 0;
		LoginFrame.add(pw, gbc);
		
		
		pwT = new JTextField(20);
		gbc.gridx = 1;
		LoginFrame.add(pwT, gbc);
				
		//LoginBTN
		gbc.gridy = 3;
		gbc.weighty = 0.4;
		gbc.gridx = 0;
		Login = new JButton("로그인");
		Login.setPreferredSize(new Dimension(200, 30));
		gbc.gridwidth = 2;
		LoginFrame.add(Login, gbc);
	}

	private void setInit() {
		// TODO Auto-generated method stub
		super.setTitle("로그인");
		super.setSize(380, 200);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setDesign() {

		super.add(LoginFrame);
	}

	private void setEvents() {
		// TODO Auto-generated method stub
		
	}
	public LoginFrame() {
		setComp();
		setInit();
		setDesign();
		setEvents();
		
		super.setVisible(true);
	}
	
}
