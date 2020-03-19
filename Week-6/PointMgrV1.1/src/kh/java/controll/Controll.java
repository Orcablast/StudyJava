package kh.java.controll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import kh.java.view.View;
import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class Controll {

	View view = new View();

	ArrayList<Grade> mbrs = new ArrayList<Grade>();

	public Controll() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("memberDB.txt"));

			StringTokenizer sT;

			String detail;

			String name, grade;

			int point;

			while (true) {

				detail = br.readLine();

				if (detail == null) {
					break;

				} else {
					sT = new StringTokenizer(detail, "/");

					name = sT.nextToken();

					grade = sT.nextToken();

					point = Integer.parseInt(sT.nextToken());

					switchGrade(name, grade, point, mbrs.size());
				}
			}
			
			System.out.println("회원 정보 로딩이 완료되었습니다.");
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void main() {

		while (true) {

			switch (view.viewMain()) {
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
				deleteMbr();
				break;

			case 0:
				saveMbrs();
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;

			}
		}
	}

	public void saveMbrs() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("memberDB.txt"));
			
			for(Grade g : mbrs) {
				bw.write(g.getName()+"/"+g.getGrade()+"/"+g.getPoint());
				
			}
			
			System.out.println("회원 정보 저장이 완료되었습니다.");
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertMbr() {
		String name = view.inputInfo("이  름 : ");

		if (searchIndex(name) != -1) {
			System.out.println("중복되는 회원이 있습니다.");
			System.out.println("이전 메뉴로 돌아갑니다.");
			return;
		} else {
			String grade = view.inputInfo("등  급 : ").toLowerCase();
			int point = Integer.parseInt(view.inputInfo("포인트 : "));

			switchGrade(name, grade, point, mbrs.size());

			System.out.println(name + "님의 회원등록이 완료되었습니다");

		}
	}

	public void switchGrade(String name, String grade, int point, int index) {

		switch (grade) {

		case "silver":
			mbrs.add(index, new Silver(name, grade, point));
			break;

		case "gold":
			mbrs.add(index, new Gold(name, grade, point));
			break;

		case "vip":
			mbrs.add(index, new Vip(name, grade, point));
			break;

		case "vvip":
			mbrs.add(index, new Vvip(name, grade, point));
			break;

		default:
			System.out.println("잘못된 등급입니다.");
			System.out.println("처음 화면으로 돌아갑니다.");
			return;
		}
	}

	public void printAll() {
		System.out.println("\n등급\t이름\t보유포인트\t\t보너스포인트");

		for (Grade g : mbrs) {
			System.out.println(g);
		}
	}

	public int searchIndex(String name) {

		for (int i = 0; i < mbrs.size(); i++) {
			if (mbrs.get(i).getName().equals(name)) {
				return i;
			}
		}

		return -1;
	}

	public void printMbr() {
		System.out.println("\n------- 회원 검색 ------");

		int index = searchIndex(view.inputInfo("검색할 회원명 : "));

		System.out.println("\n등급\t이름\t보유포인트\t\t보너스포인트");
		System.out.println(mbrs.get(index));
	}

	public void modMbr() {
		System.out.println("\n------- 회원정보 수정 ------");

		int index = searchIndex(view.inputInfo("수정할 회원명 : "));

		if (index == -1) {
			System.out.println("수정할 회원이 없습니다.");
			return;

		} else {
			String name = view.inputInfo("수정할 이름 : ");
			String grade = view.inputInfo("수정할 등급 : ");
			int point = Integer.parseInt(view.inputInfo("수정할 포인트 : "));

			if (mbrs.get(index).getGrade().equals(grade)) {
				mbrs.get(index).setName(name);
				mbrs.get(index).setPoint(point);

			} else {
				mbrs.remove(index);
				switchGrade(name, grade, point, index);
			}

		}

	}

	public void deleteMbr() {
		System.out.println("\n------- 회원 삭제 ------");

		String name = view.inputInfo("삭제할 회원명 : ");

		int index = searchIndex(name);

		if (index == -1) {
			System.out.println("찾으시는 회원이 없습니다.");
			System.out.println("이전 메뉴로 돌아갑니다.");
		} else {

			char answer = view.inputInfo("[" + name + "] 회원을 정말 삭제하시겠습니까? [y/n] : ").charAt(0);

			switch (answer) {
			case 'y':
				mbrs.remove(index);
				System.out.println("[" + name + "] 님이 삭제되었습니다.");
				break;

			case 'n':
				System.out.println("삭제를 취소합니다.");
				break;

			}
		}
	}
}
