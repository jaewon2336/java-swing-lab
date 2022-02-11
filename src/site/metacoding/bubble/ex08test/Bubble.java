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

	// bubble�� player�� ��ġ�� �����ؾ���
	// player���� �����ϸ� ���߿� ������ ���鶧 ������ �߻�
	// ���� context�� ����!
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
		// System.out.println("�������� ���� ����");

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
		// System.out.println("���������� ���� ����");

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