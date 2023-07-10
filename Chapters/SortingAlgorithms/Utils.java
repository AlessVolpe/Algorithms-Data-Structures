package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static void printArray(int array[]) {
        int size = array.length;
        for (int i = 0; i < size; ++i) System.out.print(array[i] + " ");
        System.out.println();
    }

    public static long getTimesAverage(ArrayList<Long> times) {
        int sum = 0;
        for (int i = 0; i < times.size(); i++) sum += times.get(i);
        return sum / times.size();
    }

    public static int[] generateArray() {
        Random rand = new Random();
        int size = rand.nextInt(20) + 1;
        int output[] = new int[size];

        for (int i = 0; i < size; i++)  
            output[i] = ThreadLocalRandom.current().nextInt(-1000,1000);
        
        return output;
    }

    public static int[][] generateInputs() {
        Random rand = new Random();
        int size = rand.nextInt(10) + 1, entry = 0; 
        int inputs[][] = new int[size][];

        do {
            inputs[entry] = Utils.generateArray();
            entry++;
        } while (entry < size);

        System.out.println("Generated " + entry + " input arrays");
        return inputs;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}

