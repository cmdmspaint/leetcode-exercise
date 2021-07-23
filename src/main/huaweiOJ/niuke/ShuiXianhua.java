import java.util.Scanner;

/**
 * 输出水仙花数，所谓的水仙花数是指一个3位数，其各个位数立方和等于其本身： 例如： 153=1*1*1+3*3*3+5*5*5
 *
 * @author 奋斗蒙
 *

 */

public class ShuiXianhua {

    public static void main(String[] args) {
        System.out.println("以下是所有的水仙花数");
        // 由于水仙花数是三位数，所以从100算起。
        int number = 100;
        int i, j, k; // ijk分别为number的百位，十位，个位
        for (int sum = 0; number < 1000; number++) {
            i = number / 100; // 求得百位数
            j = (number - i * 100) / 10; // 求得十位数
            k = (number - i * 100 - j * 10); // 求得个位数
            // sum就是number水仙花数的值
            sum = i * i * i + j * j * j + k * k * k;
            if (sum == number) {
                System.out.println(number + "这个是水仙花数！");
            }
        }
    }

    /*

     * 知识扩展

     * 输入显示的水仙花位数，显示所有水仙花数

     */

    public static void main1(String[] agrs) {

        System.out.print("指定最大位数N:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        for (int i = 3; i <= n; i++) {

            int a[] = new int[i];

            int num = (int) Math.pow(10, i - 1) + 1;

            System.out.print(i + "位的水仙花数有：\t");

            while (num <= Math.pow(10, i)) {
                int sum = 0;
                for (int j = 0; j < i; j++) {
                    a[j] = (int) (num / Math.pow(10, j) % 10);
                }
                for (int j = 0; j < i; j++) {
                    sum = sum + (int) Math.pow(a[j], i);
                }
                if (num == sum) {
                    System.out.print(num + "\t");
                }
                num++;
            }
            System.out.print("\n");
        }

    }

}