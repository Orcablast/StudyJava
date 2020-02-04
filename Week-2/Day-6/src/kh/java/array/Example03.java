package kh.java.array;

public class Example03 {
	public void exam01() {	// 얕은 복사
		int arr1 [] = {1,2,3,4,5};
		// 얕은 복사
		int arr2 [] = arr1;
		// 각 배열의 주소값 출력
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode());
		// arr1 배열 출력
		arr1[2] = 100;
		arr2[1] = 300;
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println(); 
	}
	
	public void exam02() { // 깊은 복사
		
		int arr1[] = {1,2,3,4,5};
		int arr2[] = new int[arr1.length];
		arr2 = arr1.clone();
		
		
		/*System.arraycopy를 이용한 깊은 복사
		int arr2[] = new int[arr1.length];
		// System.arraycopy(src, srcPos, dest, destPos, length);
		System.arraycopy(arr1, 0, arr2, 0, 4); // array data를 일부만 복사할 때
		*/
		
		/*
		int arr2[] = new int[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		*/
		
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode());
		// arr1 배열 출력
		arr1[2] = 100;
		arr2[1] = 300;
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
	}

}
