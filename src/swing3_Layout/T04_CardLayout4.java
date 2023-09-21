package swing3_Layout;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class T04_CardLayout4 extends JFrame {

	private JButton btn1, btn2, btn3, btn4;
	
	public T04_CardLayout4() {
		setTitle("CardLayout 연습");
		setSize(250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CardLayout card = new CardLayout();
		setLayout(card);
		
		btn1 = new JButton("봄");	//버튼 생성
		btn2 = new JButton("여름");
		btn3 = new JButton("가을");
		btn4 = new JButton("겨울");
		//src폴더 말고 images 폴더에서 이미지 가져오기	-방법1
		btn1.setIcon(new ImageIcon("./images/11.jpg"));
		btn2.setIcon(new ImageIcon("./images/12.jpg"));
		btn3.setIcon(new ImageIcon("./images/13.jpg"));
		btn4.setIcon(new ImageIcon("./images/14.jpg"));
		//src폴더 안에 있는 images 폴더에서 이미지 가져오기 -방법2
//		btn1.setIcon(new ImageIcon(getClass().getResource("./images/21.jpg")));
//		btn2.setIcon(new ImageIcon(getClass().getResource("./images/22.jpg")));
//		btn3.setIcon(new ImageIcon(getClass().getResource("./images/23.jpg")));
//		btn4.setIcon(new ImageIcon(getClass().getResource("./images/24.jpg")));
		add(btn1);	//버튼 추가
		add(btn2);
		add(btn3);
		add(btn4);
		
		/*-----------------------------------------------------*/
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout4 t04 = new T04_CardLayout4();
				t04.setVisible(true);
			}
		});
	}
}
