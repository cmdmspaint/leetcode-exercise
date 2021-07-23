package huawei;

public final class Demo {
    /*
    ����: ���M��N�η��������λ��(M��N������10)
	���������
	    int M��M > 10
	    int N��N > 10
	����ֵ��
	    M��N�η��������λ��
	*/

    public static int getLast3DigitsOfMN(int M, int N) {

        if (M <= 10 || N <= 10) {
            throw new IllegalArgumentException();
        }

        int rs = 1;

        for (int i = 0; i < N; i++) {
            rs *= (M % 1000);
            rs %= 1000;

        }

        return rs;
    }

}


