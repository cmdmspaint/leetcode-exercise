import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入描述:
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 *
 * 输出描述:
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 * 输入：
 *
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 *
 * 输出：
 *
 * 1 0 1 0 0 2 1
 */
public class Main18 {
    private static int a = 0; // A类IP
    private static int b = 0; // B类IP
    private static int c = 0; // C类IP
    private static int d = 0; // D类IP
    private static int e = 0; // E类IP
    private static int error = 0; // 错误IP
    private static int pri = 0; // 私有IP

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.next();
            checkIp(s);
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + error + " " + pri);
        scanner.close();

    }

    private static void checkIp(String s) {
        String[] str = s.split("~");
        String ip = str[0];
        String mask = str[1];
        if (!ip.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")) {
            error++;
            return;
        }
        String[] ipParts = ip.split("\\.");
        String[] maskParts = mask.split("\\.");

        int[] ipInts = new int[4];
        int[] maskInts = new int[4];
        StringBuilder temp = new StringBuilder();
        try {
            // 将IP解析成数字
            for (int i = 0; i < 4; i++) {
                ipInts[i] = Integer.parseInt(ipParts[i]);
                maskInts[i] = Integer.parseInt(maskParts[i]);
                if (ipInts[i] > 255 || ipInts[i] < 0 || maskInts[i] > 255 || maskInts[i] < 0) {
                    error++;
                    return;
                }
            }

            // 将掩码转成二进制格式
            for (String maskPart : maskParts) {
                BigInteger bi = new BigInteger(maskPart);
                temp.append(bi.toString(2));
            }

            // 找掩码二进制格式中的第一个0位置
            int index = temp.indexOf("0");
            temp = new StringBuilder(temp.substring(index + 1));
        } catch (Exception e) {
            error++;
            return;
        }


        // 掩码中，第一个0后如果有1说明掩码不合法
        if (temp.toString().contains("1")) {
            error++;
            return;
        }


        if (ipInts[0] >= 1 && ipInts[0] <= 126) {
            a++;
        }

        if (ipInts[0] >= 128 && ipInts[0] <= 191) {
            b++;
        }

        if (ipInts[0] >= 192 && ipInts[0] <= 223) {
            c++;
        }

        if (ipInts[0] >= 224 && ipInts[0] <= 239) {
            d++;
        }
        if (ipInts[0] >= 240 && ipInts[0] <= 255) {
            e++;
        }

        if (ipInts[0] == 10) {
            pri++;
        }

        if (ipInts[0] == 172 && ipInts[1] >= 16 && ipInts[1] <= 31) {
            pri++;
        }

        if (ipInts[0] == 192 && ipInts[1] == 168) {
            pri++;
        }

    }

}