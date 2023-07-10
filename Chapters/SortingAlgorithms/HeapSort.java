package SortingAlgorithms;

public class HeapSort {
    public static int[] heapSort(int array[], int size) {
        for (int i = size/2 - 1; i >= 0; i--)
            heapify(array, size, i);

        for (int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

        return array;
    }

    private static void heapify(int array[], int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left] > array[largest]) largest = left;
        if (right < size && array[right] > array[largest]) largest = right;

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            heapify(array, size, largest);
        }
    }
}
