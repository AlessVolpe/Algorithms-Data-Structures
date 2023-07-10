package Recursion.RecursiveFactorial;

public class RecursiveFactorial {
    public static int recursiveFactorial(int n) {
        if (n == 0) return 1; // Caso base
        else return n * recursiveFactorial(n - 1);
    }
}
