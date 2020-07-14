package zin.coding.test;

import java.util.ArrayList;
import java.util.TreeMap;

public class TreeMapForInteger extends TreeMap<Integer, ArrayList<File>> {

	
	// ��ġ�ϴ� key�� ���� ��� null ��� -1�� ��ȯ
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
