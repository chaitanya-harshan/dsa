package recursion.basic;

public class fibonacci {
    public static void main(String[] args) {
        printFibonacci(7);
        // System.out.println(fibonacci(1));
    }

    static void printFibonacci(int N) {
        for (int i = 1; i <= N; i++) {
            System.out.println(fibonacci(i)+" ");
        }
    }
    
    static int fibonacci(int N) {
        if (N <= 2) return N-1;
        int num = fibonacci(N-1) + fibonacci(N-2);
        return num;
    }
}
