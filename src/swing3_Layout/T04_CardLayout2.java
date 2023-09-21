package swing3_Layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/* CardLayout 사용법
	카드레이아웃 제어 메소드 : first(), last(), next(), show()
	first() : 첫 번째 카드 보이기
	last() : 마지막 카드 보이기
	next() : 다음 카드 보이기
	show() : 지정된 카드 보이기
*/
@SuppressWarnings("serial")
public class T04_CardLayout2 extends JFrame {

	private JPanel pnb1, pnb2, pnb3;
	private JButton btn1, btn2;
	private JLabel lbl1;
	
	public T04_CardLayout2() {
		setTitle("CardLayout 연습");
		setSize(250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());	//보더레이아웃으로 만들 거야

		lbl1 = new JLabel();
		lbl1.setText("이곳은 레이블 입니다.");

		pnb1 = new JPanel();						//패널 생성
		pnb1.setBackground(Color.GRAY);	//패널 배경색 설정
		pnb2 = new JPanel();
		pnb2.setBackground(Color.PINK);
		pnb3 = new JPanel();
		pnb3.add(lbl1);

		add(pnb1, BorderLayout.CENTER);	//패널2에 레이아웃 설정
		add(pnb2, BorderLayout.SOUTH);
		
		btn1 = new JButton("버튼 1");	//버튼 생성
		pnb2.add(btn1);								//패널2에 버튼 추가
		btn2 = new JButton("버튼 2");
		pnb2.add(btn2);
	
		
		CardLayout card = new CardLayout();
		pnb1.setLayout(card);	//패널1에 카드 추가
		
		
/*-----------------------------------------------------*/
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				card.next(getContentPane());
			}
			
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout2 t04 = new T04_CardLayout2();
				t04.setVisible(true);
			}
		});
	}
}
