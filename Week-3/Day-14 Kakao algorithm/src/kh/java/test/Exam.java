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
			System.out.println("====== ����ð� ���� ���α׷� ======");
			System.out.print("cacheSize�� �����ּ��� [0~30] : ");
			cacheSize = sc.nextInt();

			if (cacheSize < 0 || cacheSize > 30) {
				System.out.println("������ �ʰ��ϴ� �Է��Դϴ�.");
				continue;
			}

			inputCity();
			
			calcTime();
			
			System.out.println("\n\n�ҿ�� �ð� : "+time);

			break;
		}
	}

	public void inputCity() { // ����ڿ��� ���� �̸��� �Է¹޴� �Լ�

		while (cities.size() <= 100000) {
			System.out.println("�Է��� �ߴ��Ϸ��� n�� �Է��ϼ���.");
			System.out.print("���� �̸��� �Է��ϼ��� : ");
			String city = sc.next().toLowerCase();

			if (city.length() == 1 && city.charAt(0) == 'n') {
				System.out.println("���� �Է��� �ߴ��մϴ�.\n\n");
				return;
			} else if (city.length() <= 20) {
				System.out.println(city + "�� �Է��߽��ϴ�.\n");
				cities.add(city);
				System.out.println("������� �Է��� ���� ���� : " + cities.size());
			} else {
				System.out.println("20�� �̳��� �Է����ּ���! \n");
			}
		}
	}

	public void calcTime() {

		int index = 0; // ������ �ԷµǾ��� ��ġ�� �����ϴ� ����

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
