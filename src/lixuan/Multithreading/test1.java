package lixuan.Multithreading;

/**
 * 使用synchronized
 */
public class test1 {
    private static boolean stateA=true;
    private static boolean stateB=false;
    private static Object o=new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i=0;i<10;){
                        if (stateA){
                            stateA=false;
                            stateB=true;
                            System.out.println(Thread.currentThread().getName()+""+i);
                            o.notifyAll();
                            i++;
                        }else {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i=0;i<10;){
                        if (stateB){
                            stateA=true;
                            stateB=false;
                            System.out.println(Thread.currentThread().getName()+""+i);
                            o.notifyAll();
                            i++;
                        }else {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        },"B").start();
    }
}
