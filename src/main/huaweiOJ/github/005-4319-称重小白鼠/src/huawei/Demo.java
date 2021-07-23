package huawei;

import java.util.Arrays;
import java.util.Comparator;

public final class Demo {

    /*����������������ñ����ɫ
     * ������	5ֻС���������ֱ�Ϊ15 30 5 9 30��ñ����ɫ����ΪCL_RED, CL_BLUE, CL_BLUE, CL_YELLOW, CL_GRAY��
     * �������������ñ����ɫ����Ӧ��ΪCL_BLUE, CL_YELLOW, CL_RED, CL_BLUE, CL_GRAY��
        ���û��С�������null��
    ���������С��������

    */
    public static MOUSE_COLOR[] sortMouse(Mouse[] mouse) {

        if (mouse == null || mouse.length < 1) {
            return null;
        }

        Arrays.sort(mouse, new Comparator<Mouse>() {
            @Override
            public int compare(Mouse o1, Mouse o2) {
                if (o1 == null) {
                    return -1;
                }

                if (o2 == null) {
                    return 1;
                }

                return o1.weight - o2.weight;
            }
        });

        MOUSE_COLOR[] color = new MOUSE_COLOR[mouse.length];

        for (int i =0; i < mouse.length; i++) {
            if (mouse[i] != null) {
                color[i] = mouse[i].color;
            } else {
                color[i] = null;
            }
        }

        return color;
    }


}


