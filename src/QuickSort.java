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
	
	/*implement sorting adn file generation below according 
	 * to your preference
	 */
	static int ct;
	void sortCall(int size) {
		int arr[] = randomArr(size);
		arrToFile(arr, "randFile.txt");
		
		//average case
		ct = 0;
		sort(arr, 0, arr.length - 1);
		arrToFile(arr, "avgFile.txt");
		System.out.println("Number of swaps(average case): " +ct);
		
		//worst case
		ct = 0;
		int aArr[] = new int[size];
		for(int i = 0; i < size; i++)
			aArr[i] = i;
		sort(aArr, 0, aArr.length - 1);
		arrToFile(aArr, "asFile.txt");
		System.out.println("Numebr of swaps(worst case): " +ct);
	}
	
	/*
	 * implement sorting algorithm below
	 */
	//Quick Sort
	static void sort(int a[], int low, int high) {
        if (low >= high)
            return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    static int partition(int a[], int low, int high) {
        int i = low + 1, j = high, p = a[low];
        while (true) {
            while (a[i] <= p && i < high) {
				i++;
				ct++;
			}
            while (a[j] > p && j > low) {
				j--;
				ct++;
			}
            if (i < j) {				// when both 'i' and 'j' stop
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {					// final swap of 'j' with the first element of sublist and 
                int temp = a[low];
                a[low] = a[j];
                a[j] = temp;
                return j;
            }
        }
    }
}

public class QuickSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of array elements: ");
		int size = sc.nextInt();
		Sort obj = new Sort();
		obj.sortCall(size);
		sc.close();
	}
}