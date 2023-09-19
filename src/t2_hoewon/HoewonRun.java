package t2_hoewon;

public class HoewonRun {
	public static void main(String[] args) {
		
//		HoewonDAO dao = new HoewonDAO();
//		HoewonDAO2 dao = new HoewonDAO2();
		HoewonDAO3 dao = new HoewonDAO3();
		
		//hoewon 테이블의 전체 회원 조회
		dao.getList();
		
		//DB con객체 close
		dao.connClose();		
		
		
		
		
		
	}
}
