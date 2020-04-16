package lixuan.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Code139WordBreak {
    /**
     * dfs:超时
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean flag = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>();
        words.addAll(wordDict);
        dfs(s, words, 0);
        return flag;
    }

    private void dfs(String s, HashSet<String> words, int index) {
        if (index == s.length()) {
            flag = true;
            return;
        }
        for (int len = 0; len <= s.length() - index; len++) {
            String substr = s.substring(index, index + len);
            if (words.contains(substr)) {
                dfs(s, words, index + len);
            }
        }
    }

    /**
     * dp[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
