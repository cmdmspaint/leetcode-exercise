import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhanglin
 * @Date: 2021/5/25
 * @Time: 9:57 PM
 */
public class Main49 {

    static class Task implements Runnable {
        public String output;

        public Task(String output) {
            this.output = output;
        }

        @Override
        public void run() {
            System.out.print(output);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService threadPoochedPol = Executors.newSingleThreadExecutor();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                threadPoochedPol.execute(new Task("A"));
                threadPoochedPol.execute(new Task("B"));
                threadPoochedPol.execute(new Task("C"));
                threadPoochedPol.execute(new Task("D"));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        threadPoochedPol.shutdown();
        scanner.close();
    }
}