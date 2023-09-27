package xDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;

@SuppressWarnings("serial")
public class InsaList extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	private ButtonGroup genderGroup = new ButtonGroup();
	private JComboBox cbCondition;
	private JTextField txtCondition;
	
//	Vector<String> title = null;
//	Vector<String> vData = null;	24번으로 줄여 적을 수 있다
	Vector title, vData;	//JTable은 Vector로만 만들 수 있음(ArrayList 불가능)
	DefaultTableModel dtm;
	
	InsaDAO dao = new InsaDAO();

	@SuppressWarnings("unchecked")
	public InsaList() {
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 84);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setBounds(605, 16, 135, 53);
		pn1.add(btnExit);
		
		JButton btnNewWin = new JButton("새 창에 선택 값 띄우기");
		btnNewWin.setBounds(38, 16, 113, 53);
		pn1.add(btnNewWin);
		
		cbCondition = new JComboBox();
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(176, 26, 88, 32);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setHorizontalAlignment(SwingConstants.CENTER);
		txtCondition.setFont(new Font("굴림", Font.PLAIN, 12));
		txtCondition.setBounds(269, 27, 135, 32);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		JButton btnCondition = new JButton("검색");
		btnCondition.setBounds(411, 26, 78, 32);
		pn1.add(btnCondition);
		
		JButton btnList = new JButton("전체검색");
		btnList.setBounds(490, 26, 91, 32);
		pn1.add(btnList);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 85, 784, 292);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 379, 784, 182);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("선택한 내용");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(32, 10, 729, 32);
		pn3.add(lblMsg);
		
		JButton btnNameAsc = new JButton("성명 오름차순");
		btnNameAsc.setBounds(453, 62, 127, 42);
		pn3.add(btnNameAsc);
		
		JButton btnNameDesc = new JButton("성명 내림차순");
		btnNameDesc.setBounds(453, 108, 127, 42);
		pn3.add(btnNameDesc);
		
		JButton btnIpsaiAsc = new JButton("입사일 오름차순");
		btnIpsaiAsc.setBounds(592, 62, 147, 42);
		pn3.add(btnIpsaiAsc);
		
		JButton btnIpsailDesc = new JButton("입사일 내림차순");
		btnIpsailDesc.setBounds(592, 108, 147, 42);
		pn3.add(btnIpsailDesc);
		
		JRadioButton rdFemale = new JRadioButton("여  자");
		rdFemale.setBounds(52, 66, 68, 32);
		genderGroup.add(rdFemale);
		pn3.add(rdFemale);
		
		JRadioButton rdMale = new JRadioButton("남  자");
		rdMale.setBounds(52, 107, 68, 32);
		genderGroup.add(rdMale);
		pn3.add(rdMale);
		
		JButton btnGenderSearch = new JButton("성별 검색");
		btnGenderSearch.setBounds(126, 62, 97, 88);
		pn3.add(btnGenderSearch);
		
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
		dtm = new DefaultTableModel(vData, title);	//jtable을 관리
		
		// 4. DefaultTableModel에 담긴 Vector 형식의 자료와 타이틀로 JTable을 생성시켜준다. (생성시 담아준다)
		tbl = new JTable(dtm);
		
		// 5. 자료가 담긴 table을 scrollpane 생성시에 함꼐 담아서 생성한다.
		sp = new JScrollPane(tbl);
		sp.setBounds(40, 23, 709, 245);
		
		// 6. JScrollPane 을 패널에 올려준다.
		pn2.add(sp);
		
		//JTable 안의 셀의 내용을 가운데 정렬
		tableCellAlign(tbl);
		
		//0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
		
		/* ------------------------------------------------------- */
		
		//조건별 검색 처리하기 (검색 버튼을 마우스로 클릭하면 실행 처리)
		btnCondition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getConditionProcess();
			}
		});
		
		//검색 조건 선택 후, 검색어를 입력 후 Enter키 누르면 바로 검색 실행 처리하기
		txtCondition.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getConditionProcess();
			}
		});
		
		//조건 검색 콤보박스 안의 항목을 변경할 때마다 자동으로 커서를 입력 텍스트필드로 이동시키기
		cbCondition.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtCondition.requestFocus();
			}
		});
		
		//전체검색 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList();
				dtm.setDataVector(vData, title); 
			}
		});
		
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
		
		/*성별 버튼 클릭시 성별별로 조회하기*/
		
