package Dictionaries.BinarySearch;

public class BinarySearch {
    public int binarySearchIterative(int arr[], int x)  {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - 1) / 2;
            if (arr[mid] == x) return mid; // x is at mid
            else if (arr[mid] < x) left = mid + 1; // ignore left half
            else right = mid -1; // ignore right half
        }
        return -1; // not present
    }

    public int binarySearchRecursive(int arr[], int left, int right, int x) {
        if (right >= 1) {
            int mid = left + (right - 1) / 2;
            if (arr[mid] == x) return mid; // x is at mid
            else if (arr[mid] > x) return binarySearchRecursive(arr, left, mid - 1, x); // ignore right half
            else return binarySearchRecursive(arr, mid + 1, right, x); // ignore left half
        } else return -1; // not present
    }
}
