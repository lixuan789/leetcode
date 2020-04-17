package lixuan.daydayup;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class Code55canJump {

    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return false;
        }
        if (i == nums.length - 1) {
            return true;
        }
        if (nums[i] == 0) {
            return false;
        }
        for (int distance = 1; distance <= nums[i]; distance++) {//跳跃的距离
            if (dfs(nums, i + distance)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];//dp[i]表示位置i是否可达
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int distance = i - j;
                if (dp[j] && nums[j] >= distance) {//位置j可达，并且跳跃长度大于等于两者之间的距离，则可达
                    dp[i] = true;
                }
            }
        }
        return dp[n - 1];
    }

    public boolean canJump2(int[] nums) {
        // 方法2. 反向遍历 + 贪心算法
        int n = nums.length, end = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] >= end - i) end = i;
        }
        if (end > 0) return false;
        else return true;
    }

}
