package SortingAlgorithms;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[][] inputs = Utils.generateInputs();

        ArrayList<Long> selectionTimes = new ArrayList<Long>();
        ArrayList<Long> insertionTimes = new ArrayList<Long>();
        ArrayList<Long> heapTimes = new ArrayList<Long>();
        ArrayList<Long> mergeTimes = new ArrayList<Long>();
        ArrayList<Long> quickTimes = new ArrayList<Long>();


        for (int i = 0; i < inputs.length; i++){
            int input[] = inputs[i];

            System.out.println("Sorting the array number " + (i+1) + ":");
            Utils.printArray(input);
            System.out.println();

            long selectionTime = ExecutionTimeCalculator.selectionSort(input);
            selectionTimes.add(selectionTime);

            long insertionTime = ExecutionTimeCalculator.insertionSort(input);
            insertionTimes.add(insertionTime);

            long heapTime = ExecutionTimeCalculator.heapSort(input);
            heapTimes.add(heapTime);

            long mergeTime = ExecutionTimeCalculator.mergeSort(input);
            mergeTimes.add(mergeTime);     
            
            long quickTime = ExecutionTimeCalculator.inPlaceQuickSort(input);
            quickTimes.add(quickTime);   

            System.out.println();
        }
        
        System.out.println("Selection sort took on average: " + Utils.getTimesAverage(selectionTimes) + " ns");
        System.out.println("Insertion sort took on average: " + Utils.getTimesAverage(insertionTimes) + " ns");
        System.out.println("Heap sort took on average: " + Utils.getTimesAverage(heapTimes) + " ns");
        System.out.println("Merge sort took on average: " + Utils.getTimesAverage(mergeTimes) + " ns");
        System.out.println("Quick sort took on average: " + Utils.getTimesAverage(quickTimes) + " ns");

    }
}
