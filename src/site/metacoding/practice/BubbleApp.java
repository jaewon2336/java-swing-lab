package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	// 2�� ����
	// ����� �� �տ� TAG �ٿ��ֱ�
	// ��� Ŭ�������� ���� log���� Ȯ���ϱ� ����!
	private static final String TAG = "BubbleApp : ";
	private BubbleApp mContext = this;

	private BackgroundMap backgroundMap;
	private Player player;

	// ������
	public BubbleApp() {
		// �׽�Ʈ�� ������ ��¹� �ּ�ó��
		// System.out.println(TAG + "������ ����");
		initObject();
		initSetting();
		initListener();

		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleApp();
	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap(); // JLabel
		setContentPane(backgroundMap); // div �ڽ��� ��ü ���ȭ������ ����
		player = new Player(backgroundMap);

		add(player);
	}

	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	@Override
	public void initListener() {
		// �����ʴ� ����͸� �� ������ ����
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

//				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
//					player.left();
//				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//					player.right();
//				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
//					player.up();
//				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//					player.down();
//				}

				// switch�� else-if�� �ƴ϶� if if if �̱� ������
				// break�� ������ ��� case�� �� �˻��Ѵ�.

				switch (e.getKeyCode()) { // �� == case ��
				case KeyEvent.VK_LEFT:
					// ����
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						System.out.println(TAG + "���� Ű ������");
						player.left();
					}
					break; // switch ����

				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isLeftWallCrash()) {
						System.out.println(TAG + "������ Ű ������");
						player.right();
					}
					break;

				case KeyEvent.VK_UP:
					player.up();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) { // �� == case ��
				case KeyEvent.VK_LEFT:
					// ����
					player.setLeft(false);
					break; // switch ����

				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			}
		});
	}

}
