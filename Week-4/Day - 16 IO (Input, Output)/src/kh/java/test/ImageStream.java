package kh.java.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ImageStream {
	public void test() {
		// quiz.txt ������ ������ �о���� ���� ������Ʈ��
		BufferedReader br = null;
		// �̹��� ���Ϸ� �������� ���� �ֽ�Ʈ��
		FileOutputStream fos = null;
		
		try {
			// quiz.txt ������ �о���� ���� �ֽ�Ʈ�� ����
			FileReader fr = new FileReader("quiz.txt");
			// �ӵ� ������ ���� ������Ʈ�� ����
			br = new BufferedReader(fr);
			// ���Ͽ��� ���� �о��
			String str = br.readLine();
			// 16������ 1���� �����ϱ� ���ؼ� ������ �����ڷ� ��ũ������ ���
			StringTokenizer sT = new StringTokenizer(str, " ");
			// �߶� �����͸� �����ϱ� ���� ArrayList ���� (�迭�� ������� ����)
			ArrayList<Byte> al = new ArrayList<Byte>();

			while (sT.hasMoreTokens()) {
//				// ��ū���� �Ѱ� ������
//				String st = sT.nextToken();
//				// ������ 16���� �����͸� 10���� ������ ����
//				int num = Integer.parseInt(st,16);
//				// byteStream���� �����͸� �������� ���� byte Ÿ������ ����
//				byte b = (byte)(num);
//				// ArrayList�� byte ������ �߰�
//				al.add(b);
				
				// ����ȭ �ڵ� ->			
				byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
				al.add(b);
			}

			System.out.println(al.size());
			
			fos = new FileOutputStream("test.gif");
			
			for (byte b : al) {
				fos.write(b);
			}
			
			// Byte[] arr = new Byte[2097152];
			// int i = 0;
			//
			// while (sT.hasMoreTokens()) {
			// byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
			// arr[i++] = b;
			// }
			//
			// for (Byte b : arr) {
			// fos.write(arr[j]);
			// }

			System.out.println("���� ���� ��");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				br.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public void test02() { // BufferdOutput
		// quiz.txt ������ ������ �о���� ���� ������Ʈ��
		BufferedReader br = null;
		// �̹��� ���Ϸ� �������� ���� �ֽ�Ʈ��
		FileOutputStream fos = null;
		
		BufferedOutputStream bos = null;
		
		try {
			// quiz.txt ������ �о���� ���� �ֽ�Ʈ�� ����
			FileReader fr = new FileReader("quiz.txt");
			// �ӵ� ������ ���� ������Ʈ�� ����
			br = new BufferedReader(fr);
			// ���Ͽ��� ���� �о��
			String str = br.readLine();
			// 16������ 1���� �����ϱ� ���ؼ� ������ �����ڷ� ��ũ������ ���
			StringTokenizer sT = new StringTokenizer(str, " ");
			// �߶� �����͸� �����ϱ� ���� ArrayList ���� (�迭�� ������� ����)
			ArrayList<Byte> al = new ArrayList<Byte>();

			while (sT.hasMoreTokens()) {
//				// ��ū���� �Ѱ� ������
//				String st = sT.nextToken();
//				// ������ 16���� �����͸� 10���� ������ ����
//				int num = Integer.parseInt(st,16);
//				// byteStream���� �����͸� �������� ���� byte Ÿ������ ����
//				byte b = (byte)(num);
//				// ArrayList�� byte ������ �߰�
//				al.add(b);
				
				// ����ȭ �ڵ� ->			
				byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
				al.add(b);
			}

			System.out.println(al.size());
			
			fos = new FileOutputStream("test.gif");
			
			bos = new BufferedOutputStream(fos);
			
			for (byte b : al) {
				bos.write(b);
			}
			
			// Byte[] arr = new Byte[2097152];
			// int i = 0;
			//
			// while (sT.hasMoreTokens()) {
			// byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
			// arr[i++] = b;
			// }
			//
			// for (Byte b : arr) {
			// fos.write(arr[j]);
			// }

			System.out.println("���� ���� ��");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				br.close();
				bos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
