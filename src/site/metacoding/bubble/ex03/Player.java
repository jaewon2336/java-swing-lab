package site.metacoding.bubble.ex03;

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
	}

	// 외부에서 호출 가능하게
	public void left() {
		System.out.println("왼쪽 이동");
		x = x - 10;

		setIcon(playerL);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 하나의 단일 책임을 가진 메서드, 메서드 모듈
	public void right() {
		System.out.println("오른쪽 이동");
		x = x + 10;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}
}
