package kh.java.controller;

import java.util.Scanner;
import java.util.Random;
import kh.java.vo.Data;

public class Controll {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	Data[] arr;

	public void main() {
		
		Data[] arr = new Data[10];

		while (true) {
			

			System.out.println("객체 배열을 생성합니다");

			createArr();

			System.out.println("객체 배열을 출력합니다");

			showArrAll();

			System.out.println("어떤 정렬을 하시겠습니까?");
			System.out.println("1. 선택 정렬");
			System.out.println("2. 삽입 정렬");			
			int inputNum = sc.nextInt();

			switch (inputNum) {
			case 1: // 선택 정렬
				selecSort();
				
				System.out.println("객체 배열을 출력합니다");

				showArrAll();
				break;

			case 2: // 삽입 정렬
				insertSort();
				
				System.out.println("객체 배열을 출력합니다");
				
				showArrAll();				
				break;

			case 3: // 합병 정렬
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
			Data dt = new Data(rn.nextInt(50) + 1);
			for(int j=0; j<i; j++) { // 중복일시 난수 재입력
				if(dt.getData()==arr[j].getData()) {
					dt.setData(rn.nextInt(50)+1);
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
		for(int j=0; j<arr.length; j++) {
			int index=j;
			int temp;
			for(int i=j; i<arr.length; i++) {
				if (arr[i].getData()<arr[index].getData()) {
					index=i;
				} 
				
				if(i==arr.length-1) {
					temp = arr[j].getData();
					arr[j].setData(arr[index].getData());
					arr[index].setData(temp);
				}
			}
			System.out.println((j+1)+"번째 정렬");
			
			showArrAll();
			
		}		
	}
	
	public void insertSort() { // 삽입 정렬 메소드
		
		for(int i=0; i<arr.length; i++) {
			int index=i;
			int temp;
			
			for(int j=i; j<arr.length; j++) {
				if(arr[index].getData()>arr[j].getData()) {
					index=j;					
				}
			}			
			
			if(index!=i) {
				temp = arr[index].getData();
				for(int j=index; j>i; j--) {
					arr[j].setData(arr[j-1].getData());					
				}
				arr[i].setData(temp);
			}
			System.out.println((i+1)+"번째 정렬");
			
			showArrAll();
			
		}		
	}
	
	public void mergeSort() {
		
	}
	
}
