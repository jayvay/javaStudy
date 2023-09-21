package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//T1_Closing1의 방식을 더 간단하게 줄이는 방법 : 어댑터 활용

@SuppressWarnings("serial")
public class T1_Closing2 extends Frame {
	
	Button btnExit;	//필드에 놓아야 다른 메소드에서도 부른다
	
	public T1_Closing2() {
		super("어댑터 활용");
		
		this.setBounds(300, 500, 300, 350);	//this. <- 생략 가능 

		btnExit = new Button("종 료");
		this.add(btnExit);	//컨테이너에 담는다는 뜻..
		
		this.setVisible(true);
		
		///////////위는 디자인///////밑은 리스너(감시자)////////////////
		
		//리스너에서 익명객체로 어댑터를 부른다.
//		btnExit.addActionListener(new ActionAdaptor() {});	//ActionListener의 추상메소드 1개라서 어댑터로 부르지 않는다.
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});	
		
		addWindowListener(new WindowAdapter() {	//WindowListener의 추상메소드 여러 개라서 어댑터로 사용할 추상메소드만 부른다.
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
		
	}
	
	public static void main(String[] args) {
		new T1_Closing2();
	}
}
