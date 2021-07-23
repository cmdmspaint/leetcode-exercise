import java.util.Scanner;

/**
 * Author: ������
 * Date: 2016-01-17 21:28
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(intDivide(n));
        }

        scanner.close();
    }


    /**
     * <pre>
     * ��1�������������
     * dp[i] = dp[i-1]
     * �൱����(i-1)ÿ���ָ���ǰ������һ��1
     *
     * ��2�������ż����
     * dp[i] = dp[i-1] + dp[i/2]
     * �൱����(i-1)ÿ���ָ���ǰ������һ��1��ͬʱ(i/2)��ÿ���ָ�����2
     * eg��
     *  2��
     *      1 1
     *      2
     *  3��
     *      1 1 1
     *      1 2
     *  4:
     *      1 1 1 1
     *      1 1 2
     *      2 2
     *      4
     * </pre>
     *
     * @param n
     * @return
     */
    private static int intDivide(int n) {

        // ��Ŀ��Ҫ������ݷ�Χ
        if (n < 1 || n > 1000000) {
            return -1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = (dp[i - 1] + dp[i / 2]) % 1000000000;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n];
    }


}
