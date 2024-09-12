package stacks_queues.Lec1;

import java.util.Stack;

/**
 * implement_Queue_with_stack
 */
public class implement_Queue_with_stack {
    public static void main(String[] args) {
        
    }    
}

class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> buffer = new Stack<>();
    
    public MyQueue() {
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if (buffer.isEmpty()) {
            while (!stack.isEmpty()) {
                buffer.push(stack.pop());
            }
        }
        return buffer.pop();
    }
    
    public int peek() {
        if (buffer.isEmpty()) {
            while (!stack.isEmpty()) {
                buffer.push(stack.pop());
            }
        }
        return buffer.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty() && buffer.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */