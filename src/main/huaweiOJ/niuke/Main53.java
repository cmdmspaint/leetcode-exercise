import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/29
 * @Time: 4:36 PM
 * 杨辉三角变形
 * @author special
 * @date 2017年11月22日 下午11:15:13
 */
public class Main53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n <= 2) {
                System.out.println(-1);
            } else if (n % 2 == 1) {
                System.out.println(2);
            } else {
                if (n % 4 == 0) {
                    System.out.println(3);
                } else {
                    System.out.println(4);
                }
            }
        }
        in.close();
    }
}
