import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/25
 * @Time: 1:41 AM
 *
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * 示例1
 * 输入
 * 复制
 * 180
 * 输出
 * 复制
 * 2 2 3 3 5
 * 公式 x的质因数 <= 根号x
 * 故 num <=i * i
 * 好多人没明白这个问题的意思，其实就是让你把输入的整数因式分解，只不过因子必须都是质数
 * 例如：180 = 2 * 2 * 3 * 3 * 5；90 = 2 * 3 * 3 * 5；而不是找出所有的质数因子
 *
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int i = 2;
        while (num >= i * i) {
            while (num % i == 0) {
                num = num / i;
                System.out.print(i + " ");
            }
            i++;
        }
        if (num > 1) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
