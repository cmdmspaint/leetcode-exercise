package hellozepp.statck;

import java.util.Stack;

/**
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {

        int rst = 0;
        Stack<Integer> stack = new Stack<>();

        for (String st : tokens) {

            if ("+".equals(st)) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 + n2);
            } else if (st.equals("-")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
            } else if (st.equals("*")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 * n2);
            } else if ("/".equals(st)) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                stack.push(Integer.parseInt(st));
            }

        }

        if (!stack.isEmpty()) {
            rst += stack.pop();
        }
        return rst;

    }
}