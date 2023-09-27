package y_JTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class T2_image extends JFrame {

	private JPanel contentPane;
	private ButtonGroup btnGroup = new ButtonGroup();
	private JRadioButton rdImage1, rdImage2, rdImage3, rdImage4, rdImage5, rdImage6;
	private JButton btnImgInfo;
	private JLabel lblImgInfo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T2_image frame = new T2_image();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public T2_image() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 62);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		rdImage1 = new JRadioButton("그림 1");
		rdImage1.setBounds(52, 25, 69, 23);
		rdImage1.setFont(new Font("굴림", Font.PLAIN, 14));
		btnGroup.add(rdImage1);
		pn1.add(rdImage1);
		
		rdImage2 = new JRadioButton("그림 2");
		rdImage2.setBounds(173, 25, 69, 23);
		rdImage2.setFont(new Font("굴림", Font.PLAIN, 14));
		btnGroup.add(rdImage2);	
		pn1.add(rdImage2);
		
		rdImage3 = new JRadioButton("그림 3");
		rdImage3.setBounds(294, 25, 69, 23);
		rdImage3.setFont(new Font("굴림", Font.PLAIN, 14));
		btnGroup.add(rdImage3);
		pn1.add(rdImage3);
		
		rdImage4 = new JRadioButton("그림 4");
		rdImage4.setBounds(415, 25, 69, 23);
		rdImage4.setFont(new Font("굴림", Font.PLAIN, 14));
		btnGroup.add(rdImage4);
		pn1.add(rdImage4);
		
		rdImage5 = new JRadioButton("그림 5");
		rdImage5.setBounds(536, 25, 69, 23);
		rdImage5.setFont(new Font("굴림", Font.PLAIN, 14));
		btnGroup.add(rdImage5);
		pn1.add(rdImage5);
		
		rdImage6 = new JRadioButton("그림 6");
		rdImage6.setBounds(657, 25, 69, 23);
		rdImage6.setFont(new Font("굴림", Font.PLAIN, 14));
		btnGroup.add(rdImage6);
		pn1.add(rdImage6);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 62, 784, 429);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(12, 10, 760, 396);
		lblImage.setFont(new Font("굴림", Font.PLAIN, 16));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.add(lblImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 491, 784, 70);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setBounds(619, 22, 139, 38);
		btnExit.setFont(new Font("굴림", Font.PLAIN, 14));
		pn3.add(btnExit);
		
		btnImgInfo = new JButton("그림정보출력");
		btnImgInfo.setBounds(29, 22, 139, 38);
		btnImgInfo.setFont(new Font("굴림", Font.PLAIN, 14));
		pn3.add(btnImgInfo);
		
		lblImgInfo = new JLabel("그림을 클릭하면 해당 그림의 정보 출력");
		lblImgInfo.setBounds(180, 22, 416, 38);
		lblImgInfo.setHorizontalAlignment(SwingConstants.CENTER);
		pn3.add(lblImgInfo);
		
		/*-----------------------------------------------*/
		
		//그림 1 라디오버튼을 클릭하면 처리할 내용
		rdImage1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					
					ImageIcon img1 = new ImageIcon(getClass().getResource("./images/1.jpg"));
					img1 =	imageSetSize(img1, 600, 400); 
					lblImage.setIcon(img1);
//					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
				}
			}
		});
		
		//그림 2 라디오버튼을 클릭하면 처리할 내용
		rdImage2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					ImageIcon img2 = new ImageIcon(getClass().getResource("./images/2.jpg"));
					img2 =	imageSetSize(img2, 600, 400); 
					lblImage.setIcon(img2);
//					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/2.jpg")));				
				}
			}
		});
		
		//그림 3 라디오버튼을 클릭하면 처리할 내용
		rdImage3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					ImageIcon img3 = new ImageIcon(getClass().getResource("./images/3.jpg"));
					img3 =	imageSetSize(img3, 600, 400); 
					lblImage.setIcon(img3);
//					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/3.jpg")));				
				}
			}
		});
		
		//그림4 라디오버튼을 클릭하면 처리할 내용
		rdImage4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					ImageIcon img4 = new ImageIcon(getClass().getResource("./images/4.jpg"));
					img4 =	imageSetSize(img4, 600, 400); 
					lblImage.setIcon(img4);
//					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/4.jpg")));				
				}
			}
		});
		
		//그림5 라디오버튼을 클릭하면 처리할 내용
		rdImage5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					ImageIcon img5 = new ImageIcon(getClass().getResource("./images/5.jpg"));
					img5 =	imageSetSize(img5, 600, 400); 
					lblImage.setIcon(img5);
//					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/5.jpg")));				
				}
			}
		});
		
		//그림6 라디오버튼을 클릭하면 처리할 내용
		rdImage6.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					ImageIcon img6 = new ImageIcon(getClass().getResource("./images/6.jpg"));
					img6 =	imageSetSize(img6, 600, 400); 
					lblImage.setIcon(img6);
//					lblImage.setIcon(new ImageIcon(getClass().getResource("./images/6.jpg")));				
				}
			}
		});
		
		//그림정보출력 버튼
		btnImgInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String photoInfo = "그림을 클릭하면 해당 그림의 정보 출력";
				if(lblImage.getIcon() != null) photoInfo = lblImage.getIcon().toString();
					lblImgInfo.setText(photoInfo);
			}
		});
		
		//그림 자체를 클릭하면 그림정보 출력 수행 처리
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String photoInfo = "그림을 클릭하면 해당 그림의 정보 출력";
				if(lblImage.getIcon() != null) photoInfo = lblImage.getIcon().toString();
				System.out.println("photoInfo" + photoInfo);
				lblImgInfo.setText(photoInfo);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	ImageIcon imageSetSize (ImageIcon icon, int i, int j) {	//이미지 크기 조절
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i , j, Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
}
