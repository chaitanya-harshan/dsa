import java.util.ArrayList;

public class divisors {
    public static void main(String[] args) {
        
        ArrayList<Integer> divisors = printDivisors(44);
        System.out.println(divisors);
    }

    static ArrayList<Integer> printDivisors(int N) {

        int root = (int)Math.sqrt(N);
        ArrayList<Integer> divisors = new ArrayList<>();
    
        for (int i = 1; i <= root; i++) {
            if (N % i == 0)  divisors.add(i);
        }
        for (int i = divisors.size()-1; i >= 0; i--) {

            int comp_Divisor = N / divisors.get(i);
            if (divisors.get(i) != comp_Divisor) {
                divisors.add(comp_Divisor);
            }
        }
        return divisors;
    }
}
