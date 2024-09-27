package stacks_queues.Lec2;

import java.util.HashMap;
import java.util.Stack;

public class _01_infix_to_postfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public static String infixToPostfix(String exp) {
        // Your code here
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('^', 3);
        
        Stack<Character> st = new Stack<>();
        String res = "";
       
        for (char c: exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) res += c;
            else if (c == '(') st.push(c);
            else if (c == ')') {
                while(st.peek() != '(') {
                    res += st.pop();
                }
                st.pop();
            }
            else {
                while (!st.empty() && priority.getOrDefault(c, -1) <= priority.getOrDefault(st.peek(), -1) ) {
                    res += st.pop();
                }
                st.push(c);
            }
        }
        while (!st.empty()) {
            res += st.pop();
        }
        return res;
    }
}
