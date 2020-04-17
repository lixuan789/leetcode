package lixuan.DataStructure.arrayandmatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code697FindShortestSubArray {
    /**
     * 桶排序,以元素的个数来排序，得到最大频率的元素，然后遍历每个元素的最短连续子数组的长度
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[n + 1];
        for (int num : nums) {
            int cnt = count.get(num);
            if (buckets[cnt] == null) {
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(num);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = n; j >= 0; j--) {
            if (buckets[j] != null) {
                res.addAll(buckets[j]);
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            int temp = res.get(i);
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] == temp && nums[hi] == temp) {
                    break;
                }
                if (nums[lo] != temp) {
                    lo++;
                }
                if (nums[hi] != temp) {
                    hi--;
                }
            }
            int len = (hi - lo) + 1;
            min = Math.min(min, len);
        }
        return min;
    }

    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> numsCnt = new HashMap<>();
        Map<Integer, Integer> numsLastIndex = new HashMap<>();
        Map<Integer, Integer> numsFirstIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            numsLastIndex.put(num, i);
            if (!numsFirstIndex.containsKey(num)) {
                numsFirstIndex.put(num, i);
            }
        }
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numsCnt.get(num));
        }
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numsCnt.get(num);
            if (cnt != maxCnt) continue;
            ret = Math.min(ret, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
        }
        return ret;
    }
}
