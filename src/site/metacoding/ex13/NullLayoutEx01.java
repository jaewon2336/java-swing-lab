package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NullLayoutEx01 extends MyFrame{

	public NullLayoutEx01() {
		super(300, 300);
		
		JPanel panel = (JPanel)getContentPane();
		panel.setLayout(null); // null 레이아웃 : 레이아웃 없앰
		// 크기와 위치를 정해주지 않으면 화면에 나타나지 않음
		
		JButton btn1 = new JButton("버튼1");
		
		btn1.setLocation(0, 0);
		btn1.setSize(100, 50);
		
		panel.add(btn1); 
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullLayoutEx01();
	}

}
