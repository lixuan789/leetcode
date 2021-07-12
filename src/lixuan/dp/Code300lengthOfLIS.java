package lixuan.dp;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Code300lengthOfLIS {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 贪心思想：每次遇到更小的则进行替换
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        int tail = 0;//递增子序列最后元素的下标
        for (int i = 1; i < n; i++) {
            if (nums[i] > res[tail]) {
                res[++tail] = nums[i];//大于为元素则可以追加
            } else {//小于，因为递增子序列有序，可以二分查找 找到第一个大于等于该元素的元素进行替换
                int low = 0;
                int high = tail;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    if (res[mid] < nums[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                res[low] = nums[i];//替换
            }
        }
        return tail + 1;
    }
}
