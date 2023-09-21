package AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Practice extends Frame implements WindowListener, ActionListener {
	
	public Practice() {
		super("프레임 테스트");
		
		setBounds(700, 500, 400, 300);	//창의 위치와 크기 설정
		Label lbl = new Label("이것이 라벨");	//는 안 뜨네?
		this.add(lbl);
		
		Button btnExit = new Button("이것이 나가기 버튼");	//버튼 만들기
		add(btnExit);	//나가기를 추가...어디에?
		
		setVisible(true);	//뷰를 셋한다
		
		btnExit.addActionListener(this);	//버튼 활성화
		addWindowListener(this);	//윈도우가 실행하도록 만들기
	}
	
	public static void main(String[] args) {
		new Practice();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
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
		

}
