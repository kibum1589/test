package ui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import test.Memo;

class Window extends JFrame {
	private int width = 800;
	private int height = 600;
	
	private Set<Memo> memolist = new HashSet<>();
	private JPanel bg = new JPanel(null);
	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new  HorizontalMenu("Home");
	// Font 리스트 만들수 있으면 리스트 만들어서 ComboBox 로
	private JMenuItem menuItem1 = new JMenuItem("Font Size");  // ComboBox
	private JMenuItem menuItem2 = new JMenuItem("Font Style"); // 3개의 메뉴아이템에 '가' 폰트 다르게
	private JMenuItem menuItem3 = new JMenuItem("Font Color"); // '가' 에 선택된 색깔 밑줄쳐있는 버튼 + ColorChooser(ComboBox 형태로)
	private JMenuItem menuItem4 = new JMenuItem("Allign");			// 정렬 -- ??
	private JMenuItem menuItem5 = new JMenuItem("CheckBox"); // 체크박스말고도 해당라인 앞에 추가할수있는 작은 아이콘들도 생각
   																									   // textarea 옆에 작은 panel 하나 생성해서 그리면 될듯 -> Memo 클래스 수정필요
	private JPanel testp1 = new JPanel();
	private JPanel testp2 = new JPanel();
	private JPanel testp3 = new JPanel();
	
	private ListPanel listp1 = new ListPanel();
	private ListPanel listp2 = new ListPanel();
	
	private void design() {
		setContentPane(bg);
		bg.setLayout(new BorderLayout(5, 5));
		
		bg.add(testp1,BorderLayout.CENTER);
		bg.add(testp2,BorderLayout.WEST);
		bg.add(testp3,BorderLayout.EAST);
		
		testp2.setPreferredSize(new Dimension(width/4, 0));
		testp3.setPreferredSize(new Dimension(width/4, 0));
		
		
		testp1.setBorder(BorderFactory.createLineBorder(Color.black));
		testp2.setBorder(BorderFactory.createLineBorder(Color.black));
		testp3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		testp2.setLayout(new GridLayout(1, 2));
		testp2.add(listp1);
		testp2.add(listp2);
		listp1.setLayout(new BoxLayout(listp1, BoxLayout.Y_AXIS));
		listp2.setLayout(new BoxLayout(listp2, BoxLayout.Y_AXIS));
		listp1.addLabel("테스트");
		listp1.addLabel("테스트12312");
		listp1.addLabel("테스트1212");
		listp2.addLabel("테스트오옹오");
		listp2.addLabel("테스트ㅇ앙");
		listp2.addLabel("테스트자야지");
		
		
		
		
	}
	
	private void menu() {
		setJMenuBar(bar);	
		bar.add(menu);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		menu.add(menuItem4);
		menu.add(menuItem5);
		
	}

	private void event() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		MenuListener men = new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent arg0) {
				bg.setLocation(bg.getX(),bg.getY()+30);
				
			}
			
			@Override
			public void menuDeselected(MenuEvent arg0) {
				bg.setLocation(bg.getX(),bg.getY()-30);
				
			}
			
			@Override
			public void menuCanceled(MenuEvent arg0) {
				bg.setLocation(bg.getX(),bg.getY()-30);
				
			}
		};
		menu.addMenuListener(men);
		
	}

	
	public Window() {
		design();
		menu();
		event();
		
		
		setTitle("GUI Test");
		setSize(width, height);
		setLocationByPlatform(true);	
		setVisible(true);
	}

	
}

public class Test01 {

	public static void main(String[] args) {
		JFrame f = new Window();
	}
}
