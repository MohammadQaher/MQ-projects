package Algorithms;

public class BubbleSort { // Time Complexity: O(n^2) ....  Space Complexity: O(1)

    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;

        while (!isSorted) {
            isSorted = true;
            for(int i = 0; i < lastUnsorted; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //this is from b2b SDE
    public static void bubbleSort2(int[] arr) {
        int lastIndex = arr.length - 1;

        for (int i = lastIndex; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void main(String [] args) {
        int[] a = {77, 44, 23, 45, 11, 13, 9, 7, 33, 25, 44};
        bubbleSort(a);

        for(int i: a) {
            System.out.println(i);
        }
    }
}
