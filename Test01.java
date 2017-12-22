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
	// Font ����Ʈ ����� ������ ����Ʈ ���� ComboBox ��
	private JMenuItem menuItem1 = new JMenuItem("Font Size");  // ComboBox
	private JMenuItem menuItem2 = new JMenuItem("Font Style"); // 3���� �޴������ۿ� '��' ��Ʈ �ٸ���
	private JMenuItem menuItem3 = new JMenuItem("Font Color"); // '��' �� ���õ� ���� �������ִ� ��ư + ColorChooser(ComboBox ���·�)
	private JMenuItem menuItem4 = new JMenuItem("Allign");			// ���� -- ??
	private JMenuItem menuItem5 = new JMenuItem("CheckBox"); // üũ�ڽ����� �ش���� �տ� �߰��Ҽ��ִ� ���� �����ܵ鵵 ����
   																									   // textarea ���� ���� panel �ϳ� �����ؼ� �׸��� �ɵ� -> Memo Ŭ���� �����ʿ�
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
		listp1.addLabel("�׽�Ʈ");
		listp1.addLabel("�׽�Ʈ12312");
		listp1.addLabel("�׽�Ʈ1212");
		listp2.addLabel("�׽�Ʈ���˿�");
		listp2.addLabel("�׽�Ʈ����");
		listp2.addLabel("�׽�Ʈ�ھ���");
		
		
		
		
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
