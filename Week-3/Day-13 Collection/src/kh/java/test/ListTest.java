package kh.java.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListTest {
	public void exam01() {
		String[] arr = new String[3];

		arr[0] = "hi";
		arr[1] = "hello";
		arr[2] = "안녕하세요";

		System.out.println("배열 출력");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		ArrayList<String> al = new ArrayList<String>();
		al.add("HELLO");
		al.add("HI");
		al.add("안녕하세요");
		al.add("잘가요");
		
		System.out.println("ArrayList 출력");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.remove(1); // ArrayList의 삭제, 자동정렬 기능
		
		System.out.println("ArrayList 출력");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.add(1, "hi");
		System.out.println("ArrayList 출력");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.set(1, "hihihi - 수정");
		
		System.out.println("ArrayList 출력");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.clear();
		System.out.println("ArrayList 출력");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}
	
	public void exam02() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			al.add((int)(Math.random()*100)+1);
		}
		
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
		
		Collections.sort(al);
		
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
		
		Collections.reverse(al);
		
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
	}
}
