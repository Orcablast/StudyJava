package kh.java.run;
import kh.java.collection.vo.StudentMgr;
import kh.java.collection.vo.StudentMgrMap;
import kh.java.test.ListTest;
import kh.java.test.MapTest;
import kh.java.test.SetTest;

public class Start {

	public static void main(String[] args) {
		ListTest lt = new ListTest();
		StudentMgr sm = new StudentMgr();
		SetTest st = new SetTest();
		MapTest mt = new MapTest();
		StudentMgrMap smm = new StudentMgrMap();
		smm.main();
	}

}
