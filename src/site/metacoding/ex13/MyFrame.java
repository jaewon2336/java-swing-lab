package site.metacoding.ex13;

import javax.swing.JFrame;

// Import ����Ű : Ctrl + Shift + O
// �ڵ����� ����Ű : Ctrl + Shift + F
public class MyFrame extends JFrame {
	public MyFrame() {
		super(); // �����Ǿ� ����
		System.out.println("MyFrame ����Ʈ");
		setSize(600, 400); // w, h
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư Ŭ���� main ����
	}

	public MyFrame(int w, int h) {
		super(); // �����Ǿ� ����
		System.out.println("MyFrame �����ε� ������");
		setSize(w, h); // w, h
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư Ŭ���� main ����
	}
}
