public class _06_set_rightmost_0_to_1 {
    
    public static int setBit(int n) {
        int num = n;
        n = n+1;
        return num | n;

        // int num = n;
        // int i = 0;
        
        // while ((n&1) != 0) {
        //     n >>= 1;
        //     i++;
        // }
        // return num | (1 << i);
    }
}

// Given a non-negative number n . The problem is to set the rightmost unset bit in the binary representation of n.
