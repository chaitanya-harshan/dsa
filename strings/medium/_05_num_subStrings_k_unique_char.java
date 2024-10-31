package strings.medium;

import java.util.HashMap;

public class _05_num_subStrings_k_unique_char {

    // https://youtu.be/WCyAWsj9sgI - explanation
    public static void main(String[] args) {
        // String str = "urrrzaxxxhjjquooxzgwzpppavcfaxeefnggtsii";
        // String str = "etppnllcaelzqqyjyygzzlmewgbbtumfdjjrkhyibbbrjhoggghvxsggatddbbbpptyeiiualpphh";
        // String str = "aabcc";
        // String str = "aacfssa";
        // String str = "abaaca";
        String str = "aba";
        // String str = "ecbaddce";
        System.out.println(countSubStrings(str, 2));
        // System.out.println(substrCount(str, 1));
        // 6 5 4 2 1
        // 5 4 2 1
    }

    public static int countSubStrings(String str, int k) {
        // return countSubstringsGreatOrEqual(str, k) - countSubstringsGreatOrEqual(str, k+1);
        return countLessOrEq(str, k) - countLessOrEq(str, k-1);
    }

    static int countLessOrEq(String S, int K) {
        if (K < 0) return 0;
        int l = 0, cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < S.length(); r++) {
            char c = S.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);

            while (map.size() > K) {
                char ch = S.charAt(l);
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) == 0) map.remove(ch);
                l++;
            }

            cnt += r-l+1;
        }
        return cnt;
    }


    // BAD appraoch (it's similar but this is weird)
    public static int countSubstringsGreatOrEqual(String S, int K) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int cnt = 0;
        int right = 0;
        // "eedf" & "edf" are 2 diff things so u need to count them diff
        // hence u can't use for (right ; ; ) as it wont check left for the above given example
        for (int left = 0; left<S.length(); left++) {
            while (right < S.length() && map.size() < K) {
                char c = S.charAt(right);
                map.put(c, map.getOrDefault(c,0)+1);
                right++;
            }
            
            if (map.size() == K) {
                cnt += S.length() - right + 1;
                System.out.print(S.length() - right + 1 +" ");
            }
            
            char leftCh = S.charAt(left);
            map.put(leftCh, map.get(leftCh)-1);
            if (map.get(leftCh) == 0) map.remove(leftCh);
        }
        System.out.println();
        return cnt;


        // THIS WONT WORK BECASUE this will stop at 'ddce' when we should go still 'dce' in "ecbaddce" 
        // therefore it will give count with 1 value less.
        // 
        // HashMap<Character, Integer> map = new HashMap<>();
        // int count = 0;
        // 
        // int left = 0;
        // for (int right=0; right<S.length(); right++) {
        //     char c = S.charAt(right);
        //     map.put(c, map.getOrDefault(c,0)+1 );
        // 
        //     if (map.size() == K) count += S.length()-right;
        //     if (count > 0) System.out.print(S.length()-right +" ");
        // 
        //     while (map.size() == K) {
        //         char left_ch = S.charAt(left);
        //         map.put(left_ch, map.get(left_ch)-1);
        //         if (map.get(left_ch) == 0) map.remove(left_ch);
        //         left++;
        //     }
        // }
        // System.out.println();
        // return count;

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


    // wont work eg.  aac -> a,aa,a,c = 4
    // but u will get -> a,aa,[ac]x, c = 3
    // hence u need to use that weird process below
    //
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
}
