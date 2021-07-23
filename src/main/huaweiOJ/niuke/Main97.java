import java.util.Scanner;

/**
 * 记负均正
 * 描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 本题有多组输入用例。
 * 输入描述：
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 *
 * 输出描述：
 * 输出负数的个数，和所有正整数的平均值。
 *
 * 示例1
 * 输入：
 * 5
 * 1 2 3 4 5
 * 复制
 * 输出：
 * 0 3.0
 * 复制
 */
public class Main97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            calculate(num, arr);
        }
        sc.close();
    }

    private static void calculate(int num, int[] arr) {
        int positive = 0;
        int minusSign = 0;
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if (arr[i] < 0) {
                positive++;
            } else if (arr[i] > 0) {
                minusSign++;
                sum += arr[i];
            }
        }
        System.out.print(positive + " ");
        System.out.format("%.1f", (double) sum / minusSign);
        System.out.println();
    }
}
