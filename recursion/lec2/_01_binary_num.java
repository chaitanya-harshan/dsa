/*
 * Given an integer, K. Generate all binary strings of size k without consecutive 1’s.

Examples: 

Input : K = 3  
Output : 000 , 001 , 010 , 100 , 101 

Input : K  = 4 
Output :0000 0001 0010 0100 0101 1000 1001 1010
 */
package recursion.lec2;

public class _01_binary_num {
    public static void main(String[] args) {
        generate(3);
        generate(4);
    }

    public static void generate(int k) {
        if (k < 1) return;
        generateBinaryStrings("0", k, 1);
        generateBinaryStrings("1", k, 1);
        System.out.println();
    }

    public static void generateBinaryStrings(String str, int k, int n) {
        if (n > k) return;
        if (n == k) {
            System.out.print(str+" ");
            return;
        }

        if (str.charAt(str.length()-1) == '1') {
            str += '0';
            generateBinaryStrings(str, k, n+1);
        } 
        else {
            generateBinaryStrings(str+'0', k, n+1);
            generateBinaryStrings(str+'1', k, n+1);
        }
    }
}
