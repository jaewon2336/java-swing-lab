package site.metacoding.mytest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 정재원
 * 
 *
 */

// main을 가진 클래스는 해당 프로그램의 컨텍스트(문맥)를 다 알고 있다.
public class BubbleFrame extends JFrame {

	private static final String TAG = "BubbleFrame : ";

	private BubbleFrame context = this;

	private JLabel backgroundMap; // JLabel로 사진 붙이기
	private Player player;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initService();

		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}

	// 각종 모든 세팅
	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // JFrame의 기본 JPanel의 레이아웃을 AbsoulteLayout으로 설정
		setLocationRelativeTo(null); // JFrame 화면 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료
	}

	// new 하는 곳
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // 백그라운드 화면 설정

		player = new Player(context); // 플레이어 생성
		add(player); // Frame에 플레이어 붙이기
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.attack();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// System.out.println(TAG + "키보드 릴리즈");

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft를 false로
					player.setLeft(false);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// isRight를 false로
					player.setRight(false);
				}
			}

		});
	}

	// backgroundMapService 독립적인 스레드
	private void initService() {
		new Thread(new BackgroundMapService(player)).start();

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
