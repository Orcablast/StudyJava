package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;

public class PointMgr {

	Scanner sc = new Scanner(System.in); // Scanner 약어 sc로 정의

	Silver[] slv = new Silver[30]; // Silver 객체배열 약어 slv
	Gold[] gld = new Gold[30]; // Gold 객체배열 약어 gld
	Vip[] vip = new Vip[30]; // Vip 객체배열 약어 vip

	int sIndex, gIndex, vIndex;
	int grd; // 검색하는 회원의 등급을 판별하는 변수 1.silver 2.gold 3.vip, default:0

	public void main() {

		while (true) {
			grd = 0;

			System.out.println("=================== 회원관리 프로그램 v3.0 ===================");
			System.out.printf("Silver : %d\tGold : %d\tVip:%d\t\n", sIndex, gIndex, vIndex);
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (1인)");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원탈퇴");
			System.out.print("선택 > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1:

				System.out.println("회원 가입을 진행합니다.");
				System.out.print("이   름 : ");
				String name = sc.next();

				if (findMbr(name) != -1) {
					System.out.println("중복되는 회원이 있습니다.");
					continue;
				}

				System.out.print("등   급 : ");
				String grade = sc.next().toLowerCase();

				System.out.print("포인트 : ");
				int point = sc.nextInt();

				insertMbr(name, grade, point);

				break;

			case 2:

				printAll();
				break;

			case 3:
				printMbr();
				break;

			case 4:
				modMbr();
				break;

			case 5:
				System.out.print("탈퇴할 회원의 이름 :");
				delMbr(sc.next());
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		} // 메인 메뉴 while문 종료지점
	}

	public void insertMbr(String name, String grade, int point) {

		switch (grade) {
		case "silver":
			slv[sIndex++] = new Silver(name, grade, point);
			break;

		case "gold":
			gld[gIndex++] = new Gold(name, grade, point);
			break;

		case "vip":
			vip[vIndex++] = new Vip(name, grade, point);
			break;

		default:
			System.out.println("등급을 잘못 입력하셨습니다.");
			return;
		}
	}

	public void printAll() {
		System.out.printf("이름\t등급\t보유 포인트\t보너스 포인트\n");
		for (int i = 0; i < sIndex; i++) {
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", slv[i].getName(), slv[i].getGrade(), slv[i].getPoint(),
					slv[i].getBonus());
		}
		for (int i = 0; i < gIndex; i++) {
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", gld[i].getName(), gld[i].getGrade(), gld[i].getPoint(),
					gld[i].getBonus());
		}
		for (int i = 0; i < vIndex; i++) {
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", vip[i].getName(), vip[i].getGrade(), vip[i].getPoint(),
					vip[i].getBonus());
		}
	}

	public void printMbr() {
		System.out.print("출력할 회원의 이름 : ");
		String name = sc.next();

		int indexMbr = findMbr(name);

		// if (indexMbr == -1) {
		// System.out.println("회원이 없습니다.");
		// return;
		// }

		System.out.printf("이름\t등급\t보유 포인트\t보너스 포인트\n");
		switch (grd) {
		case 1: // silver 등급일 경우
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", slv[indexMbr].getName(), slv[indexMbr].getGrade(),
					slv[indexMbr].getPoint(), slv[indexMbr].getBonus());
			break;

		case 2:
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", gld[indexMbr].getName(), gld[indexMbr].getGrade(),
					gld[indexMbr].getPoint(), gld[indexMbr].getBonus());
			break;

		case 3:
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", vip[indexMbr].getName(), vip[indexMbr].getGrade(),
					vip[indexMbr].getPoint(), vip[indexMbr].getBonus());
			break;

		default:
			System.out.println("회원이 없습니다.");
		}

	}

	public int findMbr(String name) { // 특정 이름을 매개변수로 검색

		for (int i = 0; i < sIndex; i++) { // silver 검색
			if (slv[i].getName().equals(name)) {
				grd = 1;
				return i;
			}
		}

		for (int i = 0; i < gIndex; i++) { // gold 검색
			if (gld[i].getName().equals(name)) {
				grd = 2;
				return i;
			}
		}

		for (int i = 0; i < vIndex; i++) { // vip 검색
			if (vip[i].getName().equals(name)) {
				grd = 3;
				return i;
			}
		}

		return -1;
	}

	public void modMbr() {
		System.out.print("수정할 회원의 이름 : ");
		String mName = sc.next();
		
		int indexMbr = findMbr(mName);		
		if (indexMbr ==-1) {
			System.out.println("회원이 없습니다.");
		}		

		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("등급 : ");
		String grade = sc.next().toLowerCase();
		
		System.out.print("포인트 : ");
		int point = sc.nextInt();
		
		
		

		switch (grd) {
		case 1:
			if(grade=="silver") {
				slv[indexMbr].setName(name);
				slv[indexMbr].setPoint(point);
			} else {
				delMbr(name);
				insertMbr(name,grade,point);
			}			
			break;

		case 2:
			if(grade=="gold") {
				gld[indexMbr].setName(name);
				gld[indexMbr].setPoint(point);
			} else {
				delMbr(name);
				insertMbr(name,grade,point);
			}
			break;

		case 3:
			if(grade=="vip") {
				vip[indexMbr].setName(name);
				vip[indexMbr].setPoint(point);
			} else {
				delMbr(name);
				insertMbr(name,grade,point);
			}
			break;

		default:
			System.out.println("회원이 없습니다.");
		}

	}

	public void delMbr(String name) {

		int indexMbr = findMbr(name);

		switch (grd) {
		case 1:
			for (int i = 0; i < sIndex - 1; i++) {
				slv[i] = slv[i + 1];
			}
			sIndex--;
			break;

		case 2:
			for (int i = 0; i < gIndex - 1; i++) {
				gld[i] = gld[i + 1];
			}
			gIndex--;
			break;

		case 3:
			for (int i = 0; i < vIndex - 1; i++) {
				vip[i] = vip[i + 1];
			}
			vIndex--;
			break;

		default:
			System.out.println("회원이 없습니다.");
		}
	}

}
