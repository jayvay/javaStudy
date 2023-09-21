package swing3_Layout;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_FlowLayout extends JFrame {
	
	private JButton btnOk, btnExit, btnAnswer1, btnAnswer2, btnAnswer3, btnInput;
	private JLabel lblName;

	public T01_FlowLayout() {
		setTitle("FlowLayout 연습");
		setSize(300, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 창 닫기
		setLocationRelativeTo(null);	//프레임 가운데 정렬
		setResizable(false);					//프레임 크기 고정
		
		setLayout(new FlowLayout());
		
		
//		btnOk = new JButton();
		add(getBtnOk());
		add(getBtnExit());
		add(getbtnAnswer1());
		add(getbtnAnswer2());
		add(getbtnAnswer3());
		add(getBtnInput());
		
		add(getLblName());
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "확인 버튼을 누르셨습니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "작업을 종료합니다");	//메세지 띄울 때 
//				JOptionPane.showMessageDialog(null, "작업을 종료합니다", "종료창", JOptionPane.PLAIN_MESSAGE);	//메세지 띄울 때 
				JOptionPane.showMessageDialog(null, "작업을 종료합니다", "종료창", JOptionPane.WARNING_MESSAGE);	//메세지 띄울 때 
				System.exit(0);
			}
		});
		
		btnAnswer1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 'OK_CANCEL_OPTION' 인 경우 '확인(0)/취소(2)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "버튼을 선택하세요", "선택박스", JOptionPane.OK_CANCEL_OPTION);
				if(ans == 0 )	JOptionPane.showMessageDialog(null, "확인 버튼을 누르셨습니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);
				else	JOptionPane.showMessageDialog(null, "취소 버튼을 누르셨습니다.", "취소창", JOptionPane.WARNING_MESSAGE);

			}
		});
		
		btnAnswer2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 'YES_NO_OPTION' 인 경우 '예(0)/아니오(1)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?", "선택박스", JOptionPane.YES_NO_OPTION);
				if(ans == 0 )	JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);
				else	{
					JOptionPane.showMessageDialog(null, "작업을 마치겠습니다.", "취소창", JOptionPane.WARNING_MESSAGE);
					dispose();
				}
				
				
			}
		});
		
		btnAnswer3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 'YES_NO_CANCEL_OPTION' 인 경우 '예(0)/아니오(1)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?", "선택박스", JOptionPane.YES_NO_CANCEL_OPTION);
				if(ans == 0 )	JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.", "확인창", JOptionPane.INFORMATION_MESSAGE);
				else if(ans == 1) {
					JOptionPane.showMessageDialog(null, "작업을 마치겠습니다.", "취소창", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "취소합니다", "취소창", JOptionPane.WARNING_MESSAGE);
					dispose();
				}
			}
		});
		
		btnInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("성명을 입력하세요", "성명");
				JOptionPane.showMessageDialog(null, "성명 : " + name);
				lblName.setText("성명 : " + name);
				System.out.println("name : " + name);
			}
		});

	}
	
	private JLabel getLblName() {
		lblName = new JLabel();
		return lblName;
	}

	private JButton getBtnInput() {
		btnInput = new JButton("입력");
		return btnInput;
	}

	private JButton getbtnAnswer1() {
		btnAnswer1 = new JButton("선택1");
		return btnAnswer1;
	}

	private JButton getbtnAnswer2() {
		btnAnswer2 = new JButton("선택2");
		return btnAnswer2;
	}
	
	private JButton getbtnAnswer3() {
		btnAnswer3 = new JButton("선택3");
		return btnAnswer3;
	}
	
	private JButton getBtnExit() {
		btnExit = new JButton("종료");
		return btnExit;
	}

	private JButton getBtnOk() {
		if(btnOk == null) {
//			btnOk = new JButton("확인");
			btnOk = new JButton();
			btnOk.setText("확인");
		}
		return btnOk;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T01_FlowLayout t01 = new T01_FlowLayout();
				t01.setVisible(true);	//화면에 보여줘야 되니까 true
				
			}
		});
	}
}
