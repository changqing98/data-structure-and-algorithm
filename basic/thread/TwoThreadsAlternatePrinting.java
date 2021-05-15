public class TwoThreadsAlternatePrinting {

    private volatile static int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    while (flag == 1) {
                    }
                    System.out.println("A");
                    flag = 1;
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    while (flag == 0) {
                    }
                    System.out.println("B");
                    flag = 0;
                }
            };
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}