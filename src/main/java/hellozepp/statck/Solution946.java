package hellozepp.statck;

import java.util.Stack;

/**
 * @Author: zhanglin
 * @Date: 2021/5/19
 * @Time: 6:28 PM
 * 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 *
 * 提示：
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 * 解题步骤
 * 1、如果下一个弹出的数字是栈顶数字，那么直接弹出；
 * 2、如果下一个弹出的数字不在栈顶，则把pushed序列中还没有入栈的数字进栈，直到把下一个需要弹出的数字压入栈顶为止；
 * 3、如果所有数字都压入栈后，仍然没有找到下一个弹出的数字，那么该popped序列不可能是一个弹出序列（此时栈内一定不为空）。
 *
 */
public class Solution946 {
    /**
     * 比较栈顶元素与弹出序列是否一致，一致则出栈，最后栈为空则证明弹出序列正确
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        // 入栈循环
        for (int num : pushed) {
            stack.push(num);
            // 若条件不符合自动跳回for循环，即压未入栈数字进栈
            while (!stack.empty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
