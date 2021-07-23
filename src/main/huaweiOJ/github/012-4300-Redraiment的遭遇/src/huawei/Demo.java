package huawei;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/*
���������

		int Month��������Redraiment���ҵ�������
		int Day��������Redraiment���ҵ�����
���������
		��
����ֵ��
		int  ������Redraiment���Һ�����ͣ���������
*/
public class Demo {

    // �߰���ͣ�����
    private static boolean[] UNDOWN = new boolean[62];

    static {
        for (int i = 0, count = 0; i < UNDOWN.length; ) {
            UNDOWN[i] = false; // ͣ��
            count++;
            i++;
            // δͣ��
            for (int j = 0; i < UNDOWN.length && j < count; j++) {
                UNDOWN[i] = true;
                i++;
            }
        }
    }

    public int getDayNum(int month, int day) {

        if (month > 8) {
            return 0;
        }

        int beg = (month - 7) * 31 + (day - 1);

        beg = beg >= 0 ? beg : 0;

        int rs = 0;
        while (beg < UNDOWN.length) {
            if (!UNDOWN[beg]) {
                rs++;
            }
            beg++;
        }

        return rs;
    }
}
