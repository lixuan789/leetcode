package lixuan.DataStructure.arrayandmatrix;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class Code485FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }
        int res = 0;
        int ans = 0;
        for (int num : nums) {
            if (num == 1) {
                res++;
                ans = Math.max(ans, res);
            } else {
                res = 0;//从新开始
            }
        }
        return ans;
    }

    /**
     * 优化
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
