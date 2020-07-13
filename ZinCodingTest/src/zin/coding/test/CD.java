package zin.coding.test;

import java.util.ArrayList;

public class CD {
	
	// CD의 전체 용량 (MB)
	private final int maxSize = 650;
	
	// CD의 사용된 용량 (MB)
	private int currentSize;
	
	// CD에 삽입된 파일의 List
	private ArrayList<File> files;

	// 기본 생성자	
	public CD() {
		// 사용 용량을 0으로 초기화 
		this.currentSize = 0;
		
		// files의 인스턴스 생성
		this.files = new ArrayList<File>();
	}
	
	// CD의 남은 용량(MB)를 반환
	public int getRemainSize() {
		return maxSize - currentSize;
	}
	
	// CD에 파일을 삽입하는 메소드
	public boolean putFile(File file) {
		
		// CD의 남은 용량이 file을 삽입하기에 충분할 때
		if(file.getFileSize() <= getRemainSize()) {
			
			// CD의 파일리스트에 해당 파일을 삽입
			files.add(file);
			
			// CD의 점유 용량 증가
			currentSize += file.getFileSize();
			
			return true;
			
		// CD의 남은 용량이 file을 삽입하기에 불충분할 때 
		} else {
			return false;
		}
	}
	
	// CD의 정보를 출력
	public void getDesc() {
		System.out.printf("현재 용량 : %dMB, 잔여 용량 : %dMB, 점유율 : %.1f", this.currentSize, getRemainSize(), (double)(this.currentSize / maxSize * 100));
	}
}
