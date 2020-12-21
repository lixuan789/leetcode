package lixuan.everyday;

/**
 * 计数质数
 */
public class Code204CountPrimes {
    /**
     * 筛选法
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] cnt = new boolean[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!cnt[i]) {
                ans++;
                int j = i;
                while (j < n) {
                    cnt[j] = true;
                    j += i;
                }
            }
        }
        return ans;
    }
}
