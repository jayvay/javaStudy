package t10_sale;

import java.util.List;
import java.util.Scanner;

public class ProductService {
	Scanner scanner = new Scanner(System.in);
	
	ProductVO vo = null;
	ProductDAO dao = new ProductDAO();

	String pName = "";
	int res = 0;
	String ans = "";

//	public ProductService(ProductDAO dao) {	//??????????????????
//		this.dao = dao;
//	}

	public void getProductMenu() {	//상품관리 주 메뉴
		boolean run = true;
		
		while(run) {
			System.out.print("\n1:상품등록 2:상품검색 3:상품리스트 4:상품삭제 0:종료");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1:
					productInput();
					break;
				case 2:
					productSearch();
					break;
				case 3:
					productList();
					break;
				case 4:
					productDelete();
					break;
				default:
					run = false;
			}
		}
		dao.connClose();
	}

	private void productDelete() {	//상품 삭제
		System.out.print("삭제할 상품명을 입력하세요");
		pName = scanner.next();
		
		vo = dao.getNameSearch(pName);
		if(vo.getpName() == null) System.out.println("검색하신 상품이 없습니다. 다시 입력하세요.");
		else {
			System.out.println("상품 고유 번호 : " + vo.getIdx());
			System.out.println("상품명 : " + vo.getpName());
			System.out.println("상품 가격 : " + vo.getPrice());
			res = dao.setProductDelete(vo.getIdx());
			if(res == 0) System.out.println("상품 삭제 실패");
			else System.out.println(pName + " 상품이 삭제되었습니다.");
		}
	}

	private void productList() {	//전체 상품 조회
		List<ProductVO> vos = dao.getProductList();
		
		System.out.println("\n *** 전체 상품 리스트 ***");
		System.out.println("=".repeat(40));
		System.out.println("상품번호\t상품명\t\t상품가격");
		System.out.println("-".repeat(40));
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.print(vo.getIdx() + "\t");
			System.out.print(vo.getpName() + "\t\t");
			System.out.print(vo.getPrice() + "\n");	//데시말포맷?????
			System.out.println("-".repeat(40));
		}
			System.out.println("총 상품 수 : " + vos.size());
			System.out.println("=".repeat(40));
	}

	private void productSearch() {	//상품 개별 검색
		System.out.print("검색할 상품명을 입력하세요");
		pName = scanner.next();
		
		vo = dao.getNameSearch(pName);
		if(vo.getpName() == null) System.out.println("검색하신 상품이 없습니다. 다시 입력하세요.");
		else {
			System.out.println("상품 고유 번호 : " + vo.getIdx());
			System.out.println("상품명 : " + vo.getpName());
			System.out.println("상품 가격 : " + vo.getPrice());
		}
	}

	private void productInput() {	//상품 등록 처리
		while(true) {
			System.out.println("상품명을 입력하세요");
			pName = scanner.next();
			
			//상품명 중복 처리
			vo = dao.getNameSearch(pName);
			if(vo.getpName() != null) System.out.println("동일한 상품이 존재합니다. 다시 입력하세요.");
			else {
				vo.setpName(pName);
				System.out.println("상품 가격을 입력하세요");
				vo.setPrice(scanner.nextInt());
				res = dao.setProductInput(vo);
				if(res == 0) System.out.println("상품 등록 실패");
				System.out.println("상품이 등록되었습니다.");
				
				System.out.print("상품을 계속 등록하시겠습니까?(y/n)");
				ans = scanner.next().toUpperCase();
				if(ans.equals("N")) break;
			}
		} 
	}
	
	
	

}
