package huawei;

import java.util.Arrays;
import java.util.Comparator;

public final class Demo {

    // ���ܣ������������飬����Ԫ�ذ�����������������
    // ���룺arr ��Ҫ�������������
    //       flag 0:���� 1������
    // ���أ�û���ظ����ֵ�����
    public static void sortArray(Integer[] arr, int flag) {
        if (arr == null || arr.length < 2 || flag < 0 || flag > 1) {
            return;
        }

        final int FACTOR = flag == 0 ? 1 : -1;


        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if (o1 == null) {
                    return -FACTOR;
                }

                if (o2 == null) {
                    return FACTOR;
                }

                return (o1 - o2) * FACTOR;
            }
        });

    }
}