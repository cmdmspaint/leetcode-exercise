import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/28
 * @Time: 4:06 PM
 */
public class Main35 {

    /**
     * 第一行[1 3 6 10]
     * 第二行是 去掉第一行的第一列，然后将后面的[3 6 10]分别减1得到的。
     * @param args
     */
    public static void main1(String args[]) {//主方法，主要就是接收数据
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int arr[] = new int[num];
            for (int i = 0; i < num; i++) {
                int j = i, ser = 1, sum = 0;
                while (j < num) {
                    if (i == 0) {
                        sum += ser++;
                        System.out.print(sum + " ");
                        arr[j++] = sum;
                    } else {
                        System.out.print((arr[j++] - i) + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {//主方法，主要就是接收数据
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            printtriangle(num);
        }
    }

    public static void printtriangle(int num) { //输出方法输出蛇形矩阵
        int y = 1;//列的方向第一个肯定是1
        int yCount = 1;//列由上往下是等差数列，第一行和第二行差1
        for (int i = 1; i <= num; i++) {//行的循环次数
            int x = y;//第i行的第一个数就是列的第i个数
            int xCount = i + 1; //可以看到第i行第一个加数刚好是i+1
            for (int j = 1; j <= num - i + 1; j++) { //列的循环次数，每次少一列
                System.out.print(x + " ");//循环输出x
                x += xCount++;    //等差数列每次+1
            }
            System.out.println("");//换行
            y += yCount++; //等差数列每次加1
        }
    }
}
