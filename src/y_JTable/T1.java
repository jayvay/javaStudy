package y_JTable;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import xDatabase.InsaDAO;
import xDatabase.InsaVO;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T1 extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	
	
//	Vector<String> title = null;
//	Vector<String> vData = null;	24번으로 줄여 적을 수 있다
	Vector title, vData;	//JTable은 Vector로만 만들 수 있음(ArrayList 불가능)
	DefaultTableModel dtm;
	
	//xDatabase 패키지의 insaDAO클래스 참조(import)
	InsaDAO dao = new InsaDAO();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T1 frame = new T1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public T1() {
		setTitle("JTable 연습(DB에서 값을 가져와서 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 84);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setBounds(371, 10, 147, 64);
		pn1.add(btnExit);
		
		JButton btnNewWin = new JButton("새 창에 선택 값 띄우기");
		btnNewWin.setBounds(52, 10, 147, 64);
		pn1.add(btnNewWin);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 87, 584, 259);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
//		JScrollPane sp = new JScrollPane();
//		sp.setBounds(40, 23, 482, 203);
//		pn2.add(sp);
//		
//		tbl = new JTable();
//		sp.setViewportView(tbl);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 349, 584, 92);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setBounds(0, 10, 572, 72);
		pn3.add(lblMsg);
		
		/* JTable 설계하기 */
		// - '부제목'과 '데이터'를 Vector 타입으로 준비한다.
		
		// 1. '부제목'을 Vector 타입으로 준비
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 2. '데이터'를 Vector 타입으로 준비 - '데이터'는 DB에서 가져온다
		vData = dao.getInsaList();
		
		// 3. DB에서 가져온 자료를 DefaultTableModel을 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title);
		
		// 4. DefaultTableModel에 담긴 Vector 형식의 자료와 타이틀로 JTable을 생성시켜준다. (생성시 담아준다)
		tbl = new JTable(dtm);
		
		// 5. 자료가 담긴 table을 scrollpane 생성시에 함꼐 담아서 생성한다.
		sp = new JScrollPane(tbl);
		sp.setBounds(40, 23, 482, 203);
		
		// 6. JScrollPane 을 패널에 올려준다.
		pn2.add(sp);
		
		
		////////////////////////////////////////////////////
		
		//table 안의 셀을 클릭하면 입력된 상세 정보 가져오기
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl.getSelectedRow();
				int col = tbl.getSelectedColumn();
				
				Object value = tbl.getValueAt(row, col);	//꺼낸다
				
				lblMsg.setText("row : " + row + " , col : " + col + " , value : " + value );
			}
		});
		
		
		//새 창에 선택된 행의 정보 출력하는 버튼
		btnNewWin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsaVO vo = new InsaVO();
				int row = tbl.getSelectedRow();
				tbl.getValueAt(row, 0);
				
				vo.setIdx((int)tbl.getValueAt(row, 0));
				vo.setName(tbl.getValueAt(row, 1).toString());
				vo.setAge((int)tbl.getValueAt(row, 2));
				vo.setGender(tbl.getValueAt(row, 3).toString());
				vo.setIpsail(tbl.getValueAt(row, 4).toString().substring(0, 10));
				
				new InsaSearch(vo);
			}
		});
		
		
		//종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
