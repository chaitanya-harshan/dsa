package two_pointers.medium;

import java.util.HashMap;

public class _04_longest_repeating_char_len_with_replacements {
    public static void main(String[] args) {
        String s = "ABBA";
        System.out.println(characterReplacement(s, 2));
    }

    public static int characterReplacement(String s, int k) {
        int l = 0;
        int maxFreq = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(c));

            int len = r-l+1;
            if (len - maxFreq <= k) maxLen = Math.max(maxLen, len); 

            while (l < s.length() && len - maxFreq > k) {
                char ch = s.charAt(l);
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) == 0) map.remove(ch);

                // NOT Needed as since u used up for all your k, only then you're here
                // it means now to get more maxLen u need more maxFreq so u dont care about
                // reducing maxFreq just because u removed a Left char as the if you are 
                // getting a bigger len then it means your maxFreq is obviously going to be
                // greater
                // watch striver or neetcode for explantion
                // striver had made more optimization but i didnt understand.
                
                // maxFreq = Collections.max(map.values());
                l++;
                len--;
            }
        }
        return maxLen;
    }
}
