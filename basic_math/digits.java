
/**
 * digits
 */
public class digits {
    public static void main(String[] args) {
        countDigits_1(124354);    
        int digits = countDigits_2(123547679);
        System.out.println(digits);
    }

    // -----------------------
    static void countDigits_1(int N){
        // System.out.print("Number: ");
        // Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // sc.close();
        
        int i = 0;
        while (N >= Math.pow(10, i) && N > Math.pow(10, i+1)) { 
            i++;
        }
        
        System.out.println(i+1);
    }

    // ------------------------------
    static int countDigits_2(int N) {
        return (int)Math.log10(N) + 1;
    }
}