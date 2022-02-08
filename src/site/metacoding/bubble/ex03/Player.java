package site.metacoding.bubble.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon �÷��̾�� �¿��̵��� �����ϴ�. ������ �����ϴ�. ��� �߻縦 �Ѵ�.(���߿� ��������) x, y ��ǥ �ʿ�
 *         x��ǥ�� �¿� �̵� y��ǥ�� ����
 *
 */

public class Player extends JLabel {

	private int x;
	private int y;

	private ImageIcon playerR; // �������� �����ִ� pR
	private ImageIcon playerL; // ������ �����ִ� pL

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
		setLocation(x, y); // paintComponent ȣ������, �κ� ���ΰ�ħ
	}

	// �ܺο��� ȣ�� �����ϰ�
	public void left() {
		System.out.println("���� �̵�");
		x = x - 10;

		setIcon(playerL);
		setSize(50, 50);
		setLocation(x, y);
	}

	// �ϳ��� ���� å���� ���� �޼���, �޼��� ���
	public void right() {
		System.out.println("������ �̵�");
		x = x + 10;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}
}
