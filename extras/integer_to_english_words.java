// https://leetcode.com/problems/integer-to-english-words/description/

package extras;

public class integer_to_english_words {
    
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] placeString = {"", " Thousand ", " Million ", " Billion "};
        int place = 0;
        String result = "";
        
        while (num != 0) {
            int _3digits = num % 1000;
            num = num / 1000;
            if (!numsToWords(_3digits).isEmpty()) { 
                result = numsToWords(_3digits) + placeString[place] + result;
            }
            place++;
        }
        return result.trim();
    }

    static String numsToWords(int num) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
        String[] tens = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String result = "";
        if (num > 99) result += ones[num/100] + " Hundred ";
        num = num % 100;
        if (num > 19) {
            result += tens[num/10] + " ";
            result += ones[num % 10];
        }
        else if (num > 9) result += teens[num-10];
        else result += ones[num];

        return result.trim();
    }
}


/*
 * 273. Integer to English Words
Solved
Hard
Topics
Companies
Hint
Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */