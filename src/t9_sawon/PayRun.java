package t9_sawon;

import java.util.Scanner;

public class PayRun {
	public static void main(String[] args) {
		
		PayService service = new PayService();
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		int num = 0;
		
		while(run) {
			System.out.println("=".repeat(40));
			System.out.println("\t** 급여 확인 **");
			System.out.println("=".repeat(40));
			System.out.print("1.직급별 본봉 리스트 2.직원 급여 리스트 0.종료");
			num = scanner.nextInt();
			if(num == 1) {
				boolean flag1 = true;
				while(flag1) {
					System.out.print("1.입력 2.전체조회 3.수정 4.삭제 0.종료");
					num = scanner.nextInt();
					switch (num) {
						case 1:
							service.setInputBong();
							break;
						case 2:
							service.setListBong();
							break;
						case 3:
							service.setUpdate();
							break;
						case 4:
//							service.setDelete();
							break;
						default:
							flag1 = false;
					}
				}
			}	
			else if(num == 2) {
				boolean flag2 = true;
				while(flag2) {
					System.out.print("1.사원입력 2.전체조회 3.개별조회 4.수정 5.삭제 0.종료");
					num = scanner.nextInt();
					switch (num) {
						case 1:
							service.setInput();
							break;
						case 2:
							service.setList();
							break;
						case 3:
							service.setSearch();
							break;
						case 4:
							service.setUpdate();
							break;
						case 5:
							service.setDelete();
							break;
						default:
							flag2 = false;
					}
				}
			} else run = false;
		}
		
		
		
		scanner.close();
	}
}
