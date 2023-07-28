import java.util.*;
import java.io.*;

class Sort {
	
	// generates random array
	int[] randomArr(int size) {
		int arr[] = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; i++)
			arr[i] = r.nextInt(size) + 1;
		return arr;
	}
	
	//generates file for a given array, does nothing else
	void arrToFile(int arr[],String fName) {
		try {
			PrintWriter obj = new PrintWriter(new File(fName));
			for(int i : arr) {
				obj.print(i);
				obj.print(" ");
			}
			obj.close();
		}
		catch(Exception ex) {
			System.out.println("FileNotFound");
			System.exit(0);
		}
	}
	
	int ct;
	/*implement sorting adn file generation below according 
	 * to your preference
	 */
	void sortCall(int size) {
		int arr[] = randomArr(size);
		arrToFile(arr, "randFile.txt");
		
		//average case
		int aArr[] = sort(arr);
		arrToFile(aArr, "avgFile.txt");
		System.out.println("Numebr of swaps(average case): " +ct);
		
		//best case
		ct = 0;
		int bArr[] = sort(aArr);
		arrToFile(bArr, "bstFile.txt");
		System.out.println("Number of swaps(best case): " +ct);
		
		//worst case
		ct = 0;
		int wArr[] = new int[size];
		for(int i = 0; i < size; i++)
			wArr[i] = size -i;
		int wsArr[] = sort(wArr);
		arrToFile(wsArr, "wstFile.txt");
		System.out.println("Number of swaps(worst case): " +ct);
	}
	
	/*
	 * implement sorting algorithm below
	 */
	//Selection Sort
	int[] sort(int[] a){
		for(int i = 0; i < a.length - 1; i++) {
			int minPos = i;
			for(int j = i + 1; j < a.length; j++) {
				ct++;
				if(a[j] < a[minPos])
					minPos = j;
			}
			if(minPos != i) {
				int tmp = a[minPos];
				a[minPos] = a[i];
				a[i] = tmp;
			}
		}
		return a;
	}
}

public class SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of array elements: ");
		int size = sc.nextInt();
		Sort obj = new Sort();
		obj.sortCall(size);
		sc.close();
	}
}