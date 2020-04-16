package lixuan.dp;

/**
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。
 * 输出能够打印出 n 个 'A' 的最少操作次数。
 */
public class Code650MinSteps {
    /**
     * n>1时 其实就是将n分解为m个数字的乘积 且m个数字的和最小
     * 即把一个数分解为n个质数的和 从小到大的去试探
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int res = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }

    public int minSteps1(int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
