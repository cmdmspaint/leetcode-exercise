package hellozepp.string;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: “Let’s take LeetCode contest”
 * 输出: “s’teL ekat edoCteeL tsetnoc”
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Solution557 {
    private char[] mychar;

    /**
     * 解法2：使用indexOf函数：这个函数的作用有一个string.indexOf(char,index)就是在位置index开始，string查找第一个char的索引位置
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        mychar = s.toCharArray();
        int begin = 0;
        int end;
        while (begin < mychar.length) {
            end = s.indexOf(' ', begin + 1);
            if (end == -1) {
                end = mychar.length;
            }
            reverse(begin, end - 1);
            begin = end + 1;
        }
        return String.copyValueOf(mychar);
    }

    private void reverse(int i, int j) {
        while (i < j) {
            char tmp = mychar[i];
            mychar[i] = mychar[j];
            mychar[j] = tmp;
            i++;
            j--;
        }
    }

    //-----------------------------
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        s = "";
        for (int i = 0; i < strings.length - 1; i++) {
            s = s + new StringBuffer(strings[i]).reverse().toString() + " ";
        }
        return s + new StringBuffer(strings[strings.length - 1]).reverse().toString();
    }
}