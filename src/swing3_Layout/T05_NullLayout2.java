package swing3_Layout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T05_NullLayout2 extends JFrame {
	
	private JButton btnExit, btnInput, btnReset;
	private JLabel lblName, lblAge, lblTitle;
	private JTextArea txtaCon;
	private JTextField txtName, txtAge;
	
	private int x =  50, y = 100;
	
	public T05_NullLayout2() {
		setTitle("절대위치(Null) Layout 연습");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		add(getLblName());
		add(getLblAge());
		add(getTxtName());
		add(getTxtAge());
		add(getBtnExit());
		add(getBtnInput());
		add(getBtnReset());
		add(getLblTitle());
		add(getTxtaCon());
		
		/*-----------------------------------------------------*/
		
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += "성명 : " + txtName.getText() + "\n";
				str += "나이 : " + txtAge.getText();
				
				txtaCon.setText(str);
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원가입 종료");
				System.exit(0);
//				dispose();
			}
		});
		
	}


	private JButton getBtnInput() {
		btnInput = new JButton("회원가입");
		btnInput.setBounds(x, y+150, 100, 40);
		return btnInput;
	}

	private JButton getBtnReset() {
		btnReset = new JButton("다시 입력");
		btnReset.setBounds(x+120, y+150, 100, 40);
		return btnReset;
	}

	private JButton getBtnExit() {	//종료 버튼 
		btnExit = new JButton();
		btnExit.setText("종료");
		btnExit.setBounds(x+240, y+150, 100, 40);
		return btnExit;
	}

	private JTextArea getTxtaCon() {
		txtaCon = new JTextArea();
		txtaCon.setBackground(Color.LIGHT_GRAY);
		txtaCon.setBounds(x+400, y+10, 300, 180);
		return txtaCon;
	}
	
	private JLabel getLblTitle() {
		lblTitle = new JLabel("아래는 입력한 내용입니다.");
		lblTitle.setBackground(Color.LIGHT_GRAY);
		lblTitle.setBounds(x+400, y-50, 300, 100);
		return lblTitle;
	}
	
	private JLabel getLblName() {	//성명
		lblName = new JLabel();
		lblName.setText("성명");
		lblName.setBounds(x, y, 100, 30);
		return lblName;
	}
	
	private JLabel getLblAge() {	//나이
		lblAge = new JLabel();
		lblAge.setText("나이");
		lblAge.setBounds(x, y+50, 100, 30);
		return lblAge;
	}
	
	private JTextField getTxtName() {	//성명 입력란
		txtName = new JTextField();
		txtName.setBounds(x+100, y, 100, 30);
		return txtName;
	}

	private JTextField getTxtAge() {	//나이 입력란
		txtAge = new JTextField();
		txtAge.setBounds(x+100, y+50, 100, 30);
		return txtAge;
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T05_NullLayout2 t05 = new T05_NullLayout2();
				t05.setVisible(true);
			}
		});
	}
}
