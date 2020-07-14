package zin.coding.test;

import java.util.ArrayList;
import java.util.TreeMap;

public class TreeMapForInteger extends TreeMap<Integer, ArrayList<File>> {

	
	// 일치하는 key가 없을 경우 null 대신 -1을 반환
	@Override
	public Integer floorKey(Integer key) {
		
		Object obj = super.floorKey(key); 
		if(obj == null) {
			return -1;
		} else {
			return (Integer)obj;
		}
	}
}
