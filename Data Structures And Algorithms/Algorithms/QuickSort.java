package Algorithms;
public class QuickSort {// Time Complexity: O(n log n)
    public static void quickSort(int [] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivot = arr[(right + left) / 2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }
    private static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    public static void swap(int [] arr, int left, int right){
        int temp= arr[left];
        arr[left]= arr[right];
        arr[right]= temp;
    }
    public static String binaryRepresentation(int number) {
        if (number == 0) {
            return "";
        } else {
            return binaryRepresentation(number / 2) + (number % 2);
        }
    }



    public static void main(String[] args){
        int[] a = {4,2,99,1,66,3,88,23,64,13,12};
        quickSort(a);

        for (int i: a){
            System.out.println(i);
        }
       // Examples :
       System.out.println(binaryRepresentation(23));
       System.out.println(binaryRepresentation(9));
       System.out.println(binaryRepresentation(120));
    }
}
