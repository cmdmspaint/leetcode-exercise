package hellozepp.statck;

import java.util.Stack;

/**
 * 最小栈
 * 在入栈时，如果这个元素小于等于最小值，那么，我们让最小值入栈，然后将元素值赋给最小值，即新的最小值，
 * 然后正常将这个元素入栈；在出栈时，如果栈顶元素与最小值相等，说明他的下一个元素是之前push的最小值（上一个），
 * 出栈后，将这个之前的最小值赋值给最新的最小值。（每次push进去的最小值都是下面元素的最小值）
 * @Author: zhanglin
 * @Date: 2021/5/19
 * @Time: 5:04 PM
 */
public class Solution155 {
    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    /** 最小栈

     设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

     push(x) -- 将元素 x 推入栈中。
     pop() -- 删除栈顶的元素。
     top() -- 获取栈顶元素。
     getMin() -- 检索栈中的最小元素。

     示例:

     MinStack minStack = new MinStack();
     minStack.push(-2);
     minStack.push(0);
     minStack.push(-3);
     minStack.getMin();   --> 返回 -3.
     minStack.pop();
     minStack.top();      --> 返回 0.
     minStack.getMin();   --> 返回 -2.
     */
    public void push(int x) {
        // 注意这里的等于
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        Integer result = stack.pop();
        if (result == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Solution155 minStack = new Solution155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());    //  --> 返回 0.
        System.out.println(minStack.getMin()); //  --> 返回 -2.
    }
}
