package UnionFind.AckermannFunction;

public class Ackermann {
    public static long ackermannFunction(long m, long n) {
        if (m < 0 && n < 0) return 0; 
        if (m == 0) return n + 1;
        if (n == 0) return ackermannFunction(m - 1, 1);
        return ackermannFunction(m - 1, ackermannFunction(m, n - 1));
    }

    public static long inverseAckermann(long n) {
        if (n <= 4) return n;

        long a = inverseAckermann(n - 1), 
            b = inverseAckermann(n - 2);
        
        return a + b;
    }
}
