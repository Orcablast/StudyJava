package zin.coding.test;

import java.util.ArrayList;
import java.util.TreeMap;

public class TreeMapForInteger extends TreeMap<Integer, ArrayList<File>> {
	
	@Override
	public Integer floorKey(Integer key) {
		if(super.floorKey(key) == null) {
			return -1;
		} else {
			return key;
		}
	}
}
