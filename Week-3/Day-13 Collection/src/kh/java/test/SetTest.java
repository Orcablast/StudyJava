package kh.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {

	public void test1() {
		HashSet<Integer> data = new HashSet<Integer>();

		data.add(10);
		data.add(20);
		data.add(30);
		data.add(10);
		System.out.println("========== Iterator 출력 ==========");
		Iterator iter = data.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("========== for each 출력 ==========");
		for (int num : data) {
			System.out.println(num);
		}

		System.out.println("========== ArrayList 출력 ==========");
		ArrayList<Integer> al = new ArrayList<Integer>(data);

		for (int num : al) {
			System.out.println(num);
		}
	}
	
	
	public void lotto() {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		
		while(lotto.size()<6) {
			System.out.print("숫자를 입력하세요 : ");
			int num = sc.nextInt();
			if(!lotto.add(num)) {
				System.out.println("숫자가 중복됩니다.");
			}
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>(lotto);
		
		Collections.sort(al);
		
		
	}
}
