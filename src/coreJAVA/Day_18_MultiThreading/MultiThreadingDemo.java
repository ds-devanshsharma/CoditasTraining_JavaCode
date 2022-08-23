package coreJAVA.Day_18_MultiThreading;
class ThreadDemo extends  Thread{
    public void run(){
            for(int i=0 ; i<3;i++){
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread  ID :" + currentThread().getId() + " ThreadName : "+currentThread().getName()
            +"  Priority :"+ currentThread().getPriority());

//            System.out.println("Thread state : "+Thread.currentThread().getState());
            }
    }
}
public class MultiThreadingDemo {
    public static void main(String[] args) throws InterruptedException {
       ThreadDemo thread1 = new ThreadDemo();
       ThreadDemo thread2 = new ThreadDemo();
       ThreadDemo thread3 = new ThreadDemo();
       thread1.setName("One ");
       thread1.setPriority(Thread.MIN_PRIORITY);
               thread1.start();
               thread1.run();
              // thread1.join();
// join() is used to run that Thread first like giving that thread priority first among all
// this join() position matters alot
// this must be written just after starting that thread otherwise it will be effect-less
//       thread2.setName("Two ");
//// setDaemon() must be written before starting that Thread OtherWise IT WILL GIVE YOU IllegalThreadStateException
////       thread2.setDaemon(true);
//               thread2.start();
//
//       thread3.setName("Third ");
//       thread3.setPriority(Thread.MAX_PRIORITY);
//// sleep() must be written before starting any thread .
//               thread3.start();



//       System.out.println("Thread1 is alive or not ? "+thread1.isAlive());

//       System.out.println("Thread2 is alive or not ? "+thread2.isAlive());
        System.out.println("Last message : Thread "+thread1.currentThread().getName()+" "+thread1.getState()+"  Daemon thread : "+ thread1.isDaemon() );
//        System.out.println("Last message : "+thread2.getState()+ " " +thread2.isDaemon());
//        System.out.println("Last message : "+thread3.getState()+ " "+ thread3.isDaemon() );
    }
}
/*
Order of execution of Thread  is not guaranteed even after setting priorities of Thread
it only works One-Two time mostly.
---------------------------------------------
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
-----------------------------------------------------------
Thread1 is alive or not ? true
Thread2 is alive or not ? true
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :15 ThreadName : One   Priority :1
-----------------------------------------------------------
When we try to call run() explicitly then NO new thread run that time .that thread will be in NEW state
Thread  ID :1 ThreadName : main  Priority :5
Thread  ID :1 ThreadName : main  Priority :5
Thread  ID :1 ThreadName : main  Priority :5
Thread1 is alive or not ? false
Thread1 state : NEW
--------------------------------------------------------------------------------------
       thread1.setName("One ");
       thread1.setPriority(Thread.MIN_PRIORITY);
               thread1.start();
               thread1.join();
       thread2.setName("Two ");
               thread2.start();
Thread  ID :15 ThreadName : One   Priority :1
Thread state : RUNNABLE
Thread  ID :15 ThreadName : One   Priority :1
Thread state : RUNNABLE
Thread  ID :15 ThreadName : One   Priority :1
Thread state : RUNNABLE
Thread  ID :16 ThreadName : Two   Priority :5
Thread state : RUNNABLE
Thread  ID :16 ThreadName : Two   Priority :5
Thread state : RUNNABLE
Thread  ID :16 ThreadName : Two   Priority :5
Thread state : RUNNABLE
--------------------------------------------------------------------------------
       thread1.setName("One ");
       thread1.setPriority(Thread.MIN_PRIORITY);
               thread1.start();
// join() is used to run that Thread first like giving that thread priority first among all
               thread1.join();
       thread2.setName("Two ");
               thread2.start();

       thread3.setName("Third ");
       thread3.setPriority(Thread.MAX_PRIORITY);
               thread3.start();
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
-----------------------------------------------------------
setDaemon() || isDaemon()
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :17 ThreadName : Third   Priority :10
Last message : TERMINATED false
Last message : TERMINATED true
Last message : TERMINATED false
-----------------------------------------------------------
on using sleep() :
----------------
Last message : RUNNABLE false
Last message : TIMED_WAITING false
Last message : TIMED_WAITING false
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :16 ThreadName : Two   Priority :5
Thread  ID :15 ThreadName : One   Priority :1
Thread  ID :17 ThreadName : Third   Priority :10
Thread  ID :16 ThreadName : Two   Priority :5


 */