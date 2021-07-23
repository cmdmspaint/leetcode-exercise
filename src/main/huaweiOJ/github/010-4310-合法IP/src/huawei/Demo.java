package huawei;

public class Demo {
    /**
     * @param inputStr  �����ַ���
     * @param outputStr ����жϽ��
     * @description�� �����inputStr�ǺϷ���IP������YES�����򷵻�NO ʾ�� ���룺10.138.15.1 ���أ�YES
     */
    public void checkIP(String inputStr, StringBuffer outputStr) {

        if (inputStr == null || inputStr.length() < 1) {
            outputStr.delete(0, outputStr.length());
            outputStr.append("NO");
            return;
        }

        int beg = 0;
        int end = 0;
        // �ܼƴ���Ĳ���
        int count = 0;

        for (end = 1; end < inputStr.length();) {
            while (end < inputStr.length() && inputStr.charAt(end) != '.') {
                end++;
            }

            String part = inputStr.substring(beg, end);
            // ��ǰ������ǵڼ�������
            count++;

            if (!checkPart(part) || count > 4) {
                outputStr.delete(0, outputStr.length());
                outputStr.append("NO");
                return;
            }

            if (end < inputStr.length()) {
                beg = end + 1;
                end += 2;
            }
        }

        String part = inputStr.substring(beg);
//        if (!checkPart(part) || count != 4){
        if (!checkPart(part)){
            outputStr.delete(0, outputStr.length());
            outputStr.append("NO");
            return;
        }

        outputStr.delete(0, outputStr.length());
        outputStr.append("YES");
    }

    public boolean checkPart(String part) {
        if (part == null || part.length() < 1 || part.length() > 3) {
            return false;
        }

        int num = 0;
        for (int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);
            if (c > '9' || c < '0') {
                return false;
            } else {
                num = num * 10 + c - '0';
            }
        }

        return num < 256;
    }
}
