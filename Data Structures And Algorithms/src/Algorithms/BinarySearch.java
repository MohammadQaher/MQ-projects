package DataStructure;

import java.util.Arrays;

public class BinarySearch {


    public static boolean binarySearchIterative(int[] arr, int x) {
        int left =0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left )/ 2); // to avoid the overflow instead of "mid = right + left /2"
            if(arr[mid] == x) {
                return true;
            } else if ( x < arr[mid]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }




    public static boolean binarySearchRecursive(int [] arr, int x) {
        return binarySearchRecur( arr, x, 0, arr.length-1);
    }


    private static boolean binarySearchRecur(int[] arr, int x, int left, int right) {
        if(left > right) {
            return false;
        }
        int mid = left + ((right - left)/2); // to avoid the overflow instead of "mid = right + left /2"
        if(x == arr[mid]) {
            return true;
        } else if (x < arr[mid]) {
            return binarySearchRecur(arr, x, left, mid -1);
        } else {
            return binarySearchRecur(arr, x, mid + 1, right);
        }
    }



    /*
    //Solve 'Ice Cream Parlor' Using Binary Search

    public static int[] findChoices(int[] menu, int money) {
        int [] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for(int i =0;i < sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, complement);
            if(location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                int[] indices = getIndicesFromValues(menu, menu[i], complement);
                return indices;
            }
        }
        return null;
    }

    private static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        int [] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;

    }

    private static int indexOf(int[] menu, int value, int excludeThis) {
        for(int i =0; i < menu.length; i++) {
            if(menu[i] == value && i != excludeThis) {
                return i;
            }
        }
        return -1;
    }
    */



    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(binarySearchIterative(a, 3));
        System.out.println(binarySearchIterative(a, 2));
        System.out.println(binarySearchIterative(a, 11));
        System.out.println(binarySearchIterative(a, 222));

        System.out.println("--------------------------------------");
        System.out.println(binarySearchRecursive(a, 3));
        System.out.println(binarySearchRecursive(a, 2));
        System.out.println(binarySearchRecursive(a, 11));
        System.out.println(binarySearchRecursive(a, 222));
    }
}
