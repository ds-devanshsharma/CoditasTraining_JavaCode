package coreJAVA.Day_18_MultiThreading;
class MTRunnable implements Runnable{
    public void run(){
        for(int i=0;i<3 ;i++) {
            System.out.println("THREAD : "+ Thread.currentThread().getName() +" Priority : "+Thread.currentThread().getPriority());
        }
    }
}
public class MTRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        MTRunnable thread  = new MTRunnable();
        Thread thread1 = new Thread(thread);
        Thread thread11 = new Thread(thread);
        thread1.setName("One ");
        thread1.setPriority(Thread.MIN_PRIORITY);

        thread1.sleep(3000);
        thread1.start();
        thread1.join();
        thread11.start();

    }
}
/*
        thread1.setName("One ");
        thread1.setPriority(Thread.MIN_PRIORITY);

        thread1.sleep(3000);
        thread1.start();
        thread1.join();
        thread11.start();
THREAD : One  Priority : 1
THREAD : One  Priority : 1
THREAD : One  Priority : 1
THREAD : Thread-1 Priority : 5
THREAD : Thread-1 Priority : 5
THREAD : Thread-1 Priority : 5
 */
