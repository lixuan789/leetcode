package lixuan.sort;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class Code451frequencySort {
    /**
     * 方法一：使用桶排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character key : map.keySet()) {
            Integer count = map.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(key);
        }
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (int j = 0; j < buckets[i].size(); j++) {
                for (int k = 0; k < i; k++) {
                    res.append(buckets[i].get(j));
                }
            }
        }
        return res.toString();
    }

    /**
     * 方法二：使用最大堆
     * @param s
     * @return
     */
    public String frequencySort1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> maxQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });//按字符的评率进行排序
        for (Character key : map.keySet()) {
            maxQueue.add(key);
        }
        while (!maxQueue.isEmpty()){
            Character key = maxQueue.poll();
            Integer count = map.get(key);
            for (int i=0;i<count;i++){
                res.append(key);
            }
        }
        return res.toString();
    }
}
