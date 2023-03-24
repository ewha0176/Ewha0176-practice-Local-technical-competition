package windows;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class ListFrame extends JFrame {

	private Font Font1;
	private JPanel main_panel;
	private JLabel jl_tTitle;
	private ComboBoxModel<String> book_list;
	private JPanel jp_search;
	private JLabel jl_search;
	private JComboBox<String> jc_search;
	private JTextField jt_search;
	private JButton jb_search;
	private JList d_List;
	private ListModel list_string;
	private JScrollPane scrollpane;
	private JPanel jp_scroll;
	private JPanel List;
	private JScrollPane scrollbar;
	private JPanel jp_scrollPanel;

	private void setComp() {

		Font1 = new Font("맑은 고딕", Font.BOLD, 30);

		main_panel = new JPanel(new GridBagLayout());

		// Title
		GridBagConstraints gbc_Title = new GridBagConstraints();
		gbc_Title.gridx = 0;
		gbc_Title.gridy = 0;
		gbc_Title.gridheight = 1;

		jl_tTitle = new JLabel("도서 목록", jl_tTitle.CENTER);
		jl_tTitle.setFont(Font1);
		main_panel.add(jl_tTitle, gbc_Title);

		// Search
		GridBagConstraints gbc_Search = new GridBagConstraints();
		gbc_Search.gridx = 0;
		gbc_Search.gridy = 1;
		gbc_Search.gridheight = 1;

		String book_list[] = { "도서명", "저자" };
		jp_search = new JPanel(new GridBagLayout());
		jl_search = new JLabel("검색");
		jc_search = new JComboBox<String>(book_list);
		jt_search = new JTextField(10);
		jb_search = new JButton("검색");

		jp_search.add(jl_search);
		jp_search.add(jc_search);
		jp_search.add(jt_search);
		jp_search.add(jb_search);

		main_panel.add(jp_search, gbc_Search);

		// Division
		GridBagConstraints gbc_Division = new GridBagConstraints();
		gbc_Division.gridx = 0;
		gbc_Division.gridy = 2;
		gbc_Division.gridheight = 1;

		List = new JPanel();
		String division[] = { "분류", "전체", "총류", "철학", "종교", "사회과학", "자연과학", "기술과학", "예술", "언어", "문학", "역사" };
		ListModel<String> listModel = new DefaultListModel<>();
		for (String s : division) {
			((DefaultListModel<String>) listModel).addElement(s);
		}
		JList<String> d_List = new JList<>(listModel);

		jp_scroll = new JPanel(new GridBagLayout());

		ButtonGenerator panel = new ButtonGenerator();

		scrollbar = new JScrollPane(panel.getImg());
		scrollbar.setPreferredSize(new Dimension(800, 500));
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		jp_scrollPanel = new JPanel(new GridBagLayout());
		List.add(d_List);
		jp_scroll.add(List, gbc_Division);
		jp_scrollPanel.add(scrollbar);

		main_panel.add(jp_scroll, gbc_Division);
		main_panel.add(jp_scrollPanel, gbc_Division);

	}

	private void setInit() {
		// TODO Auto-generated method stub
		super.setTitle("도서목록");
		super.setResizable(false);
		super.setSize(1000, 800);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("./asset/logo.png");
		super.setIconImage(img.getImage());
	}

	private void setDesign() {
		super.add(main_panel);

	}

	private void setEvents() {

	}

	public ListFrame() {
		setComp();
		setInit();
		setDesign();
		setEvents();

		setVisible(true);
	}

}