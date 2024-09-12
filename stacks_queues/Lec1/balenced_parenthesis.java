package stacks_queues.Lec1;

/**
 * balenced_parenthesis
 */
public class balenced_parenthesis {

    public boolean isValid(String s) {
        if (s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.empty()) return false;

                char ch = stack.peek();
                if (ch == '(') ch = ')';
                else if (ch == '{') ch = '}';
                else if (ch == '[') ch = ']';
                
                if (c != ch) return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
}

/*
https://leetcode.com/problems/valid-parentheses/description/

 * 20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false

Input: s = "([])"
Output: true
 */