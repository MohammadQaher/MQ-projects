package Algorithms;
import java.util.Scanner;

public class BubbleSortBitCode {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of integers to sort");
        n = in.nextInt();
        int array[] = new int[n];
        System.out.println("Enter " + n + " integers");
        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();

        for (int i = 0; i < n - 1; i++) {
            Boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) /* For descending order use < */ {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        System.out.println("Sorted list of numbers:");
        for (int i = 0; i < n; i++)
            System.out.println(array[i]);
    }
}
