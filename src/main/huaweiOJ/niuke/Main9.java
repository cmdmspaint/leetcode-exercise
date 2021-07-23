import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder(str);
        Set<String> s = new HashSet<>();
        sb.reverse();//字符串反转
        for (int i = 0; i < sb.length(); i++) {
            //set不允许重复添加相同的元素
            if (s.add(sb.substring(i, i + 1))) {
                System.out.print(sb.substring(i, i + 1));
            }
        }
        scan.close();
    }
}