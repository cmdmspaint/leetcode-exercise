package huawei;


public final class Demo {

    /*
    ����:

    ����:

    ���:	����n!���ж��ٸ�0

    ����:

    */
    public static int getZeroCount(int n) {

        if (n < 5) {
            return 0;
        }

        int rs = 0;

        while (n != 0) {
            n /= 5;
            rs += n;
        }

        return rs;
    }
}


