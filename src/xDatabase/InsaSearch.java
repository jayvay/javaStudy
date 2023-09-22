package xDatabase;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class InsaSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdMale, rdFemale;
	private JButton btnUpdate, btnDelete, btnClose;

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
//		new InsaSearch(vo);
//	}

	public InsaSearch(InsaVO vo) {
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
		
		JLabel lblTitle = new JLabel("회원 개별조회 (검색할 성명을 입력하세요.)");
		lblTitle.setFont(new Font("돋움", Font.BOLD, 23));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 10, 784, 76);
		pn1.add(lblTitle);
		
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
		
		txtName = new JTextField();
		txtName.setBounds(204, 46, 158, 34);
		txtName.setText(vo.getName());
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(204, 126, 158, 34);
		txtAge.setText(vo.getAge() + "");
		pn2.add(txtAge);
		
		rdMale = new JRadioButton(" 남 자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("돋움", Font.PLAIN, 18));
		rdMale.setBounds(204, 216, 87, 23);
		buttonGroup.add(rdMale);
		if(vo.getGender().equals("남자")) rdMale.setSelected(true);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton(" 여 자");
		rdFemale.setFont(new Font("돋움", Font.PLAIN, 18));
		rdFemale.setBounds(295, 216, 87, 23);
		buttonGroup.add(rdFemale);
		if(vo.getGender().equals("여자")) rdFemale.setSelected(true);
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

		String[] ymds = vo.getIpsail().substring(0,10).split("-");
		if(ymds[1].substring(0,1).equals("0")) ymds[1] = ymds[1].substring(1);
		if(ymds[2].substring(0,1).equals("0")) ymds[2] = ymds[2].substring(2);
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("굴림", Font.PLAIN, 16));
		cbYY.setBounds(204, 294, 114, 34);
		cbYY.setSelectedItem(ymds[0]);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.PLAIN, 16));
		cbMM.setBounds(398, 294, 114, 34);
		cbMM.setSelectedItem(ymds[1]);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.PLAIN, 16));
		cbDD.setBounds(576, 294, 114, 34);
		cbDD.setSelectedItem(ymds[2]);
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
		
		btnUpdate = new JButton("수정");
		btnUpdate.setFont(new Font("돋움", Font.PLAIN, 17));
		btnUpdate.setBounds(58, 27, 183, 41);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("돋움", Font.PLAIN, 17));
		btnDelete.setBounds(299, 27, 183, 41);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("돋움", Font.PLAIN, 17));
		btnClose.setBounds(540, 27, 183, 41);
		pn3.add(btnClose);
		
		/*-------------------------------------------------*/

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
