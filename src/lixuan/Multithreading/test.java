package lixuan.Multithreading;

import java.util.concurrent.locks.LockSupport;

/**
 * 编写一个程序，开启三个线程，这三个线程的 ID 分别是 A、B 和 C，每个线程把自己的 ID 在屏幕上打印 10 遍，
 * 要求输出结果必须按 ABC 的顺序显示，如 ABCABCABC... 依次递推
 */
public class test {
    //使用LockSupport实现
    private static Thread threadA,threadB;

    public static void main(String[] args) throws InterruptedException {
        threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+""+i);
                    LockSupport.unpark(threadB);
                    LockSupport.park();
                }
            }
        },"A");
        threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    LockSupport.park();
                    System.out.println(Thread.currentThread().getName()+""+i);
                    LockSupport.unpark(threadA);
                }
            }
        },"B");
        threadA.start();
        Thread.sleep(1);
        threadB.start();
    }
}
