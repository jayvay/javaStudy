package t4_hoewon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		HoewonDAO dao = new HoewonDAO();
		HoewonVO vo = null;		
		
		boolean run = true;
		String name = "";
		
		while(run) {
			System.out.print("1.전체조회 2.개별조회 3.수정 4.삭제 5.종료");
			int num = scanner.nextInt();
		
			switch(num) {
				case 1:
					ArrayList<HoewonVO> vos = dao.getList();
					
					System.out.println("=".repeat(50));
					System.out.println("\t\t**짱구는 못말려 등장인물**");
					System.out.println("=".repeat(50));
					System.out.println("번호\t이름\t나이\t주소\t성별");
					System.out.println("-".repeat(50));
					
					for(HoewonVO v : vos) {
						System.out.print(v.getIdx() + "\t");		//필드명으로 검색
						System.out.print(v.getName() + "\t");
						System.out.print(v.getAge() + "\t");
						System.out.print(v.getAddress() + "\t");
						System.out.print(v.getGender());
						System.out.println();
					}
					System.out.println("=".repeat(50));
					
					break;
				case 2:
					System.out.print("검색할 회원명을 입력하세요.");
					name = scanner.next();
					vo = dao.getSearch(name);
					if(vo.getIdx() != 0) {
//					if(vo != 0) { //vo 값은 null이 되지 않는다.(0이나 null이라도 담아 온다)
//						System.out.println(vo);
						System.out.println("번호 : " + vo.getIdx());
						System.out.println("성명 : " + vo.getName());
						System.out.println("나이 : " + vo.getAge());
						System.out.println("주소 : " + vo.getAddress());
						System.out.println("성별 : " + vo.getGender());
					} else {
						System.out.println(name + " 님의 자료가 없습니다.");
					}
					break;
				case 3:
					break;
				case 4:
					System.out.print("삭제할 회원명을 입력하세요.");
					name = scanner.next();
					vo = dao.getSearch(name);
					
					if(vo.getName() == null) {
						System.out.println(name + " 님 자료가 없습니다.");
					} else {
						dao.setDelete(name);
						System.out.println(name + " 님 자료가 삭제되었습니다.");
					}
					
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
