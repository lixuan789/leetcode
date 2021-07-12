package lixuan.test.test5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {
    /*一个数组vec中存放大量坐标点，从vec中找出离目标点e最近的k个点。坐标点用结构体Coord表示。
    请实现该算法，原型如下*/
    class Coord {
        int x;
        int y;
    }

    ;

    public List<Coord> getNearestCoord(List<Coord> vec, Coord e, int k) {
        Collections.sort(vec, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                if (dist(o1, e) < dist(o2, e)) {
                    return -1;
                } else if (dist(o1, e) == dist(o2, e)) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        List<Coord> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(vec.get(i));
        }
        return res;
    }

    private double dist(Coord o, Coord e) {
        return Math.sqrt(Math.pow(o.x - e.x, 2) + Math.pow(o.y - e.y, 2));
    }
}
