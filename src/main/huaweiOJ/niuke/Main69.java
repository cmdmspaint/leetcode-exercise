import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/28
 * @Time: 8:56 PM
 * 矩阵乘法
 */
public class Main69 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            //获取行,列信息
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            int[][] first = new int[x][y];
            int[][] second = new int[y][z];
            int[][] res = new int[x][z];
            //将数组存储在数组中
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    first[i][j] = scan.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    second[i][j] = scan.nextInt();
                }
            }
            //对数组进行计算
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    for (int k = 0; k < y; k++) {
                        res[i][j] += first[i][k] * second[k][j];
                    }
                }
            }
            //按照格式输出
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}