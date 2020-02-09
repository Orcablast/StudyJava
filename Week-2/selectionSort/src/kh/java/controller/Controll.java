package kh.java.controller;

import java.util.Scanner;
import java.util.Random;
import kh.java.vo.Data;

public class Controll {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	Data[] arr = new Data[10];

	public void main() {

		while (true) {
			

			System.out.println("객체 배열을 생성합니다");

			createArr();

			System.out.println("객체 배열을 출력합니다");

			showArrAll();

			System.out.println("어떤 정렬을 하시겠습니까?");
			int inputNum = sc.nextInt();

			switch (inputNum) {
			case 1: // 선택 정렬
				selecSort();
				
				System.out.println("객체 배열을 출력합니다");

				showArrAll();
				break;

			case 2:
				break;

			case 3:
				break;

			default:
				System.out.println("잘못 입력하셨습니다");
				continue;

			}

			break;
		}

	}

	public void createArr() {				
		
		for (int i = 0; i < arr.length; i++) { // Data 객체를 10번 생성하여 arr[i]번째에 저장
			Data dt = new Data(rn.nextInt(10) + 1);
			for(int j=0; j<i; j++) { // 중복일시 난수 재입력
				if(dt.getData()==arr[j].getData()) {
					dt.setData(rn.nextInt(10)+1);
					j=-1;
				}				
			}
			arr[i] = dt;
		}

	}

	public void showArrAll() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].getData() + " ");
		}
		System.out.println();
	}
	
	public void selecSort() {

		for(int j=0; j<10; j++) {
			int index=j;
			int temp;
			for(int i=j; i<10; i++) {
				if (arr[i].getData()<arr[index].getData()) {
					index=i;
				}
				
				if(i==9) {
					temp = arr[j].getData();
					arr[j].setData(arr[index].getData());
					arr[index].setData(temp);
				}				
			}
			System.out.println((j+1)+"번째 정렬");
			
			showArrAll();
			
		}
		
		
		
	}
	
}
