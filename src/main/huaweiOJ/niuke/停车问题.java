import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/29
 * @Time: 1:33 PM
 *
 * 1.停车问题
 * 1,0,1,1,0,1,1,1表示停车位的情况，1表示有车，0表示空位，有三种车，分别占1,2,3个宽度的车位，求最少有几辆车，像上面这种情况，就是3辆车。
 * 我是遍历一次，看连续有几个1，用1的个数除以3，累加到sum,如果有余数，sum++,感觉思路没有问题，不知道哪里不对，测试用例通过95.46%。
 */
public class 停车问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("0");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int ser = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ser++;
                int big = ser / 3;
                int middle = ser % 3 / 2;
                int small = ser % 3 % 2;
                sum += big + middle + small;
            } else {
                ser = 0;
            }
        }
        System.out.println(sum);
    }
}
