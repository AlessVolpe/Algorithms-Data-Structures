package Recursion.Fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        if (!input.hasNextInt()) System.out.println("Input is not a number");
        else {
            k = Integer.parseInt(input.nextLine());
            long start1 = System.nanoTime();
            System.out.println("The " + k +"(th) fibonacci number is: " + Integer.toString(FibonacciAlgorithms.binaryFib(k))); 
            long end1 = System.nanoTime();
            System.out.println("Elapsed Time in nanoseconds: " + (end1-start1));

            long start2 = System.nanoTime();
            System.out.println("The " + k +"(th) and " + (k-1) + "(th) fibonacci numbers are: " + Arrays.toString(FibonacciAlgorithms.linearFib(k)));
            long end2 = System.nanoTime();
            System.out.println("Elapsed Time in nanoseconds: " + (end2-start2));
        }

        input.close();
    }
}
