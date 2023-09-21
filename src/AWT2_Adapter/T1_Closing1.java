package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//package AWT1에서 하던 방식
@SuppressWarnings("serial")
public class T1_Closing1 extends Frame implements WindowListener, ActionListener {
	
	Button btnExit;	//필드에 놓아야 다른 메소드에서도 부른다
	
	public T1_Closing1() {
		super("어댑터 활용");
		
		this.setBounds(300, 500, 300, 350);	//this. <- 생략 가능 

		btnExit = new Button("종 료");
		this.add(btnExit);	//컨테이너에 담는다는 뜻..
		
		this.setVisible(true);
		
		///////////위는 디자인///////밑은 리스너(감시자)////////////////
		btnExit.addActionListener(this);
		this.addWindowListener(this);	
	}
	
	public static void main(String[] args) {
		new T1_Closing1();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {	//ActionListener의 추상메소드는 이거밖에 없음 이 메소드는 외워두자
		System.exit(0);
	}
}
