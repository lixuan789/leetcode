package lixuan.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code343integerBreak {
    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    /**
     * dfs
     *
     * @param n
     * @return
     */
    private int res = 0;

    public int integerBreak1(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 10);
            n /= 10;
        }
        int[] nums = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            nums[index++] = stack.pop();
        }
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int s) {
        if (s >= nums.length) {
            res++;
            return;
        }
        if (nums[s] == 0) {
            return;
        }
        dfs(nums, s + 1);
        if (s + 1 < nums.length) {
            int num = nums[s] * 10 + nums[s + 1];
            if (num <= 26) {
                dfs(nums, s + 2);
            }
        }
    }

    public static void main(String[] args) {
        Code343integerBreak test = new Code343integerBreak();
        int i = test.integerBreak1(226);
        System.out.println(i);
    }
}
