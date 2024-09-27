package stacks_queues.Lec2;

import java.util.HashMap;
import java.util.Stack;

public class infix_to_prefix {
    
    public static void main(String[] args) {
        System.out.println(infixToPrefix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(infixToPrefix("x+y*z/w+u"));
    }

    public static String infixToPrefix(String exp) {
        // Your code here
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('^', 3);
        
        Stack<Character> st = new Stack<>();
        String res = "";
        exp = reverse(exp);
       
        for (char c: exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) res += c;
            else if (c == '(') st.push(c);
            else if (c == ')') {
                while (st.peek() != '(') {
                    res += st.pop();
                }
                st.pop();
            }
            else {
                if (c == '^') {
                    while (!st.empty() && priority.getOrDefault(c, -1) <= priority.getOrDefault(st.peek(), -1) ) {
                        res += st.pop();
                    }
                    st.push(c);
                }
                else {
                    while (!st.empty() && priority.getOrDefault(c, -1) < priority.getOrDefault(st.peek(), -1) ) {
                        res += st.pop();
                    }
                    st.push(c);
                }
            }
        }
        while (!st.empty()) {
            res += st.pop();
        }
        
        return reverse(res);
    }

    static String reverse(String s) {
        String reverse = "";
        for (char c : s.toCharArray()) {
            if (c == '(') c = ')';
            else if (c == ')') c = '(';
            reverse = c + reverse;
        }
        return reverse;
    }
}
