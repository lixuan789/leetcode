package lixuan.dp;

import java.util.Arrays;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 * 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，
 * 第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
 * 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class Code376wiggleMaxLength {
    /**
     * 动态规划：令dp[i]为0-i中最长子序列的长度
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] temp = new int[n - 1];
        int len = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                temp[len++] = nums[i] - nums[i - 1];
            }
        }
        if (len == 0) {
            return 1;
        }
        int[] dp = new int[n - 1];
        Arrays.fill(dp, 2);
        for (int i = 1; i < n - 1; i++) {
            if (temp[i] * temp[i - 1] < 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 2];
    }

    public int wiggleMaxLength1(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }
}
