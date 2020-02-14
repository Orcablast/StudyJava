package kh.java.controll;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgr {

	Scanner sc = new Scanner(System.in);

	HashMap<String, Grade> mbrs = new HashMap<String, Grade>();

	public void main() {

		while (true) {
			System.out.println("========================== 회원관리 프로그램 v6.0 ==========================");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (1인)");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				insertMbr();
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
				delMbr();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void insertMbr() {
		System.out.println("=========== 회원 가입 ===========");
		System.out.print("이름 : ");
		String name = sc.next();

		if (mbrs.containsKey(name)) {
			System.out.println("중복된 회원이 있습니다.");
		} else {

			System.out.print("등급 : ");
			String grade = sc.next().toLowerCase();
			System.out.print("포인트 : ");
			int point = sc.nextInt();

			switch (grade) {
			case "silver":
				mbrs.put(name, new Silver(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "님의 회원가입이 완료되었습니다.");
				break;

			case "gold":
				mbrs.put(name, new Gold(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "님의 회원가입이 완료되었습니다.");
				break;

			case "vip":
				mbrs.put(name, new Vip(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "님의 회원가입이 완료되었습니다.");
				break;

			case "vvip":

				mbrs.put(name, new Vvip(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "님의 회원가입이 완료되었습니다.");
				break;

			default:
				System.out.println("잘못된 입력입니다.");
				return;
			}

		}
	}

	public void printMbr() {

		System.out.println("=========== 회원 정보 출력 ===========");
		System.out.print("검색할 이름 : ");
		String fName = sc.next();

		if (mbrs.containsKey(fName)) {
			System.out.println("등급\t이름\t포인트\t보너스 포인트");
			System.out.println(mbrs.get(fName).toString());
		} else {
			System.out.println("회원이 없습니다.");
		}

	}

	public void printAll() {
		System.out.println("=========== 회원 정보 출력 ===========");
		System.out.println("등급\t이름\t포인트\t보너스 포인트");

		Set<String> keys = mbrs.keySet();

		for (String s : keys) {
			System.out.println(mbrs.get(s).toString());
		}

	}

	public void modMbr() {
		System.out.println("=========== 회원 정보 수정 ===========");
		System.out.print("수정할 이름 : ");
		String mName = sc.next();

		if (mbrs.containsKey(mName)) {
			System.out.println(mName + "님의 정보 수정을 진행합니다.");
			System.out.print("수정할 이름 : ");
			String name = sc.next();

			System.out.print("수정할 등급 : ");
			String grade = sc.next().toLowerCase();

			System.out.print("수정할 포인트 : ");
			int point = sc.nextInt();

			mbrs.remove(mName);

			switch (grade) {
			case "silver":
				mbrs.put(name, new Silver(grade, name, point));
				break;

			case "gold":
				mbrs.put(name, new Gold(grade, name, point));
				break;

			case "vip":
				mbrs.put(name, new Vip(grade, name, point));
				break;

			case "vvip":

				mbrs.put(name, new Vvip(grade, name, point));
				break;

			default:
				System.out.println("잘못된 입력입니다.");
				return;
			}

		} else {
			System.out.println("회원이 없습니다.");
		}

	}
	
	public void delMbr() {
		System.out.println("=========== 회원 정보 삭제 ===========");
		System.out.print("삭제할 이름 : ");
		String dName = sc.next();
		
		if(mbrs.containsKey(dName)) {
			mbrs.remove(dName);
			System.out.println(dName+"님의 회원정보가 삭제되었습니다.");
		} else {
			System.out.println("회원이 없습니다.");
		}
		
		
	}
}
