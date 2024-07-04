package recursion;

public class name {
    public static void main(String[] args) {
        printName(1,5);
    }

    static void printName(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println("Chaitanya");
        i++;
        printName(i, n);
    }
}
