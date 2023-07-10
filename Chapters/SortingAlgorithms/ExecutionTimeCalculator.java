package SortingAlgorithms;

public class ExecutionTimeCalculator {
    public static long selectionSort(int array[]) {
        long start = System.nanoTime();
        int selectionOutput[] = SelectionSort.selectionSort(array, array.length);
        System.out.print("[SelectionSort] The sorted array is: ");
        Utils.printArray(selectionOutput);
        long end = System.nanoTime();
        // System.out.println("Sorted:" + Utils.isSorted(array));

        long selectionTime = end-start;
        System.out.println("Elapsed Time in nanoseconds: " + selectionTime);
        return selectionTime;
    }

    public static long insertionSort(int array[]) {
        long start = System.nanoTime();
        int insertionOutput[] = InsertionSort.insertionSort(array, array.length);
        System.out.print("[InsertionSort] The sorted array is: ");
        Utils.printArray(insertionOutput);
        long end = System.nanoTime();
        // System.out.println("Sorted:" + Utils.isSorted(array));

        long insertionTime = end-start;
        System.out.println("Elapsed Time in nanoseconds: " + insertionTime);
        return insertionTime;
    }

    public static long heapSort(int array[]) {
        long start = System.nanoTime();
        int heapOutput[] = HeapSort.heapSort(array, array.length);
        System.out.print("[HeapSort] The sorted array is: ");
        Utils.printArray(heapOutput);
        long end = System.nanoTime();
        // System.out.println("Sorted:" + Utils.isSorted(array));

        long heapTime = end-start;
        System.out.println("Elapsed Time in nanoseconds: " + heapTime);
        return heapTime;
    }

    public static long mergeSort(int array[]) {
        long start = System.nanoTime();
        MergeSort.sort(array, 0, array.length - 1);
        System.out.print("[MergeSort] The sorted array is: ");
        Utils.printArray(array);
        long end = System.nanoTime();
        // System.out.println("Sorted:" + Utils.isSorted(array));

        long mergeTime = end-start;
        System.out.println("Elapsed Time in nanoseconds: " + mergeTime);
        return mergeTime;
    }

    public static long inPlaceQuickSort(int array[]) {
        long start = System.nanoTime();
        InPlaceQuickSort.quickSort(array, 0, array.length - 1);
        System.out.print("[QuickSort] The sorted array is: ");
        Utils.printArray(array);
        long end = System.nanoTime();
        // System.out.println("Sorted:" + Utils.isSorted(array));

        long quickTime = end-start;
        System.out.println("Elapsed Time in nanoseconds: " + quickTime);
        return quickTime;
    }
}
