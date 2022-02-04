package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import site.metacoding.ex13.constant.BorderConstant;

public class BorderLayoutEx01 extends MyFrame {

	public BorderLayoutEx01() {
		super(500, 500);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new BorderLayout()); // ��������!
		// ����Ʈ ���̾ƿ��� BorderLayout�̶� Set�� �ʿ� ����

		JButton btnEast = new JButton("����");
		JButton btnWest = new JButton("����");
		JButton btnSouth = new JButton("����");
		JButton btnNorth = new JButton("����");
		JButton btnCenter = new JButton("���");

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

		setVisible(true); // ȭ�鿡 �׸� �׸���, paint �޼���
	}

	public static void main(String[] args) {
		new BorderLayoutEx01();
	}

}
