import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/25
 * @Time: 10:33 AM
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述:
 * 输入一行没有空格的字符串。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 输出
 * 复制
 * 3
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (char aCh : ch) {
                set.add(aCh);
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}
