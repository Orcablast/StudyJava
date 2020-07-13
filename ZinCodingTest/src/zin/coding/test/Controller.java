package zin.coding.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Controller {

	// CD 객체를 보관할 List
	private ArrayList<CD> cdList;

	// 생성된 파일이 보관될 TreeMap
	// 같은 크기의 파일 객체들을 보관하기 위해 ArrayList 활용
	private TreeMapForInteger tree;

	// 사용자 입력을 받을 scanner
	private BufferedReader inputReader;

	// 기본 생성자
	public Controller() {
		// 인스턴스 생성
		this.cdList = new ArrayList<CD>();
		this.inputReader = new BufferedReader(new InputStreamReader(System.in));
		this.tree = new TreeMapForInteger();
	}

	public void setUp() throws IOException {
		System.out.println("생성할 파일의 갯수를 입력해주세요. (파일의 크기는 1~649 중 난수로 정해집니다)");
		System.out.print("입력 > ");
		setTree(Integer.parseInt(inputReader.readLine()));
	}

	// 사용자 입력값 만큼 파일 객체를 생성하여 TreeMap에 삽입
	public void setTree(int inputNumber) {

		for (int i = 0; i < inputNumber; i++) {
			// file 인스턴스 생성
			File file = new File();

			System.out.println(file.getFileSize());

			// 파일 크기를 key값으로 TreeMap으로부터 value를 조회
			// 조회된 value는 File 객체를 담는 ArrayList
			// 현재 생성된 파일의 크기와 중복되는 객체가 없을 경우 null
			ArrayList<File> node = tree.get(file.getFileSize());

			// 같은 크기의 파일 객체가 존재하지 않을 때
			if (node == null) {

				// 파일 객체를 담기위한 ArrayList 생성 후 삽입
				node = new ArrayList<File>();
				node.add(file);

				// 파일 크기를 키값으로 해당 ArrayList를 TreeMap에 삽입
				tree.put(file.getFileSize(), node);

			} else {
				// 파일 객체를 해당 노드 ArrayList에 삽입
				node.add(file);
			}
		}

		System.out.println(tree.size() + "개 유형의 파일크기를 가진 파일들이 생성되었습니다.");		
	}

	public void putFileToCd() {

		// CD에 삽입되지 않은 파일이 없을때까지 반복
		while (!tree.isEmpty()) {
			// 최초 실행시 CD 생성
			if (cdList.isEmpty()) {
				cdList.add(new CD());
			}

			// cdList의 먼저 add된 CD들은 이미 파일 삽입이 끝난 CD이므로
			// cdList의 마지막 CD를 호출
			CD cd = cdList.get(cdList.size()-1);
			// 빈 CD 일때
			if (cd.getRemainSize() == 650) {
				
				// TreeMap에서 조회된 가장 큰 파일을 CD에 삽입
				cd.putFile(getFileFromTree(tree.lastKey()));
				cd.getDesc();
			} else { // 빈 CD가 아닐때 
				System.out.println(tree.floorKey(cd.getRemainSize()));
				
				// CD의 잔여 용량에 가장 근접한 작은 크기의 파일을 조회
				// 해당하는 파일이 없을 경우 null
				File file = getFileFromTree(tree.floorKey(cd.getRemainSize()));
				
				// 잔여 용량에 삽입할 파일이 있을 경우
				if(file != null) {
					
					// CD에 파일 삽입
					cd.putFile(file);		
				
				// 잔여 용량에 삽입할 파일이 없을 경우
				} else {
					// cdList에 새로운 CD 삽입
					cdList.add(new CD());
				}
				cd.getDesc();
			}			
		}
		
		System.out.println("정리 완료!");
	}
	
	// TreeMap으로부터 File객체를 리턴받기 위한 메소드
	public File getFileFromTree(int key) {
		
		if(key == -1) {
			return null;
		} else {
			// TreeMap으로부터 key값을 통해 ArrayList의 인스턴스를 획득
			ArrayList<File> node = tree.get(key);
			
			// ArrayList로부터 마지막 File 인스턴스를 획득
			File file = node.get(node.size()-1);
			
			// 획득한 인스턴스를 ArrayList에서 제거
			node.remove(node.size()-1);
			
			// ArrayList에 File객체가 존재하지 않을 경우
			if (node.isEmpty()) {
				
				// TreeMap에서 해당 키값 삭제
				tree.remove(key);
			}
			
			// 파일 객체 반환
			return file;			
		}		
	}
}
