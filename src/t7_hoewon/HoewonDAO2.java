package t7_hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoewonDAO2 {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	HoewonVO vo = null;
	
	public HoewonDAO2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void connClose() {
			try {
				conn.close();
			} catch (Exception e) {}
	}
	
	//stmt객체 close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();	//stmt를 사용했을 때만 닫아라
		} catch (SQLException e) {} 
	}

	//rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();	
			pstmtClose();	//rs는 null이라 닫을 필요 없어도 stmt는 닫아야지
		} catch (Exception e) {}
	}
	
	
	//전체 회원 조회
	public ArrayList<HoewonVO> getList() {
		ArrayList<HoewonVO> vos = new ArrayList<>();
		try {
			sql = "select * from hoewon order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {	//rs.next()가 true일 때까지 돌아간다
				
				vo = new HoewonVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
//			System.out.println("SQL 문장 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}

	//개별 회원 조회
	public HoewonVO getSearch(String name) {
		HoewonVO vo = new HoewonVO();
		try {
			sql = "select * from hoewon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); //1번째 ?에 name을 넣어줄 거야
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	
	//회원가입 처리
//	public void setHoewonInput(String name, int age, String address, int gender) {
	public int setHoewonInput(HoewonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoewon values (default, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getGender());
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		} return res;
	}

	
	//회원 자료 수정
	public int setHoewonUpdate(String name, int age, String address, String strGender) {
		int res = 0;
		try {
			sql = "update hoewon set age = ?, address = ?, gender = ? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, address);
			pstmt.setString(3, strGender);
			pstmt.setString(4, name);
			res = pstmt.executeUpdate();	//수행한 횟수가 0이면 오류났다(수행을 못했다)는 뜻
		} catch (Exception e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	
	//회원 자료 삭제
	public void setDelete(String name) {
		try {
			sql = "delete from hoewon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();	//삭제는 반환할 값이 없다.
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
}
