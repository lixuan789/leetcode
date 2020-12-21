package lixuan.everyday;

import java.util.HashMap;
import java.util.Map;

public class Code454FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = A[i] + B[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = -(C[i] + D[j]);
                if (map.containsKey(key)) {
                    ans += map.get(key);
                }
            }
        }
        return ans;
    }
}
