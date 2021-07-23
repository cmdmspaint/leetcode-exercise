import java.util.Scanner;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 *
 * 输入描述:
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * 示例1
 * 输入
 * 复制
 * hello nowcoder
 * 输出
 * 复制
 * 8
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("   ".split(" ").length);//0
        System.out.println("  1 ".split(" ").length);//3
        System.out.println("  1 ".split(" ")[0]+"--");//1
        System.out.println("  1 ".split(" ")[2]+"--");//1
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        System.out.println(length(st));
    }

    public static int length(String[] st) {
        int count = 0;
        if (st.length != 0) {
            char[] ch = st[st.length - 1].toCharArray();
            count = ch.length;
        }
        return count;
    }
}
