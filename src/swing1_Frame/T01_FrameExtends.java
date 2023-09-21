package swing1_Frame;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T01_FrameExtends extends Frame {
	
	public T01_FrameExtends() {
//		super("스윙 연습");
		setTitle("스윙 연습");
		setBounds(1100, 300, 500, 500);
	}
	
	public static void main(String[] args) {
		T01_FrameExtends t1 = new T01_FrameExtends();
		
		t1.setVisible(true);
		
		
	}
}
