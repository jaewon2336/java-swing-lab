package site.metacoding.bubble.ex08;

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

		// 방향 체크
		if (player.getDirection() == 0) {
			left();
		} else if (player.getDirection() == 1) {
			right();
		}
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

	private void left() {
		new Thread(() -> {
			try {
				for (int i = 0; i < 400; i++) {
					x--; // x = x - 1
					setLocation(x, y);
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void right() {
		new Thread(() -> {
			try {
				for (int i = 0; i < 400; i++) {
					x++; // x = x + 1
					setLocation(x, y);
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
}