package zin.coding.test;

import java.util.ArrayList;

public class CD {
	
	// CD�� ��ü �뷮 (MB)
	private final int maxSize = 650;
	
	// CD�� ���� �뷮 (MB)
	private int currentSize;
	
	// CD�� ���Ե� ������ List
	private ArrayList<File> files;

	// �⺻ ������	
	public CD() {
		// ��� �뷮�� 0���� �ʱ�ȭ 
		this.currentSize = 0;
		
		// files�� �ν��Ͻ� ����
		this.files = new ArrayList<File>();
	}
	
	// CD�� ���� �뷮(MB)�� ��ȯ
	public int getRemainSize() {
		return maxSize - currentSize;
	}
	
	// CD�� ������ �����ϴ� �޼ҵ�
	public boolean putFile(File file) {
		
		// CD�� ���� �뷮�� file�� �����ϱ⿡ ����� ��
		if(file.getFileSize() <= getRemainSize()) {
			
			// CD�� ���ϸ���Ʈ�� �ش� ������ ����
			files.add(file);
			
			// CD�� ���� �뷮 ����
			currentSize += file.getFileSize();
			
			return true;
			
		// CD�� ���� �뷮�� file�� �����ϱ⿡ ������� �� 
		} else {
			return false;
		}
	}
	
	// CD�� ������ ���
	public void getDesc() {
		System.out.printf("���� �뷮 : %dMB, �ܿ� �뷮 : %dMB, ������ : %.1f", this.currentSize, getRemainSize(), (double)(this.currentSize / maxSize * 100));
	}
}
