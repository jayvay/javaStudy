package xDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsaMain extends JFrame {

	private JPanel contentPane;
	private JButton btnInput, btnSearch, btnList, btnExit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsaMain frame = new InsaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsaMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 10, 784, 73);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인 사 관 리 프 로 그 램 (v1.0)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("경기천년바탕 Bold", Font.BOLD, 29));
		lblNewLabel.setBounds(0, 10, 784, 56);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 90, 784, 364);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMain = new JLabel("");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon(InsaMain.class.getResource("/xDatabase/images/main.jpg")));
		lblMain.setBounds(0, 0, 784, 364);
		pn2.add(lblMain);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 464, 784, 97);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원등록");
		btnInput.setBounds(30, 20, 158, 56);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setBounds(218, 20, 158, 56);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setBounds(406, 20, 158, 56);
		pn3.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(594, 20, 158, 56);
		pn3.add(btnExit);

		/*-------------------------------------------*/
		
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
			}
		});
	
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "없는 회원입니다");
				else new InsaSearch(vo);
			}
		});
		
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
