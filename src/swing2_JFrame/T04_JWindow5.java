package swing2_JFrame;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_JWindow5 extends JWindow {
	
	JLabel lblImg;

	public T04_JWindow5() {
		setSize(600, 350);
		
//		lblImg = new JLabel("안녕하세요.");
		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
		add(lblImg);
		
		//JWindow를 화면 중앙에 띄우기
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		Point centerPoint = ge.getCenterPoint();
//		
//		int leftTopX = centerPoint.x - this.getWidth()/2;
//		int leftTopY = centerPoint.y - this.getHeight()/2;
//		setLocation(leftTopX, leftTopY);
		setLocationRelativeTo(null);	//화면 가운데 view(window) 배치하기
		
		addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();	//닫겠다
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_JWindow5 t05 = new T04_JWindow5();
				t05.setVisible(true);
			}
		});
	}
}
