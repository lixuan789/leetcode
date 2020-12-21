package lixuan.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code349Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums1) {
            if (!count.containsKey(num)) {
                count.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (count.containsKey(num)&&count.get(num) == 1) {
                res.add(num);
                count.put(num, 0);
            }
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }
}
