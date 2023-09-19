package t3_hoewon;

import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		HoewonDAO dao = new HoewonDAO();
		HoewonDAO2 dao = new HoewonDAO2();
				
		boolean run = true;
		
		while(run) {
			System.out.print("1.전체조회 2.개별조회 3.종료(999 입력)");
			int num = scanner.nextInt();
		
			switch(num) {
				case 1:
					dao.getList();
					break;
				case 2:
					System.out.print("검색할 회원명을 입력하세요.");
					String name = scanner.next();
					//hoewon 테이블의 회원 조회
					dao.getSearch(name);
					break;
				default:
					run = false;
			}
			System.out.println("-".repeat(50));
		}
		
		System.out.println("작업 끝");
		
		//DB con객체 close
		dao.connClose();		
		
		scanner.close();
	}
}
