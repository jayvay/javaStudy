package AWT2_Adapter;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class T2_Button_Event extends Frame {
	
	Button btnPlay, btnExit;	//버튼 만들 걸 쭉 써
	
	public T2_Button_Event() {
		
		//디자인
		super("어댑터 활용~");
		setBounds(1100, 300, 500, 500);
		
		//frame이라는 container 위에 layout pane을 만들어 버튼들을 나열한다.(layout이 없으면 창 전체가 버튼이 됨. 버튼이 여러 개면 버튼들이 쌓임)
		setLayout(new FlowLayout());	
		
		btnPlay = new Button("Play");	
		btnExit = new Button("Exit");
		add(btnPlay);
		add(btnExit);
		
		setVisible(true);

		
		//리스너
		//플레이 버튼(btnPlay) 제어하기
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(e.getSource());	//java.awt.Button[button0,212,36,37x23,label=Play] 정보
				Button btn = (Button) e.getSource();
				
				if(btn.getLabel().equals("Play")) {
					btn.setLabel("Stop");	//toggle이 되는 것
					System.out.println("음악이 시작되었습니다.");
				}
				else if(btn.getLabel().equals("Stop")) {
					btn.setLabel("Play");	
					System.out.println("음악이 중지되었습니다.");
				}
			}
		});
		
		//종료 버튼(btnExit)을 이용한 윈도우 종료
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("종료 버튼을 눌렀습니다.");
				System.exit(0);
			}
		});
		
		//윈도우어댑터를 이용한 윈도우 종료
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T2_Button_Event();
	}
}
