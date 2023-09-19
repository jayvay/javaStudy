package t10_sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDAO extends ParentDAO {
	
//	Connection conn = null;	//부모가 conn 객체 갖고 있음
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	ProductVO pVO = null;	//vo 써먹든 안써먹든 일단 선언은 해놓아요
	SaleVO sVO = null;
	
//	public SaleDAO() {	//싱글톤이 아니면 발생하는 문제
//		String url = "jdbc:mysql://localhost:3306/javaProject";
//		String user = "atom";
//		String password = "1234";
//			
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(url, user, password);
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 검색 실패" + e.getMessage());
//		} catch (SQLException e) {
//			System.out.println("데이터베이스 연동 실패" + e.getMessage());
//		}
//	}
	

	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {	//??????????????????????????
			pstmtClose();
		}
	}

	public int setSaleInput(SaleVO sVo) {	//판매 상품 등록 처리
		int res = 0;
		
		try {
			sql = "insert into sale values (default,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sVo.getpName());
			pstmt.setInt(2, sVo.getEa());
			pstmt.setString(3, sVo.getpDate());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	public ProductVO getNameSearch(String pName) {	//등록된 상품(판매 가능 상품) 검색
		ProductVO vo = new ProductVO();
		
		try {
			sql = "select * from product where pName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			
			if(rs.next())	{
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(pName);
				vo.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vo;
	}

	public ArrayList<SaleVO> getSaleNameSearch(String pName) {	//판매된 상품 검색
		ArrayList<SaleVO> vos = new ArrayList<SaleVO>();
		ResultSet rs2 = null;
		
		try {
			sql = "select * from sale where pName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs2 = pstmt.executeQuery();
			
			while(rs2.next())	{
				sVO = new SaleVO();
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(pName);
				sVO.setEa(rs2.getInt("ea"));
				sVO.setpDate(rs2.getString("pDate"));
				sVO.setSalePrice(getNameSearch(pName).getPrice());
				vos.add(sVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}

	public ArrayList<SaleVO> getSaleDateSearch(String pDate) {	//판매 일자별 검색
		ArrayList<SaleVO> vos = new ArrayList<SaleVO>();
		ResultSet rs2 = null;
		
		try {
			sql = "select * from sale where pDate = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pDate);
			rs2 = pstmt.executeQuery();
			
			while(rs2.next())	{
				sVO = new SaleVO();
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("ea"));
				sVO.setpDate(rs2.getString("pDate"));
				sVO.setSalePrice(getNameSearch(sVO.getpName()).getPrice());
				vos.add(sVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}

	public ArrayList<SaleVO> getSaleList() { //전체 판매 내역 조회
		ArrayList<SaleVO> vos = new ArrayList<SaleVO>();
		ResultSet rs2 = null;
		
		try {
			sql = "select * from sale";
			pstmt = conn.prepareStatement(sql);
			rs2 = pstmt.executeQuery();
			
			while(rs2.next())	{
				sVO = new SaleVO();
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("ea"));
				sVO.setpDate(rs2.getString("pDate"));
				sVO.setSalePrice(getNameSearch(sVO.getpName()).getPrice());
				vos.add(sVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}
}
