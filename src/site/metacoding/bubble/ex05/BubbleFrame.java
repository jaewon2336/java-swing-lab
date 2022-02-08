package site.metacoding.bubble.ex05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon 목적 : 점프
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

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // int니까 ==으로 비교
					// isRight를 false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft를 false
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) { // 누르면
				// 왼 37, 오 39, 위 38, 아래 40
				// System.out.println("키보드 프레스 : " + e.getKeyCode());

				// 그러기 위해선 누르고 있는지 누르고 있지 않은지 확인하는 상태 변수가 필요하다.
				if (e.getKeyCode() == 39) { // int니까 ==으로 비교
					// 키보드를 누르고 있는 동안 right() 메서드는 한번만 실행하고 싶다.
					if (!player.isRight()) { // == false 와 같음
						player.right(); // 이동은 플레이어의 책임
					}
				} else if (e.getKeyCode() == 37) {
					if (!player.isLeft()) {
						player.left();
					}
				} else if (e.getKeyCode() == 38) {
					if (!player.isJump()) {
						player.isJump();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
