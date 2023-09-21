package swing2_JFrame;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_JWindow3 extends JWindow {
	
	JButton btnExit;

	public T04_JWindow3() {
		setSize(600, 350);
		
		btnExit = new JButton("종료");
		add(btnExit);
		
		//JWindow를 화면 중앙에 띄우기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		
		int leftTopX = centerPoint.x - this.getWidth()/2;
		int leftTopY = centerPoint.y - this.getHeight()/2;
		setLocation(leftTopX, leftTopY);
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_JWindow3 t04 = new T04_JWindow3();
				t04.setVisible(true);
			}
		});
	}
}
