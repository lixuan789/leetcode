package lixuan.hot100;

import java.util.Stack;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }


    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') dp[i] = 0;
            else {
                if (i >= 1 && chars[i - 1] == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                }
                if (i >= 1 && chars[i - 1] == ')') {
                    if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
