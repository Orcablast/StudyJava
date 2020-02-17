package kh.java.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgrView {

	Scanner sc = new Scanner(System.in);

	public int main() {

		while (true) {
			System.out.println("========== 회원 관리 프로그램 v7.1 ==========");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (1인)");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");

			int slt = sc.nextInt();

			return slt;
		}
	}

	public Grade insertMbr() {

		while (true) {
			System.out.println("회원가입을 진행합니다.");
			System.out.print("이름 : ");
			String name = sc.next();

			System.out.print("등급 : ");
			String grade = sc.next();

			System.out.print("포인트 : ");
			int point = sc.nextInt();

			Grade g = switchGradeOrNull(name, grade, point);

			if (g == null) {
				System.out.println("등급을 잘못 입력하셨습니다.");
				continue;
			} else {
				return g;
			}
		}
	}

	public Grade switchGradeOrNull(String name, String grade, int point) {

		switch (grade) {
		case "silver":
			return new Silver(name, grade, point);

		case "gold":
			return new Gold(name, grade, point);

		case "vip":
			return new Vip(name, grade, point);

		case "vvip":
			return new Vvip(name, grade, point);

		default:
			return null;
		}
	}

	public void printAllMbr(HashMap<String, Grade> mbrs) {

		Set<String> keys = mbrs.keySet();

		System.out.println("등급\t이름\t포인트\t보너스 포인트");

		for (String key : keys) {
			System.out.println(mbrs.get(key));
			;
		}
	}

	public String getName(String msg) {
		System.out.print(msg + "할 이름을 입력하세요 : ");
		String name = sc.next();

		return name;
	}

	public Grade modifyMbr() {
		System.out.print("수정할 이름 : ");
		String name = sc.next();
		System.out.print("수정할 등급 : ");
		String grade = sc.next();
		System.out.print("수정할 포인트 : ");
		int point = sc.nextInt();		
		
		return switchGradeOrNull(name, grade, point);
	}
}
