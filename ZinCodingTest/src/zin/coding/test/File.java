package zin.coding.test;

public class File {
	
	// ������ �뷮 (MB)
	private int fileSize;

	// �⺻ ������
	public File() {
		// ������ �뷮�� ���� 1~649 ������ ������ �ο�
		this.fileSize = (int)(Math.random()*650);
	}
	
	// ������ �뷮�� ��ȯ
	public int getFileSize() {
		return this.fileSize;
	}

}
