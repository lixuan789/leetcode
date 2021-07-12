package lixuan.test.test5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    //在微博中，一个用户可以关注另一个用户，userA关注userB表示为如下的结构体：
    class Record {
        // 表示userA关注userB
        String userA;
        String userB;
    };
    class Result {
        String maxFollow;       // 关注最多的人
        String maxFollowed;   // 被关注最多的人
    };

    /*现在给定一个关注关系的数组（vecRecords），
    请找出一个用户：该用户关注的人最多
    请找出一个用户：该用户被最多的人关注，方法声明如下*/
    public Result getTopUser(final List<Record> vecRecords) {
        HashMap<String, Set<String>> A2B=new HashMap<>();
        HashMap<String, Set<String>> B2A=new HashMap<>();
        for (Record record:vecRecords){
            if (!A2B.containsKey(record.userA)){
                A2B.put(record.userA,new HashSet<>());
            }
            Set<String> set = A2B.get(record.userA);
            set.add(record.userB);
            A2B.put(record.userA,set);

            if (!B2A.containsKey(record.userB)){
                B2A.put(record.userB,new HashSet<>());
            }
            Set<String> set1 = B2A.get(record.userB);
            set.add(record.userA);
            B2A.put(record.userB,set1);
        }
        Result res = new Result();
        int max=0;
        for (String key:A2B.keySet()){
            if (max<A2B.get(key).size()){
                res.maxFollow=key;
                max=A2B.get(key).size();
            }
        }
        max=0;
        for (String key:B2A.keySet()){
            if (max<B2A.get(key).size()){
                res.maxFollowed=key;
                max=B2A.get(key).size();
            }
        }
        return res;
    }
}
