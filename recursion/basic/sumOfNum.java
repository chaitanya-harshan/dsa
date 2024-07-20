package recursion.basic;

public class sumOfNum {
    public static void main(String[] args) {
        System.out.println(sumOfNum(7));
    }

    static int sumOfNum(int N) {
        if ( N == 1) return 0;
        return N + sumOfNum(N-1);
    }
}
