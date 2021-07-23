import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/28
 * @Time: 5:07 PM
 */
public class Main58 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int num = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            for (int i = 0; i < num; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}