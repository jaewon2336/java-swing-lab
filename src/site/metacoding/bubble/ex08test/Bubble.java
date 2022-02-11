package site.metacoding.bubble.ex08test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	private BubbleFrame context;
	private Player player;

	private int x;
	private int y;

	private static final int BUBBLESPEED = 1;

	private ImageIcon bubble, bomb;

	// bubble은 player의 위치에 의존해야함
	// player에만 의존하면 나중에 적군을 만들때 문제가 발생
	// 따라서 context에 의존!
	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();
		initObject();
		initSetting();
	}

	private void initObject() {
		bubble = new ImageIcon("image/bubble.png");
		bomb = new ImageIcon("image/bomb.png");
	}

	private void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void left() {
		// System.out.println("왼쪽으로 버블 가랏");

		new Thread(() -> {
			try {
				for (int i = 0; i < 400; i++) {
					x = x - BUBBLESPEED;
					setLocation(x, y);
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

	}

	public void right() {
		// System.out.println("오른쪽으로 버블 가랏");

		new Thread(() -> {
			try {
				for (int i = 0; i < 400; i++) {
					x = x + BUBBLESPEED;
					setLocation(x, y);
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
}