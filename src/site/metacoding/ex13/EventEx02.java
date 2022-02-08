package site.metacoding.ex13;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {

	int x = 100;
	int y = 200;

	// JPanel을 새로고침(다시 그린다)하는 것
	@Override
	protected void paintComponent(Graphics g) { // g는 붓이다.
		super.paintComponent(g);
		System.out.println("패널 다시 그려짐");
		// Panel에 그림이 다시 그려질 때마다 paintComponent가 호출되는 것
		g.drawLine(10, 20, x, y);
	}
}

public class EventEx02 extends JFrame implements UserInterface {

	MyPanel myPanel;
	JLabel labelText;
	JButton btn1, btn2; // 200, 300으로 변경

	public EventEx02() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	@Override
	public void initSetting() {
		setSize(500, 500);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 클릭시 main 종료
	}

	@Override
	public void initObject() {
		myPanel = new MyPanel();
		labelText = new JLabel("첫글자");
		btn1 = new JButton("글자변경");
		btn2 = new JButton("그림변경");
	}

	@Override
	public void initAssign() {
		add(myPanel); // JFrame에 Panel 하나 add
		myPanel.add(labelText); // getContentPane().add와 같은 것
		myPanel.add(btn1);
		myPanel.add(btn2);
	}

	@Override
	public void initListener() {
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setText 메서드는 부분 변경!!
				// 화면을 새로고침 하려면 다른 방법을 사용해야함
				// 어떤 메서드를 썼을 때 부분 변경인지 전체 변경인지 다 다름 !!!
				labelText.setText("두번째글자"); // setText 메서드는 내부에 paintComponent를 재호출해준다.
			}
		});

		// MyPanel 전체 새로고침
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.x = myPanel.x + 30;
				myPanel.y = myPanel.y + 30; // 실제로 값은 바뀜 ! 그림만 바뀌지 않은 상태 !!

				System.out.println(myPanel.x);
				System.out.println(myPanel.y);

				// repaint(); // this. 가 생략된것. 즉, MyFrame이 repaint
				myPanel.repaint(); // myPanel만 repaint
			}
		});
	}

	public static void main(String[] args) {
		new EventEx02();

	}

}
