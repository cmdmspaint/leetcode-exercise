import java.util.Scanner;

/**
 * @Author: zhanglin
 * @Date: 2021/5/25
 * @Time: 11:58 AM
 *
 * 密码验证合格程序
 * 题目描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有相同长度大于2的子串重复
 *
 * 输入描述:
 * 一组或多组长度超过2的字符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入
 * 复制
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * 复制
 * OK
 * NG
 * NG
 * OK
 */
public class Main20 {
    // 1.长度超过8位
    public static boolean checkLength(String password) {
        return password != null && password.length() > 8;
    }

    // 2.包括大小写字母.数字.其它符号,以上四种至少三种
    public static boolean checkCharKinds(String password) {
        int digit = 0, lowercase = 0, uppercase = 0, others = 0;
        char[] ch = password.toCharArray();
        for (char aCh : ch) {
            if (aCh >= '0' && aCh <= '9') {
                digit = 1;
            } else if (aCh >= 'a' && aCh <= 'z') {
                lowercase = 1;
            } else if (aCh >= 'A' && aCh <= 'Z') {
                uppercase = 1;
            } else {
                others = 1;
            }
        }
        int total = digit + lowercase + uppercase + others;
        return total >= 3;
    }

    // 3.不能有相同长度超2的子串重复
    public static boolean checkCharRepeat(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String substr1 = password.substring(i, i + 3);
            if (password.substring(i + 1).contains(substr1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String psw = sc.nextLine();
            if (checkLength(psw) && checkCharKinds(psw) && checkCharRepeat(psw)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}
