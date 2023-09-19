package t1_DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test2DAO {
	
	Connection con = null;
	
	public Test2DAO() {
		
		//1.드라이버 검색
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공");
			
		//2.드라이버 
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패" + e.getMessage());			
		}
		
		
	}

	//connection 객체 close
	public void conClose() {
		try {
			con.close();
			System.out.println("con객체가 닫혔습니다.");
		} catch (SQLException e) {}
	}
	
}
