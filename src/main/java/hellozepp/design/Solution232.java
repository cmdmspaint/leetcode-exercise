package hellozepp.design;


import java.util.Stack;

/**
 * 实现Queue 使用stack
 * <p>
 * 难度1星
 */
public class Solution232 {

    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();


    public void push(int x) {
        input.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public int top() {
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}