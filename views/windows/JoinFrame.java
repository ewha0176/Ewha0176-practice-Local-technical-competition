package windows;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.*;

public class JoinFrame extends JFrame {
	private DbManager dbMgr;
	private Font Font1;
	private JLabel lTop;
	private JPanel JoinFrame;
	private JLabel name;
	private JTextField nameT;
	private JLabel id;
	private JTextField idT;
	private JLabel pw;
	private JTextField pwT;
	private JButton Join;

	private void setComp() {
		// TODO Auto-generated method stub
		Font1 = new Font("맑은 고딕", Font.BOLD, 25);

		JoinFrame = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// title
		gbc.gridy = 0;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;

		lTop = new JLabel("회원가입");
		lTop.setFont(Font1);
		JoinFrame.add(lTop, gbc);
		gbc.gridwidth = 1;

		// name
		gbc.gridy = 1;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		name = new JLabel("이름", JLabel.LEFT);
		gbc.gridx = 0;
		JoinFrame.add(name, gbc);

		nameT = new JTextField(20);
		gbc.gridx = 1;
		JoinFrame.add(nameT, gbc);

		// id
		gbc.gridy = 2;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		id = new JLabel("아이디", JLabel.LEFT);
		gbc.gridx = 0;
		JoinFrame.add(id, gbc);

		idT = new JTextField(20);
		gbc.gridx = 1;
		JoinFrame.add(idT, gbc);

		// pw
		gbc.gridy = 3;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pw = new JLabel("비밀번호", JLabel.LEFT);
		gbc.gridx = 0;
		JoinFrame.add(pw, gbc);

		pwT = new JTextField(20);
		gbc.gridx = 1;
		JoinFrame.add(pwT, gbc);

		// JoinBTN
		gbc.gridy = 4;
		gbc.weighty = 0.4;
		gbc.gridx = 0;
		Join = new JButton("회원가입");
		Join.setPreferredSize(new Dimension(200, 30));
		gbc.gridwidth = 2;
		JoinFrame.add(Join, gbc);

	}

	private void setInit() {
		// TODO Auto-generated method stub
		super.setTitle("회원가입");
		super.setSize(380, 200);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("./asset/logo.png");
		super.setIconImage(img.getImage());
	}

	private void setDesign() {

		super.add(JoinFrame);
	}

	private void setEvents() {
		Join.addActionListener(new ActionListener() {

			private int i;

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameT.getText();
				String id = idT.getText();
				String pw = pwT.getText();

				// 빈칸이 있을 때
				if (name.equals("") || id.equals("") || pw.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸이 있습니다.", "회원가입 실패", JOptionPane.DEFAULT_OPTION);
					return;
				} else if (name.length() < 2 || !name.matches("[가-힣]+")) { // 이름 2글자 미만 or 한글이 아님
					JOptionPane.showMessageDialog(null, "이름은 한글로 2글자 이상만 가능합니다.", "회원가입 실패",
							JOptionPane.DEFAULT_OPTION);
					nameT.setText("");
					nameT.requestFocus(); ;
				}

				String sql = "SELECT * FROM 2023지방_2.user WHERE u_id = \"" + id + "\"";
				System.out.println(sql);
				ResultSet rs = dbMgr.getRs(sql);

				String Id = "";
				try {
					Id = rs.getString("u_id");
					rs.next();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				if (id.equals(Id) || id.matches("[admin]+")) { // 아이디 중복
					JOptionPane.showMessageDialog(null, "이미 있는 아이디 입니다.", "정보", JOptionPane.DEFAULT_OPTION);
					idT.setText("");
					idT.requestFocus();
					return;
				} else if (id.matches("[가-힣]+")) { // 아이디 한글 포함
					JOptionPane.showMessageDialog(null, " 아이디에 한글은 사용이 불가능합니다", "정보", JOptionPane.DEFAULT_OPTION);
					idT.setText("");
					idT.requestFocus();
					return;
				} else if (pw.length() < 6 || !pw.matches("[a-z]+[1-9]+[!, @, #, $]+")) { // 비번 형식 불일치
					JOptionPane.showMessageDialog(null, " 비밀번호 형식이 일치하지 않습니다.", "정보", JOptionPane.DEFAULT_OPTION);
					pwT.setText("");
					pwT.requestFocus();
					return;
				} else if (pw.length() > 5) {

					boolean isConsecutive = false;
					for (int i = 0; i < pw.length() - 1; i++) {
						for (int j = i + 1; j < pw.length(); j++) {
							if (pw.charAt(i) == pw.charAt(j)) {
								isConsecutive = true;
								break;
							}
						}
						if (isConsecutive) {
							break;
						}
					}
					if (isConsecutive) { // 연속된 문자가 있는 경우
						JOptionPane.showMessageDialog(null, "비밀번호는 연속으로 같은 글자가 올 수 없습니다.", "정보",
								JOptionPane.DEFAULT_OPTION);
						pwT.setText("");
						pwT.requestFocus();
						return;
					} else { // 회원가입 완료
						JOptionPane.showMessageDialog(null, name + "님 회원가입이 완료되었습니다.", "정보",
								JOptionPane.DEFAULT_OPTION);
						sql = "INSERT INTO 2023지방_2.user (u_name, u_id, u_pw) VALUES ('" + name + "', '" + id + "', '"
								+ pw + "')";
						dbMgr.executeSql(sql);
						new MainFrame();
						setVisible(false);
					}
				}
			}
		});
	}

	public JoinFrame() {
		dbMgr = new DbManager();

		setComp();
		setInit();
		setDesign();
		setEvents();

		super.setVisible(true);
	}

}
