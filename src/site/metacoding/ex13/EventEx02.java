package site.metacoding.ex13;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {

	int x = 100;
	int y = 200;

	// JPanel�� ���ΰ�ħ(�ٽ� �׸���)�ϴ� ��
	@Override
	protected void paintComponent(Graphics g) { // g�� ���̴�.
		super.paintComponent(g);
		System.out.println("�г� �ٽ� �׷���");
		// Panel�� �׸��� �ٽ� �׷��� ������ paintComponent�� ȣ��Ǵ� ��
		g.drawLine(10, 20, x, y);
	}
}

public class EventEx02 extends JFrame implements UserInterface {

	MyPanel myPanel;
	JLabel labelText;
	JButton btn1, btn2; // 200, 300���� ����

	public EventEx02() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	@Override
	public void initSetting() {
		setSize(500, 500);
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư Ŭ���� main ����
	}

	@Override
	public void initObject() {
		myPanel = new MyPanel();
		labelText = new JLabel("ù����");
		btn1 = new JButton("���ں���");
		btn2 = new JButton("�׸�����");
	}

	@Override
	public void initAssign() {
		add(myPanel); // JFrame�� Panel �ϳ� add
		myPanel.add(labelText); // getContentPane().add�� ���� ��
		myPanel.add(btn1);
		myPanel.add(btn2);
	}

	@Override
	public void initListener() {
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setText �޼���� �κ� ����!!
				// ȭ���� ���ΰ�ħ �Ϸ��� �ٸ� ����� ����ؾ���
				// � �޼��带 ���� �� �κ� �������� ��ü �������� �� �ٸ� !!!
				labelText.setText("�ι�°����"); // setText �޼���� ���ο� paintComponent�� ��ȣ�����ش�.
			}
		});

		// MyPanel ��ü ���ΰ�ħ
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.x = myPanel.x + 30;
				myPanel.y = myPanel.y + 30; // ������ ���� �ٲ� ! �׸��� �ٲ��� ���� ���� !!

				System.out.println(myPanel.x);
				System.out.println(myPanel.y);

				// repaint(); // this. �� �����Ȱ�. ��, MyFrame�� repaint
				myPanel.repaint(); // myPanel�� repaint
			}
		});
	}

	public static void main(String[] args) {
		new EventEx02();

	}

}
