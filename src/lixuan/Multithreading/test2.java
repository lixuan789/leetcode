package lixuan.Multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock
 */
public class test2 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i=0;i<10;i++){
                        System.out.println(Thread.currentThread().getName()+""+i);
                        conditionB.signal();
                        conditionA.await();
                    }
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        },"A").start();
        Thread.sleep(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i=0;i<10;i++){
                        System.out.println(Thread.currentThread().getName()+""+i);
                        conditionA.signal();
                        conditionB.await();
                    }
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        },"B").start();
    }
}
