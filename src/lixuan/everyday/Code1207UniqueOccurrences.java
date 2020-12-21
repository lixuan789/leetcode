package lixuan.everyday;

import java.util.HashMap;
import java.util.HashSet;

public class Code1207UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int n = count.size();
        HashSet<Integer> set = new HashSet<>();
        for (int key : count.keySet()) {
            set.add(count.get(key));
        }
        return n == set.size();
    }
}
