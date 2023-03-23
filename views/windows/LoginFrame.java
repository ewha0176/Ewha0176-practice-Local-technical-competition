package windows;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.*;

public class LoginFrame extends JFrame {
	private DbManager dbMgr;
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

		// title
		gbc.gridy = 0;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;

		lTop = new JLabel("로그인");
		lTop.setFont(Font1);
		LoginFrame.add(lTop, gbc);
		gbc.gridwidth = 1;

		// id
		gbc.gridy = 1;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		id = new JLabel("아이디", JLabel.LEFT);
		gbc.gridx = 0;
		LoginFrame.add(id, gbc);

		idT = new JTextField(20);
		gbc.gridx = 1;
		LoginFrame.add(idT, gbc);

		// pw
		gbc.gridy = 2;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pw = new JLabel("비밀번호", JLabel.LEFT);
		gbc.gridx = 0;
		LoginFrame.add(pw, gbc);

		pwT = new JPasswordField(20);
		gbc.gridx = 1;
		LoginFrame.add(pwT, gbc);

		// LoginBTN
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
		ImageIcon img = new ImageIcon("./asset/logo.png");
	    super.setIconImage(img.getImage());
	    }

	private void setDesign() {

		super.add(LoginFrame);
	}

	private void setEvents() {

		Login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idT.getText();
				String pw = pwT.getText();

				// 빈칸이 있을 때
				if (id.equals("") || pw.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸이 있습니다.", "정보", JOptionPane.DEFAULT_OPTION);
					
					return;
				}
				String sql = "SELECT * FROM 2023지방_2.user WHERE u_id = \"" + id + "\" AND u_pw = \"" + pw + "\"";
				System.out.println(sql);
				ResultSet rs = dbMgr.getRs(sql);

				String name = "";
				try {
					rs.next();
					name = rs.getString("u_name");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				if (name != "") { // 유저 로그인
					JOptionPane.showMessageDialog(null, name + "님 로그인 되었습니다.", "정보", JOptionPane.DEFAULT_OPTION);
					new UserFrame();
					setVisible(false);
				} else if (id.equals("admin") && pw.equals("1234")) { // 관리자 로그인
					JOptionPane.showMessageDialog(null, "관리자 로그인 되었습니다.", "정보", JOptionPane.DEFAULT_OPTION);
					new AdminFrame();
					setVisible(false);
				} else { // 로그인 실패
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다.", "정보",
							JOptionPane.DEFAULT_OPTION);
					idT.setText("");
					pwT.setText("");
					idT.requestFocus();
				}
			}

		});
	}

	public LoginFrame() {
		dbMgr = new DbManager();
		setComp();
		setInit();
		setDesign();
		setEvents();

		super.setVisible(true);
	}

}
