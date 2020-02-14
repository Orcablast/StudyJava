package kh.java.controll;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgr {

	Scanner sc = new Scanner(System.in);

	ArrayList<Grade> mbrs = new ArrayList<Grade>();

	public void main() {

		while (true) {
			System.out.println("============ 회원관리 프로그램 v5.0 ============");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (개인)");
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
				return;

			default:
				System.out.println("잘못된 입력입니다.");
				continue;

			}
		}
	}

	public void insertMbr() {

		System.out.println("--------- 회원 가입 ---------");
		System.out.print("회원 이름 : ");
		String name = sc.next();

		if (searchIndex(name) != -1) {
			System.out.println("중복되는 회원이 있습니다.");
			return;
		}

		System.out.print("회원 등급 : ");
		String grade = sc.next().toLowerCase();

		System.out.print("회원 포인트 : ");
		int point = sc.nextInt();

		switch (grade) {
		case "silver":
			mbrs.add(new Silver(grade, name, point));
			break;

		case "gold":
			mbrs.add(new Gold(grade, name, point));
			break;

		case "vip":
			mbrs.add(new Vip(grade, name, point));
			break;

		case "vvip":
			mbrs.add(new Vvip(grade, name, point));
			break;

		default:
			System.out.println("잘못 입력하셨습니다.");
			return;
		}

	}

	public int searchIndex(String name) {

		for (int i = 0; i < mbrs.size(); i++) {
			if (mbrs.get(i).getName().equals(name)) {
				return i;
			}
		}

		// 중간에 빠져나와야하는 로직일 경우 for each는 비효율적
		// for each가 효율적인 경우 = 배열의 모든 객체를 무조건 확인할 경우
		// for(Grade g : mbrs) {
		// if(g.getName().equals(name)) {
		// return mbrs.indexOf(g);
		// }
		// }

		return -1;
	}

	public void printMbr() {

		System.out.println("--------- 회원 정보 출력 ---------");
		System.out.print("출력할 회원 이름 : ");
		String fName = sc.next();

		int index = searchIndex(fName);

		if (index == -1) {
			System.out.println("회원이 없습니다.");
			return;
		} else {
			System.out.println("회원등급\t이름\t포인트\t보너스 포인트");
			System.out.print(mbrs.get(index).toString());

		}

	}

	public void printAll() {
		System.out.println("회원등급\t이름\t포인트\t보너스 포인트");
		for (int i = 0; i < mbrs.size(); i++) {
			System.out.print(mbrs.get(i).toString());
		}
	}

	public void delMbr() {
		System.out.println("--------- 회원 정보 삭제 ---------");
		System.out.print("삭제할 회원의 이름을 입력하세요 : ");
		String name = sc.next();

		int index = searchIndex(name);

		if (index == -1) {
			System.out.println("회원이 없습니다.");
			return;
		} else {
			System.out.print(name + "님의 회원정보를 삭제하시겠습니까? [y/n] :");
			char ans = sc.next().charAt(0);

			if (ans == 'y') {
				mbrs.remove(index);
				System.out.println(name + "님의 회원정보가 삭제되었습니다.");
			} else {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
		}
	}

	public void modMbr() {
		System.out.println("--------- 회원 정보 수정 ---------");
		System.out.print("수정할 회원의 이름을 입력하세요 : ");

		String mName = sc.next();

		int index = searchIndex(mName);

		if (index == -1) {
			System.out.println("회원이 없습니다.");
			return;
			
		} else {
			System.out.println("수정할 정보를 입력해주세요!");
			System.out.print("현재 이름 : "+mbrs.get(index).getName()+"\t수정 : ");
			String name = sc.next();
			System.out.print("현재 등급 : "+mbrs.get(index).getGrade()+"\t수정 : ");
			String grade = sc.next().toLowerCase();
			System.out.print("현재 이름 : "+mbrs.get(index).getPoint()+"\t수정 : ");
			int point = sc.nextInt();
			
			mbrs.remove(index);

			switch (grade) {
			case "silver":				
				mbrs.add(index, new Silver(grade, name, point));
				break;

			case "gold":
				mbrs.add(index, new Gold(grade, name, point));
				break;

			case "vip":
				mbrs.add(index, new Vip(grade, name, point));
				break;

			case "vvip":
				mbrs.add(index, new Vvip(grade, name, point));
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
			}
			
			System.out.println("수정이 완료되었습니다.");
		}
	}

}
