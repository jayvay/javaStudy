package t1_DBConnection;

public class Test2Run {
	public static void main(String[] args) {
		
		Test2DAO dao = new Test2DAO();
		
		System.out.println("데이터베이스 연결 작업 중입니다.");
		
		Test2Service service = new Test2Service();
		service.getTestMethod();
		
		//DB 연결 종료 메소드 호출
		dao.conClose();
		System.out.println("데이터베이스 연결 종료");
		
	}
}
