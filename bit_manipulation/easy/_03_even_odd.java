public class _03_even_odd {
    public static void main(String[] args) {
        System.out.println(oddEven(8));
    }

    static String oddEven(int n) {
        return (n & 1) == 1 ? "odd" : "even";
    }
}
