import java.util.ArrayList;
import java.util.Scanner;

public class 堆积木 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<Integer>[] als = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            als[i] = new ArrayList<Integer>();
            als[i].add(i);
        }
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = scan.nextInt();//记录a位置
            arr[i][1] = scan.nextInt();//记录b位置
        }
        for (int i = 0; i < m; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            if (a != b) {
                als[a].addAll(als[b]);//把b位置的所有元素给a位置
                als[b].clear();
            }

        }
        //System.out.println("==================================");
        for (int k = 1; k <= n; k++) {//输出所有的位置上的元素
            for (int j = 0; j < als[k].size(); j++) {
                System.out.print(als[k].get(j));
                if (j != als[k].size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}