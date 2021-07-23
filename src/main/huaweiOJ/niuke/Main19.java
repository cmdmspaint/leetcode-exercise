import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 3、 输入的文件可能带路径，记录文件名称不能带路径。
 输入描述:一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 输出描述:将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 输入例子:E:\V1R2\product\fpgadrive.c   1325
 输出例子:fpgadrive.c 1325 1
 * @author WGS
 */
public class Main19 {

    private static void recordingErrorLogs(Map<String, Integer> map, String fileLocation, int lineNum) {
        //input[0]文件路径:E:\V1R2\product\fpgadrive.c   input[1]行号:1325
        //1 获取文件名，超过长度16的截取
        String[] arr = fileLocation.split("\\\\");//分解：>>E:  \\   V1R2 \\  product  \\  fpgadrive.c
        String fileName = arr[arr.length - 1];
        if (fileName.length() > 16) {
            fileName = fileName.substring(fileName.length() - 16);
        }

        //2  将文件路径和行号连接为字符串，作为map的key键值
        String inputStr = fileName + " " + lineNum;

        //3 验证：对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
        if (map.containsKey(inputStr)) {
            map.put(inputStr, map.get(inputStr) + 1);
        } else {
            //没有重复的，次数就设置为1
            map.put(inputStr, 1);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //不需要排序，所以使用LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String fileLocation = sc.next();
            int lineNum = sc.nextInt();
            //输一条信息，记录一条
            recordingErrorLogs(map, fileLocation, lineNum);
        }
        //遍历map的key键值（含有文件+行号信息），输出最后的八条记录；
        int count = 0;
        for (String s : map.keySet()) {
            ++count;
            //从倒数第八条开始遍历
            if (count > map.size() - 8) {
                System.out.println(s + " " + map.get(s));//文件路径行号+个数
            }
        }
        sc.close();
    }
}