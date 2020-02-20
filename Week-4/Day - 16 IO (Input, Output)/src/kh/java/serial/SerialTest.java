package kh.java.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialTest {
	
	public void main() {
		ObjectOutputStream oos = null;
		
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\object.txt");
			oos = new ObjectOutputStream(fos);
			
			ArrayList<User> list = new ArrayList<User>();
			
			User user1 = new User("test1", "1234", 1234, new Score(100,100,100));
			User user2 = new User("test2", "1234", 1234, new Score(100,100,100));
			User user3 = new User("test3", "1234", 1234, new Score(100,100,100));
			
			list.add(user1);
			list.add(user2);
			list.add(user3);
			
			
			oos.writeObject(list);
			
			System.out.println("저장완료!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void readObj() {
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\user1\\Desktop\\object.txt");
			
			ois = new ObjectInputStream(fis);
			
			ArrayList<User> list = (ArrayList<User>)ois.readObject();
			
			System.out.println(list.get(0).getId());
			System.out.println(list.get(1).getId());
			System.out.println(list.get(2).getId());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
				
		
		
		
	}

}
