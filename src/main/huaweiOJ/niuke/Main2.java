import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/25
 * @Time: 1:00 AM
 *
 * 题目描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
 *
 * 输入描述:
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * ABCabc
 * A
 * 输出
 * 复制
 * 2
 */
public class Main2 {
    public static void main(String[] args) {
        int count = 0;

        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toUpperCase();
        char target = in.nextLine().toUpperCase().charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        System.out.println(count);
        in.close();

    }
}
