package xDatabase;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class InsaInput extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdMale, rdFemale;
	private JButton btnInput, btnReset, btnClose;

	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;

	int res = 0;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaInput frame = new InsaInput();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		new InsaInput();
//	}

	public InsaInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 128));
		pn1.setBounds(0, 0, 784, 96);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setFont(new Font("돋움", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 784, 76);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 96, 784, 370);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("돋움", Font.PLAIN, 18));
		lblName.setBounds(58, 34, 149, 50);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("돋움", Font.PLAIN, 18));
		lblAge.setBounds(58, 118, 149, 50);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성 별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("돋움", Font.PLAIN, 18));
		lblGender.setBounds(58, 202, 149, 50);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("돋움", Font.PLAIN, 18));
		lblIpsail.setBounds(58, 286, 149, 50);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();		//txtName = 성명 입력란
		txtName.setBounds(204, 46, 158, 34);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();		//txtAge = 나이 입력란
		txtAge.setColumns(10);
		txtAge.setBounds(204, 126, 158, 34);
		pn2.add(txtAge);
		
		rdMale = new JRadioButton(" 남 자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("돋움", Font.PLAIN, 18));
		rdMale.setBounds(204, 216, 87, 23);
		buttonGroup.add(rdMale);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton(" 여 자");
		rdFemale.setFont(new Font("돋움", Font.PLAIN, 18));
		rdFemale.setBounds(295, 216, 87, 23);
		buttonGroup.add(rdFemale);
		pn2.add(rdFemale);
		
		//입사일
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2000;
			yy[i] =	imsi + "";
		}

		for(int i=0; i<mm.length; i++) {
			mm[i] =	(i+1) + "";
		}

		for(int i=0; i<dd.length; i++) {
			dd[i] =	(i+1) + "";
		}

		
		JComboBox cbYY = new JComboBox(yy);		//cb는 콤보박스다!!!
		cbYY.setFont(new Font("굴림", Font.PLAIN, 16));
		cbYY.setBounds(204, 294, 114, 34);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.PLAIN, 16));
		cbMM.setBounds(398, 294, 114, 34);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.PLAIN, 16));
		cbDD.setBounds(576, 294, 114, 34);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("돋움", Font.PLAIN, 18));
		lblYY.setBounds(330, 299, 39, 24);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setFont(new Font("돋움", Font.PLAIN, 18));
		lblMM.setBounds(519, 299, 39, 24);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setFont(new Font("돋움", Font.PLAIN, 18));
		lblDD.setBounds(702, 299, 39, 24);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 255, 128));
		pn3.setBounds(0, 465, 784, 96);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("돋움", Font.PLAIN, 17));
		btnInput.setBounds(58, 27, 183, 41);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("돋움", Font.PLAIN, 17));
		btnReset.setBounds(299, 27, 183, 41);
		pn3.add(btnReset);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("돋움", Font.PLAIN, 17));
		btnClose.setBounds(540, 27, 183, 41);
		pn3.add(btnClose);
		
		/*-------------------------------------------------*/
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();	//성명 입력란에 적은 텍스트
				String age = txtAge.getText();
				String gender;
				String ipsail = cbYY.getSelectedItem() + "-" + cbMM.getSelectedItem() + "-" + cbDD.getSelectedItem();	//DB에 저장하는데 하이픈에 " - " 이렇게 띄어쓰기 하면 안됨... 
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();		//.requestFocus() : 여기에 마우스 커서를 두겠다는 뜻
				}
				else if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요");
					txtAge.requestFocus();
				}
				else {
					if(!Pattern.matches("^[0-9]{1,2}$", age)) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요(최대 2자)");
					txtAge.requestFocus();
					} else {
						if(rdMale.isSelected()) gender = "남자";		//.isSelected() : 라디오버튼 선택한 항목 
						else gender = "여자";
						
						//모든 체크가 끝나면 DB에 새로운 회원을 가입 처리한다.
						//회원명 중복 처리
						vo = dao.getNameSearch(name);
						if(vo.getName() != null) {
							JOptionPane.showMessageDialog(null, "이미 사용 중인 이름입니다. 다시 입력하세요");
							txtName.requestFocus();
						}
						else {
							//정상적으로 자료가 입력 되었다면 vo에 담는다.
							vo.setName(name);
							vo.setAge(Integer.parseInt(age));	//age 타입은 원래 int인데 텍스트필드에 입력은 문자로 했기 때문에 int로 바꿔준다
							vo.setGender(gender);
							vo.setIpsail(ipsail);
							
							//vo에 담긴 자료를 DB에 저장시킨다.
							res = dao.setInsaInput(vo);
							
							if(res == 0) {
								JOptionPane.showMessageDialog(null, "회원가입 실패! 다시 가입하세요");
								txtName.requestFocus();
							}
							else {
								JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
								
								//다음 입력 자료 처리를 위한 준비
//								txtName.setText("");
//								txtAge.setText("");
//								rdMale.setSelected(true);
//								txtName.requestFocus();
								btnReset.doClick();
							}
						}
					}
				}
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				rdMale.setSelected(true);
				
				//오늘 날짜로 입사일 디폴트 주기
				InsaService service = new InsaService();
				vo = service.getDefaultDate();
				
				//vo에 가져온 날짜 데이터를 날짜 콤보 상자에 넣어준다.
				cbYY.setSelectedItem(vo.getStrYY());
				cbMM.setSelectedItem(vo.getStrMM());
				cbDD.setSelectedItem(vo.getStrDD());
				
				txtName.requestFocus();
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//회원 성명 입력 후 Enter키 누르면 커서를 나이 입력창으로 보내기
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) txtAge.requestFocus();
			}
		});
		
	}
}
