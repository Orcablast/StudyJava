package zin.coding.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Controller {

	// CD ��ü�� ������ List
	private ArrayList<CD> cdList;

	// ������ ������ ������ TreeMap
	// ���� ũ���� ���� ��ü���� �����ϱ� ���� ArrayList Ȱ��
	private TreeMapForInteger tree;

	// ����� �Է��� ���� scanner
	private BufferedReader inputReader;

	// �⺻ ������
	public Controller() {
		// �ν��Ͻ� ����
		this.cdList = new ArrayList<CD>();
		this.inputReader = new BufferedReader(new InputStreamReader(System.in));
		this.tree = new TreeMapForInteger();
	}

	public void setUp() throws IOException {
		System.out.println("������ ������ ������ �Է����ּ���. (������ ũ��� 1~649 �� ������ �������ϴ�)");
		System.out.print("�Է� > ");
		setTree(Integer.parseInt(inputReader.readLine()));
	}

	// ����� �Է°� ��ŭ ���� ��ü�� �����Ͽ� TreeMap�� ����
	public void setTree(int inputNumber) {

		for (int i = 0; i < inputNumber; i++) {
			// file �ν��Ͻ� ����
			File file = new File();

			System.out.println(file.getFileSize());

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

	public void putFileToCd() {

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
				System.out.println(tree.floorKey(cd.getRemainSize()));
				
				// CD�� �ܿ� �뷮�� ���� ������ ���� ũ���� ������ ��ȸ
				// �ش��ϴ� ������ ���� ��� null
				File file = getFileFromTree(tree.floorKey(cd.getRemainSize()));
				
				// �ܿ� �뷮�� ������ ������ ���� ���
				if(file != null) {
					
					// CD�� ���� ����
					cd.putFile(file);		
				
				// �ܿ� �뷮�� ������ ������ ���� ���
				} else {
					// cdList�� ���ο� CD ����
					cdList.add(new CD());
				}
				cd.getDesc();
			}			
		}
		
		System.out.println("���� �Ϸ�!");
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
			
			// ���� ��ü ��ȯ
			return file;			
		}		
	}
}
