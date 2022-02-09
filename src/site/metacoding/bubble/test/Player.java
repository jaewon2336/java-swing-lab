package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator �÷��̾�� �¿��̵�, ������ �����ϴ�. ����� �߻��ϸ� ������ �Ѵ�.(���߿�) �÷��̾��� ��ġ��
 *         x, y��ǥ�� �������ش�. x��ǥ�� �¿��̵�, y��ǥ�� ���� ����
 *
 */

public class Player extends JLabel {
	private int x; // �÷��̾��� x��ǥ
	private int y; // �÷��̾��� y��ǥ

	private ImageIcon playerR; // �������� �����ִ� �÷��̾� Image
	private ImageIcon playerL; // ������ �����ִ� �÷��̾� Image

	private boolean isRight; // ���� booleanŸ�� ���� �̸����� is�� ����
	private boolean isLeft;
	private boolean isJump;

	private static final int JUMPSPEED = 2; // ���� �ӵ�
	private static final int SPEED = 4; // �̵� �ӵ�

	// �ڹ� Ư¡ : is�� ���� boolean ������ getter�� getIsRight�� �ƴ� isRight��� �̸��� ����
	public boolean isRight() {
		return isRight;
	}

	// �ڹ� Ư¡ : is�� ���� boolean ������ setter�� setIsRight�� �ƴ� setRight��� �̸��� ����
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// �����ڿ��� �ʱ�ȭ
	// �����ڿ� ȣ��Ǿ��ִ� �޼���ϱ� �굵 ������ ���!
	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ��, �κ� ���ΰ�ħ

		// ó�� ���ۿ� ������ �ִ� ����
		isRight = false;
		isLeft = false;
		isJump = false;

	}

	// �ϳ��� ���� å���� ���� �޼���, �޼��� ���
	// �ܺο��� ȣ�� �����ϰ� public
	public void right() {
		isRight = true;

		System.out.println("������ �̵�");

		setIcon(playerR);

		// ���ο� ������ ����
		new Thread(() -> {
			// isRight�� true�϶��� �̵�
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // �׸� �ٽ� �׸���
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void left() {
		isLeft = true;

		System.out.println("���� �̵�");

		setIcon(playerL);

		// ���ο� ������ ����
		new Thread(() -> {
			// isLeft�� true�϶��� �̵�
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // �׸� �ٽ� �׸���
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void jump() {
		isJump = true;

		System.out.println("���� ����");
		// ������ for���� ��������
		// up : sleep(5), down : sleep(3)

		// ���ο� ������ ����
		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED�� ���� ���̰� �޶����� �ȵ�!
				y = y - JUMPSPEED;
				setLocation(x, y); // �׸� �ٽ� �׸���
				isJump = true; // ���������� ���� ����!

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			// �ٴڿ� �������� �� while�� ����!
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y); // �׸� �ٽ� �׸���
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			isJump = false;

		}).start();
	}
}
