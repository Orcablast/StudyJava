package zin.coding.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {

	// 생성된 파일이 보관될 TreeMap
	private TreeMapForInteger tree;
	
	// TreeMap의 value로써 CD 객체를 보관할 List
	private ArrayList<CD> cdList;

	// 사용자 입력을 받기위한 reader
	private BufferedReader inputReader;
	
	// 사용자가 입력한 파일의 갯수
	private int totalFileNum;
	
	// 소요 시간을 측정하기 위한 변수
	private long beginTime;
	private long endTime;

	// 기본 생성자
	public Controller() {
		// 인스턴스 생성
		this.cdList = new ArrayList<CD>();
		this.inputReader = new BufferedReader(new InputStreamReader(System.in));
		this.tree = new TreeMapForInteger();
	}
	
	// 사용자에게 생성할 파일 갯수를 입력받는 메서드
	public void setUp() throws IOException {
		System.out.println("생성할 파일의 갯수를 입력해주세요. (파일의 크기는 1~649 중 난수로 정해집니다)");
		System.out.print("입력 > ");
		totalFileNum = Integer.parseInt(inputReader.readLine());
		setTree(totalFileNum);
	}

	// 사용자 입력값 만큼 파일 객체를 생성하여 TreeMap에 삽입
	public void setTree(int inputNumber) {

		for (int i = 0; i < inputNumber; i++) {
			// file 인스턴스 생성
			File file = new File();

			System.out.println(file.getFileSize()+"MB 파일 생성");

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
	
	
	// 파일 적재 핵심 메서드
	public void putFileToCd() {
		System.out.println("==================== 분류 시작! ====================");

		// 시간 측정 시작
		beginTime = Calendar.getInstance().getTimeInMillis();
		
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
				
				// CD의 잔여 용량에 가장 근접한 작은 크기의 파일을 조회
				// 해당하는 파일이 없을 경우 null
				File file = getFileFromTree(tree.floorKey(cd.getRemainSize()));
				
				// 잔여 용량에 삽입할 파일이 있을 경우
				if(file != null) {
					
					// CD에 파일 삽입
					cd.putFile(file);	
					cd.getDesc();	
				
				// 잔여 용량에 삽입할 파일이 없을 경우
				} else {
					// cdList에 새로운 CD 삽입
					cdList.add(new CD());
					System.out.println("용량부족, 다음 CD 삽입");
				}
			}			
		}
		
		
		// 종료시간 측정
		endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("==================== 분류 종료! ====================");
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
			System.out.println(file.getFileSize()+"MB 파일 삽입");
			// 파일 객체 반환
			return file;			
		}		
	}
	
	// 결과 출력 메소드
	public void printResult() {
		double sumTotalRate = 0;
		
		for(CD cd : cdList) {
			sumTotalRate += cd.getOccupancyRate();
		}
		
		sumTotalRate = (sumTotalRate/cdList.size());
		
		System.out.println("파일 적재에 소요된 시간 : "+(endTime-beginTime)+"ms");
		System.out.println("정리한 파일의 갯수 : "+totalFileNum);
		System.out.println("사용한 CD의 갯수 : "+cdList.size());
		System.out.printf("모든 CD의 평균 공간 점유율 : %.1f%%",sumTotalRate);
		
	}
}
