package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jdbc.DbManager;

//import jdbc.Operator;

public class UserFrame extends JFrame {
	private DbManager dbMgr;
	private JLabel jl_Top;
	private Font Font1;
	private JPanel MainPage;
	private JPanel jp_Center;
	private JLabel jl_cTop;
	private JComboBox<String> jc_btCenter;
	private JPanel jp_Bottom;
	private JButton JButton;
	private JButton jb_bLogOut;
	private JButton jb_bJoin;
	private JButton jb_bList;
	private JButton jb_bMyPage;
	private JButton jb_bRead;
	private JButton jb_bExit;
	private Container myPanel;

	private void setComp() {
		String sql = "SELECT * FROM 2023지방_2.user";
		ResultSet rs = dbMgr.getRs(sql);

		String name = "";
		try {
			rs.next();
			name = rs.getString("u_name");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		Font1 = new Font("맑은 고딕", Font.BOLD, 30);
		jl_Top = new JLabel(name + "님 환영합니다.");
		myPanel = new MyPanel("./asset/메인1.jpg");
		JButton = new JButton("");

		MainPage = new JPanel(new BorderLayout());

		// Top
		jl_Top.setFont(Font1);
		jl_Top.setForeground(Color.white);
		myPanel.add(jl_Top);
		MainPage.add(myPanel, BorderLayout.NORTH);

		// CENTER
		jp_Center = new JPanel();
		jl_cTop = new JLabel("인기 도서");
		jc_btCenter = new JComboBox<String>();
		jp_Center.add(jl_cTop);
		jp_Center.add(jc_btCenter);
		MainPage.add(jp_Center, BorderLayout.CENTER);

		// BOTTOM
		jp_Bottom = new JPanel();
		jb_bLogOut = new JButton("로그아웃");
		jb_bJoin = new JButton("회원가입");
		jb_bJoin.setEnabled(false);
		jb_bList = new JButton("도서 목록");
		jb_bMyPage = new JButton("마이 페이지");
		jb_bRead = new JButton("책 읽기");
		jb_bExit = new JButton("종료");
		jp_Bottom.add(jb_bLogOut);
		jp_Bottom.add(jb_bJoin);
		jp_Bottom.add(jb_bList);
		jp_Bottom.add(jb_bMyPage);
		jp_Bottom.add(jb_bRead);
		jp_Bottom.add(jb_bExit);
		MainPage.add(jp_Bottom, BorderLayout.SOUTH);
	}

	private void setInit() {
		super.setTitle("메인");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setResizable(false);
		super.setSize(900, 750);
		super.setLocationRelativeTo(null);
		ImageIcon img = new ImageIcon("./asset/logo.png");
	    super.setIconImage(img.getImage());

	}

	private void setDesign() {

		super.add(MainPage);
	}

	private void setEvents() {

		// 로그아웃 버튼
		jb_bLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				setVisible(false);
			}
		});
		
		jb_bList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ListFrame();
				setVisible(false);
				
			}
		});

		// 종료 버튼
		jb_bExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	public UserFrame() {
		dbMgr = new DbManager();
		setComp();
		setInit();
		setDesign();
		setEvents();

		super.setVisible(true);
	}

}
