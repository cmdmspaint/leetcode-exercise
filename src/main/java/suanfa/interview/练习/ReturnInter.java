package suanfa.interview.练习;

/**
 * @Author: zhanglin
 * @Date: 2021/5/20
 * @Time: 3:33 PM
 * 一个环上有10个点,编号为0-9,从0点出发,每步可以顺时针到下一个点,也可以逆时针到上一个点,求:经过n步又回到0点有多少种不同的走法？
 *
 * 举例
 * 如果n=1，则从0出发只能到1或者9，不可能回到0，共0种走法
 * 如果n=2，则从0出发有4条路径:0->1->2, 0->1->0, 0->9->8, 0->9->0,其中有两条回到了0点，故一共有2种走法
 * 0 1 2 3 4 5 6 7 8  9 0
 * 状态方程为：d(k, j) = d(k-1, j-1) + d(k-1, j+1);
 * 由于可能发生越界，故转换为
 * d(k, j) = d(k-1, (j-1+n)%n) + d(k-1, (j+1)%n);
 * 解释为：j步达到i点的问题，转化为j-1步从相邻的两个节点到达目标节点的方法数之和。
 */
public class ReturnInter {
    /**
     * 单数不可能回到原点， 因为圆圈点为10 ， 10是2 的倍数。
     * 转换成求排列组合问题， 比如n == 6， 则必然有3步向前，3步后退， 无关顺序，所以只要选3个位置存放向前即可，组合共有6*5*4 / 3/2 =  20种方案
     * 当n > 10 时，需要进行迭代， 因为过10则可以有全向前的步数。 当n == 10 时，多出两个走法。
     * 排列方程 Amn  = n!/(n-m)!  组合方程 cmn=n!/(n-m)!m! 注意0!=1,求排列4的排列为4！
     * c3 6 = 6*5*4 / 3/2 =  20
     * @param args
     */

    public static void main(String[] args) {
        //System.out.print(calc(6, 2));
        System.out.println(findNumber(4));
        System.out.println(findNumber(11));
        System.out.println(findNumber(12));
        System.out.println(findNumber(22));
    }

    private static Integer findNumber(Integer n) {

        if (n == 0 || n % 2 == 1) {
            return 0;
        }
        return travel(n - 10, n);
    }

    private static Integer travel(Integer needInsert, Integer n) {
        if (needInsert < 0) {
            return calc(n, n / 2);
        } else if (needInsert == 0) {
            return calc(n, n / 2) + 2;
        } else if (needInsert % 10 == 0) {
            return 2 * calc(n, needInsert / 2) + travel(needInsert - 10, n) + 2;
        } else {
            return 2 * calc(n, needInsert / 2) + travel(needInsert - 10, n);
        }
    }

    private static Integer calc(Integer n, int i) {
        int number = 1;
        int temp = 1;
        while (i > 0) {
            number = number * (n - i + 1);
            temp = temp * i;
            i--;
        }
        return number / temp;
    }
}
