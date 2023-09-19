package t9_sawon;

import java.util.Scanner;

public class PayRun2 {
	public static void main(String[] args) {
		
		PayService2 service = new PayService2();
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		int num = 0;
		
		while(run) {
			System.out.println("=".repeat(40));
			System.out.println("\t** 급여 확인을 하고 싶어요 **");
			System.out.println("=".repeat(40));
			boolean flag2 = true;
			while(flag2) {
				System.out.print("1.정보입력 2.전체조회 3.개별조회 4.수정 5.삭제 0.종료");
				num = scanner.nextInt();
				switch (num) {
					case 1:
						service.setInput();
						break;
					case 2:
						System.out.print("어떤 정보를 보시겠습니까? 1.사원 정보 2.직급 정보");
						num = scanner.nextInt();
						if(num ==1 ) service.setList();
						else if(num == 2) service.setListBong();
						break;
					case 3:
						service.setSearch();
						break;
					case 4:
						service.setUpdate();
						break;
					case 5:
						System.out.print("무엇을 삭제하시겠습니까? 1.사원 정보 2.직급 정보");
						num = scanner.nextInt();
						if(num ==1 ) service.setDelete();
						else if(num == 2) service.setDeleteBong();
						break;
					default:
						flag2 = false;
				}
			}
		}
		
		
		
		scanner.close();
	}
}
