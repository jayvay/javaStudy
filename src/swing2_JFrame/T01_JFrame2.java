package swing2_JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T01_JFrame2 extends JFrame {
	
	JButton btnExit;
	
	public T01_JFrame2() {
		setTitle("스윙 연습 2");
		setBounds(1100, 300, 300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//윈도우 창 종료
		
		btnExit = new JButton("Exit");
		add(btnExit);
		
		////////////////////////////
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		T01_JFrame2 t1 = new T01_JFrame2();
		t1.setVisible(true);
	}
}
