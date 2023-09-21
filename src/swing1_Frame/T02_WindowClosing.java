package swing1_Frame;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T02_WindowClosing extends Frame implements WindowListener {
	
	public T02_WindowClosing() {
//		super("스윙 연습");
		setTitle("스윙 연습");
		setBounds(1100, 300, 500, 500);
		
		//////////////////////////////
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		T02_WindowClosing t1 = new T02_WindowClosing();
		
		t1.setVisible(true);
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {System.exit(0);}

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
}
