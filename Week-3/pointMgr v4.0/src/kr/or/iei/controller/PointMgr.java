package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Grade;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;
import kr.or.iei.point.Vvip;

public class PointMgr {

	Scanner sc = new Scanner(System.in); // Scanner 약어 sc로 정의

	Grade mbrs[] = new Grade[30]; // 3개 객체배열을 1개의 객체배열로 통일

	int index; // 3개 객체배열의 index를 1개 변수로 통일

	public void main() { // main 실행 메소드

		while (true) { // 메뉴를 반복실행 시키기 위한 무한루프

			System.out.println("=================== 회원관리 프로그램 v4.0 ===================");
			System.out.printf("총 회원수 : %d\n", index); // 각 인덱스의 버그 유무를 확인하기 위한 출력문
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (1인)");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원탈퇴");
			System.out.print("선택 > ");

			int slt = sc.nextInt(); // 메뉴를 선택할 정수를 입력받아 변수 slt로 선언

			switch (slt) { // 사용자가 입력한 변수 slt의 값을 통한 switch 구문
			case 1: // 회원가입 시퀀스, slt의 입력값이 1일 때

				System.out.println("회원 가입을 진행합니다.");
				System.out.print("이   름 : ");
				String name = sc.next().toLowerCase(); // 사용자가 입력한 문자열을 변수 name으로 선언

				if (findMbr(name) != -1) { // findMbr 메소드를 사용자가 입력한 name을 매개변수로 실행하여 중복되는 회원이 있는지 확인
					System.out.println("중복되는 회원이 있습니다.");
					break; // 중복을 알리는 출력문을 실행하고 메뉴선택 루프로 회귀
				} // findMbr(name)의 값이 -1이면 if문을 빠져나와 시퀀스 진행

				System.out.print("등   급 : ");
				String grade = sc.next().toLowerCase(); // 사용자가 입력한 문자열을 변수 grade로 선언, 소문자로 저장

				System.out.print("포인트 : "); // 사용자가 입력한 정수를 변수 point로 선언
				int point = sc.nextInt();

				insertMbr(name, grade, point); // 회원가입을 진행하는 메소드. 상위에서 입력한 매개변수 name, grade, point를 대입
				break; // 회원가입 시퀀스가 끝나면 switch 구문을 빠져나와 메뉴선택 루프로 회귀

			case 2: // 전체 회원정보를 출력하는 시퀀스, slt의 입력값이 2일때

				printAll(); // 전체 회원정보를 출력하는 메소드
				break; // 시퀀스가 끝나면 switch문을 빠져나와 메뉴선택 루프로 회귀

			case 3: // 이름을 입력받아 일치하는 1명의 회원정보를 출력하는 시퀀스
				printMbr(); // 회원 1명의 정보를 출력하는 메소드
				break; // 시퀀스가 끝나면 switch문을 빠져나와 메뉴선택 루프로 회귀

			case 4: // 이름을 입력받아 일치하는 1명의 회원정보를 수정하는 시퀀스, 사실상 수정 or 삭제+추가
				modMbr(); // 회원의 개인정보를 수정하는 메소드
				break; // 시퀀스가 끝나면 switch문을 빠져나와 메뉴선택 루프로 회귀

			case 5: // 이름을 입력받아 일치하는 1명의 회원정보를 삭제하고 객체배열을 재배열하는 시퀀스
				System.out.print("탈퇴할 회원의 이름 :"); // 탈퇴할 회원의 이름을 묻는 출력문
				delMbr(sc.next()); // 사용자가 입력한 문자열을 매개변수로 회원탈퇴 메소드를 실행
				break; // 시퀀스가 끝나면 switch문을 빠져나와 메뉴선택 루프로 회귀

			default: // 사용자가 1~5 이외의 값을 입력했을때
				System.out.println("잘못 입력하셨습니다."); // 잘못 입력함을 알리는 출력문
				continue; // 메뉴선택 루프로 회귀 (없어도됨)
			}
		} // 메인 메뉴 while문 종료지점
	}

	public void insertMbr(String name, String grade, int point) { // 문자열과 정수를 매개변수로 삼아 객체를 생성하여 해당 객체배열에 추가하는 메소드

		switch (grade) { // 사용자가 입력한 문자열 grade를 기준으로 하는 switch 구문
		case "silver": // 사용자가 grade값에 silver를 입력했을 경우
			mbrs[index++] = new Silver(name, grade, point); // slv 객체배열의 sIndex번째에 각 매개변수를 토대로 새로운 객체를 생성하고 sIndex값을 1
													// 증가
			break; // switch 구문을 끝내고 메뉴선택 루프로 돌아감

		case "gold": // 사용자가 grade값에 gold를 입력했을 경우
			mbrs[index++] = new Gold(name, grade, point); // gld 객체배열의 gIndex번째에 각 매개변수를 토대로 새로운 객체를 생성하고 gIndex값을 1 증가
	
			break;

		case "vip": // 사용자가 grade값에 vip를 입력했을 경우
			mbrs[index++] = new Vip(name, grade, point); // vip 객체배열의 vIndex번째에 각 매개변수를 토대로 새로운 객체를 생성하고 vIndex값을 1증가
		
			break;
			
		case "vvip":
			mbrs[index++] = new Vvip(name, grade, point); // Vvip 객체배열의 vIndex번째에 각 매개변수를 토대로 새로운 객체를 생성하고 vIndex값을 1증가
		
			break;			

		default: // 사용자가 grade값에 silver, gold, vip 이외의 값을 입력했을 경우, 객체를 생성하고 않고 메뉴선택 루프로 복귀
			System.out.println("등급을 잘못 입력하셨습니다.");
			return;
		}
	}

	public void printAll() { // 전체 회원정보를 출력하는 메소드
		System.out.printf("이름\t등급\t보유 포인트\t보너스 포인트\n"); // 객체의 각 변수 항목을 지시하는 출력문
		for (int i = 0; i < index; i++) { // i값은 0에서 시작하여 sIndex값보다 작을때까지 실행문을 반복 후 i값을 1씩 증가
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", mbrs[i].getName(), mbrs[i].getGrade(), mbrs[i].getPoint(),
					mbrs[i].getBonus());
		}
	}

	public void printMbr() { // 사용자가 입력한 문자열과 일치하는 회원을 찾아 회원정보를 출력하는 메소드
		System.out.print("출력할 회원의 이름 : ");
		String name = sc.next(); // 사용자가 입력한 값을 문자열 변수 name으로 선언

		int indexMbr = findMbr(name); // 문자열 변수 name을 매개로 findMbr 메소드를 실행, 결과값을 정수형 변수 indexMbr로 선언

		if (indexMbr == -1) {
			System.out.println("회원이 없습니다.");
			return;
		}

		System.out.printf("이름\t등급\t보유 포인트\t보너스 포인트\n");
		System.out.printf("%s\t%s\t%d\t\t%.2f\n", mbrs[indexMbr].getName(), mbrs[indexMbr].getGrade(),
				mbrs[indexMbr].getPoint(), mbrs[indexMbr].getBonus());

	}

	public int findMbr(String name) { // 매개변수 name을 기준으로 일치하는 회원의 index값을 return하는 메소드

		for (int i = 0; i < index; i++) { // i값은 0으로 시작하여 index보다 작을때까지 반복 후 i값은 1증가
			if (mbrs[i].getName().equals(name)) { // mbrs 객체배열의 i번째 name값이 매개변수 name과 같는지 비교
				return i; // return하는 i값은 해당 객체배열에 매개변수 name과 동일한 회원이 몇번째에 있는지 지시한다
			}
		}

		// 상위 for문에서는 return되지 않았다면 어느 객체배열에도 해당 매개변수와 동일한 name값이 존재하지 않으므로
		// 입력한 name과 동일한 회원은 없음을 의미
		return -1; // 회원이 없음을 지시하는 return값
	}

	public void modMbr() { // 회원의 정보를 수정하는 메소드
		System.out.print("수정할 회원의 이름 : ");
		String mName = sc.next(); // 사용자가 입력한 문자열을 변수 mName으로 선언

		int indexMbr = findMbr(mName); // mName을 매개변수로 하여 findMbr을 실행하고 결과값을 indexMbr으로 선언
		if (indexMbr == -1) { // 입력한 문자열과 동일한 회원이 없을 경우 즉시 메소드를 종료
			System.out.println("회원이 없습니다.");
			return;
		}

		System.out.print("이름 : ");
		String name = sc.next(); // 사용자가 입력한 문자열을 변수 name으로 선언 -> 수정할 이름

		System.out.print("등급 : ");
		String grade = sc.next().toLowerCase(); // 사용자가 입력한 문자열을 grade로 선언 -> 수정할 등급

		System.out.print("포인트 : ");
		int point = sc.nextInt(); // 사용자가 입력한 정수를 point로 선언 -> 수정할 포인트

		if (mbrs[indexMbr].getGrade().equals(grade)) { // 회원이 수정할 grade와 기존 grade가 같을 경우
			mbrs[indexMbr].setName(name); // mbrs 객체배열의 indexMbr번째 객체의 name값을 매개변수 name으로 선언
			mbrs[indexMbr].setPoint(point); // mbrs 객체배열의 indexMbr번째 객체의 point값을 매개변수 point로 선언
		} else { // 수정할 grade와 기존 grade가 다른 경우
			delMbr(mName);
			insertMbr(name, grade, point);
		}

	}

	// 문자열 name을 매개변수로 하여 회원정보를 삭제하는 메소드
	// findMbr을 통해 해당 객체가 어느 객체배열에 위치하는 확인하여
	// 객체배열을 한칸씩 앞당기고 마지막 객체를 null값으로 처리
	public void delMbr(String name) {

		int indexMbr = findMbr(name); // 매개변수 name으로 findMbr 메소드를 실행한 결과값을 정수형 변수 indexMbr로 선언

		if (indexMbr == -1) {
			System.out.println("회원이 없습니다.");
			return;
		}

		for (int i = indexMbr; i < index - 1; i++) { // i값은 0에서 시작하여 sIndex보다 작을때까지 반복실행 후 i값을 1 증가
			mbrs[i] = mbrs[i + 1]; // slv 객체배열의 i번째에 i+1번째 값을 대입 -> 한칸씩 당긴다는 개념
		}
		mbrs[index--] = null; // slv 객체배열의 sIndex에 해당하는 값을 null로 선언하고 sIndex값을 1 감소

	}
}
