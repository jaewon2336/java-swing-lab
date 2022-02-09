package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator ���� : ����
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap; // ��� �̹���
	private Player player; // JLabel

	public BubbleFrame() {

		initSetting(); // ���� ��� ����
		initObject(); // new �ϴ� ��
		initListener(); // ������

		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 ����
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640); // Frame Size
		getContentPane().setLayout(null); // null�� ��� absoulute ���̾ƿ����� �����
		setLocationRelativeTo(null); // Frame�� ȭ�� �߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� �̹��� ����

		player = new Player(); // �÷��̾� �߰�
		add(player); // Frame�� �߰�
	}

	// ������
	private void initListener() {
		// Ű���� ������
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { // ������ ����
				System.out.println("Ű���� ������");

				// Ű���带 ������ ���¸� ������ �־�� ��
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // VK_RIGHT = 39
					// isRight�� false��
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft�� false��
					player.setLeft(false);
				}
			}

			// ���̽�ƽ
			@Override
			public void keyPressed(KeyEvent e) { // Ű���带 ������
				// ���� 37, ���� 38, ������ 39, �Ʒ��� 40
				System.out.println("Ű���� ������ : " + e.getKeyCode());

				// Ű���带 �������ִ��� �ƴ��� Ȯ���ϴ� ���� ����
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

					// Ű���带 ������ �ִ� ���� right() �޼���� �ѹ��� �����ϰ� �ʹ�.
					if (player.isRight() == false) {
						player.right(); // ���������� �������� ������ ������ Ű�� ������ right() �޼��� ����
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					if (player.isLeft() == false) {
						player.left(); // �������� �������� ������ ���� Ű�� ������ left() �޼��� ����
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {

					if (player.isJump() == false) {
						player.jump(); // �������� �������� ������ ���� Ű�� ������ jump() �޼��� ����
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
