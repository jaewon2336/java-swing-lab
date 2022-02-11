package site.metacoding.bubble.ex08;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author jaewon ���� : ���� �߻��ϱ� (�浹������ ����!) ����߻�
 *
 */

// main�� ���� Ŭ������ �ش� ���α׷��� ���ؽ�Ʈ(����)�� �� �˰� �ִ�.
// ���� main���� ����(new)�ϴϱ� �Ѹ��� �� �˰��ֱ� ����
// ���� main�� ���� Ŭ������ ���ؽ�Ʈ��� �θ���.
public class BubbleFrame extends JFrame/* implements BubbleContext */ {

	// ����� ���� BubbleFrame���� �ٿ�ĳ�����Ͽ� ����ؾ���
	// private BubbleContext context = this; // BubbleFrame�� heap �ּ�
	// player�� new�� �� �Ѱ��ָ� �� �׷��� context�� ������ ���� add ����
	// Ŭ������ context�� �˰��ϱ� ���ؼ��� �������� �ؾ���
	// �ƴϸ� �׳� main�޼��尡 �˰��ִ°��� �� !
	private BubbleFrame context = this;

	private JLabel backgroundMap;
	private Player player; // JLabel

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initService(); // ������ �ٷεڿ� ���ָ� ����
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.

		// �׽�Ʈ
		// new BackgroundMapService(player);
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����

		player = new Player(context); // �÷��̾� �߰�
		add(player); // Frame�� �߰�
	}

	private void initService() {
		new Thread(new BackgroundMapService(player)).start();
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // null�� ��� absolute ���̾ƿ��� ��
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	// Ű����
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { // ������ ����
				// System.out.println("Ű���� ������");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // int�ϱ� ==���� ��
					// isRight�� false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft�� false
					player.setLeft(false);
				}
			}

			// ���̽�ƽ
			@Override
			public void keyPressed(KeyEvent e) { // ������
				// �� 37, �� 39, �� 38, �Ʒ� 40
				// System.out.println("Ű���� ������ : " + e.getKeyCode());

				// �׷��� ���ؼ� ������ �ִ��� ������ ���� ������ Ȯ���ϴ� ���� ������ �ʿ��ϴ�.
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // int�ϱ� ==���� ��
					// Ű���带 ������ �ִ� ���� right() �޼���� �ѹ��� �����ϰ� �ʹ�.
					if (!player.isRight() && player.isRightWallCrash() == false) { // == false �� ����
						player.right(); // �̵��� �÷��̾��� å��
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!player.isLeft() && player.isLeftWallCrash() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) { // if ��ü�� ������ �̺�Ʈ ���� ����� ����
					// System.out.println("üũ");
					if (!player.isUp() && !player.isDown()) {
						player.up(); // �޼��� ���ο��� if �б� ó���� �̺�Ʈ ������ ����� �Ǵµ� ������ �ȵǴ� ��
					}
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					// ������ ��� ���� Player�� å��
					// Bubble bubble = new Bubble();
					// add(bubble); ����� ����� �ȵ�!! �÷��̾��� å���� !!
					player.attack();
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
