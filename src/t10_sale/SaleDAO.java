package t10_sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDAO extends ParentDAO {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	ProductVO pVO = null;
	SaleVO sVO = null;
	
	int res = 0;
	String pName = "";
	String pDate = "";
	String total = "";
	
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

    ////////////////////////////////////////////////

    public ProductVO getNameSearch(String pName) {
    	pVO = new ProductVO();
    	try {
			sql = "select * from product where pName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pVO.setIdx(rs.getInt("idx"));
				pVO.setpName(rs.getString("pName"));
				pVO.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return pVO;
	}

	public int setSaleInput(SaleVO sVO) {
		res = 0;
		try {
			sql = "insert into sale values (default, ? , ? , ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sVO.getpName());
			pstmt.setInt(2, sVO.getEa());
			pstmt.setString(3, sVO.getpDate());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	public ArrayList<SaleVO> getSaleProcess(String item, String flag) {
		ArrayList<SaleVO> vos = new ArrayList<SaleVO>();
		try {
			if(item.equals("total")) {
				sql = "select * from sale order by idx desc";
			}
			else if(item.equals("pNameOrPDate")){
				if(flag.equals("n")) sql = "select * from sale where pName = ?";
				else if(flag.equals("d")) sql = "select * from sale where pDate = ?";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pDate);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sVO = new SaleVO();
				sVO.setIdx(rs.getInt("idx"));
				sVO.setpName(rs.getString("pName"));
				sVO.setEa(rs.getInt("ea"));
				sVO.setpDate(rs.getString("pDate"));
				vos.add(sVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}

	public int setDelete(String pName, String pDate) {
		res = 0;
		try {
			sql = "delete from sale where pName = ? and pDate = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			pstmt.setString(2, pDate);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return res;
	}
}
