package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	// 2개 고정
	// 출력할 때 앞에 TAG 붙여주기
	// 어디 클래스에서 남긴 log인지 확인하기 위해!
	private static final String TAG = "BubbleApp : ";
	private BubbleApp mContext = this;

	private BackgroundMap backgroundMap;
	private Player player;

	// 생성자
	public BubbleApp() {
		// 테스트가 끝나면 출력문 주석처리
		// System.out.println(TAG + "생성자 실행");
		initObject();
		initSetting();
		initListener();

		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleApp();
	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap(); // JLabel
		setContentPane(backgroundMap); // div 박스를 전체 배경화면으로 설정
		player = new Player(backgroundMap);

		add(player);
	}

	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	@Override
	public void initListener() {
		// 리스너는 어댑터를 다 가지고 있음
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

//				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
//					player.left();
//				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//					player.right();
//				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
//					player.up();
//				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//					player.down();
//				}

				// switch는 else-if가 아니라 if if if 이기 때문에
				// break가 없으면 모든 case를 다 검사한다.

				switch (e.getKeyCode()) { // 값 == case 값
				case KeyEvent.VK_LEFT:
					// 내부
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						System.out.println(TAG + "왼쪽 키 눌렀음");
						player.left();
					}
					break; // switch 종료

				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isLeftWallCrash()) {
						System.out.println(TAG + "오른쪽 키 눌렀음");
						player.right();
					}
					break;

				case KeyEvent.VK_UP:
					player.up();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) { // 값 == case 값
				case KeyEvent.VK_LEFT:
					// 내부
					player.setLeft(false);
					break; // switch 종료

				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			}
		});
	}

}
