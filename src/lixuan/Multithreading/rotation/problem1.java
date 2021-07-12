package lixuan.Multithreading.rotation;

/**
 * 三个线程交替打印ABC
 * 使用synchronize+变量
 */
public class problem1 {
    private static volatile int order=1;
    private static Object lock=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                for (int i=0;i<10;i++){
                    while (order!=1){
                        try {
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    lock.notifyAll();
                    order=2;
                }
                lock.notifyAll();
            }
        },"threadA").start();

        new Thread(()->{
            synchronized (lock){
                for (int i=0;i<10;i++){
                    while (order!=2){
                        try {
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    lock.notifyAll();
                    order=3;
                }
                lock.notifyAll();
            }
        },"threadB").start();

        new Thread(()->{
            synchronized (lock){
                for (int i=0;i<10;i++){
                    while (order!=3){
                        try {
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    lock.notifyAll();
                    order=1;
                }
                lock.notifyAll();
            }
        },"threadC").start();

    }



}


