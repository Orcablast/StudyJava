package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgrView {
	
	Scanner sc = new Scanner(System.in);
	
	public int main() {		
		while(true) {
			System.out.println("=================== ȸ������ ���α׷� v7.0 ===================");
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (1��)");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ��Ż��");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");
			
			int select = sc.nextInt();
			
			return select;
		}		
	}
	
	public Grade insertMbr() {
		
		while(true) {			
			System.out.println("------ ȸ�� ������ �����մϴ�. ------");
			System.out.print("��   �� : ");
			String name = sc.next();
									
			System.out.print("��   �� : ");
			String grade = sc.next().toLowerCase();
			
			System.out.print("����Ʈ : ");
			int point = sc.nextInt();
					
			
			Grade g = switchGradeOrNull(name, grade, point);
			
			if(g!=null) {
				return g;
			} else {
				continue;				
			}			
		}			
	}
	
	public void printAllMbr(ArrayList<Grade> mbrs) {
		System.out.println("���\t�̸�\t��������Ʈ\t���ʽ�����Ʈ");
		
		for(Grade g : mbrs) {
			System.out.println(g);
		}
	}
	
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public String getName(String msg) {
		System.out.print(msg+"�� ȸ�� �̸� : ");
		String name = sc.next();
		return name;
	}
	
	public Grade modifyMbr() {
		
		while(true) {
			System.out.print("������ �̸� : ");
			String name = sc.next();
			
			System.out.print("������ ��� : ");
			String grade = sc.next().toLowerCase();
			
			System.out.print("������ ����Ʈ : ");
			int point = sc.nextInt();					
			
			Grade g = switchGradeOrNull(name, grade, point);
			
			if(g!=null) {
				return g;
			} else {
				continue;
			}
		}		
	}
	
	
	public Grade switchGradeOrNull(String name, String grade, int point) {
		switch(grade) {
		
		case "silver" :
			return new Silver(name,grade,point);
			
		case "gold" : 
			return new Gold(name,grade,point);
			
		case "vip" :
			return new Vip(name,grade,point);			
			
		case "vvip":
			return new Vvip(name,grade,point);			
			
		default : 
			System.out.println("ȸ�� ����� �߸� �Է��ϼ̽��ϴ� : "+grade);
			return null;
		}		
	}
	
}
