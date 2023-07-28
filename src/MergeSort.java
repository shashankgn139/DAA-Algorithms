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
	void arrToFile(int arr[],String fName) throws IOException {
		PrintWriter obj = new PrintWriter(new File(fName));
		for(int i : arr) {
			obj.print(i);
			obj.print(" ");
		}
		obj.close();
		
	}
	
	static int ct;
	
	// make use of 'randomArr(<size>)' and 'arrToFile(<arr>, 0, <arr>.length)'
	void sortCall(int size) throws IOException{
		int arr[] = randomArr(size);
		arrToFile(arr, "rndFile.txt");
		
		//best case, worst case, average case
		ct = 0;
		sort(arr);
		arrToFile(arr, "srtFile.txt");
		System.out.println("Numebr of swaps(best, avg and worst case): " +ct);
	}
	
	/*
	 * implement sorting algorithm below
	 */
	//Merge Sort
	void sort(int a[]) {
		if(a.length > 1) {
			int b[] = Arrays.copyOfRange(a, 0, a.length/2);
			int c[] = Arrays.copyOfRange(a, a.length/2, a.length);
			sort(b);
			sort(c);
			merge(b, c, a);
		}
	}
	void merge(int b[], int c[], int a[]) {
		int i = 0, j = 0, k = 0;
		while(i < b.length && j < c.length) {
			if(b[i] < c[j]) {
				a[k++] = b[i++];
			} else {
				a[k++] = c[j++];
			}
			ct++;
		}
		while(i < b.length) {
			a[k++] = b[i++];
		}
		while(j < c.length) {
			a[k++] = c[j++];
		}
	}
	
}

public class MergeSort {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of array elements: ");
		int size = sc.nextInt();
		Sort obj = new Sort();
		obj.sortCall(size);
		sc.close();
	}
}