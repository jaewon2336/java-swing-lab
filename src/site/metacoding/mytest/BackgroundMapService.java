package site.metacoding.mytest;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다)
public class BackgroundMapService implements Runnable {

	private static final String TAG = "BackgroundMapService : ";

	// 컴포지션
	private Player player;
	private BufferedImage image;

	// 컴포지션을 위한 기술 -> 의존성 주입 (생성자를 통해서 주입) = DI (Dependency Injection)
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
		// 멈추지 않고 while을 돌며 색상 확인
		while (true) {
			try {
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));

				// System.out.println(TAG + "leftColor : " + leftColor);
				// System.out.println(TAG + "rightColor : " + rightColor);

				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

				// System.out.println(TAG + bottomColor);

				if (bottomColor != -2) { // 바닥에 장애물이 있다!
					// System.out.println(TAG + "바닥에 밟히는게 있네");
					player.setDown(false); // 그만 떨어져
				} else { // 바닥이 흰색
					if (!player.isDown() && !player.isUp()) {
						// System.out.println(TAG + "바닥에 아무것도 없어!!");
						player.down();
					}
				}

				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) { // 왼쪽벽이 빨간색이면
					System.out.println(TAG + "왼쪽 벽에 부딪혔다!");
					player.setLeftWallCrash(true);
					player.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					System.out.println(TAG + "오른쪽 벽에 부딪혔다!");
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
