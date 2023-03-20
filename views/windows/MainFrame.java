package windows;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JLabel jl_Top;
	private MyPanel myPanel1;
	private MyPanel myPanel2;
	private MyPanel myPanel3;
	private Font Font1;
	private JPanel MainPage;
	private JPanel jp_Center;
	private JLabel jl_cTop;
	private JComboBox<String> jc_btCenter;
	private JPanel jp_Bottom;
	private JButton JButton;
	private JButton jb_bLogin;
	private JButton jb_bJoin;
	private JButton jb_bList;
	private JButton jb_bMyPage;
	private JButton jb_bRead;
	private JButton jb_bExit;
	private Container myPanel;
	
	private void setComp() {
		Font1 = new Font("맑은 고딕",Font.BOLD,30);
		jl_Top = new JLabel("로그인 후 이용해주세요.");
		myPanel = new MyPanel("./asset/메인1.jpg");
		JButton = new JButton("");

		MainPage = new JPanel(new BorderLayout());
		MainPage.setBorder(BorderFactory.createLineBorder(Color.blue));

		// Top
		jl_Top.setFont(Font1);
		jl_Top.setForeground(Color.white);
		myPanel.add(jl_Top);
		MainPage.add(myPanel, BorderLayout.NORTH);
		
		 
		//CENTER
		jp_Center = new JPanel();
		jl_cTop = new JLabel("인기 도서");
		jc_btCenter = new JComboBox<String>();
		jp_Center.add(jl_cTop);
		jp_Center.add(jc_btCenter);
		jp_Center.setBorder(BorderFactory.createLineBorder(Color.pink));
		MainPage.add(jp_Center, BorderLayout.CENTER);
		
		//BOTTOM
		jp_Bottom = new JPanel();
		jb_bLogin = new JButton("로그인");
		jb_bJoin = new JButton("회원가입");
		jb_bList = new JButton("도서 목록");
		jb_bMyPage = new JButton("마이 페이지");
		jb_bRead = new JButton("책 읽기");
		jb_bExit = new JButton("종료");
		jp_Bottom.add(jb_bLogin);
		jp_Bottom.add(jb_bJoin);
		jp_Bottom.add(jb_bList);
		jp_Bottom.add(jb_bMyPage);
		jp_Bottom.add(jb_bRead);
		jp_Bottom.add(jb_bExit);
		jp_Bottom.setBorder(BorderFactory.createLineBorder(Color.green));
		MainPage.add(jp_Bottom, BorderLayout.SOUTH);
	}
	
	private void setInit() {
		super.setTitle("메인");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setResizable(false);
		super.setSize(900, 750);
		super.setLocationRelativeTo(null);
		
	}
	
	private void setDesign() {
		
		super.add(MainPage); 
	}
	
	private void setEvents() {
		jb_bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                setVisible(false); // 창 안보이게 하기 
            }
        });
	}
	public MainFrame() {		
		setComp();
		setInit();
		setDesign();
		setEvents();
		
		super.setVisible(true);
	}

}
