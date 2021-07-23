package hellozepp.string;

/**
 *
 * 求2个数字为字符串的 乘法
 *示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 我的思路
 * 两个数相乘的时候，最后得到的积位数绝对不会超过这两个数的位数和
 *
 * 假设A数有m位，B数有n位，两数相乘得到C的位数为m+n，那么使用m+n的int数组存放每一位相乘的结果，
 * 当然数组中的每一位都不一定是个位数，所以最后用一个循环把这个数组中的数字循环一边，逐个进位，最后得到结果
 * 如果采用这种思路的话，自己就需要手动处理一些首位为0的情况
 *
 * 难度2.5星
 *
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        int n1Len = num1.length(), n2Len = num2.length();
        int[] pos = new int[n1Len + n2Len];

        for (int i = n1Len - 1; i >= 0; i--) {
            for (int j = n2Len - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;  //关键
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : pos) {
            if (sb.length() == 0 && n == 0) {
                continue;
            }
            sb.append(n);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("123", "456"));
        System.out.println(new Solution43().multiply("999", "0"));
        System.out.println(new Solution43().multiply("100", "1"));
    }
}