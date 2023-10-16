package task1;

import java.lang.reflect.Array;
import java.util.Iterator;

public class Task1 {

	// Sắp xếp giảm dần
	public static void selectionSort(int[] array) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			int max = i;

			for (int j = i + 1; j < n; j++) {
				if (array[j] > array[max]) {
					max = j;
				}
			}

			// Hoán đổi vị trí giữa array[max] và array[i]
			int temp = array[max];
			array[max] = array[i];
			array[i] = temp;
		}
	}

	// sort by descending order
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// sort by descending order
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j] >= array[j - 1]) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j--;
			}
		}
	}
	

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 10, 4, 2, 5, 9 };
		// Sắp xếp mảng theo thứ tự giảm dần
		selectionSort(array1);
		// In ra mảng sau khi sắp xếp
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		int[] array2 = { 1, 2, 10, 4, 2, 5, 9 };
		bubbleSort(array2);
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}

		System.out.println();
		int[] array3 = { 1, 2, 10, 4, 2, 5, 9 };
		insertionSort(array3);
		;
		for (int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + " ");
		}
	}

}
