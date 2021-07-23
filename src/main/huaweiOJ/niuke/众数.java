import java.util.Collections;
import java.util.List;

/**
 * @Author: zhanglin
 * @Date: 2021/5/29
 * @Time: 3:39 PM
 * 求众数(Java)
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 */
public class 众数 {
    public int majorityElement(int[] num) {

        int major = num[0], count = 1;//major:主要的 投票最多的获胜
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) count++;
            else count--;

        }
        return major;
    }

    /**
     * 中位数
     * @param total
     * @return
     */
    private static double median(List<Integer> total) {
        double j = 0;
        //集合排序
        Collections.sort(total);
        int size = total.size();
        if (size % 2 == 1) {
            j = total.get((size - 1) / 2);
        } else {
            //加0.0是为了把int转成double类型，否则除以2会算错
            j = (total.get(size / 2 - 1) + total.get(size / 2) + 0.0) / 2;
        }
        return j;
    }
}
