package lixuan.test.test5;

import java.util.*;

public class Main1 {
    //A和B号码包都是亿级的号码包文件,  文件A和文件B中的号码全为QQ号，号码包文件一行一个QQ号， A和B号码包是有重叠的，请找出A，B两个号码包中重叠的QQ号。
    /*public List<String> getTheSameQQ(final List<String> vecA, final List<String> vecB) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        set.addAll(vecA);
        for (String qq : vecB) {
            if (set.contains(qq)) {
                res.add(qq);
            }
        }
        return res;
    }*/

    public List<String> getTheSameQQ(final List<String> vecA, final List<String> vecB) {
        Set<String>[] table=new Set[100];
        for (int i=0;i<100;i++){
            table[i]=new HashSet<>();
        }
        for (String qq:vecA){
            int index=qq.hashCode()%100;
            table[index].add(qq);
        }
        List<String> res = new ArrayList<>();
        for (String qq:vecB){
            int index=qq.hashCode()%100;
            if (table[index].contains(qq)){
                res.add(qq);
            }else {
                table[index].add(qq);
            }
        }
        return res;
    }
}
