package SortingAlgorithms;

public class MergeSort {
    public static void merge(int arr[], int left, int middle, int right) {
        int size1 = middle - left + 1, size2 = right - middle;
        int arr1[] = new int[size1], arr2[] = new int[size2];

        for (int i = 0; i < size1; ++i) arr1[i] = arr[left + i];
        for (int j = 0; j < size2; ++j) arr2[j] = arr[middle + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < size1 && j < size2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = arr1[i];
            i++; k++;
        }
 
        while (j < size2) {
            arr[k] = arr2[j];
            j++; k++;
        }
    }

    public static void sort(int arr[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(arr, left, middle); 
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
}
