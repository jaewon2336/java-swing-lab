package site.metacoding.mytest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author �����
 * 
 *
 */

// main�� ���� Ŭ������ �ش� ���α׷��� ���ؽ�Ʈ(����)�� �� �˰� �ִ�.
public class BubbleFrame extends JFrame {

	private static final String TAG = "BubbleFrame : ";

	private BubbleFrame context = this;

	private JLabel backgroundMap; // JLabel�� ���� ���̱�
	private Player player;

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
		initService();

		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ��� AbsoulteLayout���� ����
		setLocationRelativeTo(null); // JFrame ȭ�� ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� ����
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����

		player = new Player(context); // �÷��̾� ����
		add(player); // Frame�� �÷��̾� ���̱�
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.attack();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// System.out.println(TAG + "Ű���� ������");

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft�� false��
					player.setLeft(false);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// isRight�� false��
					player.setRight(false);
				}
			}

		});
	}

	// backgroundMapService �������� ������
	private void initService() {
		new Thread(new BackgroundMapService(player)).start();

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
