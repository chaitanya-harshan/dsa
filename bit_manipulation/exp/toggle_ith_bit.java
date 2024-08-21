package bit_manipulation.exp;

public class toggle_ith_bit {
    public static void main(String[] args) {
        int num =  46;
        System.out.println(num +" " + Integer.toBinaryString(num));
        num = toggle(num, 4);
        System.out.println(num +" " + Integer.toBinaryString(num));
    }

    public static int toggle(int n, int i) {
        return n ^ (1 << i);
    }
}

// 0 indexing