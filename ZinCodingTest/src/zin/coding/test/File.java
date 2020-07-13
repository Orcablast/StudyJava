package zin.coding.test;

public class File {
	
	// 파일의 용량 (MB)
	private int fileSize;

	// 기본 생성자
	public File() {
		// 파일의 용량을 정수 1~649 사이의 난수로 부여
		this.fileSize = (int)(Math.random()*650);
	}
	
	// 파일의 용량을 반환
	public int getFileSize() {
		return this.fileSize;
	}

}
