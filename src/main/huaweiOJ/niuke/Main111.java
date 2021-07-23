/**
 * @Author: zhanglin
 * @Date: 2021/5/29
 * @Time: 7:37 PM
 * 5,4,3,2,2,2,1,2,6,7,5
 * 4 3 2 1 1 2 1 2 3 4 1
 * 24
 */

import java.util.Scanner;

public class Main111 {
    // 1234443214
    // 1234143212
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str == null || str.isEmpty()) {
                System.out.println("");
                continue;
            }
            String[] arr = str.split(",");
            int[] scores = new int[arr.length];
            scores[0] = 1;
            for (int i = 0; i < arr.length - 1; i++) {
                int score = Integer.valueOf(arr[i]);
                int next = Integer.valueOf(arr[i + 1]);
                if (next > score) {
                    scores[i + 1] = scores[i] + 1;
                } else {
                    scores[i + 1] = 1;
                }
            }
            for (int i = arr.length - 1; i > 0; i--) {
                int score = Integer.valueOf(arr[i]);
                int prev = Integer.valueOf(arr[i - 1]);
                if (prev > score && scores[i - 1] <= scores[i]) {
                    scores[i - 1] = scores[i] + 1;
                }
            }
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
