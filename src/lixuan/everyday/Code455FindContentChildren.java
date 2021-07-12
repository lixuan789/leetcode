package lixuan.everyday;

import java.util.Arrays;

public class Code455FindContentChildren {
    /**
     * 分发饼干：贪心
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int ans = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                j++;
                i++;
                ans++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
