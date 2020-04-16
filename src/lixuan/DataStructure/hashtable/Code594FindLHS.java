package lixuan.DataStructure.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 */
public class Code594FindLHS {
    /**
     * 相邻两个数最多的个数
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre=nums[i]-1;
            if(count.containsKey(pre)){
                res=Math.max(res,count.get(nums[i])+count.get(pre));
            }
            int r=nums[i]+1;
            if(count.containsKey(r)){
                res=Math.max(res,count.get(nums[i])+count.get(r));
            }
        }
        return res;
    }

    /**
     * 简化：只需判断一次就可以了
     * @param nums
     * @return
     */
    public int findLHS1(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }
}
