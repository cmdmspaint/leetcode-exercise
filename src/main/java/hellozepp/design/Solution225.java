package hellozepp.design;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 用queue 模拟 stack
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) – 元素 x 入栈
 * pop() – 移除栈顶元素
 * top() – 获取栈顶元素
 * empty() – 返回栈是否为空
 */
public class Solution225 {

    private Queue<Integer> queue = new LinkedList<>();

    private int top;

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!queue.isEmpty()) {
            queue.remove(top);

            int i = 1;
            for (int n : queue) {
                if (i++ == queue.size()) {
                    top = n;
                }
            }
        }
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {

        return queue.isEmpty();
    }
}