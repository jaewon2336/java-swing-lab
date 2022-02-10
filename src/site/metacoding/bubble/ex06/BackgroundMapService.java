package site.metacoding.bubble.ex06;

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
			image = ImageIO.read(new File("image/test.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// ���� ���(while)
		while (true) {
			try {
				Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
				System.out.println("�� : " + color.getRed());
				System.out.println("�� : " + color.getGreen());
				System.out.println("�� : " + color.getBlue());
				System.out.println("==============");
				Thread.sleep(10); // �浹������ �̼��ϰ� �ϴ� ������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
