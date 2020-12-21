package lixuan.everyday;

public class Code1365SmallerNumbersThanCurrent {
    /**
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     * <p>
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     * <p>
     * 以数组形式返回答案
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[i] > nums[j]) {
                    num++;
                }
            }
            ans[i] = num;
        }
        return ans;
    }

    /**
     * 提示：
     * <p>
     * 2 <= nums.length <= 500
     * 0 <= nums[i] <= 100
     * 桶排序
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] bucket = new int[101];
        for (int num : nums) {
            bucket[num]++;
        }
        int[] ans = new int[nums.length];
        for (int i = 1; i < 100; i++) {
            bucket[i]+=bucket[i-1];
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                ans[i]=0;
                continue;
            }
            ans[i]=bucket[nums[i]-1];
        }
        return ans;
    }
}
