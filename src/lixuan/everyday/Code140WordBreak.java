package lixuan.everyday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code140WordBreak {
    private List<String> ans = new ArrayList<>();
    private Set<String> set = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return ans;
        }
        for (String word : wordDict) {
            set.add(word);
        }
        if (!isTrue(s)) {//先判断能不能分割，使用dp进行判断
            return ans;
        }
        List<String> temp = new ArrayList<>();
        dfs(0, s, temp);
        return ans;
    }

    /**
     * 先判断是否能分割
     *
     * @param s
     * @return
     */
    private boolean isTrue(String s) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 超时
     *
     * @param start
     * @param s
     * @param temp
     */
    private void dfs(int start, String s, List<String> temp) {
        if (start >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String item : temp) {
                sb.append(item + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            return;
        }
        for (int i = start; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (set.contains(substring)) {
                temp.add(substring);
                dfs(i, s, temp);
                temp.remove(temp.size() - 1);
            }
        }
        String sub = s.substring(start);
        if (!set.contains(sub)) {
            return;
        }
    }
}
