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
			
			
			System.out.println("=========== 학생 관리 프로그램 v1.0 ===========");
			System.out.println("전체 학생 : "+index);
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 정보 조회(전체)");
			System.out.println("3. 학생 정보 조회 (1명)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int slt = sc.nextInt();
			
			
			switch (slt) {
			case 1:
				System.out.println("============== 학생 정보 입력 ==============");
				
				insertStd(index);
				
				System.out.println("학생 정보 등록 성공!");
				
				break;

			case 2:
				System.out.println("============== 학생 전체 정보 출력 ==============");
				System.out.printf("이름\t나이\t주소\n");
				printStdAll();				
				break;

			case 3:
				System.out.println("============== 학생 개인 정보 출력 ==============");
				stdNum = findStd("조회");
				
				if(chkNoStd(stdNum,"조회")) {
					printStd(stdNum);
				}
							
				break;

			case 4:
				System.out.println("============== 학생 개인 정보 수정 ==============");
				stdNum = findStd("수정");
				
				if(chkNoStd(stdNum,"수정")) {
					insertStd(stdNum);
					index--;
				}				
				
				break;

			case 5:
				System.out.println("============== 학생 개인 정보 삭제 ==============");
				stdNum = findStd("삭제");
				
				if(chkNoStd(stdNum,"삭제")) {
					dltStd(stdNum);
				}
				
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
	}
	
	public void insertStd(int num) {
		
		System.out.print("이름 입력 : ");
		nameStd[num] = sc.next();
		
		System.out.print("나이 입력 : ");
		ageStd[num] = sc.nextInt();
		
		sc.nextLine();
		System.out.print("주소 입력 : ");
		addrStd[num] = sc.nextLine();		
		
		index++;
	}
	
	public void printStdAll() {
		
		for(int i=0; i<index; i++) {
			System.out.println(nameStd[i]+"\t"+ageStd[i]+"\t"+addrStd[i]);
		}		
	}

	public void printStd(int i) {
		System.out.println("이름 : "+nameStd[i]);
		System.out.println("나이 : "+ageStd[i]);
		System.out.println("주소 : "+addrStd[i]);
	}
	
	public int findStd(String msg) {
		System.out.print(msg+"할 학생 이름 입력 : ");
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
			System.out.println(msg+"할 학생이 없습니다");
		} else {
			
			return true;
		}
		return false;
	}
	
	public void dltStd(int i) {

		System.out.println(nameStd[i]+"님이 삭제되었습니다.");
		
		for(; i<index-1; i++) {
			nameStd[i]=nameStd[i+1];
			ageStd[i]=ageStd[i+1];
			addrStd[i]=addrStd[i+1];
		}
		
		index--;		
	}

}
