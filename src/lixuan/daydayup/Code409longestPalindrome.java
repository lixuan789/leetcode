package lixuan.daydayup;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Code409longestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[58];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            count[c]++;
        }
        boolean isFirst = true;
        int res = 0;
        for (int i = 0; i < 58; i++) {
            if (count[i] % 2 == 0) {
                res += count[i];
            } else if (isFirst) {//第一次为奇数个数的字母，加上全部
                isFirst = false;
                res += count[i];
            } else {//不是第一次为奇数个数的字母，加偶数个
                res += (count[i] - 1);
            }
        }
        return res;
    }
}
