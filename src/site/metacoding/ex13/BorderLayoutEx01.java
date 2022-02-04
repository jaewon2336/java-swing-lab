package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import site.metacoding.ex13.constant.BorderConstant;

public class BorderLayoutEx01 extends MyFrame {

	public BorderLayoutEx01() {
		super(500, 500);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new BorderLayout()); // 생략가능!
		// 디폴트 레이아웃이 BorderLayout이라서 Set할 필요 없음

		JButton btnEast = new JButton("동쪽");
		JButton btnWest = new JButton("서쪽");
		JButton btnSouth = new JButton("남쪽");
		JButton btnNorth = new JButton("북쪽");
		JButton btnCenter = new JButton("가운데");

//		panel.add(btnEast, BorderConstant.EAST);
//		panel.add(btnWest, BorderConstant.WEST);
//		panel.add(btnSouth, BorderConstant.SOUTH);
//		panel.add(btnNorth, BorderConstant.NORTH);
//		panel.add(btnCenter, BorderConstant.CENTER);

		// panel.add(btnEast, BorderLayout.EAST);
		panel.add(btnWest, BorderLayout.WEST);
		// panel.add(btnSouth, BorderLayout.SOUTH);
		panel.add(btnNorth, BorderLayout.NORTH);
		panel.add(btnCenter, BorderLayout.CENTER);

		setVisible(true); // 화면에 그림 그리기, paint 메서드
	}

	public static void main(String[] args) {
		new BorderLayoutEx01();
	}

}
