package swing2_JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_JWindow2 extends JWindow {
	
	JButton btnExit;

	public T04_JWindow2() {
		setSize(600, 350);
		
		btnExit = new JButton("종료");
		add(btnExit);
		
//		btnExit.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
//				setVisible(false);
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_JWindow2 t04 = new T04_JWindow2();
				t04.setVisible(true);
			}
		});
	}
}
