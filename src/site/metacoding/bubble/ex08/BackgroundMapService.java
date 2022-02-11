package site.metacoding.bubble.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// ��׶��� ����
// ���񽺴� ���������� �ȸ���
// ��� üũ�ؾ��ϴϱ�!
// üũ ���� �ʿ����, ������ �ʿ� ���� ����
// �������� ������ �ʿ�
public class BackgroundMapService implements Runnable {

	// �����ؾ��ϴ� �ֵ��� ��������(����) �ؾ��� : Player
	private Player player;
	// ���ڿ��� �ƴ� �̹����� �о����
	// ������ �м��ϱ� ���ؼ��� ���۷� �о �м��ؾ���
	private BufferedImage image;

	// ���������� ���� ���
	// => ������ ����(�����ڸ� ���ؼ� ����) = DI(Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw�ϰ� ���� : �� �� �״�� �д� ��
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// ���� ���(while)
		while (true) {
			try {
				/*
				 * Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
				 * System.out.println("�� : " + color.getRed()); System.out.println("�� : " +
				 * color.getGreen()); System.out.println("�� : " + color.getBlue());
				 * System.out.println("==============");
				 */
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));

				// System.out.println("leftColor : " + leftColor);
				// System.out.println("rightColor : " + rightColor);

				// System.out.println(image.getRGB(player.getX(), player.getY() + 50 + 5));
				// -2�϶��� �ٴڿ� �ƹ��͵� ���� ����!(-1, -1 ���� ��)
				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1 ���
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

				if (bottomColor != -2) { // ���� �浹 ����! -> down�� �������
					player.setDown(false);
				} else if (bottomColor == -2) {
					if (!player.isDown() && !player.isUp()) {
						player.down();
					}
				}

				// ���°��� �־�� ������ ������ �� ����
				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
					// System.out.println("���� ���� �浹��");
					player.setLeftWallCrash(true);
					player.setLeft(false);

				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					// System.out.println("������ ���� �浹��");
					player.setRightWallCrash(true);
					player.setRight(false);
					// else if(bottomColor.getRed() == 255 && bottomColor.getGreen() == 0 &&
					// bottomColor.getBlue() == 0) {
				} else {
					player.setRightWallCrash(false);
					player.setLeftWallCrash(false);
				}

				Thread.sleep(10); // �浹������ �̼��ϰ� �ϴ� ������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
