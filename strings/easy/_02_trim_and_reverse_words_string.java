package strings.easy;

public class _02_trim_and_reverse_words_string {
    public static void main(String[] args) {
        String s = "   the sky is      blue ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int left = 0, right = s.length()-1;
        String str = "";
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && (i == s.length()-1 || s.charAt(i+1) == ' ')) right = i+1;
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i-1) == ' ')) {
                left = i;
                if (str != "") str += ' ' + s.substring(left, right);
                else str += s.substring(left, right);
            }
        }
        return str;

        // s = s.trim();
        // Stack<String> st = new Stack<>();
        
        // String word = "";
        // for (int i=0; i<s.length(); i++) {
        //     if (s.charAt(i) == ' ') {
        //         if (!word.isEmpty()) st.push(word);
        //         word = "";
        //     }
        //     else word += s.charAt(i);
        // }
        // st.push(word);

        // String res = st.pop();
        // while (!st.empty()) {
        //     res += ' ' + st.pop();
        // }
        // return res;
    }
}
