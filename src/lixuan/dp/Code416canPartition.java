package lixuan.dp;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code416canPartition {
    /**
     * 等价转换：是否可以从这个数组中挑选出一些正整数，使得这些数的和等于整个数组元素的和的一半
     * 类似于0-1背包问题
     * 状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
     * dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        //动态规划，背包问题，从nums中选择一部分数字组合，填满容量为sum/2的背包
        int n = nums.length;
        if (n == 0) {
            return false;
        }

        //确定背包c的大小
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int c = sum / 2;

        //两个相等的整数的和一定为偶数
        if (sum % 2 == 1) {
            return false;
        }

        //动态规划
        //明确状态：dp[m][n] 考虑是否将第m个数字放入容量为n的背包
        boolean[][] dp = new boolean[n][c + 1];

        //状态初始化
        for (int i = 0; i <= c; i++) {
            if (i != nums[0]) {
                dp[0][i] = false;
            } else {
                dp[0][i] = true;
            }
        }
        //状态转移方程：dp[m][n] = dp[m-1][n] || dp[m-1][n-nums[m]]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][c];
    }

    /**
     * 优化
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {                 // 0-1 背包一个物品只能用一次
            for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
