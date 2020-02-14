package kh.java.test;

import java.util.HashMap;
import java.util.Set;

public class MapTest {
	
	public void test1() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("two", 3);
	
		
		
		System.out.println(map.get("one"));
		System.out.println(map.get("two"));
		System.out.println(map.get("four"));
		System.out.println(map);
		
//		map.remove("two"); ªË¡¶πÆ
		
		
		System.out.println(map.get("two"));
		
		System.out.println(map.containsKey("one"));
		System.out.println(map.containsKey("two"));
		
		Set<String> keys = map.keySet();
		
		for(String s : keys	) {
			System.out.println("key : "+s+"\tvalue : "+map.get(s));
		}
			
	}
}
