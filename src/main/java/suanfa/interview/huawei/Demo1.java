package suanfa.interview.huawei;

import java.io.FileNotFoundException;

public final class Demo1 {

	/*
	001-4415-重复的电话号码（Java）
	功能: 检查是否有两个或多个公司拥有相同的电话号码,并统计输出

	输入参数: inFileName  - 包含个性电话号码个数与列表的源文件名      [格式请见题目说明PPT]
	        outFileName - 输出统计重复号码的结果的目标文件名                  [格式请见题目说明PPT]

	返回: 0 - 成功
	        1 - 其它各种错误，如文件不存在
	*/

    public static int phoneBookProcess(String inFileName, String outFileName) throws FileNotFoundException {
//        File file = new File(inFileName);
//        FileInputStream fis = new FileInputStream(file);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
//        if (freopen(inFileName, "r", stdin) == null)
//            return 1;
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFileName))));
//        if (freopen(outFileName, "w", stdout) == null)
//            return 1;
//    /*1.映射关系,可以优化成
//    char hsm[]="222333444555666777888999"*/
//        int hsm[ 26];
//        hsm[0] = 2;
//        hsm[1] = 2;
//        hsm[2] = 2;
//        hsm[3] = 3;
//        hsm[4] = 3;
//        hsm[5] = 3;
//        hsm[6] = 4;
//        hsm[7] = 4;
//        hsm[8] = 4;
//        hsm[9] = 5;
//        hsm[10] = 5;
//        hsm[11] = 5;
//        hsm[12] = 6;
//        hsm[13] = 6;
//        hsm[14] = 6;
//        hsm[15] = 7;
//        hsm[16] = 7;
//        hsm[17] = 7;
//        hsm[18] = 7;
//        hsm[19] = 8;
//        hsm[20] = 8;
//        hsm[21] = 8;
//        hsm[22] = 9;
//        hsm[23] = 9;
//        hsm[24] = 9;
//        hsm[25] = 9;
//        int n;
//        int cas = 0;
//
//        char str[ 50];
//        scanf("%d", & n);
//
//        /**/
//        map<int, int> m;
//        map<int, int>::iterator it;
//        bool flag = false;
//
//        for (cas = 0; cas < n; cas++) {
//            scanf("%s", str);
//            int num = 0;
//            int len = strlen(str);
//            /*将字符串转换成电话号码*/
//            for (int i = 0; i < len; i++) {
//                if (str[i] >= '0' && str[i] <= '9')
//                    num = num * 10 + str[i] - '0';
//                else if (str[i] >= 'A' && str[i] <= 'Z')
//                    num = num * 10 + hsm[str[i] - 'A'];  /*对应关系*/
//                else if (str[i] >= 'a' && str[i] <= 'z')
//                    num = num * 10 + hsm[str[i] - 'a'];
//            }
//            if (num == 0)
//                continue;
//            m[num]++;
//        }
//        /**/
//        for (it = m.begin(); it != m.end(); it++) {
//            if (it -> second > 1)
//                flag = true;
//        }
//        if (flag == false)
//            printf("No duplicates.\n");
//        else {
//            for (it = m.begin(); it != m.end(); it++) {
//                if (it -> second > 1)
//                    printf("%d %d\n", it -> first, it -> second);
//            }
//        }
//
//        fclose(stdin);
//        fclose(stdout);
//
//        return 0;
        return 1;
    }
}


