package Recursion.Fibonacci;

public class FibonacciAlgorithms {
    public static Integer binaryFib(Integer k) {
        if (k <= 1) return k;
        else return binaryFib(k - 1) + binaryFib(k - 2);
    }

    public static Integer[] linearFib(Integer k) {
        if (k == 1) {
            Integer[] fibPair = {1,0};
            return fibPair;
        }
        else {
            Integer[] recursivePair = linearFib(k - 1);
            Integer[] fibPair = {recursivePair[0]+recursivePair[1], recursivePair[0]};
            return fibPair;
        }
    }
}
