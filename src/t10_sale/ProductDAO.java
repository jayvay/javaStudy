package t10_sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends ParentDAO {
	
//	Connection conn = null;	//부모가 conn 객체 갖고 있음
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	ProductVO vo = null;	//vo 써먹든 안써먹든 일단 선언은 해놓아요
	
//	public ProductDAO() {
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
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
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

	public ProductVO getNameSearch(String pName) {	//상품명 검색(중복 처리)
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

	public int setProductInput(ProductVO vo) {	//상품 등록 처리
		int res = 0;
		
		try {
			sql = "insert into product values (default,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getpName());
			pstmt.setInt(2, vo.getPrice());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	public List<ProductVO> getProductList() {	//전체 상품 조회
		List<ProductVO> vos = new ArrayList<ProductVO>();
		
		try {
			sql = "select * from product order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())	{
				vo = new ProductVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setPrice(rs.getInt("price"));
				vos.add(vo);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}

	public int setProductDelete(int idx) {	//상품 삭제 처리
		int res = 0;
		
		try {
			sql = "delete from product where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	
}