//		//성별 남자 버튼 클릭시 남자만 조회하기
//		rdMale.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				if(rdMale.isSelected()) vData = dao.getGenderSearch("성별","남자");
////				else vData = dao.getGenderSearch("성별","여자");
//				vData = dao.getGenderSearch("성별","남자");
//				dtm.setDataVector(vData, title); 
//			}
//		});
//		
//		//성별 여자 버튼 클릭시 여자만 조회하기
//		rdFemale.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				vData = dao.getGenderSearch("성별","여자");
//				dtm.setDataVector(vData, title);  
//			}
//		});
		
//		//성별 남자 버튼 클릭시 남자만 조회하기
//		rdMale.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				vData = dao.getGender("남자");
//				dtm.setDataVector(vData, title);
//			}
//		});
//		
//		//성별 여자 버튼 클릭시 여자만 조회하기
//		rdFemale.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				vData = dao.getGender("여자");
//				dtm.setDataVector(vData, title);
//			}
//		});
		
		//성별 라디오 버튼으로 성별 선택 후 성별 버튼 클릭시 선택한 성별 자료를 검색 처리 후 출력
		btnGenderSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if(rdMale.isSelected()) gender = "남자";
				else gender = "여자";
				
				vData = dao.getGender(gender);
				dtm.setDataVector(vData, title);
			
				//JTable 안의 셀의 내용을 가운데 정렬
				tableCellAlign(tbl);
				//0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
				
			}
		});
		
		//성명 오름차순 버튼
		btnNameAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name", "a");
				dtm.setDataVector(vData, title); 
			//JTable 안의 셀의 내용을 가운데 정렬
				tableCellAlign(tbl);
			//0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});

		//성명 내림차순 버튼
		btnNameDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name", "d");
				dtm.setDataVector(vData, title); 
			//JTable 안의 셀의 내용을 가운데 정렬
				tableCellAlign(tbl);
			//0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//입사일 오름차순 버튼
		btnIpsaiAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail", "a");
				dtm.setDataVector(vData, title); 
				
				//JTable 안의 셀의 내용을 가운데 정렬
				tableCellAlign(tbl);
				//0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});

		//입사일 내림차순 버튼
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail", "d");
				dtm.setDataVector(vData, title); 
				
				//JTable 안의 셀의 내용을 가운데 정렬
				tableCellAlign(tbl);
				//0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		
		//종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}

	private void tableCellAlign(JTable tbl) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableColumnModel tcm = tbl.getColumnModel();
		
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	//검색 조건 선택 후 검색어 입력 후 키보드 Enter키를 누르거나, '검색 버튼'을 마우스로 클릭할 때 수행 처리
	protected void getConditionProcess() {
		String cbCond = cbCondition.getSelectedItem().toString();
		String txtCond = txtCondition.getText();
		
		if(txtCond.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			txtCondition.requestFocus();
			return;
		}
//		if(cbCond.equals("성명")) vData = dao.getConditionNameSearch(txtCond);
		if(cbCond.equals("성명")) vData = dao.getConditionSearch("name", txtCond);
		else if(cbCond.equals("나이")) {
			if(!Pattern.matches("^[0-9]*$", txtCond)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
				txtCondition.requestFocus();
			}
			else vData = dao.getConditionSearch("age", txtCond);
		}
		else if(cbCond.equals("성별")) vData = dao.getConditionSearch("gender", txtCond);
		else if(cbCond.equals("입사일")) vData = dao.getConditionSearch("ipsail", txtCond);
		
		dtm.setDataVector(vData, title); 
		
		//JTable 안의 셀의 내용을 가운데 정렬
		tableCellAlign(tbl);
		//0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
	}
}
