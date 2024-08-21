import java.util.ArrayList;
import java.util.List;

public class _07_swap_2_nums {
    
    public static List<Integer> swap(int a,int b) {
        a = a ^ b;
        b = a ^ b; // = b = a
        a = a ^ b; // a = a^b ^ a = b
        
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);

        return list;
    }
}

/*
 * Swap given two numbers and print them. (Try to do it without a temporary variable.) and return it.
 * 
 * https://www.geeksforgeeks.org/problems/swap-two-numbers3844/1
 */