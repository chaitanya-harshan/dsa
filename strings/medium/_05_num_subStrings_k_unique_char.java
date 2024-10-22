package strings.medium;

import java.util.HashMap;

public class _05_num_subStrings_k_unique_char {

    // https://youtu.be/WCyAWsj9sgI - explanation
    public static void main(String[] args) {
        // String str = "urrrzaxxxhjjquooxzgwzpppavcfaxeefnggtsii";
        // String str = "etppnllcaelzqqyjyygzzlmewgbbtumfdjjrkhyibbbrjhoggghvxsggatddbbbpptyeiiualpphh";
        // String str = "aabcc";
        // String str = "aacfssa";
        String str = "abaaca";
        System.out.println(countSubStrings(str, 1));
        // System.out.println(substrCount(str, 1));
    }

    // wont work eg.  aac -> a,aa,a,c = 4
    // but u will get -> a,aa,[ac]x, c = 3
    // hence u need to use that weird process below
    // static int substrCount (String S, int k) {
    //     // https://www.youtube.com/watch?v=WCyAWsj9sgI
    //     HashMap<Character, Integer> map = new HashMap<>();
        
    //     int cnt = 0;
    //     int right = 0;
    //     for (int left = 0; left<S.length(); left++) {
    //         while (right < S.length() && map.size() <= k) {
    //             char c = S.charAt(right);
    //             map.put(c, map.getOrDefault(c,0)+1);
    //             if (map.size() == k) cnt++;
    //             right++;
    //         }
            
    //         char leftChar = S.charAt(left);
    //         map.put(leftChar, map.get(leftChar)-1);
    //         if (map.get(leftChar) == 0) map.remove(leftChar);
    //         if (map.size() == k) cnt++;
    //     }
    //     return cnt;
    // }

    public static int countSubStrings(String str, int k) {
        // Write your code here.
        return countSubstringsGreatOrEqual(str, k) - countSubstringsGreatOrEqual(str, k+1);
    }

    public static int countSubstringsGreatOrEqual(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (str.length() < k) return 0;
        
        int count = 0;
        int j = 0;
        for (int left = 0; left < str.length()-k; left++) {
            while (j < str.length() && map.size() < k) {
                char c = str.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                j++;
            }
            if (map.size() == k) {
                count += str.length()-j+1;
            }

            char ch = str.charAt(left);
            map.put(ch, map.get(ch)-1);
            if (map.get(ch) == 0) map.remove(ch);           
        }
        return count;
    }

    // Wrong code

    // public static int countSubStrings1(String str, int k) {
    //     // Write your code here.
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     if (str.length() < k) return 0;
    //   
    //     int left = 0;
    //     int count = 0;
    //     for (int i = 0; i < str.length(); i++) {
    //         char c = str.charAt(i);
    //
    //         if (!map.containsKey(c)) map.put(c, 1);
    //         else map.put(c, map.get(c)+1);
    //
    //         if (map.size() == k) count++;
    //
    //         if (map.size() == k && k > 1) {
    //             while (str.charAt(left) == str.charAt(left+1)) {
    //                 map.put( str.charAt(left), map.get(str.charAt(left)) - 1 );
    //                 count++;
    //                 left++;
    //             }
    //         }
    //
    //         if (map.size() > k) {
    //             while (map.size() > k) {
    //                 char ch = str.charAt(left++);
    //                 int chCnt = map.get(ch); 
    //                 if (chCnt > 1) map.put(ch, chCnt-1);
    //                 else map.remove(ch);
    //             }
    //             if (map.size() == k) count++;
    //         }
    //     }
    //     return count;
    // }
}
