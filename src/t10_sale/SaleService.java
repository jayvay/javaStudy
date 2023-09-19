package t10_sale;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleService {
	
	Scanner scanner = new Scanner(System.in);
	
//	ProductDAO dao = null;
	SaleDAO dao = new SaleDAO();
	ProductVO pVo = null;
	SaleVO sVo = null;
	
	String pName = "";
	int res = 0;
	String ans = "";
	
//	public SaleService(ProductDAO dao) {
//		this.dao = dao;
//	}
	
	public void getSaleMenu() {	//판매 관리 주 메뉴
		boolean run = true;
		
		while(run) {
			System.out.print("\n1:판매내역 등록 2:상품검색 3:날짜검색 4.판매내역 리스트 5:삭제 0:종료");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1:
					saleInput();	
					break;
				case 2:
					saleSearch();	//판매된 상품 검색
					break;
				case 3:
					saleDateSearch();	//판매 일자별 검색
					break;
				case 4:
					saleList();	//전체 판매 내역
					break;
				case 5:
//					saleDelete();
					break;
				default:
					run = false;
			}
		}
//		dao.connClose();??????????????????
	}

	private void saleList() {	//전체 판매 내역
		ArrayList<SaleVO> vos = dao.getSaleList();
		
		System.out.println("\n *** 판매 상품 리스트(전체) - 연습용 ***");
		System.out.println("=".repeat(40));
		System.out.println("상품번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-".repeat(40));
		for(int i=0; i<vos.size(); i++) {
			sVo = vos.get(i);
			System.out.print(sVo.getIdx() + "\t");
			System.out.print(sVo.getpName() + "\t");
			System.out.print(sVo.getEa() + "\t");
			System.out.print((sVo.getSalePrice()*sVo.getEa()) + "\t");
			System.out.print(sVo.getpDate().substring(0,10) + "\n");
			System.out.println("-".repeat(40));
		}
			System.out.println("총 판매 건수 : " + vos.size());
			System.out.println("=".repeat(40));
	}

	private void saleDateSearch() {	//판매 일자별 검색
		System.out.print("검색할 판매 일자를 입력하세요");
		String pDate = scanner.next();
		
		ArrayList<SaleVO> vos = dao.getSaleDateSearch(pDate);
		
		System.out.println("\n *** 판매 상품 리스트(일자별) ***");
		System.out.println("=".repeat(40));
		System.out.println("상품번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-".repeat(40));
		for(int i=0; i<vos.size(); i++) {
			sVo = vos.get(i);
			System.out.print(sVo.getIdx() + "\t");
			System.out.print(sVo.getpName() + "\t");
			System.out.print(sVo.getEa() + "\t");
			System.out.print((sVo.getSalePrice()*sVo.getEa()) + "\t");
			System.out.print(sVo.getpDate().substring(0,10) + "\n");
			System.out.println("-".repeat(40));
		}
			System.out.println("총 판매 건수 : " + vos.size());
			System.out.println("=".repeat(40));
	}

	private void saleSearch() {	//판매 상품 검색
		System.out.print("검색할 판매 상품명을 입력하세요");
		pName = scanner.next();
		
		ArrayList<SaleVO> vos = dao.getSaleNameSearch(pName);
		
		System.out.println("\n *** 판매 상품 리스트(판매상품별) ***");
		System.out.println("=".repeat(40));
		System.out.println("상품번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-".repeat(40));
		for(int i=0; i<vos.size(); i++) {
			sVo = vos.get(i);
			System.out.print(sVo.getIdx() + "\t");
			System.out.print(sVo.getpName() + "\t");
			System.out.print(sVo.getEa() + "\t");
			System.out.print((sVo.getSalePrice()*sVo.getEa()) + "\t");
			System.out.print(sVo.getpDate().substring(0,10) + "\n");
			System.out.println("-".repeat(40));
		}
			System.out.println("총 판매 건수 : " + vos.size());
			System.out.println("=".repeat(40));
	}

	private void saleInput() {	//판매 내역 등록
		while(true) {
			System.out.print("판매 상품명을 입력하세요");
			pName = scanner.next();
			
			//판매 상품이 상품 테이블에 등록되어 있는지 검색
			pVo = dao.getNameSearch(pName);
			if(pVo.getpName() == null) System.out.println("등록된 상품이 아닙니다. 다시 입력하세요.");
			else {
				sVo = new SaleVO();
				sVo.setpName(pName);
				System.out.print("판매 날짜(연(yyyy)-월-일)를 입력하세요");
				sVo.setpDate(scanner.next());
				System.out.print("판매 수량을 입력하세요");
				sVo.setEa(scanner.nextInt());
				res = dao.setSaleInput(sVo);
				if(res == 0) System.out.println("상품 등록 실패");
				System.out.println("상품이 등록되었습니다.");
				
				System.out.print("상품을 계속 등록하시겠습니까?(y/n)");
				ans = scanner.next().toUpperCase();
				if(ans.equals("N")) break;
			}
		} 
	}
	

}
