package windows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminFrame extends JFrame {

	private JLabel jl_Top;
	private Font Font1;
	private JPanel MainPage;
	private JPanel jp_Center;
	private JLabel jl_cTop;
	private JComboBox<String> jc_btCenter;
	private JPanel jp_Bottom;
	private JButton JButton;
	private JButton jb_bLogOut;
	private JButton jb_bAdd;
	private JButton jb_bManage;
	private JButton jb_bStatistics;
	private JButton jb_bExit;
	private Container myPanel;

	private void setComp() {

		Font1 = new Font("맑은 고딕", Font.BOLD, 30);
		jl_Top = new JLabel("관리자님 환영합니다.");
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
		jb_bManage = new JButton("도서관리");
		jb_bAdd = new JButton("도서등록");
		jb_bStatistics = new JButton("대출통계");
		jb_bExit = new JButton("종료");
		jp_Bottom.add(jb_bLogOut);
		jp_Bottom.add(jb_bManage);
		jp_Bottom.add(jb_bAdd);
		jp_Bottom.add(jb_bStatistics);
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
		
		//대출 통계 버튼
		jb_bStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StatFrame();
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

	public AdminFrame() {
		setComp();
		setInit();
		setDesign();
		setEvents();

		super.setVisible(true);
	}

}
