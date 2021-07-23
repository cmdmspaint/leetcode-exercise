package suanfa.leetcode;

/**
 * x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class a69sqrt {
    public static int solution(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid < n) {
                low = mid + 1;
            } else if (mid * mid > n) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return high;  //注意，low <= high不成立是，high已经越界变成low
    }

    public static int mySqrt(int x) {
        long lo = 0;
        long hi = x;

        while (hi >= lo) {
            long mid = lo + (hi - lo) / 2;
            if (x < mid * mid) {
                hi = mid - 1;      // not hi = mid
            } else {
                lo = mid + 1;
            }
        }
        return (int) hi;
    }

    public static void main(String[] args) {
        System.out.println(solution(63));
        System.out.println(mySqrt(63));
    }
}
