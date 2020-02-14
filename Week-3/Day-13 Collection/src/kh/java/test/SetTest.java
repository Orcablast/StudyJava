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
		System.out.println("========== Iterator ��� ==========");
		Iterator iter = data.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("========== for each ��� ==========");
		for (int num : data) {
			System.out.println(num);
		}

		System.out.println("========== ArrayList ��� ==========");
		ArrayList<Integer> al = new ArrayList<Integer>(data);

		for (int num : al) {
			System.out.println(num);
		}
	}
	
	
	public void lotto() {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		
		while(lotto.size()<6) {
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int num = sc.nextInt();
			if(!lotto.add(num)) {
				System.out.println("���ڰ� �ߺ��˴ϴ�.");
			}
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>(lotto);
		
		Collections.sort(al);
		
		
	}
}
