package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame {

	// 컴포넌트, 컨테이너들은 전역변수로 만들어줌
	// 생성자는 스택, 지역변수 오래못감

	JPanel myPanel;
	JButton btn1, btn2; // Ctrl + Shift + O import 단축키
	JCheckBox checkBox1;
	JLabel labelText, labelImg; // Label에는 text도 넣을 수 있고, img도 넣을 수 있음 div임 !!

	public EventEx01() {

		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	private void initSetting() {
		setSize(300, 300);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 클릭시 main 종료
	}

	private void initObject() {
		myPanel = new JPanel(); // heap에 띄우기
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		checkBox1 = new JCheckBox();
		labelText = new JLabel("레이블1");
		// 내 프로젝트 위치부터 상대경로가 지정되어 있음
		// 만약 절대경로라면 C:\getinthere.. 다 적어줘야함
		labelImg = new JLabel(new ImageIcon("image/dog.jpg"));
	}

	private void initAssign() {
		add(myPanel);

		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		myPanel.add(labelText);
		myPanel.add(labelImg);
	}

	private void initListener() {
		checkBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// System.out.println(e);
				// System.out.println(e.getStateChange());

				if (e.getStateChange() == 1) {
					System.out.println("체크되었습니다.");
				} else {
					System.out.println("체크 해제 되었습니다.");
				}
			}
		});

		// 윈도우야 지켜봐줘 이 버튼을
		btn1.addActionListener(new ActionListener() { // 익명 클래스

			// 버튼이 클릭되면 윈도우가 해당 메서드를 콜백해준다.
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1이 클릭되었습니다.");

			}
		});

		btn2.addActionListener((ActionEvent e) -> {
			System.out.println("버튼2가 클릭되었습니다.");
		});

	}

	public static void main(String[] args) {
		new EventEx01();
	}

}
