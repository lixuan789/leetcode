package lixuan.greedy;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
 * 而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1:
 * s = "abc", t = "ahbgdc".返回 true.
 * 示例 2:
 * s = "axc", t = "ahbgdc".返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code392isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() || j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == s.length()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 改进
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (chars_s[i] == chars_t[j]) {
                i++;
            }
            j++;
        }
        return i == chars_t.length;
    }
}
