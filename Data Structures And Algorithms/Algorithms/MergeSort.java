package Algorithms;
public class MergeSort {// Time Complexity: O(n log n) .... Space Complexity: O(n)
    public static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp,mid + 1, right);
        mergeHalves(arr, temp, left, right);
    }
    private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        //left index
        int left = leftStart;
        //right index
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if(arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }/*
    * The java.lang.System.arraycopy() method copies a source array from a specific beginning position to the destination
      array from the mentioned position. No. of arguments to be copied are decided by len argument.
    */
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);

        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }




    public static void main(String[] args) {
        int[] a = {77, 44, 23, 45, 11, 13, 9, 7, 33, 25, 44};
        mergeSort(a);

        for(int i: a) {
            System.out.println(i);
        }
    }

}
