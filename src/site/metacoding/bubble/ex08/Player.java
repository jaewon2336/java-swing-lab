package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon 플레이어는 좌우이동이 가능하다. 점프가 가능하다. 방울 발사를 한다.(나중에 생각하자) x, y 좌표 필요
 *         x좌표로 좌우 이동 y좌표로 점프
 *
 */

public class Player extends JLabel {

	// 컴포지션
	private BubbleFrame context;

	private int x;
	private int y;

	private ImageIcon playerR; // 오른쪽을 보고있는 pR
	private ImageIcon playerL; // 왼쪽을 보고있는 pL

	// 플레이어 방향의 상태는 아님
	// 이동의 상태임!
	private boolean isRight; // 보통 boolean 변수 이름에는 is가 붙음
	private boolean isLeft;

	// private boolean isJump; // 점프 상태(up, down)
	private boolean up;
	private boolean down;

	// 플레이어 방향의 상태
	private int direction; // 0은 왼쪽, 1은 오른쪽, -1 방향 없음

	private boolean leftWallCrash; // 왼쪽 벽에 부딪힌 상태
	private boolean rightWallCrash; // 오른쪽 벽에 부딪힌 상태

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

	// 자바의 특징 : is가 붙은 boolean 변수는 getIsRight가 아닌 isRight라고 이름이 붙음
	public boolean isRight() {
		return isRight;
	}

	// 자바의 특징 : is가 붙은 boolean 변수는 setIsRight가 아닌 setRight라고 이름이 붙음
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

	// 생성자에서 초기화, 생성자에서 호출되어있으니까 얘도 생성자 !
	private void initSetting() {
		x = 70;
		y = 535;
		direction = -1;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌, 부분 새로고침

		isRight = false;
		isLeft = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;
	}

	public void attack() {
		// 1. 버블 new
		// 의존성 주입
		Bubble bubble = new Bubble(context); // JLabel
		// 2. 버블 화면에 붙여야함 이건 JFrame에서 해야하는데?
		// JFrame과 의존해야함!
		context.add(bubble);
		// 3. 버블은 여러개니까 컬렉션에 담아둬야함(지금안함)
		// 4. 수평 이동(플레이어 방향대로)
	}

	// 하나의 단일 책임을 가진 메서드, 메서드 모듈
	public void right() {
		isRight = true;
		// leftWallCrash = false;
		direction = 1;

		System.out.println("오른쪽 이동");

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

	// 외부에서 호출 가능하게
	public void left() {
		isLeft = true;
		// rightWallCrash = false;
		direction = 0;

		System.out.println("왼쪽 이동");

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

	// 키보드 윗방향키
	// up() down() 메서드 나누기!
	public void up() {
		up = true;

		System.out.println("위로 업");
		// 점프는 for문을 돌려야함
		// up 이때는 sleep(5), down 이때는 sleep(3)
		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED에 따라 높이가 달라지면 안됨!
				y = y - JUMPSPEED;
				setLocation(x, y);
				// up = true; // 더블점프 안됨 ! 키보드 입력을 한번만 받아야해

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			up = false; // 무조건 스레드 안에 !!
			down();
		}).start();

	}

	// 점프하지 않았을 때도 다운해야하기 때문에 분리시킴
	// 낙하
	public void down() {
		down = true;

		System.out.println("아래로 다운");
		// 점프는 for문을 돌려야함
		// up 이때는 sleep(5), down 이때는 sleep(3)
		new Thread(() -> {
			// down
			// while로 바닥에 떨어지기
			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// down = false; //는 down()메서드에서 제어 불가능
		}).start();

	}
}
