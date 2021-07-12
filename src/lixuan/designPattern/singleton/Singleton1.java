package lixuan.designPattern.singleton;

/**
 * 饿汉式线程安全
 *
 */
public class Singleton1 {
    private Singleton1(){}//构造器私有
    private static Singleton1 single=new Singleton1();//类初始化时就立即加载对象
    public static Singleton1 getInstance(){
        return single;
    }
}
