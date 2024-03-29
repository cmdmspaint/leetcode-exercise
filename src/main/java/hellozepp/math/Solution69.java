package hellozepp.math;


/**
 * Implement int sqrt(int x).
 * <p>
 * 难度2星
 */
public class Solution69 {

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

    /**
     * 二分法
     * 平方根的 解在 [1, x/2]
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;

            if (mid > x / mid) right = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1)) return mid;
                else left = mid + 1;
            }
        }
    }
}