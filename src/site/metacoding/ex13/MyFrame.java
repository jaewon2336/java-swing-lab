package site.metacoding.ex13;

import javax.swing.JFrame;

// Import 단축키 : Ctrl + Shift + O
// 자동정렬 단축키 : Ctrl + Shift + F
public class MyFrame extends JFrame {
	public MyFrame() {
		super(); // 생략되어 있음
		System.out.println("MyFrame 디폴트");
		setSize(600, 400); // w, h
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 클릭시 main 종료
	}

	public MyFrame(int w, int h) {
		super(); // 생략되어 있음
		System.out.println("MyFrame 오버로딩 생성자");
		setSize(w, h); // w, h
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 클릭시 main 종료
	}
}
