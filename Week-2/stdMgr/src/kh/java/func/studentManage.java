package kh.java.func;

import java.util.Scanner;

public class studentManage {

	int index;
	int stdNum;
	
	String nameStd[] = new String [5];
	int ageStd[] = new int [5];
	String addrStd[] = new String [5]; 
	
	Scanner sc = new Scanner(System.in);
	
	
	public void main() {				
		
		while (true) {
			
			
			System.out.println("=========== �л� ���� ���α׷� v1.0 ===========");
			System.out.println("��ü �л� : "+index);
			System.out.println("1. �л� ���");
			System.out.println("2. �л� ���� ��ȸ(��ü)");
			System.out.println("3. �л� ���� ��ȸ (1��)");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");
			int slt = sc.nextInt();
			
			
			switch (slt) {
			case 1:
				System.out.println("============== �л� ���� �Է� ==============");
				
				insertStd(index);
				
				System.out.println("�л� ���� ��� ����!");
				
				break;

			case 2:
				System.out.println("============== �л� ��ü ���� ��� ==============");
				System.out.printf("�̸�\t����\t�ּ�\n");
				printStdAll();				
				break;

			case 3:
				System.out.println("============== �л� ���� ���� ��� ==============");
				stdNum = findStd("��ȸ");
				
				if(chkNoStd(stdNum,"��ȸ")) {
					printStd(stdNum);
				}
							
				break;

			case 4:
				System.out.println("============== �л� ���� ���� ���� ==============");
				stdNum = findStd("����");
				
				if(chkNoStd(stdNum,"����")) {
					insertStd(stdNum);
					index--;
				}				
				
				break;

			case 5:
				System.out.println("============== �л� ���� ���� ���� ==============");
				stdNum = findStd("����");
				
				if(chkNoStd(stdNum,"����")) {
					dltStd(stdNum);
				}
				
				break;

			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			
		}
	}
	
	public void insertStd(int num) {
		
		System.out.print("�̸� �Է� : ");
		nameStd[num] = sc.next();
		
		System.out.print("���� �Է� : ");
		ageStd[num] = sc.nextInt();
		
		sc.nextLine();
		System.out.print("�ּ� �Է� : ");
		addrStd[num] = sc.nextLine();		
		
		index++;
	}
	
	public void printStdAll() {
		
		for(int i=0; i<index; i++) {
			System.out.println(nameStd[i]+"\t"+ageStd[i]+"\t"+addrStd[i]);
		}		
	}

	public void printStd(int i) {
		System.out.println("�̸� : "+nameStd[i]);
		System.out.println("���� : "+ageStd[i]);
		System.out.println("�ּ� : "+addrStd[i]);
	}
	
	public int findStd(String msg) {
		System.out.print(msg+"�� �л� �̸� �Է� : ");
		String name = sc.next();
		
		int chkIndex = -1;
		
		for(int i=0; i<index; i++) {		
			chkIndex++;
			
			if(nameStd[i].equals(name)) {
				break;
			}	
		}	
		
		return chkIndex;
	}
	
	public boolean chkNoStd(int i, String msg) {
		
		if (i==-1) {
			System.out.println(msg+"�� �л��� �����ϴ�");
		} else {
			
			return true;
		}
		return false;
	}
	
	public void dltStd(int i) {

		System.out.println(nameStd[i]+"���� �����Ǿ����ϴ�.");
		
		for(; i<index-1; i++) {
			nameStd[i]=nameStd[i+1];
			ageStd[i]=ageStd[i+1];
			addrStd[i]=addrStd[i+1];
		}
		
		index--;		
	}

}
