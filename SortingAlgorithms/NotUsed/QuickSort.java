package SortingAlgorithms.NotUsed;

import java.util.Comparator;

public class QuickSort {
    public static void quickSort (Object[] S, Comparator<Object> c) {
        if (S.length < 2) return; // the array is already sorted in this case
            quickSortStep(S, c, 0, S.length-1); // recursive sort method
    }

    private static void quickSortStep (Object[] S, Comparator<Object> c, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return; // the indices have crossed

        Object temp, pivot = S[rightBound];; // temp object used for swapping
        int leftIndex = leftBound, rightIndex = rightBound-1; // leftIndex will scan rightward, while rightIndex will scan leftward
 
        while (leftIndex <= rightIndex) { 
            // scan right until larger than the pivot
            while ((leftIndex <= rightIndex) && (c.compare(S[leftIndex], pivot)<=0)) leftIndex++;

            // scan leftward to find an element smaller than the pivot
            while ( (rightIndex >= leftIndex) && (c.compare(S[rightIndex], pivot)>=0)) rightIndex--;

            if (leftIndex < rightIndex) { 
                // both elements were found
                temp = S[rightIndex];
                S[rightIndex] = S[leftIndex]; // swap these elements
                S[leftIndex] = temp;
            }
        } 
        
        // the loop continues until the indices cross
        temp = S[rightBound]; // swap pivot with the element at leftIndex
        S[rightBound] = S[leftIndex];
        S[leftIndex] = temp; // the pivot is now at leftIndex, so recurse
        quickSortStep(S, c, leftBound, leftIndex-1);
        quickSortStep(S, c, leftIndex+1, rightBound);
    }
}
