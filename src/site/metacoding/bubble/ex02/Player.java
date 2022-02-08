package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon 플레이어는 좌우이동
 *
 */

public class Player extends JLabel {

	private int x;
	private int y;

	private ImageIcon playerR; // 오른쪽을 보고있는 pR

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌, 부분 새로고침
	}

}
