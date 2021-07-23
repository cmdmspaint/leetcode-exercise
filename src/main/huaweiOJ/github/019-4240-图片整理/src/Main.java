import java.util.Scanner;

/**
 * Author: ������
 * Date: 2016-01-17 19:49
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(sort(input));
        }

        scanner.close();
    }

    private static String sort(String s) {
        StringBuilder builder = new StringBuilder();
        int[] ints = new int[256];

        // ͳ��ÿ���ַ����ֵĴ���
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)]++;
        }

        // ��������ַ���
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i]; j++) {
                builder.append((char) i);
            }
        }

        return builder.toString();
    }


}
