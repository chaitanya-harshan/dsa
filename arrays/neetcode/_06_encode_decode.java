package arrays.neetcode;

import java.util.ArrayList;
import java.util.List;

public class _06_encode_decode {
    
    public static void main(String[] args) {
        String[] strs = {"neet","code","love","you"};
        String encodedString = encode(strs);
        System.out.println(decode(encodedString));
    }

    public static String encode(String[] strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s: strs) {
            int lenOflenStr = String.valueOf(s.length()).length();
            
            encoded.append(lenOflenStr).append(s.length()).append(s);
            // System.out.println(encoded.toString());
        }
        return encoded.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int lols = str.charAt(i) - '0';
            i++;
            int los = Integer.parseInt(str.substring(i, i+lols));
            i = i+lols;
            list.add(str.substring(i, i+los));
            i = i+los;

            // System.out.println(list);
        }
        return list;
    }
}

/*
 * Encode and Decode Strings
 * https://neetcode.io/problems/string-encode-and-decode
 * 
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.
 */