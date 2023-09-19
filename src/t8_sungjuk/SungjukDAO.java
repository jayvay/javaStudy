package t8_sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SungjukDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	SungjukVO vo = null;
	String sql = "";
	int res = 0;
	
	public SungjukDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject"; //mysql 서버가 들어가있는 주소를 입력
		String user = "atom";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");	//1.드라이버 검색
			conn = DriverManager.getConnection(url, user, password);	//2.데이터베이스 검색
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 오류" + e.getMessage());
		} catch (Exception e) {
			System.out.println("데이터베이스 연동 실패" + e.getMessage());
		}	
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}

//	public void rsClose() {
//		try {
//			if(rs != null) rs.close();	
//			pstmtClose();	//rs는 null이라 닫을 필요 없어도 stmt는 닫아야지
//		} catch (Exception e) {}
//	}
	
	public int setInput(SungjukVO vo) {	//성적 입력
		res = 0;
		try {
			sql = "insert into sungjuk values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	public ArrayList<SungjukVO> getList() {	//전체 조회
		ArrayList<SungjukVO> vos = new ArrayList<SungjukVO>();
		try {
			sql = "select * from sungjuk order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new SungjukVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vos;
	}

	public SungjukVO getSearch(String name) {	//개별 조회
		SungjukVO vo = new SungjukVO();
		
		try {
			sql = "select * from sungjuk where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
			}
			else vo = null;	//rs가 없어도 vo에 담겨 -> vo != null이 됨 -> vo를 null로 만들어준다(사실상 vo = null이니까)
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vo;
	}

	
	public int setUpdate(SungjukVO vo) {	//수정
		res = 0;
		try {
			sql = "update sungjuk set name = ?, kor = ?, eng = ?, mat = ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int setDelete(SungjukVO vo) {
		res = 0;
		try {
			sql = "delete from sungjuk where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

}
