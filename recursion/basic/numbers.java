package recursion.basic;

public class numbers {
    public static void main(String[] args) {
        printOneToN(6);
        System.out.println("---");
        printNtoOne(8);
    }

    static void printOneToN(int N) {
        if (N < 1) {
            return;
        }
        printOneToN(N-1);
        System.out.println(N);
    }

    static void printNtoOne(int N) {
        if (N < 1) {
            return;
        }
        System.out.println(N);
        printNtoOne(N-1);
    }
}
