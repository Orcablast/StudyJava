package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Drink;
import kh.java.vo.InstantFood;
import kh.java.vo.Items;
import kh.java.vo.Medicine;
import kh.java.vo.Snack;

public class ConMgr {
	Scanner sc = new Scanner(System.in);

	Drink[] d = new Drink[10];
	int dIndex;

	InstantFood[] iFood = new InstantFood[10];
	int iIndex;

	Snack[] s = new Snack[10];
	int sIndex;

	Medicine[] m = new Medicine[10];
	int mIndex;

	Items[] etc = new Items[10];
	int eIndex;

	// 장바구니

	Items[] cart = new Items[10];
	int cIndex;

	public ConMgr() {
		d[dIndex++] = new Drink("스프라이트", 100, 2000, false, 550, 300);

		d[dIndex++] = new Drink("제로 코크", 30, 1500, false, 300, 150);

		d[dIndex++] = new Drink("환타", 60, 1300, false, 120, 65);

		d[dIndex++] = new Drink("클라우드", 30, 3000, true, 350, 200);

		iFood[iIndex++] = new InstantFood("치킨 도시락", 3, 3500, false, "2020-02-13", 1150);

		iFood[iIndex++] = new InstantFood("도련님 도시락", 2, 4000, false, "2020-02-12", 980);

		iFood[iIndex++] = new InstantFood("돈까스 도시락", 1, 3800, false, "2020-02-13", 1020);

		s[sIndex++] = new Snack("포카칩", 10, 1500, false, 360, 50);

		s[sIndex++] = new Snack("홈런볼", 5, 1000, false, 270, 60);

		s[sIndex++] = new Snack("썬칩", 4, 1300, false, 330, 40);

		m[mIndex++] = new Medicine("게보린", 5, 5000, false, "2020-07-30");

		m[mIndex++] = new Medicine("타이레놀", 3, 6000, false, "2020-06-30");

		etc[eIndex++] = new Items("말보로", 20, 4500, true);

		etc[eIndex++] = new Items("던힐", 18, 4500, true);

		etc[eIndex++] = new Items("우산", 12, 2000, false);

		etc[eIndex++] = new Items("마스크", 3, 1000, false);

	}

	public void main() {

		while (true) {
			System.out.println("===== DS 25 =====");
			System.out.println("1. 직원");
			System.out.println("2. 손님");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				staff();
				break;

			case 2:
				client();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

		}
	}

