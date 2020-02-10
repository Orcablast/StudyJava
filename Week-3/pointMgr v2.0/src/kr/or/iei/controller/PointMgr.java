package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;

public class PointMgr {

	Scanner sc = new Scanner(System.in);

	Silver[] slv = new Silver[10];
	Gold[] gld = new Gold[10];
	Vip[] vip = new Vip[10];

	int sIndex; // Silver 등급 인덱스
	int gIndex; // Gold 등급 인덱스
	int vIndex; // Vip 등급 인덱스

	public void main() {

		while (true) {
			System.out.println("========= 포인트 관리 v2.0 =========");
			System.out.printf("Vip : %d \tGold : %d\tSilver : %d\n", vIndex, gIndex, sIndex);
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (1인)");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원 탈퇴");
			System.out.print("선택 > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1: // 회원가입
				System.out.println("회원가입을 진행합니다.");

				System.out.print("이       름    : ");
				String name = sc.next();

				if (findMbr(name) != -1) { // 회원중 같은 이름이 있으면 회원가입을 중단
					System.out.println("중복된 회원이 있습니다.");
					continue;
				}

				System.out.print("등       급    : ");
				String grade = sc.next().toLowerCase(); // 대소문자 입력 실수에 의한 보정

				System.out.print("보유 포인트 : ");
				int point = sc.nextInt();

				insertMbr(name, grade, point);

				break;

			case 2: // 회원정보 출력 (전체)

				printAll();
				break;

			case 3: // 회원정보 출력 (1인)

				printMbr();
				break;

			case 4: // 회원정보 수정
				modifyMbr();
				break;

			case 5: // 회원 탈퇴
				System.out.print("탈퇴할 회원 이름 : ");
				delMbr(findMbr(sc.next()));
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;

			}

		}
	} // main method 종료

	public void insertMbr(String name, String grade, int point) { // 회원가입 메소드

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
			System.out.println("잘못된 입력입니다.");
			return;
		}

	}

	public void printAll() { // 회원 정보 전체를 출력하는 메소드
		System.out.println("이름\t등급\t보유 포인트\t보너스 포인트");

		for (int i = 0; i < vIndex; i++) {
			System.out.println(vip[i].getName() + "\t" + vip[i].getGrade() + "\t" + vip[i].getPoint() + "\t\t"
					+ vip[i].getBonusP());
		}

		for (int i = 0; i < gIndex; i++) {
			System.out.println(gld[i].getName() + "\t" + gld[i].getGrade() + "\t" + gld[i].getPoint() + "\t\t"
					+ gld[i].getBonusP());
		}

		for (int i = 0; i < sIndex; i++) {
			System.out.println(slv[i].getName() + "\t" + slv[i].getGrade() + "\t" + slv[i].getPoint() + "\t\t"
					+ slv[i].getBonusP());
		}
	}

	public void printMbr() { // 이름을 통해 검색하여 해당 회원정보를 검색하는 메소드
		System.out.print("출력할 회원 이름 : ");
		String name = sc.next();

		int mbrIndex = findMbr(name);

		if (mbrIndex == -1) {
			System.out.println("회원이 없습니다.");
			return;

		} else if (mbrIndex - slv.length - gld.length >= 0) {
			mbrIndex -= (slv.length - gld.length);
			System.out.println("이       름       : " + vip[mbrIndex].getName());
			System.out.println("등       급       : " + vip[mbrIndex].getGrade());
			System.out.println("보유    포인트 : " + vip[mbrIndex].getPoint());
			System.out.println("보너스 포인트 : " + vip[mbrIndex].getBonusP());

		} else if (mbrIndex - slv.length >= 0) {
			mbrIndex -= slv.length;
			System.out.println("이       름       : " + gld[mbrIndex].getName());
			System.out.println("등       급       : " + gld[mbrIndex].getGrade());
			System.out.println("보유    포인트 : " + gld[mbrIndex].getPoint());
			System.out.println("보너스 포인트 : " + gld[mbrIndex].getBonusP());

		} else {
			System.out.println("이       름       : " + slv[mbrIndex].getName());
			System.out.println("등       급       : " + slv[mbrIndex].getGrade());
			System.out.println("보유    포인트 : " + slv[mbrIndex].getPoint());
			System.out.println("보너스 포인트 : " + slv[mbrIndex].getBonusP());

		}
	}

	public int findMbr(String name) { // 검색할 회원의 index를 return하는 메소드

		for (int i = 0; i < sIndex; i++) {
			if (slv[i].getName().equals(name)) {
				return i;
			}
		}

		for (int i = 0; i < gIndex; i++) {
			if (gld[i].getName().equals(name)) {
				return i + slv.length;
			}
		}

		for (int i = 0; i < vIndex; i++) {
			if (vip[i].getName().equals(name)) {
				return i + slv.length + gld.length;
			}
		}

		return -1;
	}

	public void modifyMbr() { // 회원 이름을 통해 회원정보를 수정하는 메소드
		System.out.print("수정할 회원 이름 : ");

		int mbrIndex = findMbr(sc.next());

		if (mbrIndex == -1) {
			System.out.println("회원이 없습니다.");
			return;
		}

		System.out.print("이       름    : ");
		String name = sc.next();
		System.out.print("등       급    : ");
		String grade = sc.next().toLowerCase();
		System.out.print("보유 포인트 : ");
		int point = sc.nextInt();

		if (mbrIndex - slv.length - gld.length >= 0) { // vip

			if (grade == "vip") {
				mbrIndex -= (slv.length + gld.length);
				vip[mbrIndex].setName(name);
				vip[mbrIndex].setPoint(point);
			} else {
				delMbr(mbrIndex);
				mbrIndex -= (slv.length - gld.length);
				insertMbr(name, grade, point);
			}

		} else if (mbrIndex - slv.length >= 0) {// gold

			if (grade == "gold") {
				mbrIndex -= slv.length;
				gld[mbrIndex].setName(name);
				gld[mbrIndex].setPoint(point);
			} else {
				delMbr(mbrIndex);
				mbrIndex -= slv.length;
				insertMbr(name, grade, point);
			}

		} else { // silver

			if (grade == "silver") {
				gld[mbrIndex].setName(name);
				gld[mbrIndex].setPoint(point);
			} else {
				delMbr(mbrIndex);
				insertMbr(name, grade, point);
			}

		}

		System.out.println("수정이 완료되었습니다.");
	}

	public void delMbr(int num) { // 회원 이름을 통해 회원정보를 삭제하는 메소드

		int mbrIndex = num;

		if (mbrIndex == -1) {
			System.out.println("회원이 없습니다.");
			return;

		} else if (mbrIndex - slv.length - gld.length >= 0) {
			mbrIndex -= (slv.length - gld.length);

			for (int i = mbrIndex; i < vIndex - 1; i++) {
				vip[i] = vip[i + 1];
			}

			vip[--vIndex] = null;
			;

		} else if (mbrIndex - slv.length >= 0) {
			mbrIndex -= slv.length;

			for (int i = mbrIndex; i < gIndex - 1; i++) {
				gld[i] = gld[i + 1];
			}

			gld[--gIndex] = null;

		} else {

			for (int i = mbrIndex; i < sIndex - 1; i++) {
				slv[i] = slv[i + 1];
			}

			slv[--sIndex] = null;
		}

		//
		// if (mbrIndex == -1) {
		// System.out.println("회원이 없습니다.");
		// } else {
		//
		// for (int i = mbrIndex; i < sIndex - 1; i++) {
		// slv[i].setName(slv[i + 1].getName());
		// slv[i].setGrade(slv[i + 1].getGrade());
		// slv[i].setPoint(slv[i + 1].getPoint());
		// }
		//
		// sIndex--;
		//
		// slv[sIndex].setName(null);
		// slv[sIndex].setGrade(null);
		// slv[sIndex].setPoint(0);
		//
		// }
	}

}
