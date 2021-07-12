package lixuan.Multithreading.rotation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印ABC
 * 使用ReentrantLock
 */
public class problem2 {
    private static ReentrantLock lock=new ReentrantLock();
    private static Condition a=lock.newCondition();
    private static Condition b=lock.newCondition();
    private static Condition c=lock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                lock.lock();
                for (int i=0;i<10;i++){
                    System.out.println("A");
                    b.signal();
                    a.await();
                }
                b.signal();
            }catch (InterruptedException e){

            } finally {
                lock.unlock();
            }

        },"threadA").start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }

        new Thread(()->{
            try {
                lock.lock();
                for (int i=0;i<10;i++){
                    System.out.println("B");
                    c.signal();
                    b.await();
                }
                c.signal();
            }catch (InterruptedException e){

            }finally {
                lock.unlock();
            }

        },"threadB").start();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }

        new Thread(()->{
            try {
                lock.lock();
                for (int i=0;i<10;i++){
                    System.out.println("C");
                    a.signal();
                    c.await();
                }
                a.signal();
            }catch (InterruptedException e){

            }finally {
                lock.unlock();
            }

        },"threadC").start();

    }



}


