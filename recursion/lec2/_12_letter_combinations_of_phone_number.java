package recursion.lec2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _12_letter_combinations_of_phone_number {
    
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, digits, map);
        return result;
    }

    static void backtrack(List<String> result, String word, int key, String digits, HashMap<Character, String> map) {
        if (key == digits.length()) {
            if (!word.isEmpty()) result.add(word);
            return;
        }

        for (char c: map.get(digits.charAt(key)).toCharArray()) {
            backtrack(result, word + c, key+1, digits, map);
        }
    }
}

/*
 * 17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Input: digits = ""
Output: []

Input: digits = "2"
Output: ["a","b","c"]
 */