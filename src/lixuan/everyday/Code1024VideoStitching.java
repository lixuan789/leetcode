package lixuan.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * <p>
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，
 * 例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * <p>
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 */
public class Code1024VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        if (T <= 0) {
            return -1;
        }
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int[] pre = clips[clips.length - 1];
        if (pre[1] < T) {
            return -1;
        }
        int ans = 1;
        int n = clips.length - 1;
        if (pre[1] != T) {
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][1] >= T) {
                    n = i;
                    break;
                }
            }
        }
        while (n > 0 && pre[0] > 0) {
            int temp = n;
            for (int i = 0; i <= n - 1; i++) {
                if (clips[i][1] >= pre[0] && clips[i][1] <= pre[1]) {
                    ans++;
                    pre = clips[i];
                    n = i;
                    break;
                }
            }
            if (temp == n) {
                break;//没有重叠的
            }
        }
        if (pre[0] != 0) {
            return -1;
        }
        return ans;
    }

    /**
     * 动态规划
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching1(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    /**
     * 贪心
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching2(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }

}
