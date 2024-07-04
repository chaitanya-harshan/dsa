package strings.easy;

/**
 * _03_largest_odd_num_string
 */
public class _03_largest_odd_num_string {

    public static String largestOddNumber(String num) {
        for (int i=num.length()-1; i>=0; i--) {
            if ((int)num.charAt(i) % 2 == 1) {
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}