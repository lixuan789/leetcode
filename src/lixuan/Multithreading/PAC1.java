package lixuan.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrontLock实现
 */
public class PAC1 {
    private static int count=0;//产品数量
    private static int FULL=10;//最大数量
    private ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty=lock.newCondition();//非空
    private final Condition notFull=lock.newCondition();//非满

    class Product implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                lock.lock();
                try{
                    while (count==FULL){
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产"+"目前产品数量"+count);
                    notEmpty.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                lock.lock();
                try{
                    while (count==0){
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费"+"目前产品数量"+count);
                    notFull.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        PAC1 test = new PAC1();
        for (int i=0;i<5;i++){
            new Thread(test.new Product()).start();
            new Thread(test.new Consumer()).start();
        }

    }

}
