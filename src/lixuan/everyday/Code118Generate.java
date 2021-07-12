package lixuan.everyday;

import java.util.ArrayList;
import java.util.List;

public class Code118Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows <= 0) {
            return ans;
        }
        List<Integer> pre = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                if (pre != null) {
                    int num = pre.get(j) + pre.get(j - 1);
                    list.add(num);
                }
            }
            if (i > 0) {
                list.add(1);
            }
            ans.add(list);
            pre = list;
        }
        return ans;
    }
}
