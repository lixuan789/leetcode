package lixuan.designPattern.singleton;

/**
 * 懒汉式线程不安全
 * 为了安全可加锁
 */
public class Singleton {
    private Singleton(){}//构造器私有
    private static Singleton single=null;

    /**
     * 运行时加载对象
     * @return
     */
    public static Singleton getInstance(){
        if (single==null){
            single=new Singleton();
        }
        return single;
    }
}
