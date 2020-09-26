package Algorithms;

public class InsertionSort {

    /*
      Worst Case Time Complexity [ Big-O ]: O(n2)
      Best Case Time Complexity [Big-omega]: O(n)
      Average Time Complexity [Big-theta]: O(n2)
    */

    //Function to sort array using insertion sort
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 4, 9, 11, 13};

        insertionSort(arr);
        printArray(arr);
    }
}

