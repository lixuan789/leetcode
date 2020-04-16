package lixuan.DataStructure.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 要求时间复杂度为O（n）
 */
public class Code128LongestConsecutive {
    /**
     * 判断一个数是否存在，哈希表的时间复杂度为o(1)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {//连续序列的起点
                int cur = num;
                int len = 1;
                while (set.contains(cur + 1)) {
                    len++;
                    cur++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
