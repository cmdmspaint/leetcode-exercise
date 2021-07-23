package huawei;

public final class Demo {

    // ���ܣ���ȡ�������������Լ��
    // ���룺��������
    // ���أ����Լ��
    public static long getMaxDivisor(long m, long n) {
        // ��֤��һ������С�ڵڶ�����
        if (m < n) {
            getMaxDivisor(n, m);
        }

        long t;

        while (m % n != 0) {
            t = n;
            n = m % n;
            m = t;
        }


        return n;
    }

    // ���ܣ���ȡ������������С������
    // ���룺��������
    // ���أ���С������
    public static long getMinMultiple(long m, long n) {

        return m / getMaxDivisor(m, n) * n;
    }

}