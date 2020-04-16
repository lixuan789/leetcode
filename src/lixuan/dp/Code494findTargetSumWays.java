package lixuan.dp;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class Code494findTargetSumWays {
    private int count = 0;

    /**
     * 方法一：dfs暴力搜索
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, S, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int sum, int start) {
        if (start == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(nums, target, sum + nums[start], start + 1);
        dfs(nums, target, sum - nums[start], start + 1);

    }

    /**
     * 0-1背包问题
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum + S) & 1) == 1) {
            return 0;
        }
        int target = (sum + S) / 2;
        if (target > sum) return 0;
        int size = nums.length;
        int[][] dp = new int[size][target + 1];
        //动态规划 dp[0][0]这个初始化得看nums[0]的情况，如果nums[0]=0，则可以选也可以不选，如果不等于0，只能不选
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else if (nums[0] != 0) {
            dp[0][0] = 1;
        }
        for (int i = 1; i <= target; i++) {
            if (nums[0] == i) {
                dp[0][i] = 1;
                break;
            }
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[size - 1][target];
    }

    /**
     * 压缩
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum + S) & 1) == 1) {
            return 0;
        }
        int target = (sum + S) / 2;
        if (target > sum) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
