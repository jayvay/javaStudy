package xDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class InsaDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	InsaVO vo = null;
	
	public InsaDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";	//mysql 서버 연결
		String user = "root";
		String Password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, Password);
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
		} catch (SQLException e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();			
		} catch (SQLException e) {}
		pstmtClose();
	}
	
	//회원명 검색(회원 중복 처리)
	public InsaVO getNameSearch(String name) {
		vo = new InsaVO();
		try {
			sql = "select * from insa where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vo;
	}

	//회원가입 처리
	public int setInsaInput(InsaVO vo) {
		int res = 0;
		try {
			sql = "insert into insa values (default, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	//회원정보 수정 처리
	public int setInsaUpdate(InsaVO vo) {
		int res = 0;
		try {
			sql = "update insa set age = ?, gender = ?, ipsail = ? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	//회원 삭제 처리
	public int setInsaDelete(String name) {
		int res = 0;
		try {
			sql = "delete from insa where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	//전체 리스트 가져오기 (y_Jtable 패키지 T1클래스 참조)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getInsaList() {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				vo = new InsaVO(); 	는 안됨(dtm에서 Vector밖에 못 받아들임)
//				vo.setIdx(rs.getInt("idx"));
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vData;
	}

	//조건별 정렬 처리하기 
	@SuppressWarnings("unchecked")
	public Vector getNameAscList(String str, String flag) {
		Vector vData = new Vector<>();
		try {
			if(str.equals("name")) {
				if(flag.equals("a")) sql = "select * from insa order by name";
				else sql = "select * from insa order by name desc";
			}
			else if(str.equals("ipsail")) {
				if(flag.equals("a")) sql = "select * from insa order by ipsail";
				else sql = "select * from insa order by ipsail desc";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vData;
	}

	//////////////////////////////////////////
	public Vector getGenderSearch(String fieldName, String value) {
		Vector vData = new Vector<>();
		try {
//			if(fieldName.equals("gender")) {
//				if(value.equals("여자")) sql = "select * from insa where gender = '여자' order by name";
//				else sql = "select * from insa where gender = '남자' order by name";
//				pstmt = conn.prepareStatement(sql);
//			}
//			else if(fieldName.equals("age")) {
//					sql = "select * from insa where age = ? order by ipsail";
//					pstmt = conn.prepareStatement(sql);
//					pstmt.setInt(1, Integer.parseInt(value));
//			}
			if(value.equals("여자")) sql = "select * from insa where gender = '여자' order by name";
			else sql = "select * from insa where gender = '남자' order by name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vData;
	}

	
	/*
	//성별 남자 버튼 클릭시 남자만 조회하기
	public Vector getGenderMale() {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where gender = '남자' order by name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vData;
	}
	
//성별 여자 버튼 클릭시 여자만 조회하기
	public Vector getGenderFemale() {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where gender = '여자' order by name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vData;
	}
	*/
	
	//성별 남자 또는 여자 라디오 버튼 클릭시 남자 또는 여자 자료만 검색 처리하기
	public Vector getGender(String gender) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where gender = ? order by name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vData;
	}

	
//	//조건 검색 - 성명만 (입력한 글자가 포함된 자료는 모두 검색)
//	public Vector getConditionNameSearch(String txtCond) {
//		Vector vData = new Vector<>();
//		try {
//			sql = "select * from insa where name like ? order by name";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%"+txtCond+"%");	//?에 ''포함된 거라 ''를 따로 적지 않아야 함
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Vector vo = new Vector<>();
//				vo.add(rs.getInt("idx"));
//				vo.add(rs.getString("name"));
//				vo.add(rs.getInt("age"));
//				vo.add(rs.getString("gender"));
//				vo.add(rs.getString("ipsail"));
//				vData.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			rsClose();
//		}
//		return vData;
//	}


	//다양한 조건 선택 후 문자열을 입력하고 검색 버튼 눌러서 검색 - 모든 조건(성명,나이,성별,입사일)
	public Vector getConditionSearch(String fieldName, String txtCond) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where " + fieldName + " like ? order by name";	//?는 무조건 값이 옴. 
			pstmt = conn.prepareStatement(sql);
			
			if(fieldName.equals("age")) pstmt.setInt(1, Integer.parseInt(txtCond));
			else pstmt.setString(1, "%"+txtCond+"%");	//?에 ''포함된 거라 ''를 따로 적지 않아야 함
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vData;
	}

}
