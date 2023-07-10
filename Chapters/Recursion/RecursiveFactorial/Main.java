package Recursion.RecursiveFactorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        if (!input.hasNextInt()) System.out.println("Input is not a number");
        else {
            n = Integer.parseInt(input.nextLine());
            System.out.println("The factorial of " + n + " is: " + RecursiveFactorial.recursiveFactorial(n));
        }

        input.close();
    }
}
