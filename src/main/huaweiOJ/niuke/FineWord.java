/**
 * 单词接龙
 * 先给了k和n两个数字，表示接龙从第k个字符串开始，共有n个字符串，然后给了n个字符串，接龙就是后一个字符串的首字母和前一个字符串的尾字母要一样，
 * 如果有多个可以接上，选长度最长的，如果长度相同，按字典序，输出接好的字符串，每个字符串只能用一次。
 * 这个我是用list存字符串，用过后从list中删除，每次把可以接上的也存到另一个list,我记作appendList,这个我用的是循环做的，stream api更方便，
 * 然后用Collections.sort排序，要自己写一个Comparator接口，
 * 排在第一位的就是要接在后面的。这个一次就全部AC了。
 */
public class FineWord {
}