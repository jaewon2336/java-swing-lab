package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator 목적 : 점프
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap; // 배경 이미지
	private Player player; // JLabel

	public BubbleFrame() {

		initSetting(); // 각종 모든 세팅
		initObject(); // new 하는 곳
		initListener(); // 리스너

		setVisible(true); // 내부에 paintComponent() 호출 코드가 있음
	}

	// 각종 모든 세팅
	private void initSetting() {
		setSize(1000, 640); // Frame Size
		getContentPane().setLayout(null); // null을 줘야 absoulute 레이아웃으로 변경됨
		setLocationRelativeTo(null); // Frame을 화면 중앙에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // 백그라운드 이미지 설정

		player = new Player(); // 플레이어 추가
		add(player); // Frame에 추가
	}

	// 리스너
	private void initListener() {
		// 키보드 리스너
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { // 누른걸 떼면
				System.out.println("키보드 릴리즈");

				// 키보드를 놓으면 상태를 변경해 주어야 함
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // VK_RIGHT = 39
					// isRight를 false로
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft를 false로
					player.setLeft(false);
				}
			}

			// 조이스틱
			@Override
			public void keyPressed(KeyEvent e) { // 키보드를 누르면
				// 왼쪽 37, 위쪽 38, 오른쪽 39, 아래쪽 40
				System.out.println("키보드 프레스 : " + e.getKeyCode());

				// 키보드를 누르고있는지 아닌지 확인하는 상태 변수
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

					// 키보드를 누르고 있는 동안 right() 메서드는 한번만 실행하고 싶다.
					if (player.isRight() == false) {
						player.right(); // 오른쪽으로 가고있지 않을때 오른쪽 키를 누르면 right() 메서드 실행
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					if (player.isLeft() == false) {
						player.left(); // 왼쪽으로 가고있지 않을때 왼쪽 키를 누르면 left() 메서드 실행
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {

					if (player.isJump() == false) {
						player.jump(); // 위쪽으로 가고있지 않을때 위쪽 키를 누르면 jump() 메서드 실행
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
