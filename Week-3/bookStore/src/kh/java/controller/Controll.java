package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Books;
import kh.java.vo.Economics;
import kh.java.vo.EduBook;
import kh.java.vo.NAndE;

public class Controll {
	Scanner sc = new Scanner(System.in);

	// Books[] to = new Books[90];
	// int tIndex;

	NAndE[] ne = new NAndE[30];
	int nIndex;

	Economics[] eco = new Economics[30];
	int cIndex;

	EduBook[] edu = new EduBook[30];
	int dIndex;

	Books[] cart = new Books[30];
	int ctIndex;

	int point; // 회원의 point를 기록할 변수

	public void main() {
		while (true) {
			System.out.println("서점 관리 프로그램");
			System.out.println("1. 직원");
			System.out.println("2. 손님");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				staff();
				break;

			case 2:
				customer();
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void staff() {

		while (true) {
			System.out.println("===== 직원 메뉴 =====");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 현황");
			System.out.println("3. 도서 관리");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 추천도서 관리");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1: // 도서 등록
				insertBook();
				break;

			case 2: // 도서 현황
				break;

			case 3: // 도서 관리
				modBook();
				break;

			case 4: // 도서 삭제
				break;

			case 5: // 추천도서 관리
				break;

			case 0: // 뒤로가기
				System.out.println("이전으로 이동합니다");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		}

	}

	public void customer() {

		while (true) {

			System.out.println("===== 손님 메뉴 =====");
			System.out.println("1. 쇼핑하기");
			System.out.println("2. 추천 도서 목록");
			System.out.println("3. 장바구니");
			System.out.println("4. 포인트 보기");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1: // 쇼핑하기
				break;

			case 2: // 추천도서 목록
				break;

			case 3: // 장바구니
				break;

			case 4:
				break;

			case 0: // 뒤로가기
				System.out.println("이전으로 이동합니다");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");

			}
		}

	}

	public void insertBook() {

		while (true) {

			System.out.println("======== 도서 등록 카테고리 ========");
			System.out.println("1. 소설 or 에세이");
			System.out.println("2. 경제");
			System.out.println("3. 학습서");
			System.out.println("0. 뒤로가기");
			int slt = sc.nextInt();

			System.out.println("등록할 도서의 정보를 입력해주세요.");

			sc.nextLine();
			System.out.print("도서 이름 : ");
			String name = sc.nextLine();

			System.out.print("저자명 : ");
			String writer = sc.next();

			System.out.print("장르 : ");
			String genre = sc.next();

			System.out.print("가격 : ");
			int price = sc.nextInt();

			System.out.print("수량 : ");
			int stock = sc.nextInt();

			switch (slt) {
			case 1: // 소설 or 에세이 ne 배열
				ne[nIndex++] = new NAndE(name, writer, genre, price, stock);
				break;

			case 2: // 경제 eco 배열
				eco[cIndex++] = new Economics(name, writer, genre, price, stock);
				break;

			case 3: // 학습서 edu 배열
				edu[dIndex++] = new EduBook(name, writer, genre, price, stock);
				break;

			case 0:
				System.out.println("이전 메뉴로 이동합니다");
				return;
			}
		}
	}

	public void modBook() {

		while (true) {

			System.out.println("======== 도서 관리 카테고리 ========");
			System.out.println("1. 소설 or 에세이");
			System.out.println("2. 경제");
			System.out.println("3. 학습서");
			System.out.println("0. 뒤로가기");
			int num1 = sc.nextInt();

			int num2;

			int index = 0;

			switch (num1) {
			case 1:
				printNE();
				System.out.print("수정할 도서의 no.를 입력하세요 : ");
				num2 = sc.nextInt() - 1;
				modDetail(ne, num2);
				break;

			case 2:
				printEco();
				System.out.print("수정할 도서의 no.를 입력하세요 : ");
				num2 = sc.nextInt() - 1;
				modDetail(eco, num2);
				break;

			case 3:
				printEdu();
				System.out.print("수정할 도서의 no.를 입력하세요 : ");
				num2 = sc.nextInt() - 1;
				modDetail(edu, num2);
				break;

			case 0:
				System.out.println("이전 메뉴로 이동합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		}
	}

	public void modDetail(Books[] book, int index) {

		while (true) {
			System.out.println("[" + book[index].getName() + "]을 선택하셨습니다.");
			System.out.println("무엇을 수정하시겠습니까 ?");
			System.out.println("1. 도서 이름");
			System.out.println("2. 도서 저자");
			System.out.println("3. 도서 장르");
			System.out.println("4. 도서 가격");
			System.out.println("5. 도서 수량");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				sc.nextLine();
				System.out.println("현재 도서명: " + book[index].getName());
				System.out.print("수정할 도서명을 입력하세요 : ");
				book[index].setName(sc.nextLine());
				break;

			case 2:
				System.out.println("현재 저자: " + book[index].getWriter());
				System.out.print("수정할 저자명을 입력하세요 : ");
				book[index].setWriter(sc.next());
				break;

			case 3:
				sc.nextLine();
				System.out.println("현재 장르: " + book[index].getGenre());
				System.out.print("수정할 장르를 입력하세요 : ");
				book[index].setGenre(sc.nextLine());
				break;

			case 4:
				System.out.println("현재 가격 : " + book[index].getPrice());
				System.out.print("수정할 가격을 입력하세요 : ");
				book[index].setPrice(sc.nextInt());
				break;

			case 5:
				System.out.println("현재 수량 : " + book[index].getStock());
				System.out.print("수정할 가격을 입력하세요 : ");
				book[index].setStock(sc.nextInt());
				break;

			case 0:
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

			System.out.println("수정이 완료되었습니다.");

		}

	}

	public void deleteBook() {
		while (true) {
			System.out.println("===== 도서 삭제 =====");
			System.out.println("1. 소설/에세이");
			System.out.println("2. 경제");
			System.out.println("3. 학습서");
			System.out.println("0. 뒤로가기");
			System.out.print("삭제할 도서의 카테고리를 선택하세요 : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				printNE();
				nIndex = deleteBook(ne, nIndex);
				break;

			case 2:
				printEco();
				cIndex = deleteBook(eco, cIndex);
				break;

			case 3:
				printEdu();
				dIndex = deleteBook(edu, dIndex);
				break;

			case 0:
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		}
	}

	public int deleteBook(Books[] product, int index) {
		System.out.print("삭제할 제품의 No를 입력하세요 : ");
		int selIndex = sc.nextInt() - 1;
		System.out.println("[" + ne[selIndex].getName() + "]을 선택하셨습니다.");
		System.out.print("[" + ne[selIndex].getName() + "]을 삭제하시겠습니까? [y/n]");
		char ch = sc.next().charAt(0);
		if (ch == 'y') {
			for (int i = selIndex; i < index - 1; i++) {
				product[i] = product[i + 1];
				product[index--] = null;
			}
		} else {
			System.out.println("삭제 취소");
		}
		return index;
	}

	public void printNE() {
		System.out.println("===== 소설/에세이 =====");
		System.out.println("NO\t도서명\t저자\t가격\t수량\t장르");
		for (int i = 0; i < nIndex; i++) {
			System.out.println((i + 1) + "\t" + ne[i].getName() + "\t" + ne[i].getWriter() + "\t" + ne[i].getPrice()
					+ "\t" + ne[i].getStock() + "\t" + ne[i].getGenre());

		}
	}

	public void printEco() {
		System.out.println("===== 경제 =====");
		System.out.println("NO\t도서명\t저자\t가격\t수량");
		for (int i = 0; i < cIndex; i++) {
			System.out.println((i + 1) + "\t" + eco[i].getName() + "\t" + eco[i].getWriter() + "\t" + eco[i].getPrice()
					+ "\t" + eco[i].getStock() + "\t");
		}
	}

	public void printEdu() {
		System.out.println("===== 학습서 =====");
		System.out.println("NO\t도서명\t저자\t가격\t수량");
		for (int i = 0; i < dIndex; i++) {
			System.out.println((i + 1) + "\t" + edu[i].getName() + "\t" + edu[i].getWriter() + "\t" + edu[i].getPrice()
					+ "\t" + edu[i].getStock() + "\t");
		}

	}

	public void showCart() {

		int totalPrice = 0;
		
		while(true) {				
			System.out.println("===== 현재 장바구니 =====");
			System.out.println("no.\t도서명\t저자\t장르\t가격\t수량\t");
			for (int i = 0; i < ctIndex; i++) {
				System.out.println((i + 1) + "\t" + cart[i].getName() + "\t" + cart[i].getWriter() + "\t"
						+ cart[i].getGenre() + "\t" + cart[i].getPrice() + "\t" + cart[i].getStock());
				totalPrice += cart[i].getPrice();
			}
			
			System.out.println("합계 금액 : " + totalPrice+"원");
			
			System.out.print("이대로 구매 하시겠습니까? [y/n] : ");
			char ans = sc.next().charAt(0);
			
			switch (ans) {
			case 'y':
				System.out.println(totalPrice+"원을 지불하셨습니다.");
				System.out.println("적립 포인트 : "+(totalPrice*0.05));
				point += totalPrice*0.05;
				break;
				
			case 'n':
				System.out.println("장바구니를 비우시겠습니까? [y/n]");
				char ans2 = sc.next().charAt(0);
				
				if(ans2=='y') {
					
				} else {
					System.out.println("이전 메뉴로 돌아갑니다.");
					return;
				}
				
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;				
			}
		}

	}
	
	public void clearCart() {
		
	}

}
