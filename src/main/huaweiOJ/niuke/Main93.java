import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/29
 * @Time: 3:59 PM
 * 数组分组
 * 描述
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，输出true；不满足时输出false。
 * 本题含有多组样例输入。
 * 输入描述：
 * 第一行是数据个数，第二行是输入的数据
 *
 * 输出描述：
 * 返回true或者false
 *
 * 示例1
 * 输入：
 * 4
 * 1 5 -5 1
 * 3
 * 3 5 8
 * 复制
 * 输出：
 * true
 * false
 * 复制
 * 说明：
 * 第一个样例：
 * 第一组：5 -5 1
 * 第二组：1
 * 第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
 */
//参考网友ld1230的解法
//思想：将能整除3或者5的各自分为一组，记为sum1和sum2，剩余的保存在数组nums里
//现有两组，剩余nums里的数要么在sum1里要么在sum2里，利用递归依次放在sum1和sum2中
//最终nums里的数字全部放进去，若sum1 == sum2，则返回true，否则，返回false
public class Main93 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int index = 0, sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                int tmp = scanner.nextInt();
                if (tmp % 5 == 0) {
                    sum1 += tmp;
                } else if (tmp % 3 == 0) {
                    sum2 += tmp;
                } else {
                    nums[index++] = tmp;
                }
            }
            System.out.println(isExists(sum1, sum2, nums, 0));
        }
        scanner.close();
    }

    public static boolean isExists(int sum1, int sum2, int[] nums, int index) {
        if (index == nums.length && sum1 != sum2) return false;
        if (index == nums.length && sum1 == sum2) return true;
        if (index < nums.length)
            return isExists(sum1 + nums[index], sum2, nums, index + 1)
                    || isExists(sum1, sum2 + nums[index], nums, index + 1);
        return false;
    }
}