package t9_sawon;

import java.util.ArrayList;
import java.util.Scanner;

public class PayService {

	PayVO vo = null;
	PayDAO dao = new PayDAO();
	Scanner scanner = new Scanner(System.in);
	int res = 0;
	String name = "";
	String ans = "N";
	
	public void setInputBong() {	//본봉 입력
		while(true) {
			vo = new PayVO();
			vo.setJikkub(scanner.next());
			vo.setBonbong(scanner.nextInt());
			
			res = dao.getInputBong(vo);
			
			if(res == 0) System.out.println("입력 실패! 다시 입력하세요.");
			else System.out.println("입력이 완료되었습니다.");
			
			System.out.println("계속 하시겠습니까?(y/n)");
			ans = scanner.next();
			if(ans.toUpperCase().equals("N")) break;
		}
	}
	
	public void setInput() {	//사원 입력
		while(true) {
			vo.setName(scanner.next());
			vo.setJikkub(scanner.next());
			vo.setNight(scanner.nextInt());
			
			res = dao.getInput(vo);
			
			if(res == 0) System.out.println("입력 실패! 다시 입력하세요.");
			else System.out.println("입력이 완료되었습니다.");
			
			System.out.println("계속 하시겠습니까?(y/n)");
			ans = scanner.next();
			if(ans.toUpperCase().equals("N")) break;
		}
	}

	public void setList() {	//사원 전체 조회
		ArrayList<PayVO> vos = dao.getList();
		
		System.out.println("=".repeat(60));
		System.out.println("\t *** 전 사원 급여 리스트 ***");
		System.out.println("-".repeat(60));
		System.out.println("사번\t성명\t직급\t야근시간\t급여(세전)\t공제액\t실수령액");
		System.out.println("-".repeat(60));
		
		for(int i=0; i<vos.size(); i++) {			
			vo = vos.get(i);
			calculator(vo);
			System.out.print(vo.getSabun() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getJikkub() + "\t");
			System.out.print(vo.getNight() + "\t");
			System.out.print(vo.getBonbong() + "\t");
			System.out.print(vo.getGongje() + "\t");
			System.out.print(vo.getSilbong() + "\n");
		}
		System.out.println("=".repeat(60));
	}

	private void calculator(PayVO vo) {
		vo.setGongje((vo.getBonbong() + (25000 * vo.getNight())) * 0.1);
		vo.setSilbong((vo.getBonbong() + (25000 * vo.getNight())) - vo.getGongje());
	}

	public void setListBong() {	//본봉 전체 조회
		ArrayList<PayVO> vos2 = dao.getListBong();
		
		System.out.println("=".repeat(30));
		System.out.println("\t ***  본봉 리스트 ***");
		System.out.println("-".repeat(30));
		System.out.println("직급\t본봉");
		System.out.println("-".repeat(30));
		
		for(int i=0; i<vos2.size(); i++) {			
			vo = vos2.get(i);
//			System.out.print(vo.getJikkubBong() + "\t");
			System.out.print(vo.getBonbong() + "\t\n");
		}
		System.out.println("=".repeat(30));
	}

	public void setSearch() {
		while(true) {
			System.out.print("조회할 성명을 입력하세요.");
			name = scanner.next();
			
			vo = dao.getSearch(name);
			
			if(vo != null) {
				calculator(vo);
				System.out.println("사원번호 :" + vo.getSabun());
				System.out.println("사원성명 :" + vo.getName());
				System.out.println("사원직급 :" + vo.getJikkub());
				System.out.println("야근시간(시) :" + vo.getNight());
				System.out.println("세전급여 :" + vo.getBonbong());
				System.out.println("공제액 :" + vo.getGongje());
				System.out.println("실수령액 :" + vo.getSilbong());
			} else {
				System.out.println("검색하신 " + name + " 님은 없습니다.");
			}
			System.out.print("계속 검색하시겠습니까?(y/n)");
			ans = scanner.next();
			if(ans.toUpperCase().equals("N")) break;
		}		
	}

	public void setUpdate() {
		while(true) {
			System.out.print("조회할 성명을 입력하세요.");
			name = scanner.next();
			
			vo = dao.getSearch(name);
			
			if(vo != null) {
				calculator(vo);
				System.out.println("사원번호 :" + vo.getSabun());
				System.out.println("사원성명 :" + vo.getName());
				System.out.println("사원직급 :" + vo.getJikkub());
				System.out.println("야근시간(시) :" + vo.getNight());
				System.out.println("세전급여 :" + vo.getBonbong());
				System.out.println("공제액 :" + vo.getGongje());
				System.out.println("실수령액 :" + vo.getSilbong());
				break;
			} else {
				System.out.println("검색하신 " + name + " 님은 없습니다.");
			}
		}	
			
		boolean flag = true;
		while(flag) {
			System.out.print("수정하고 싶은 항목을 입력하세요.(1.성명/2.직급/3.야근시간(999입력시 수정 종료))");
			int num = scanner.nextInt();
		
			switch (num) {
				case 1:
					System.out.print("변경 성명을 입력하세요.");
					vo.setName(scanner.next());
					break;
				case 2:
					System.out.print("변경 직급을 입력하세요.");
					vo.setJikkub(scanner.next());
					break;
				case 3:
					System.out.print("변경 야근시간을 입력하세요.");
					vo.setNight(scanner.nextInt());
					break;
				default:
					flag = false;
			}
			
			if(num == 999) System.out.println("수정을 취소하셨습니다. 초기 메뉴로 돌아갑니다");
			else {
				res = dao.setUpdate(vo);
				if(res == 0) System.out.println("정보 수정 실패");
				else System.out.println("정보 수정 완료");

				System.out.print("계속 수정하시겠습니까?(y/n)");
				ans = scanner.next();
				if(ans.toUpperCase().equals("N")) break;
			}	
		}
	}

	public void setDelete() {
		
		while(true) {
			System.out.println("삭제할 사원 성명을 입력하세요.");
			name = scanner.next();
			vo = dao.getSearch(name);
			
			if(vo != null) {
				res = dao.getDelete(vo);
				if(res == 0) {
					System.out.println("삭제 실패. 다시 입력하세요.");
				} else {
					System.out.println(name + " 님의 자료가 삭제되었습니다.");
				}
				
				System.out.print("계속 하시겠습니까?");
				ans = scanner.next();
				if(ans.toUpperCase().equals("N")) break;
			} 
			else {
				System.out.println("검색하신 " + name + "님은 없습니다.");
			}	
		}
	}
	
	
	
	
	
	


}
