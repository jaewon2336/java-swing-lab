package site.metacoding.bubble.ex03;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon 목적 : 키보드의 입력을 받아 좌우 이동
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player; // JLabel

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();

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

	// 키보드
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { // 누른걸 떼면
				System.out.println("키보드 릴리즈");
			}

			@Override
			public void keyPressed(KeyEvent e) { // 누르면
				// 왼 37, 오 39, 위 38, 아래 40
				System.out.println("키보드 프레스 : " + e.getKeyCode());

				if (e.getKeyCode() == 39) { // int니까 ==으로 비교
					player.right(); // 이동은 플레이어의 책임
				} else if (e.getKeyCode() == 37) {
					player.left();
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
