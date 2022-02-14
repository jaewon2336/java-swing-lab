package site.metacoding.mytest;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ����� �÷��̾�� �¿��̵��� �����ϴ�. ������ �����ϴ�. ����� �߻��Ѵ�.
 *
 */

public class Player extends JLabel {

	private static final String TAG = "Player : ";

	private BubbleFrame context;

	private static final int SPEED = 4;
	private static final int JUMPSPEED = 2;

	// ��ġ ����
	private int x, y;
	private ImageIcon playerR, playerL;

	// ������ ����
	private boolean isLeft, isRight, isUp, isDown;

	// �浹 ����
	private boolean leftWallCrash, rightWallCrash;

	// ���� ����
	private int direction; // -1 ���� 0 ����x 1 ������

	// X
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	// Y
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// isLeft
	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	// isRight
	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	// isUp
	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	// isDown
	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	// leftWallCrash
	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	// rightWallCrash
	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	// direction
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	// ������
	public Player(BubbleFrame context) {
		this.context = context;

		initObject();
		initSetting();
	}

	private void initSetting() {
		// �÷��̾� ��ǥ ����
		x = 90;
		y = 535;

		// default ���� ����
		setIcon(playerR);
		setSize(50, 50);

		// �÷��̾� �׸� �׸��� paintComponent ȣ��
		setLocation(x, y);

		isLeft = false;
		isRight = false;
		isUp = false;
		isDown = false;

		leftWallCrash = false;
		rightWallCrash = false;

		direction = 1;
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	public void left() {
		System.out.println(TAG + "����");

		isLeft = true;
		setRightWallCrash(false);
		direction = -1;
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

	public void right() {
		System.out.println(TAG + "������");

		isRight = true;
		setLeftWallCrash(false);
		direction = 1;
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

	public void up() {
		System.out.println(TAG + "����");

		isUp = true;

		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			isUp = false;
			down();

		}).start();
	}

	public void down() {
		System.out.println(TAG + "�Ʒ���");
		isDown = true;

		new Thread(() -> {
			// down
			while (isDown) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void attack() {
		System.out.println(TAG + "����!");
		Bubble bubble = new Bubble(context); // JLabel
		context.add(bubble);

		new Thread(new BackgroundBubbleService(bubble)).start();
	}
}
