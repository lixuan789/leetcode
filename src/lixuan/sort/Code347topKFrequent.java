package lixuan.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class Code347topKFrequent {
    /**
     * 方法一：桶排序
     * 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，
     * 即第 i 个桶中存储的数出现的频率为 i。
     * <p>
     * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer key : map.keySet()) {
            int frenquency = map.get(key);
            if (buckets[frenquency] == null) {
                buckets[frenquency] = new ArrayList<>();
            }
            buckets[frenquency].add(key);
        }
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - res.size())) {
                res.addAll(buckets[i]);
            } else {
                res.addAll(buckets[i].subList(0, k - res.size()));
            }

        }
        return res;
    }

    /**
     * 方法二：使用最小堆
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });//最小堆
        for (Integer key : map.keySet()) {
            minQueue.add(key);
            if (minQueue.size() > k) {
                minQueue.poll();
            }
        }
        while (!minQueue.isEmpty()) {
            Integer key = minQueue.poll();
            res.add(key);
        }
        Collections.reverse(res);
        return res;
    }

}
