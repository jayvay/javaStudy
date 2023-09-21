package AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T4_Button extends Frame implements WindowListener, ActionListener {
	
	public T4_Button() {
		//디자인
		super("프레임 테스트");		
//		setSize(400, 300);
		setBounds(600, 300, 400, 300);	//(x좌표,y좌표,너비,높이)
		
		//이름표(Label) : 레이블 컴포넌트
		Label lbl = new Label("회 원 가 입");		//회원가입이라는 내용 추가
		this.add(lbl);
		
		//버튼 컴포넌트
		Button btnExit = new Button("종 료");	//종료 버튼 추가
		add(btnExit);
		setVisible(true);	
		
		/* ----------------------------------- */
		//감시자
		btnExit.addActionListener(this);	//버튼 누르기 실행
		addWindowListener(this); 					//창 닫기 실행
	}
	
	public static void main(String[] args) {
		new T4_Button();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {	//창 닫기
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
	public void actionPerformed(ActionEvent e) {	//버튼 누르기
		System.exit(0);
	}
}
