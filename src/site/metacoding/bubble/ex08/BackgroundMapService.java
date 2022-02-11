package site.metacoding.bubble.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스
// 서비스는 죽을때까지 안멈춤
// 계속 체크해야하니까!
// 체크 변수 필요없음, 제어할 필요 없기 때문
// 독립적인 스레드 필요
public class BackgroundMapService implements Runnable {

	// 의존해야하는 애들을 컴포지션(결합) 해야함 : Player
	private Player player;
	// 문자열이 아닌 이미지로 읽어버림
	// 사진을 분석하기 위해서는 버퍼로 읽어서 분석해야함
	private BufferedImage image;

	// 컴포지션을 위한 기술
	// => 의존성 주입(생성자를 통해서 주입) = DI(Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw하게 읽음 : 날 것 그대로 읽는 것
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 색상 계산(while)
		while (true) {
			try {
				/*
				 * Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
				 * System.out.println("빨 : " + color.getRed()); System.out.println("초 : " +
				 * color.getGreen()); System.out.println("파 : " + color.getBlue());
				 * System.out.println("==============");
				 */
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));

				// System.out.println("leftColor : " + leftColor);
				// System.out.println("rightColor : " + rightColor);

				// System.out.println(image.getRGB(player.getX(), player.getY() + 50 + 5));
				// -2일때만 바닥에 아무것도 없는 상태!(-1, -1 양쪽 끝)
				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1 흰색
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

				if (bottomColor != -2) { // 바텀 충돌 상태! -> down이 멈춰야함
					player.setDown(false);
				} else if (bottomColor == -2) {
					if (!player.isDown() && !player.isUp()) {
						player.down();
					}
				}

				// 상태값이 있어야 행위를 제어할 수 있음
				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
					// System.out.println("왼쪽 벽에 충돌함");
					player.setLeftWallCrash(true);
					player.setLeft(false);

				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					// System.out.println("오른쪽 벽에 충돌함");
					player.setRightWallCrash(true);
					player.setRight(false);
					// else if(bottomColor.getRed() == 255 && bottomColor.getGreen() == 0 &&
					// bottomColor.getBlue() == 0) {
				} else {
					player.setRightWallCrash(false);
					player.setLeftWallCrash(false);
				}

				Thread.sleep(10); // 충돌감지를 미세하게 하는 조절법
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
