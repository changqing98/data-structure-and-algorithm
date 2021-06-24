import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NThreadsAlternatePrinting {

    public static void main(String[] args) throws InterruptedException {
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Task(i));
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
        for (int i = 0; i < 10; i++) {
            thread[i].join();
        }
    }

    static class Task implements Runnable {

        private static final ReentrantLock lock = new ReentrantLock();
        private static final Condition cond = lock.newCondition();
        private static int count;
        private final int num;

        public Task(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (count >= 30) {
                    lock.unlock();
                    break;
                }
                if (count % 10 == num) {
                    System.out.println("Thread " + num + " ----> " + count);
                    count++;
                } else {
                    try {
                        cond.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                cond.signalAll();
                lock.unlock();
            }
        }
    }
}
