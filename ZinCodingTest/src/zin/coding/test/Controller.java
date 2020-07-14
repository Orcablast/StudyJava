package zin.coding.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {

	// ������ ������ ������ TreeMap
	private TreeMapForInteger tree;
	
	// TreeMap�� value�ν� CD ��ü�� ������ List
	private ArrayList<CD> cdList;

	// ����� �Է��� �ޱ����� reader
	private BufferedReader inputReader;
	
	// ����ڰ� �Է��� ������ ����
	private int totalFileNum;
	
	// �ҿ� �ð��� �����ϱ� ���� ����
	private long beginTime;
	private long endTime;

	// �⺻ ������
	public Controller() {
		// �ν��Ͻ� ����
		this.cdList = new ArrayList<CD>();
		this.inputReader = new BufferedReader(new InputStreamReader(System.in));
		this.tree = new TreeMapForInteger();
	}
	
	// ����ڿ��� ������ ���� ������ �Է¹޴� �޼���
	public void setUp() throws IOException {
		System.out.println("������ ������ ������ �Է����ּ���. (������ ũ��� 1~649 �� ������ �������ϴ�)");
		System.out.print("�Է� > ");
		totalFileNum = Integer.parseInt(inputReader.readLine());
		setTree(totalFileNum);
	}

	// ����� �Է°� ��ŭ ���� ��ü�� �����Ͽ� TreeMap�� ����
	public void setTree(int inputNumber) {

		for (int i = 0; i < inputNumber; i++) {
			// file �ν��Ͻ� ����
			File file = new File();

			System.out.println(file.getFileSize()+"MB ���� ����");

			// ���� ũ�⸦ key������ TreeMap���κ��� value�� ��ȸ
			// ��ȸ�� value�� File ��ü�� ��� ArrayList
			// ���� ������ ������ ũ��� �ߺ��Ǵ� ��ü�� ���� ��� null
			ArrayList<File> node = tree.get(file.getFileSize());
			
			// ���� ũ���� ���� ��ü�� �������� ���� ��
			if (node == null) {

				// ���� ��ü�� ������� ArrayList ���� �� ����
				node = new ArrayList<File>();
				node.add(file);

				// ���� ũ�⸦ Ű������ �ش� ArrayList�� TreeMap�� ����
				tree.put(file.getFileSize(), node);

			} else {
				// ���� ��ü�� �ش� ��� ArrayList�� ����
				node.add(file);
			}
		}

		System.out.println(tree.size() + "�� ������ ����ũ�⸦ ���� ���ϵ��� �����Ǿ����ϴ�.");
	}
	
	
	// ���� ���� �ٽ� �޼���
	public void putFileToCd() {
		System.out.println("==================== �з� ����! ====================");

		// �ð� ���� ����
		beginTime = Calendar.getInstance().getTimeInMillis();
		
		// CD�� ���Ե��� ���� ������ ���������� �ݺ�
		while (!tree.isEmpty()) {
			// ���� ����� CD ����
			if (cdList.isEmpty()) {
				cdList.add(new CD());
			}

			// cdList�� ���� add�� CD���� �̹� ���� ������ ���� CD�̹Ƿ�
			// cdList�� ������ CD�� ȣ��
			CD cd = cdList.get(cdList.size()-1);
			// �� CD �϶�
			if (cd.getRemainSize() == 650) {
				
				// TreeMap���� ��ȸ�� ���� ū ������ CD�� ����
				cd.putFile(getFileFromTree(tree.lastKey()));
				cd.getDesc();
			} else { // �� CD�� �ƴҶ� 
				
				// CD�� �ܿ� �뷮�� ���� ������ ���� ũ���� ������ ��ȸ
				// �ش��ϴ� ������ ���� ��� null
				File file = getFileFromTree(tree.floorKey(cd.getRemainSize()));
				
				// �ܿ� �뷮�� ������ ������ ���� ���
				if(file != null) {
					
					// CD�� ���� ����
					cd.putFile(file);	
					cd.getDesc();	
				
				// �ܿ� �뷮�� ������ ������ ���� ���
				} else {
					// cdList�� ���ο� CD ����
					cdList.add(new CD());
					System.out.println("�뷮����, ���� CD ����");
				}
			}			
		}
		
		
		// ����ð� ����
		endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("==================== �з� ����! ====================");
	}
	
	// TreeMap���κ��� File��ü�� ���Ϲޱ� ���� �޼ҵ�
	public File getFileFromTree(int key) {
		
		if(key == -1) {
			return null;
		} else {
			// TreeMap���κ��� key���� ���� ArrayList�� �ν��Ͻ��� ȹ��
			ArrayList<File> node = tree.get(key);
			
			// ArrayList�κ��� ������ File �ν��Ͻ��� ȹ��
			File file = node.get(node.size()-1);
			
			// ȹ���� �ν��Ͻ��� ArrayList���� ����
			node.remove(node.size()-1);
			
			// ArrayList�� File��ü�� �������� ���� ���
			if (node.isEmpty()) {
				
				// TreeMap���� �ش� Ű�� ����
				tree.remove(key);
			}
			System.out.println(file.getFileSize()+"MB ���� ����");
			// ���� ��ü ��ȯ
			return file;			
		}		
	}
	
	// ��� ��� �޼ҵ�
	public void printResult() {
		double sumTotalRate = 0;
		
		for(CD cd : cdList) {
			sumTotalRate += cd.getOccupancyRate();
		}
		
		sumTotalRate = (sumTotalRate/cdList.size());
		
		System.out.println("���� ���翡 �ҿ�� �ð� : "+(endTime-beginTime)+"ms");
		System.out.println("������ ������ ���� : "+totalFileNum);
		System.out.println("����� CD�� ���� : "+cdList.size());
		System.out.printf("��� CD�� ��� ���� ������ : %.1f%%",sumTotalRate);
		
	}
}
