/**
 * @author: Navdeep
 * Date: 2023-10-19
 * Time: 8:43 p.m.
 */
package examples;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arrayToSort = {5, 2, 9, 1, 5, 6};

        bubbleSort(arrayToSort);

        System.out.println("Sorted Array: " + Arrays.toString(arrayToSort));
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Swap arr[i-1] and arr[i]
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}


