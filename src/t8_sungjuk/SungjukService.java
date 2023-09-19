package t8_sungjuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukService {
	//비즈니스 로직
	
	Scanner scanner = new Scanner(System.in);	//필드에서 close()메소드 쓸 수 없다. 동작하는 애들은 메소드 안에 있어야 한다
	SungjukDAO dao = new SungjukDAO();
	SungjukVO vo = null;
	
	String ans = "N";
	String name = "";
	int res = 0;
	
	public void setInput() {	//성적 입력
		vo = new SungjukVO();
		
		while(true) {
			System.out.println("\n** 성적 입력 처리");
			
			//동명2인 처리(같은 성명 자료는 입력 못하게)-숙제
			while(true) {	
				System.out.print("성명 : "); name = scanner.next();
				
				vo = dao.getSearch(name);	
				if(vo.getName() == null) break;
				System.out.println("목록에 같은 이름이 존재합니다. 다시 입력하세요.");
			}
			vo.setName(name);
			
			System.out.print("국어 : "); vo.setKor(scanner.nextInt());
			System.out.print("영어 : "); vo.setEng(scanner.nextInt());
			System.out.print("수학 : "); vo.setMat(scanner.nextInt());
			
			res = dao.setInput(vo);
			if(res == 0) System.out.println("성적 등록 실패");
			else System.out.println("성적 등록 완료");
			
			System.out.print("계속 하시겠습니까?(y/n)");
			ans = scanner.next();
			if(ans.toUpperCase().equals("N")) break;
		}
//		scanner.close();	//service에서 close하면 Run에서 닫힌다.???????????? 
	}

	
	public void setList() {	//성적 전체 조회
		ArrayList<SungjukVO> vos = dao.getList();
		
		System.out.println("\n\t *** 성 적 리 스 트 ");
		System.out.println("=".repeat(60));
		System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-".repeat(60));
		
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			calculator(vo);
			System.out.print(vo.getIdx() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMat() + "\t");
			System.out.print(vo.getTot() + "\t");
			System.out.print(String.format("%.1f", vo.getAvg()) + "\t");
			System.out.print(vo.getGrade() + "\n");
		}
		
		System.out.println("-".repeat(60));
		System.out.println("\t\t총 인원 수 : " + vos.size() + " 명");
		System.out.println("=".repeat(60));
		
	}

	
	private void calculator(SungjukVO vo) {	//계산 처리(총점,평균,학점)
		vo.setTot(vo.getKor() + vo.getEng() + vo.getMat());
		vo.setAvg(vo.getTot() / 3.0);
		if(vo.getAvg() >= 90) vo.setGrade('A');
		else if(vo.getAvg() >= 80) vo.setGrade('B');
		else if(vo.getAvg() >= 70) vo.setGrade('C');
		else if(vo.getAvg() >= 60) vo.setGrade('D');
		else vo.setGrade('F');
		
	}

	
	public void setSearch() {	//성적 개별 조회
		while(true) {
			System.out.print("\n조회할 성명을 입력하세요.");
			name = scanner.next();
			
			vo = dao.getSearch(name);
			
			if(vo != null) {
			//if(vo.getName() != null) {
				calculator(vo);
				System.out.println("\n번호 : " + vo.getIdx());
				System.out.println("성명 : " + vo.getName());
				System.out.println("국어 : " + vo.getKor());
				System.out.println("영어 : " + vo.getEng());
				System.out.println("수학 : " + vo.getMat());
				System.out.println("총점 : " + vo.getTot());
				System.out.println("평균 : " + vo.getAvg());
				System.out.println("학점 : " + vo.getGrade());
			} else System.out.println("검색하신 " + name + "님은 없습니다.");
			
			System.out.print("계속 검색하시겠습니까?(y/n)");
			ans = scanner.next();
			if(ans.toUpperCase().equals("N")) break;
		}
	}

	
	public void setUpdate() {	//성적 수정
		
		while(true) {
			System.out.print("\n성명을 입력하세요.");
			name = scanner.next();
			
			vo = dao.getSearch(name);
			
			if(vo != null) {
				calculator(vo);
				System.out.println("-".repeat(50));
				System.out.println("번호 : " + vo.getIdx());
				System.out.println("성명 : " + vo.getName());
				System.out.println("국어 : " + vo.getKor());
				System.out.println("영어 : " + vo.getEng());
				System.out.println("수학 : " + vo.getMat());
				System.out.println("총점 : " + vo.getTot());
				System.out.println("평균 : " + String.format("%.1f", vo.getAvg()));
				System.out.println("학점 : " + vo.getGrade());
				System.out.println("-".repeat(50));
				break;
			} else {
				System.out.println("검색하신 " + name + "님은 없습니다.");
			}
		}
		
		boolean flag = true;
		while(flag) {
			System.out.print("수정하고 싶은 항목을 입력하세요.(성명/국어/영어/수학(999입력시 수정 종료))");
			String sub = scanner.next();
			
			switch (sub) {
				case "성명":
					System.out.print("변경할 성명을 입력하세요.");
					vo.setName(scanner.next());
					break;

				case "국어":
					System.out.print("점수를 입력하세요.");
					vo.setKor(scanner.nextInt());
					break;
					
				case "영어":
					System.out.print("점수를 입력하세요.");
					vo.setEng(scanner.nextInt());
					break;

				case "수학":
					System.out.print("점수를 입력하세요.");
					vo.setMat(scanner.nextInt());
					break;
				default: 
					flag = false;
			}
			
			if(sub.equals("999")) System.out.println("~~수정 취소! 초기 메뉴로 돌아갑니다~~");
			else {
				res = dao.setUpdate(vo);
				if(res == 0) System.out.println("성적 수정 실패");
				else System.out.println("성적 수정 완료");

				System.out.print("계속 수정하시겠습니까?(y/n)");
				ans = scanner.next();
				if(ans.toUpperCase().equals("N")) break;
			}
		}
	}


	public void setDelete() {	//성적 삭제
		
		while(true) {
			System.out.print("\n성명을 입력하세요.");
			name = scanner.next();
			vo = dao.getSearch(name);
			
			if(vo != null) {
				res = dao.setDelete(vo);
				if(res == 0) System.out.println("자료 삭제 실패");
				else System.out.println(name + " 님의 자료가 삭제되었습니다.");
				
				System.out.print("계속 하시겠습니까?");
				ans = scanner.next();
				if(ans.toUpperCase().equals("N")) break;
				
			} else {
				System.out.println("검색하신 " + name + "님은 없습니다.");
			}	
		}
		
		
		
	}
}
