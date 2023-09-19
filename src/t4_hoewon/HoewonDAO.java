package t4_hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoewonDAO {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	HoewonVO vo = null;
	
	public HoewonDAO() {
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

	public ArrayList<HoewonVO> getList() {
		ArrayList<HoewonVO> vos = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoewon order by idx desc";
			rs = stmt.executeQuery(sql);
			
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
		}
		return vos;
	}

	//개별 회원 조회
	public HoewonVO getSearch(String name) {
		HoewonVO vo = new HoewonVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoewon where name = '" + name + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}
		return vo;
	}
	
	//회원 자료 삭제
	public void setDelete(String name) {
		try {
			stmt = conn.createStatement();
			sql = "delete from hoewon where name = '" + name + "'";
			stmt.executeUpdate(sql);	//삭제는 반환할 값이 없다.
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}
	}
	
	
	
}
