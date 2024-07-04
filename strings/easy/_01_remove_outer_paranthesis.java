package strings.easy;

/**
 * _01_remove_paranthesis
 */
public class _01_remove_outer_paranthesis {

    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    // Best & simple
    public static String removeOuterParentheses(String s) {
        String str = "";
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) str += c;
            if (c == ')' && opened-- > 1) str += c;
        }
        return str;
    }





    
    public static String removeOuterParentheses1(String s) {
        int opened = 0;
        String str = "";
        int left = 0, right = 0;

        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(' && opened == 0) {
                left = i+1;
                opened++;
            }
            else if(s.charAt(i) == '(') opened++;

            if (s.charAt(i) == ')' && opened == 1) {
                right = i;
                opened--;
                str += s.substring(left, right);
            }
            else if(s.charAt(i) == ')') opened--;
        }
        return str;
    }
}