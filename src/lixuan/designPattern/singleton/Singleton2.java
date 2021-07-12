package lixuan.designPattern.singleton;

/**
 * 懒汉式（双重检验锁）线程安全
 */
public class Singleton2 {
    private Singleton2(){}//构造器私有
    private static volatile Singleton2 single=null;

    /**
     * 运行时加载
     * @return
     */
    public static Singleton2 getInstance(){
        if (single==null){
            synchronized (Singleton2.class){
                if (single==null){
                    single=new Singleton2();
                }
            }
        }
        return single;
    }
}
