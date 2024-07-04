package strings.easy;

public class _04_longest_common_prefix {
    
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j<strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return prefix;
                }
            }
            prefix += c;
        }
        return prefix; 
    }
}
