package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon 플레이어는 좌우이동이 가능하다. 점프가 가능하다. 방울 발사를 한다.(나중에 생각하자) x, y 좌표 필요
 *         x좌표로 좌우 이동 y좌표로 점프
 *
 */

public class Player extends JLabel {

	private int x;
	private int y;

	private ImageIcon playerR; // 오른쪽을 보고있는 pR
	private ImageIcon playerL; // 왼쪽을 보고있는 pL

	private boolean isRight; // 보통 boolean 변수 이름에는 is가 붙음
	private boolean isLeft;
	private boolean isJump;

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
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

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌, 부분 새로고침

		isRight = false;
		isLeft = false;
		isJump = false;
	}

	// 하나의 단일 책임을 가진 메서드, 메서드 모듈
	public void right() {
		isRight = true;

		System.out.println("오른쪽 이동");

		setIcon(playerR);

		new Thread(() -> {
			while (isRight) {
				x = x + 10;
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

		System.out.println("왼쪽 이동");

		setIcon(playerL);

		new Thread(() -> {
			while (isLeft) {
				x = x - 10;
				setLocation(x, y);
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

		System.out.println("위로 점프");

		new Thread(() -> {
			for (int i = 0; i < 150; i++) {
				y = y + i;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
