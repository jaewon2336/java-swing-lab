package site.metacoding.mytest;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// ��׶��� ���� (�������� ������� ������ �Ѵ�)
public class BackgroundMapService implements Runnable {

	private static final String TAG = "BackgroundMapService : ";

	// ��������
	private Player player;
	private BufferedImage image;

	// ���������� ���� ��� -> ������ ���� (�����ڸ� ���ؼ� ����) = DI (Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// ������ �ʰ� while�� ���� ���� Ȯ��
		while (true) {
			try {
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));

				// System.out.println(TAG + "leftColor : " + leftColor);
				// System.out.println(TAG + "rightColor : " + rightColor);

				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

				// System.out.println(TAG + bottomColor);

				if (bottomColor != -2) { // �ٴڿ� ��ֹ��� �ִ�!
					// System.out.println(TAG + "�ٴڿ� �����°� �ֳ�");
					player.setDown(false); // �׸� ������
				} else { // �ٴ��� ���
					if (!player.isDown() && !player.isUp()) {
						// System.out.println(TAG + "�ٴڿ� �ƹ��͵� ����!!");
						player.down();
					}
				}

				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) { // ���ʺ��� �������̸�
					System.out.println(TAG + "���� ���� �ε�����!");
					player.setLeftWallCrash(true);
					player.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					System.out.println(TAG + "������ ���� �ε�����!");
					player.setRightWallCrash(true);
					player.setRight(false);
				}

				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
