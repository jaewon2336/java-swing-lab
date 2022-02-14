package site.metacoding.mytest;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다)
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
		// 멈추지 않고 while을 돌며 색상 확인
		while (true) {
			try {

				Color leftColor = new Color(image.getRGB(bubble.getX() - 10, bubble.getY() + 25));
				Color rightColor = new Color(image.getRGB(bubble.getX() + 50 + 10, bubble.getY() + 25));

				int topColor = image.getRGB(bubble.getX() + 25, bubble.getY() - 5);

				// System.out.println(TAG + topColor);

				if (topColor == -65536) { // 버블이 천장에 닿았어!
					// System.out.println(TAG + "머리 부딪혔어");
					bubble.setUp(false); // 그만 올라가
					bubble.setTopWallCrash(true);
					bubble.pop();
				}

				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) { // 왼쪽벽이 빨간색이면
					// System.out.println(TAG + "왼쪽 벽에 부딪혔다!");
					bubble.setLeftWallCrash(true);
					bubble.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					// System.out.println(TAG + "오른쪽 벽에 부딪혔다!");
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
