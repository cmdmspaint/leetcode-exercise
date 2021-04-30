/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题31：栈的压入、弹出序列
 * // 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * // 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
 * // 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
 * // 4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
package offer;
import java.util.Stack;

public class Java31_StackPushPopOrder {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if (pushA.length == 0 || popA.length == 0) {
		    return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		//用于识别弹出序列的位置
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
		    stack.push(pushA[i]);
		    while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
		        stack.pop();
		        popIndex++;
		    }
		}
		return stack.isEmpty();
	  }
  }