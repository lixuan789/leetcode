package lixuan.DataStructure.string;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
 * 并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code696CountBinarySubstrings {
    /**
     * 暴力法超时
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 2; j < s.length(); j++) {
                String str = s.substring(i, j);
                if (isTrue(str)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 具有相同数量0和1的非空(连续)子字符串的数量，
     * 并且这些子字符串中的所有0和所有1都是组合在一起的。
     *
     * @param str
     * @return
     */
    private boolean isTrue(String str) {
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first == last) {
            return false;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == first) {
                a++;
            } else {
                break;
            }
        }
        for (int j = str.length() - 1; j >= 0; j--) {
            if (str.charAt(j) == last) {
                b++;
            } else {
                break;
            }
        }
        return a == b && a + b == str.length();
    }

    /**
     * AC代码
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings1(String s) {
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}
