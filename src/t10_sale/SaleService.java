//package t10_sale;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class SaleService {
//
//  Scanner scanner = new Scanner(System.in);
//	
//	SaleDAO dao = new SaleDAO();
//	ProductVO pVO = null;
//	SaleVO sVO = null;
//
//	int res = 0;
//	String ans = "";
//	String pName = "";
//	String pDate = "";
//	
//	public void getSaleMenu() {
//		boolean run = true;
//		
//		while(run) {
//            System.out.print("\n1:판매내역 등록  2:판매내역 검색(상품명)  3:판매내역 검색(판매일자)  4:판매내역 리스트  5:판매내역 삭제  0:종료 ==> ");
//            int no = scanner.nextInt();
//            switch (no) {
//            	case 1:
//                    saleInput();        
//                    break;
//                case 2:
//                    saleSearch("pNameOrPDate","상품명or판매일자");        
//                    break;
//                case 3:
//                    saleSearch("pNameOrPDate","상품명or판매일자");   
//                    break;
//                case 4:
//                		saleSearch("total","전체");               
//                    break;
//                case 5:
//                    saleDelete();
//                    break;
//                default:
//                    run = false;
//			}
//		}
//		dao.connClose();
//	}
//
//	
//	//판매내역 등록
//	private void saleInput() {	
//		while(true) {
//			System.out.print("판매한 상품 이름 : "); pName = scanner.next();
//			pVO = dao.getNameSearch(pName);
//			if(pVO.getpName() == null) System.out.println("등록되지 않은 상품입니다.");
//			else {
//				sVO = new SaleVO();
//				sVO.setpName(pName);
//				System.out.print("판매한 수량 : "); sVO.setEa(scanner.nextInt());
//				System.out.print("판매한 날짜(년(yyyy)-월-일) : "); sVO.setpDate(scanner.next());
//				res = dao.setSaleInput(sVO);
//				if(res == 0) System.out.println("판매 내역 등록 실패");
//				else System.out.println("판매 내역 등록 완료");
//			}
//			
//			System.out.print("계속 등록하시겠습니까?");
//			ans = scanner.next().toUpperCase();
//			if(ans.equals("N")) break;
//		}
//	}
//	
//	
//	//판매내역 검색
////					pVO = dao.getNameSearch(pName);
////					if(pVO.getpName() == null) System.out.println("등록되지 않은 상품입니다.");
////					else break;
//	private void saleSearch(String item, String flag) {	
//		if(item.equals("pNameOrPDate")) {
//				if(flag.equals("상품명or판매일자")) {
//					System.out.print("상품명 또는 판매일자를 입력하세요 : "); 
//					String pNameOrPDate = scanner.next();
//					ArrayList<SaleVO> vos = dao.getSaleProcess(pNameOrPDate, "n");
//					ArrayList<SaleVO> vos = dao.getSaleProcess(pNameOrPDate, "d");
//				}
//		}
//		else if(item.equals("total")) {
//			ArrayList<SaleVO> vos = dao.getSaleProcess("total", "t");
//		}
//		
//		System.out.println("\n\t\t*** 판매상품 리스트(판매상품별) ***");
//		System.out.println("=".repeat(60));
//        System.out.println("상품번호\t상품명\t판매수량\t판매가격\t판매일자\t\t매출액");
//        System.out.println("-".repeat(60));
//		for(int i=0; i<vos.size(); i++) {
//			sVO = vos.get(i);
//			System.out.print(sVO.getIdx() + "\t");
//			System.out.print(sVO.getpName() + "\t");
//			System.out.print(sVO.getEa() + "\t");
//			sVO.setSalePrice(dao.getNameSearch(sVO.getpName()).getPrice());
//			System.out.print(sVO.getSalePrice() + "\t");
//			System.out.print(sVO.getpDate().substring(0, 10) + "\t");
//			System.out.println(sVO.getSalePrice() * sVO.getEa());
//		}
//		System.out.println("=".repeat(60));
//	}
//
//	
//	//판매내역 삭제
//	private void saleDelete() {	
//		while(true) {
//			System.out.print("상품명 : "); pName = scanner.next();
//			pVO = dao.getNameSearch(pName);
//			if(pVO.getpName() == null) System.out.println("등록되지 않은 상품입니다.");
//			else {
//				ArrayList<SaleVO> vos = dao.getSaleProcess(pName);
//				if(vos.size() != 0) {	//판매내역이 있다.
//					System.out.print("판매일자 : "); pDate = scanner.next();
////				for(int i=0; i<vos.size(); i++) {
////					if(vos.get(i).getpDate().equals(pDate)) {
//					res = dao.setDelete(pName, pDate);	//판매내역을 지운다.
////						break;
////					}
////				}
//					if(res == 0) System.out.println("판매내역 삭제 실패");
//					else System.out.println("판매내역 삭제 완료되었습니다.");
//				}
//				else System.out.println("해당 상품의 판매내역이 없습니다.");
//			}
//			System.out.print("계속 하시겠습니까?");
//			ans = scanner.next().toUpperCase();
//			if(ans.equals("N")) break;
//		}
//	}
//}
