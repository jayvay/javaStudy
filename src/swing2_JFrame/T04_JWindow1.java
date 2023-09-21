package swing2_JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_JWindow1 extends JWindow implements MouseListener {
	
	JButton btnExit;

	public T04_JWindow1() {
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
		
		btnExit.addMouseListener(this);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_JWindow1 t04 = new T04_JWindow1();
				t04.setVisible(true);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {System.exit(0);}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
