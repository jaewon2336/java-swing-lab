package site.metacoding.mytest;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// ��׶��� ���� (�������� ������� ������ �Ѵ�)
public class BackgroundBubbleService implements Runnable {

	private static final String TAG = "BackgroundBubbleService : ";

	private Bubble bubble;
	private BufferedImage image;

	public BackgroundBubbleService(Bubble bubble) {
		this.bubble = bubble;

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

				Color leftColor = new Color(image.getRGB(bubble.getX() - 10, bubble.getY() + 25));
				Color rightColor = new Color(image.getRGB(bubble.getX() + 50 + 10, bubble.getY() + 25));

				int topColor = image.getRGB(bubble.getX() + 25, bubble.getY() - 5);

				// System.out.println(TAG + topColor);

				if (topColor == -65536) { // ������ õ�忡 ��Ҿ�!
					// System.out.println(TAG + "�Ӹ� �ε�����");
					bubble.setUp(false); // �׸� �ö�
					bubble.setTopWallCrash(true);
					bubble.pop();
				}

				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) { // ���ʺ��� �������̸�
					// System.out.println(TAG + "���� ���� �ε�����!");
					bubble.setLeftWallCrash(true);
					bubble.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					// System.out.println(TAG + "������ ���� �ε�����!");
					bubble.setRightWallCrash(true);
					bubble.setRight(false);
				}

				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
