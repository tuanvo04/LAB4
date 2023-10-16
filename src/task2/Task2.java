package task2;

import java.util.Arrays;

public class Task2 {
	// sort by descending order
	public static void mergeSort(int[] array) {
		// nếu mảng trống hoặc ko có phần tử thì nó đã sắp xếp
		if (array == null || array.length < 2) {
			return;
		}
// khi mảng có nhiều hơn 1 phần tử
		int left = 0;
		int right = array.length - 1;
		int mid = left + (right - left) / 2;

		int[] leftArray = Arrays.copyOfRange(array, 0, mid + 1);
		int[] rightArray = Arrays.copyOfRange(array, mid + 1, array.length);

		// gọi đệ quy
		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(array, leftArray, rightArray);
	}

	public static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		int i = 0, j = 0, k = 0;
// lấy số lớn hơn bỏ vào vị trí đầu của mảng
		while (i < leftSize && j < rightSize) {
			if (leftArray[i] >= rightArray[j]) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}
// lấy phần tử bên trái mảng chưa được đưa vào
		while (i < leftSize) {
			array[k++] = leftArray[i++];
		}
// lấy phần bên phải mảng chưa được đưa vào
		while (j < rightSize) {
			array[k++] = rightArray[j++];
		}
	}

	// squickSort
	public static void quickSort(int[] array) {
	    if (array == null || array.length < 2 ) {
	        return; // Base case: empty or single element array
	    }

	    quickSortHelper(array, 0, array.length - 1);
	}

	private static void quickSortHelper(int[] array, int left, int right) {
	    if (left < right) {
	        int partitionIndex = partition(array, left, right);

	        quickSortHelper(array, left, partitionIndex - 1);  // Sort left subarray
	        quickSortHelper(array, partitionIndex + 1, right); // Sort right subarray
	    }
	}

	private static int partition(int[] array, int left, int right) {
	    int pivot = array[right]; // Choose the rightmost element as the pivot
	    int i = left - 1; // Index of smaller element

	    for (int j = left; j < right; j++) {
	        // If current element is less than or equal to the pivot
	        if (array[j] <= pivot) {
	            i++;
	            // Swap array[i] and array[j]
	            int temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	        }
	    }

	    // Swap array[i+1] and array[right] (the pivot)
	    int temp = array[i + 1];
	    array[i + 1] = array[right];
	    array[right] = temp;

	    return i + 1;
	}
	
//getPivot_MedianOfThree
	private static int getPivot_MedianOfThree(int[] array) {
	    // Ensure the array is not null and contains elements
	    if (array == null || array.length == 0) {
	        throw new IllegalArgumentException("Invalid array");
	    }

	    int left = 0;
	    int right = array.length - 1;
	    int mid = left + (right - left) / 2;

	    // Compare the elements at left, right, and mid
	    int leftValue = array[left];
	    int midValue = array[mid];
	    int rightValue = array[right];

	    // Determine the median value among the three
	    int medianValue;
	    if (leftValue > midValue) {
	        if (midValue > rightValue) {
	            medianValue = midValue;
	        } else if (leftValue > rightValue) {
	            medianValue = rightValue;
	        } else {
	            medianValue = leftValue;
	        }
	    } else {
	        if (leftValue > rightValue) {
	            medianValue = leftValue;
	        } else if (midValue > rightValue) {
	            medianValue = rightValue;
	        } else {
	            medianValue = midValue;
	        }
	    }

	    return medianValue;
	}
	private static int getPivot_First(int[] array) {
	    // Đảm bảo mảng không null và chứa phần tử
	    if (array == null || array.length == 0) {
	        throw new IllegalArgumentException("Mảng không hợp lệ");
	    }

	    // Chọn phần tử đầu tiên làm pivot
	    return array[0];
	    
	}
	private static int getPivot_Last(int[] array) {
	    // Đảm bảo mảng không null và chứa phần tử
	    if (array == null || array.length == 0) {
	        throw new IllegalArgumentException("Mảng không hợp lệ");
	    }

	    // Chọn phần tử cuối cùng làm pivot
	    return array[array.length - 1];
	}
	private static int getPivot_Random(int[] array) {
	    // Đảm bảo mảng không null và chứa phần tử
	    if (array == null || array.length == 0) {
	        throw new IllegalArgumentException("Mảng không hợp lệ");
	    }

	    // Chọn ngẫu nhiên một phần tử làm pivot
	    int randomIndex = (int) (Math.random() * array.length);
	    return array[randomIndex];
	}
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 6, 3, 7, 9 };
		mergeSort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
       quickSort(array);
       System.out.println("quckSort: " + Arrays.toString(array));
       
       getPivot_MedianOfThree(array);
       System.out.println(Arrays.toString(array));
       getPivot_First(array);
       System.out.println(Arrays.toString(array));
       getPivot_Last(array);
       System.out.println(Arrays.toString(array));
       getPivot_Random(array);
       System.out.println(Arrays.toString(array));
	}
}
