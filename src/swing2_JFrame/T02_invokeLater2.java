package swing2_JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class T02_invokeLater2 extends JFrame{	//클래스 하나가 스레드 하나다.
	
	public T02_invokeLater2() {
		setTitle("스윙 이벤트 큐 연습");	//Queue : 선입선출 (First in First out)
		setSize(300, 200);
		
		System.out.println("222");
		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {	
		
		System.out.println("111");
		
		SwingUtilities.invokeLater(new Runnable() {	//swing은 느려서 독립적으로 작동시키겠다(순차적 작동하면 오래 걸려서) //Runnable 클래스: 스레드를 제어하는 클래스
			@Override
			public void run() {
				T02_invokeLater2 t02 = new T02_invokeLater2();
				t02.setVisible(true);
				System.out.println(Thread.currentThread().getName());	//결과 : AWT-EventQueue-0
			}
		});
		
		System.out.println("333");
		System.out.println(Thread.currentThread().getName());	//결과 : main

	}
}
