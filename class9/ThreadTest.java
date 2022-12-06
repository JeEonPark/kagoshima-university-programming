package class9;

public class ThreadTest {
    public class TimeThread extends Thread {
        private String name;
        private int sec;
        private int cnt;

        public TimeThread(String n, int s) {
            name = n;
            sec = s;
            cnt = 0;
        }

        public void run() {
            System.out.println(name + "開始");
            while (cnt < 10) {
                try {
                    sleep(sec * 1000);
                } catch (Exception e) {
                }
                cnt++;
                System.out.println(name + ": " + cnt + "回目(" + (sec * cnt) + "秒)");
            }
            System.out.println(name + "終了");
        }
    }

    public void exec() {
        System.out.println("メインスレッド開始");
        (new TimeThread("スレッド1", 1)).start();
        (new TimeThread("スレッド2", 2)).start();
        (new TimeThread("スレッド3", 3)).start();
        System.out.println("メインスレッド終了");
    }

    public static void main(String[] args) {
        (new ThreadTest()).exec();
    }
}