package suanfa.interview.练习;

/**
 * 跳一跳
 * 从起点开始接下来有 100 个方块，相邻方块间的距离都为 1，每个方块上有增加体 力的⻝用蘑菇或减少体力的毒蘑菇，
 * 蘑菇带来的体力改变是已知的。一个人初始体 力为 m，每次可以往前跳任意个方块，体力耗尽就会死掉。
 * 1. 每跳一次消耗的体力与跳的距离成正比，比例为 1。问这个人能否跳到终点，如 果能，求可能剩余的最大体力。
 * 2. 每跳一次消耗的体力是跳的距离的平方。问这个人能否跳到终点，如果能，求 可能剩余的最大体力。
 * 3. 每跳一次消耗的体力是跳的距离的平方，每跳一个方块加 1 分。问这个人能否 跳到终点，如果能，求可能得到的最高分数。
 *
 * @Author: zhanglin
 * @Date: 2021/5/20
 * @Time: 12:18 PM
 */
public class Flip {
    /**
     * 微信跳一跳第一问
     * m: 初始体力
     * array: 蘑菇带来的体力改变 :return: 可能剩余的最大体力
     * 贪心算法，时间复杂度 O(n)
     */
    public int flip1(int m, int[] array) {
        for (int n : array) {
            m -= 1; // 消耗的体力与跳的距离成正比
            if (m <= 0) { //体力不足死掉
                return -1;
            }
            if (n > 0) { //只跳加体力的格子
                m += n;
            }
        }
        // 终点的蘑菇必须吃
        if (array[array.length - 1] < 0) {
            m += array[array.length - 1];
        }
        return m > 0 ? m : -1;
    }

    // powers 表示在每个格子可能剩余的最大体力
    public int flip2(int m, int[] array) {
        int[] powers = new int[array.length + 1];
        powers[0] = m;
        for (int i = 1; i <= array.length; i++) {
            for (int j = 0; j < i; j++) {
                int iPlus = (i - j) * (i - j);
                if (powers[j] > iPlus) {
                    powers[i] = Math.max(powers[i], powers[j] - iPlus + array[i - 1]);// i - 1 为格子的位置，i是从1开始计数的
                }
            }
        }
        return powers[powers.length - 1] > 0 ? powers[powers.length - 1] : -1;
    }

    /**
     * # scores 表示在每个格子得到不同分数时可能剩余的最大体力 scores = [{0: m}] + [{} for _ in range(len(array))]
     * for i in range(1, len(array) + 1):
     * for j in range(i):
     * for score, power in scores[j].items():
     * left = power - (i - j) ** 2
     * if left > 0 and left + array[i - 1] > 0:
     * scores[i][score + 1] = max(scores[i].get(score + 1, 0), left + array[i - return max(scores[-1].keys()) if scores[-1].keys() else 0
     * */
    public static void main(String[] args) {
        System.out.println(new Flip().flip2(10, new int[]{1, 2, 1, 2, -2, -3, 1, 1, 1, 10, -10, 1, -1}));
    }

}
