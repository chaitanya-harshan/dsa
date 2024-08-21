package bit_manipulation.exp;

public class set_rightmost_set_bit_to_0 {

    public static void main(String[] args) {
        int num = 44;
        System.out.println(num +" "+ Integer.toBinaryString(num));
        num = unset(num);
        System.out.println(num +" "+ Integer.toBinaryString(num));
    }
    
    public static int unset(int n) {
        int num = n;
        return (n-1) & num; 
    }
}
