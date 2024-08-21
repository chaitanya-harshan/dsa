package bit_manipulation.exp;

/**
 * binary_conversion
 */
public class binary_conversion {

    public static void main(String[] args) {
        System.out.println(binary(13));
        System.out.println(binary(234));
        System.out.println(binary(1));
        System.out.println(binary(0));
    }

    static String binary(int num){
        String bits = "";
        while (num != 1 && num != 0) {
            if (num % 2 == 1) bits = '1' + bits;
            else bits = '0' + bits;
            num /= 2;
        }
        bits = num + bits;
        return bits;
    } 
}