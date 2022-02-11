package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon �÷��̾�� �¿��̵��� �����ϴ�. ������ �����ϴ�. ��� �߻縦 �Ѵ�.(���߿� ��������) x, y ��ǥ �ʿ�
 *         x��ǥ�� �¿� �̵� y��ǥ�� ����
 *
 */

public class Player extends JLabel {

	// ��������
	private BubbleFrame context;

	private int x;
	private int y;

	private ImageIcon playerR; // �������� �����ִ� pR
	private ImageIcon playerL; // ������ �����ִ� pL

	// �÷��̾� ������ ���´� �ƴ�
	// �̵��� ������!
	private boolean isRight; // ���� boolean ���� �̸����� is�� ����
	private boolean isLeft;

	// private boolean isJump; // ���� ����(up, down)
	private boolean up;
	private boolean down;

	// �÷��̾� ������ ����
	private int direction; // 0�� ����, 1�� ������, -1 ���� ����

	private boolean leftWallCrash; // ���� ���� �ε��� ����
	private boolean rightWallCrash; // ������ ���� �ε��� ����

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	// �ڹ��� Ư¡ : is�� ���� boolean ������ getIsRight�� �ƴ� isRight��� �̸��� ����
	public boolean isRight() {
		return isRight;
	}

	// �ڹ��� Ư¡ : is�� ���� boolean ������ setIsRight�� �ƴ� setRight��� �̸��� ����
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player(BubbleFrame context) {
		this.context = context;
		initObject();
		initSetting();
		direction = -1;
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// �����ڿ��� �ʱ�ȭ, �����ڿ��� ȣ��Ǿ������ϱ� �굵 ������ !
	private void initSetting() {
		x = 70;
		y = 535;
		direction = -1;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ������, �κ� ���ΰ�ħ

		isRight = false;
		isLeft = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;
	}

	public void attack() {
		// 1. ���� new
		// ������ ����
		Bubble bubble = new Bubble(context); // JLabel
		// 2. ���� ȭ�鿡 �ٿ����� �̰� JFrame���� �ؾ��ϴµ�?
		// JFrame�� �����ؾ���!
		context.add(bubble);
		// 3. ������ �������ϱ� �÷��ǿ� ��Ƶ־���(���ݾ���)
		// 4. ���� �̵�(�÷��̾� ������)
	}

	// �ϳ��� ���� å���� ���� �޼���, �޼��� ���
	public void right() {
		isRight = true;
		// leftWallCrash = false;
		direction = 1;

		System.out.println("������ �̵�");

		setIcon(playerR);

		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	// �ܺο��� ȣ�� �����ϰ�
	public void left() {
		isLeft = true;
		// rightWallCrash = false;
		direction = 0;

		System.out.println("���� �̵�");

		setIcon(playerL);

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	// Ű���� ������Ű
	// up() down() �޼��� ������!
	public void up() {
		up = true;

		System.out.println("���� ��");
		// ������ for���� ��������
		// up �̶��� sleep(5), down �̶��� sleep(3)
		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED�� ���� ���̰� �޶����� �ȵ�!
				y = y - JUMPSPEED;
				setLocation(x, y);
				// up = true; // �������� �ȵ� ! Ű���� �Է��� �ѹ��� �޾ƾ���

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			up = false; // ������ ������ �ȿ� !!
			down();
		}).start();

	}

	// �������� �ʾ��� ���� �ٿ��ؾ��ϱ� ������ �и���Ŵ
	// ����
	public void down() {
		down = true;

		System.out.println("�Ʒ��� �ٿ�");
		// ������ for���� ��������
		// up �̶��� sleep(5), down �̶��� sleep(3)
		new Thread(() -> {
			// down
			// while�� �ٴڿ� ��������
			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// down = false; //�� down()�޼��忡�� ���� �Ұ���
		}).start();

	}
}
