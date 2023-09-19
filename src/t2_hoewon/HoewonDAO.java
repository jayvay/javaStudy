package t2_hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HoewonDAO {

	Connection conn = null;
	
	public HoewonDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);	//Connection : 데이터베이스에 접속
			
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

	
	//전체 회원 조회
	public void getList() {
		try {
			Statement stmt = conn.createStatement();	//Statement : 데이터베이스 안 테이블 처리를 위한 sql(질의어)을 실어나르는 객체, sql을 처리해주는 객체 생성
			String sql = "select * from hoewon";
			//테이블 안 레코드를 읽고 처리하는 객체 ResultSet : 반환받을 때만 쓰기 때문에 executeQuery()에서만 씀
			ResultSet rs = stmt.executeQuery(sql); //executeQuery() : select(조회)
//			stmt.executeUpdate(sql); //insert,update,delete
			rs.next();
			System.out.println("번호 : " + rs.getInt("idx"));		//필드명으로 검색
			System.out.println("이름 : " + rs.getString("name"));
			System.out.println("나이 : " + rs.getInt("age"));
			System.out.println("주소 : " + rs.getString("address"));
			System.out.println("성별 : " + rs.getString("gender"));
			System.out.println();
			
			rs.next();
			System.out.println("번호 : " + rs.getInt("idx"));	
			System.out.println("이름 : " + rs.getString("name"));
			System.out.println("나이 : " + rs.getInt("age"));
			System.out.println("주소 : " + rs.getString("address"));
			System.out.println("성별 : " + rs.getString("gender"));
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}
	}
	
}
