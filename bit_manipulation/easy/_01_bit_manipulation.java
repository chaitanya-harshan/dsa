/*
 * Given a 32 bit unsigned integer num and an integer i. Perform following operations on the number - 

1. Get ith bit
2. Set ith bit
3. Clear ith bit

Input: 70 3
Output: 1 70 66
Explanation: Bit at the 3rd position from LSB is 1. (1 0 0 0 1 1 0) .The value of the given number after setting the 3rd bit is 70. 
The value of the given number after clearing 3rd bit is 66. (1 0 0 0 0 1 0)

https://bit.ly/3Eo8JVW
 */
package bit_manipulation.easy;

public class _01_bit_manipulation {
    public static void main(String[] args) {
        bitManipulation(70, 3);
        bitManipulation(678883006, 16);
    }

    static void bitManipulation(int num, int i) {
        int n = num;
        int ithBit = (n >> i-1) & 1;
        int set = num | (1 << i-1);
        int clear = num & ~(1 << i-1);
        System.out.println(ithBit +" "+ set +" "+ clear);
    }
}
