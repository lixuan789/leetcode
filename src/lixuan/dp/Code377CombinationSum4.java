package lixuan.dp;

import java.util.Arrays;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * 请注意，顺序不同的序列被视作不同的组合。
 * <p>
 * 因此输出为 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code377CombinationSum4 {
    /**
     * dp[i]表示和为i的组合个数
     * dp[i]+=dp[i-num]
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;//是为了算上自己的情况，比如dp[1]可以由dp【0】和1这个数的这种情况组成。
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    private int count = 0;

    /**
     * dfs超时
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum41(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, target);
        return count;
    }

    private void dfs(int[] nums, int target) {
        if (target == 0) {
            count++;
        }
        for (int num : nums) {
            if (target >= num) {
                dfs(nums, target - num);
            }
        }
    }
}
