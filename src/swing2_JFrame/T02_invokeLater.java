package swing2_JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class T02_invokeLater extends JFrame{
	
	public T02_invokeLater() {
		setTitle("스윙 이벤트 큐 연습");
		setSize(300, 200);
		
		System.out.println("222");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {	//메인 스레드
		
		System.out.println("111");
		
		T02_invokeLater t02 = new T02_invokeLater();
		t02.setVisible(true);
		System.out.println(Thread.currentThread().getName());
		
		System.out.println("333");
	}
}
