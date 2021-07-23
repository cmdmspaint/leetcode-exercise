import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/28
 * @Time: 9:50 PM
 * 记负均正II
 * 描述
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 * 数据范围小于1e6
 * 输入描述：
 * 输入任意个整数，每行输入一个。
 *
 * 输出描述：
 * 输出负数个数以及所有非负数的平均值
 *
 * 示例1
 * 输入：
 * -13
 * -4
 * -7
 * 复制
 * 输出：
 * 3
 * 0.0
 * 复制
 */
public class Main105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float count1 = 0;
        int count2 = 0;
        float sum = 0;
        while (sc.hasNextInt()) {
            int cur = sc.nextInt();
            if (cur >= 0) {
                count1++;
                sum += cur;
            } else {
                count2++;
            }
        }
        System.out.println(count2);
        if (sum == 0) {
            System.out.println("0.0");
        } else {
            System.out.printf("%.1f\n", sum / count1);
        }
    }
}
