package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon 목적 : 배경화면 설정, 캐릭터 추가
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player; // JLabel

	public BubbleFrame() {
		initObject();
		initSetting();

		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // 백그라운드 화면 설정

		player = new Player(); // 플레이어 추가
		add(player); // Frame에 추가
	}

	// 각종 모든 세팅
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // null을 줘야 absolute 레이아웃이 됨
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
