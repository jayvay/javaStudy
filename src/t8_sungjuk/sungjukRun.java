package t8_sungjuk;

import java.util.Scanner;

public class sungjukRun {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		SungjukService service = new SungjukService();
		
		boolean run = true;
		while(run) {
			System.out.println("\n\t ** 성 적 표 **");
			System.out.print("메뉴 1:입력 2:전체 조회 3:개별 조회 4:수정 5:삭제 0:종료");
			int num = scanner.nextInt();
			
			switch (num) {
				case 1:	//입력 -중복 처리(숙제)
					service.setInput();
					break;
				case 2:	//전체 조회
					service.setList();
					break;
				case 3:	//개별 조회
					service.setSearch();
					break;
				case 4:	//수정(숙제)
					service.setUpdate();
					break;
				case 5:	//삭제(숙제)
					service.setDelete();
					break;
				default:	//종료
					run = false;
			}
		}
		System.out.println("작업 끝~");
		
		
		
		
		
		
		
		
		
		
		
		scanner.close();
	}
}
