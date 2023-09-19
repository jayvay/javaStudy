package t9_sawon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PayDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	PayVO vo = null;
	String sql = "";
	int res = 0;
	
	public PayDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패" + e.getMessage());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
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

	public int getInputBong(PayVO vo) {
		res = 0;
		try {
			sql = "insert into bonbong values (?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getJikkub());
			pstmt.setInt(2, vo.getBonbong());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	public int getInput(PayVO vo) {
		res = 0;
		try {
			sql = "insert into sawon values (default,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getJikkub());
			pstmt.setInt(3, vo.getNight());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public ArrayList<PayVO> getList() {
		
		ArrayList<PayVO> vos = new ArrayList<>();
		try {
			sql = "select * from sawon";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new PayVO();
				vo.setSabun(rs.getInt("sabun"));
				vo.setName(rs.getString("name"));
				vo.setJikkub(rs.getString("jikkub"));
				vo.setNight(rs.getInt("night"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	public ArrayList<PayVO> getListBong() {
		
		ArrayList<PayVO> vos2 = new ArrayList<>();
		try {
			sql = "select * from bonbong";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new PayVO();
				vo.setJikkub(rs.getString("jikkub"));
				vo.setBonbong(rs.getInt("bonbong"));
				vos2.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos2;
	}

	public PayVO getSearch(String name) {
		vo = new PayVO();
		
		try {
			sql = "select * from sawon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setSabun(rs.getInt("sabun"));
				vo.setName(rs.getString("name"));
				vo.setJikkub(rs.getString("jikkub"));
				vo.setNight(rs.getInt("night"));
			}
			else vo = null;
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	public PayVO getSearchBong(String jikkub) {
		vo = new PayVO();
		
		try {
			sql = "select * from bonbong where jikkub = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jikkub);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setJikkub(rs.getString("jikkub"));
				vo.setBonbong(rs.getInt("bonbong"));
			}
			else vo = null;
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public int setUpdate(PayVO vo) {
		res = 0;
		try {
			sql = "update sawon set name = ?, jikkub = ?, night = ? where sabun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getJikkub());
			pstmt.setInt(3, vo.getNight());
			pstmt.setInt(4, vo.getSabun());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int setUpdateBong(PayVO vo) {
		res = 0;
		try {
			sql = "update bonbong set bonbong = ? where sabun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBonbong());
			pstmt.setInt(2, vo.getSabun());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	public int getDelete(PayVO vo) {
		res = 0;
		try {
			sql = "delete from sawon where name = ?";
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

	public int getDeleteBong(PayVO vo) {
		res = 0;
		try {
			sql = "delete from bonbong where name = ?";
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
