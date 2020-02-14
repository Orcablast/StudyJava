package kh.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Exam {
	Scanner sc = new Scanner(System.in);

	ArrayList<String> cities = new ArrayList<String>();

	int cacheSize;

	HashMap<String, Integer> cache = new HashMap<String, Integer>();
	
	int time;

	public void main() {

		time = 0;

		while (true) {
			System.out.println("====== 실행시간 측정 프로그램 ======");
			System.out.print("cacheSize를 정해주세요 [0~30] : ");
			cacheSize = sc.nextInt();

			if (cacheSize < 0 || cacheSize > 30) {
				System.out.println("범위를 초과하는 입력입니다.");
				continue;
			}

			inputCity();
			
			calcTime();
			
			System.out.println("\n\n소요된 시간 : "+time);

			break;
		}
	}

	public void inputCity() { // 사용자에게 도시 이름을 입력받는 함수

		while (cities.size() <= 100000) {
			System.out.println("입력을 중단하려면 n을 입력하세요.");
			System.out.print("도시 이름을 입력하세요 : ");
			String city = sc.next().toLowerCase();

			if (city.length() == 1 && city.charAt(0) == 'n') {
				System.out.println("도시 입력을 중단합니다.\n\n");
				return;
			} else if (city.length() <= 20) {
				System.out.println(city + "를 입력했습니다.\n");
				cities.add(city);
				System.out.println("현재까지 입력한 도시 갯수 : " + cities.size());
			} else {
				System.out.println("20자 이내로 입력해주세요! \n");
			}
		}
	}

	public void calcTime() {

		int index = 0; // 정보가 입력되야할 위치를 지시하는 변수

		for (String city : cities) {

			if (cache.containsKey(city)) {
				
				time++;
				dataGetOld();
				cache.put(city, cache.get(city)+1);
				
			} else if(cache.size()==cacheSize) {
				String oldKey = cacheReplace();
				cache.remove(oldKey);
				cache.put(city, 0);
				time += 5;
				
			} else if (cache.size()<cacheSize || cacheSize==0) {
				
				time += 5;
				dataGetOld();
				cache.put(city, 0);
			}		
		}
	}

	public void dataGetOld() {
		
		if(cache.isEmpty()) {
			return;
		}
		
		Set<String> keys = cache.keySet();
		
		for(String key : keys) {
			cache.put(key, (cache.get(key)-1));
		}		
	}
	
	public String cacheReplace() {
		String oldKey = "1";
		
		Set<String> keys = cache.keySet();
		
		for(String key : keys) {
			if(oldKey.equals("1")) {
				oldKey=key;
				
			} else if (cache.get(oldKey)>cache.get(key)){
				oldKey = key;
			}
		}
		
		return oldKey;		
	}	
}