	public void staff() {

		while (true) {
			System.out.println("--- 열심히 일하십시오 휴먼 ---");
			System.out.println("1. 새 제품 등록");
			System.out.println("2. 현재 재고 현황");
			System.out.println("3. 재고 변경");
			System.out.println("4. 제품 삭제");
			System.out.println("0. 뒤로 가기");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				insertItem();
				break;

			case 2:
				printDrink();
				printSnack();
				printIFood();
				printMedi();
				printEtc();
				break;

			case 3:
				updateItem();
				break;

			case 4:
				delItem();
				break;

			case 0:
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");

			} // staff while 종료지점
		}
	}

	public void insertItem() {

		while (true) {
			System.out.println("------ 상품 등록 ------");
			System.out.println("1. 음료 등록");
			System.out.println("2. 즉석 식품 등록");
			System.out.println("3. 과자 등록");
			System.out.println("4. 의약품 등록");
			System.out.println("5. 기타상품 등록");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");

			int slt = sc.nextInt();

			if (slt == 0) {
				return;
			} else if (0 < slt && slt < 6) {
				int kcal;
				int amount;
				int weight;
				String expired;
				System.out.print("등록할 상품명 : ");
				sc.nextLine();
				String name = sc.nextLine();

				System.out.print("등록할 상품의 가격 : ");
				int price = sc.nextInt();

				System.out.print("수량을 입력하세요 : ");
				int stock = sc.nextInt();

				System.out.println("성인만 구입이 가능합니까? [y/n]");
				char ch = sc.next().charAt(0);

				boolean adult = (ch == 'y' ? true : false);

				switch (slt) {
				case 1:
					System.out.println("음료를 등록합니다.");
					System.out.print("등록할 상품의 용량(ml) : ");
					amount = sc.nextInt();
					System.out.print("등록할 상품의 칼로리(kcal) : ");
					kcal = sc.nextInt();

					d[dIndex++] = new Drink(name, stock, price, adult, amount, kcal);

					break;

				case 2:
					System.out.print("등록할 상품의 유통기한 (yyyy-mm-dd) : ");
					expired = sc.next();

					System.out.print("등록할 상품의 칼로리(kcal) : ");
					kcal = sc.nextInt();

					iFood[iIndex++] = new InstantFood(name, stock, price, adult, expired, kcal);
					break;

				case 3: // Snack
					System.out.print("등록할 상품의 칼로리(kcal) : ");
					kcal = sc.nextInt();

					System.out.print("등록할 상품의 무게(g) : ");
					weight = sc.nextInt();

					s[sIndex++] = new Snack(name, stock, price, adult, kcal, weight);

					break;

				case 4: // Medicine

					System.out.print("등록할 상품의 유통기한 (yyyy-mm-dd) : ");
					expired = sc.next();

					m[mIndex++] = new Medicine(name, stock, price, adult, expired);

					break;

				case 5: // etc

					etc[eIndex++] = new Items(name, stock, price, adult);

					break;

				}

			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

			System.out.println("상품을 성공적으로 등록했습니다.");

		} // insertItem while문 종료지점

	}

	public void printDrink() { // 음료 현황 출력
		System.out.println("===== 음료 =====");
		System.out.println("no.\t제품명\t\t재고\t가격\t성인여부\t칼로리\t용량");

		for (int i = 0; i < dIndex; i++) {
			System.out.println((i + 1) + "\t" + d[i].getName() + "\t\t" + d[i].getStock() + "\t" + d[i].getPrice()
					+ "\t" + (d[i].getAdult() ? "O" : "X") + "\t" + d[i].getKcal() + "\t" + d[i].getAmount());
		}
	}

	public void printIFood() {
		System.out.println("===== 즉석 식품 =====");
		System.out.println("no.\t제품명\t\t재고\t가격\t성인여부\t칼로리\t유통기한");

		for (int i = 0; i < iIndex; i++) {
			System.out.println((i + 1) + "\t" + iFood[i].getName() + "\t" + iFood[i].getStock() + "\t"
					+ iFood[i].getPrice() + "\t" + (iFood[i].getAdult() ? "O" : "X") + "\t" + iFood[i].getKcal() + "\t"
					+ iFood[i].getExpired());
		}
	}

	public void printSnack() {
		System.out.println("===== 스낵류 =====");
		System.out.println("no.\t제품명\t\t재고\t가격\t성인여부\t칼로리\t무게");

		for (int i = 0; i < sIndex; i++) {
			System.out.println((i + 1) + "\t" + s[i].getName() + "\t\t" + s[i].getStock() + "\t" + s[i].getPrice()
					+ "\t" + (s[i].getAdult() ? "O" : "X") + "\t" + s[i].getKcal() + "\t" + s[i].getWeight());
		}
	}

	public void printMedi() {
		System.out.println("===== 의약품류 =====");
		System.out.println("no.\t제품명\t\t재고\t가격\t성인여부\t유통기한");

		for (int i = 0; i < mIndex; i++) {
			System.out.println((i + 1) + "\t" + m[i].getName() + "\t\t" + m[i].getStock() + "\t" + m[i].getPrice()
					+ "\t" + (m[i].getAdult() ? "O" : "X") + "\t" + m[i].getExpired());
		}
	}

	public void printEtc() {
		System.out.println("===== 기타 상품 =====");
		System.out.println("no.\t제품명\t\t재고\t가격\t성인여부");

		for (int i = 0; i < eIndex; i++) {
			System.out.println((i + 1) + "\t" + etc[i].getName() + "\t\t" + etc[i].getStock() + "\t" + etc[i].getPrice()
					+ "\t" + (etc[i].getAdult() ? "O" : "X"));
		}
	}

	public void updateItem() {
		while (true) {
			System.out.println("====== 재고 변경 ======");
			System.out.println("1. 음료");
			System.out.println("2. 즉석식품");
			System.out.println("3. 스낵류");
			System.out.println("4. 의약품");
			System.out.println("5. 기타상품");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printDrink();
				updateItem(d);
				break;

			case 2:
				printIFood();
				updateItem(iFood);
				break;

			case 3:
				printSnack();
				updateItem(s);
				break;

			case 4:
				printMedi();
				updateItem(m);
				break;

			case 5:
				printEtc();
				updateItem(s);
				break;

			case 0:
				System.out.println("이전 메뉴로 이동합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");

			}

		}

	}

	public void updateItem(Items[] item) {
		System.out.print("재고를 변경할 상품의 no.를 선택해주세요 > ");
		int slt = sc.nextInt() - 1;

		System.out.println("[" + item[slt].getName() + "] 선택하셨습니다.");

		System.out.println("현재 재고 : " + item[slt].getStock());
		System.out.print("변경 재고 : ");
		int input = sc.nextInt();

		item[slt].setStock(input);

		System.out.println("[" + item[slt].getName() + "] 의 재고를 [" + item[slt].getStock() + "] 으로 변경합니다");

	}

	public void delItem() {
		while (true) {
			System.out.println("===== 제품 삭제 =====");
			System.out.println("1. 음료");
			System.out.println("2. 즉석식품");
			System.out.println("3. 과자");
			System.out.println("4. 의약품");
			System.out.println("5. 기타");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printDrink();
				dIndex = delItem(d, dIndex);
				break;

			case 2:
				printIFood();
				iIndex = delItem(iFood, iIndex);
				break;

			case 3:
				printSnack();
				sIndex = delItem(s, sIndex);
				break;

			case 4:
				printMedi();
				mIndex = delItem(m, mIndex);
				break;

			case 5:
				printEtc();
				eIndex = delItem(etc, eIndex);
				break;

			case 0:
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");

			}

		}

	}

	public int delItem(Items[] item, int index) {
		System.out.print("삭제할 제품의 no.를 입력하세요 > ");
		int slt = sc.nextInt() - 1;

		System.out.println("[" + item[slt].getName() + "] 선택하셨습니다.");
		System.out.print("정말 삭제하시겠습니까? [y/n] : ");
		char ch = sc.next().charAt(0);

		switch (ch) {
		case 'y':
			for (int i = slt; i < index - 1; i++) {
				item[i] = item[i + 1];
			}
			System.out.println("제품을 삭제했습니다.");
			return --index;

		case 'n':
			System.out.println("삭제 메뉴로 돌아갑니다.");
			break;

		default:
			System.out.println("잘못 입력하셨습니다.");
		}

		return index;
	}

	public void client() {
		System.out.println("어서오세요 호갱님");

		while (true) {
			System.out.println("1. 쇼핑하기");
			System.out.println("2. 장바구니 보기");
			System.out.println("0. 뒤로가기");
			System.out.println("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				shopping();
				break;

			case 2:
				showCart();
				break;

			case 0:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}


	public void shopping() {

		while (true) {
			System.out.println("====== 쇼핑하기 ======");
			System.out.println("1. 음료");
			System.out.println("2. 즉석식품");
			System.out.println("3. 과자");
			System.out.println("4. 의약품");
			System.out.println("5. 기타 상품");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printDrink();
				buy(d);
				break;

			case 2: // 즉석식품
				printIFood();
				buy(iFood);
				break;

			case 3: // 과자
				printSnack();
				buy(s);
				break;

			case 4: // 의약품
				printMedi();
				buy(m);
				break;

			case 5: // 기타
				printEtc();
				buy(etc);
				break;

			case 0:
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		}

	}

	public void buy(Items[] item) {
		System.out.print("구매할 제품 번호 입력 : ");
		int index = sc.nextInt() - 1;

		System.out.print("구매할 수량 입력 :");
		int amount = sc.nextInt();

		if (item[index].getStock() < amount) {
			System.out.println("재고가 부족합니다.");
			System.out.println("이전으로 돌아갑니다.");
			return;
		}

		System.out.println("[" + item[index].getName() + "] 제품 " + amount + "개를 선택하셨습니다.");
		System.out.print("장바구니에 담으시겠습니까? [y/n] : ");
		char ans = sc.next().charAt(0);

		switch (ans) {
		case 'y':
			String name = item[index].getName();
			int price = item[index].getPrice();
			int stock = amount;
			boolean adult = item[index].getAdult();
			
			cart[cIndex++] = new Items(name, stock, price, adult);
			
			item[index].setStock(item[index].getStock()-amount);
			
			break;

		case 'n':
			System.out.println("구매를 취소하겠습니다.");
			return;

		default:
			System.out.println("잘못 입력하셨습니다.");

		}

	}

	private void showCart() {
		
		int totalPrice = 0;
		
		System.out.println("======= 현재 장바구니 ========");
		System.out.println("제품명\t가격\t수량");
		for(int i=0; i<cIndex; i++) {
			System.out.println(cart[i].getName()+"\t"+cart[i].getPrice()+"\t"+cart[i].getStock());
			totalPrice += cart[i].getStock()*cart[i].getPrice();
		}
		System.out.println("총 구매가격 : " + totalPrice+"원 입니다");
	}

	
}
