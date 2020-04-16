package lixuan.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Code131partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(res, new ArrayDeque<String>(), s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, ArrayDeque<String> path, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int len = 1; len <= s.length() - start; len++) {
            String substring = s.substring(start, start + len);
            if (isPalindrome(substring)) {
                path.addLast(substring);
                dfs(res, path, s, start + len);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
