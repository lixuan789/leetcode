package lixuan.DataStructure.hashtable;

import java.util.HashMap;

public class Code1TwoSum {
    /**
     * 用 HashMap 存储数组元素和索引的映射，在访问到 nums[i] 时，
     * 判断 HashMap 中是否存在 target - nums[i]，
     * 如果存在说明 target - nums[i] 所在的索引和 i 就是要找的两个数。
     * 该方法的时间复杂度为 O(N)，空间复杂度为 O(N)，使用空间来换取时间。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[]{indexForNum.get(target - nums[i]), i};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
    }
}
