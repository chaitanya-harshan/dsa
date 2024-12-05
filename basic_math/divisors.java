
public class divisors {
    
    public static void main(String[] args) {
        System.out.println(sumOfDivisors(6));
    }
    
    public static int sumOfDivisors(int n) {
        // code here
        int sum = 0;
        for (int i=1; i<=n; i++) {
            System.out.println(divisors(i));
            sum += divisors(i);
        }
        return sum;
    }
    
    public static int divisors(int num) {
        int sum = 0;
        int sqrt = (int)Math.sqrt(num);
        for (int n = 1; n <= sqrt; n++) {
            if (num%n == 0) {
                sum += n;
                int comp_div = num/n;
                if (comp_div != n) sum += comp_div;
            }
        }
        return sum;
    }

    // public static void main(String[] args) {
    //     ArrayList<Integer> divisors = printDivisors(44);
    //     System.out.println(divisors);
    // }

    // static ArrayList<Integer> printDivisors(int N) {
    //     int root = (int)Math.sqrt(N);
    //     ArrayList<Integer> divisors = new ArrayList<>();
    //     for (int i = 1; i <= root; i++) {
    //         if (N % i == 0)  divisors.add(i);
    //     }
    //     for (int i = divisors.size()-1; i >= 0; i--) {
    //         int comp_Divisor = N / divisors.get(i);
    //         if (divisors.get(i) != comp_Divisor) {
    //             divisors.add(comp_Divisor);
    //         }
    //     }
    //     return divisors;
    // }
}
