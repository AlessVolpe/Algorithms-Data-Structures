package UnionFind.AckermannFunction;

public class Main {
    public static void main(String[] args) {
        for (long m = 0; m < 4; m++) {
            for (long n = 0; n <= 10; n++) {
                System.out.println("A(" + m + ", " + n + ") = " + Ackermann.ackermannFunction(m, n));
            }
            System.out.println();
        }
        System.out.println("A(4, 0) = " + Ackermann.ackermannFunction(4, 0));
        System.out.println("Going any higher than A(4, 0) results in a buffer overflow");
        System.out.println();

        for (long n = 0; n <= 20; n++) {
            System.out.println("A("+ n +")^(-1) = " + Ackermann.inverseAckermann(n));
        }
    }
}
